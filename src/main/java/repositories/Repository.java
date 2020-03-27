package repositories;

import models.Member;

import java.util.ArrayList;

public interface Repository {

    ArrayList getData();

    void addMember(Member member);

    boolean isExist(String email, String password);

}
