package repositories;

import at.favre.lib.crypto.bcrypt.BCrypt;
import models.Member;
import storage.Storage;

import java.util.ArrayList;

public class MyRepository implements Repository {
    @Override
    public ArrayList getData() {
        return Storage.getStorage().getMembers();
    }

    @Override
    public void addMember(Member member) {
        Storage.getStorage().getMembers().add(member);
    }

    @Override
    public boolean isExist(String email, String password) {
        ArrayList<Member> members = getData();
        for (Member member : members) {
            if (member.getEmail().equals(email) && checkPassword(member.getPassword(), password))
                return true;
        }

        return false;
    }

    public String getCrypt(String password) {
        String hashPass = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
        System.out.println(hashPass);
        return hashPass;
    }

    public boolean checkPassword(String passwordHash, String userInput) {
        if (passwordHash == null || passwordHash.isEmpty()) {
            return false;
        }
        return BCrypt.verifyer().verify(userInput.toCharArray(), passwordHash).verified;
    }
}
