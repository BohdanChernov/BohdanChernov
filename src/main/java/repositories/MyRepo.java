package repositories;

import models.Member;

import java.util.ArrayList;
import java.util.List;

public class MyRepo implements Repository {
    private static MyRepo myRepo = new MyRepo();

    private static ArrayList<Member> list = new ArrayList<>();

    private MyRepo() {
    }

    @Override
    public ArrayList getData() {
        return this.list;
    }

    public static MyRepo getInstance() {
        return myRepo;
    }

    public void putMember(Member member) {
        list.add(member);
    }
}
