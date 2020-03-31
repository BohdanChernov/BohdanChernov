package projectModels;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    Optional<T> find(Integer id);

    void save(T model);

    void update(T model);

    void delete(int id);

    List<T> findAll();

    boolean isExist(String email, String password);

    boolean checkPassword(String passwordHash, String userInput);

}
