package spring.mvc.hibernate.dao;

import spring.mvc.hibernate.model.User;
import java.util.List;

public interface UserDAO {

    List<User> listUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);

}
