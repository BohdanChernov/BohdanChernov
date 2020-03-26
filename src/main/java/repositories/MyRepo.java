package repositories;

import java.util.ArrayList;
import java.util.List;

public class MyRepo implements Repository{

    @Override
    public List getData() {
        List<String> list = new ArrayList<>();
        list.add("member1");
        list.add("member2");
        list.add("member3");
        return list;
    }
}
