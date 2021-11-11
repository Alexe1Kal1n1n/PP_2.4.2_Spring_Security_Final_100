package spring.mvc.hibernate.service;

import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getListUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);

    User getUser(String userName);
}
