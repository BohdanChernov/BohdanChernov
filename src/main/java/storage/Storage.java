package storage;

import models.Member;

import java.util.ArrayList;

public class Storage {
    private static final Storage storage = new Storage();

    private static ArrayList<Member> list = new ArrayList<>();

    private Storage() {
    }

    public static Storage getStorage() {
        return storage;
    }

    public static ArrayList<Member> getMembers() {
        return list;
    }
}
