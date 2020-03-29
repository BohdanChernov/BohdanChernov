package projectModels;

import java.util.List;

public interface CRUD<T> {

    public void save();

    public List<T> getList();

    public void update();

    public void delete();

}
