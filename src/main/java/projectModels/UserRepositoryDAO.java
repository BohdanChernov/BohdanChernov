package projectModels;

import models.Member;

import javax.sql.DataSource;
import java.util.List;

public class UserRepositoryDAO implements UserCRUD {
    DataSource dataSource;

    public UserRepositoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save() {

    }

    @Override
    public List<Member> getList() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
