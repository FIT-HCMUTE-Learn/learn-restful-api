package com.landingis.api.repository;

import com.landingis.api.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserStaticRepository {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 5;

    static {
        users.add(new User(1, "Adam", new Date(), new ArrayList<>()));
        users.add(new User(2, "Even", new Date(), new ArrayList<>()));
        users.add(new User(3, "Mike", new Date(), new ArrayList<>()));
        users.add(new User(4, "Peter", new Date(), new ArrayList<>()));
        users.add(new User(5, "Jack", new Date(), new ArrayList<>()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
