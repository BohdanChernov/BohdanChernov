package projectModels;

import models.Member;

import java.util.List;

public interface UserCRUD extends CRUD<Member> {
    List<Member> findAllByFirstName(String firstName);

}
