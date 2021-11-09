package spring.mvc.hibernate.dao;

import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;

import java.util.List;

public interface RoleDAO {

    List<User> listRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);
}
