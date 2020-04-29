package com.jihu.exer;

import java.util.List;

public class DAOTest {

    public static void main(String[] args) {
        Dao<User> dao = new Dao<User>();
        dao.save("1001",new User("1001",34,"周杰伦"));
        dao.save("1002",new User("1002",20,"昆凌"));
        dao.save("1003",new User("1003",25,"蔡依林"));

        dao.update("1003",new User("1003",25,"方文山"));

        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);


    }
}
