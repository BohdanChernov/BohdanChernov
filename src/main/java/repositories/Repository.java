package repositories;

import models.Member;

import java.util.ArrayList;

public interface Repository {

    ArrayList getData();

    void addMember(String name, String last, String email, String pass);

    boolean isExist(String email, String password);

}
