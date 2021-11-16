package spring.mvc.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.mvc.hibernate.dao.UserDAO;
import spring.mvc.hibernate.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleService roleService;

    public UserServiceImpl(UserDAO userDAO, RoleService roleService) {
        this.userDAO = userDAO;
        this.roleService = roleService;
    }

    private BCryptPasswordEncoder bCrypt() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListUsers() {
        return userDAO.getListUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public User getUser(String userName) {
        return userDAO.getUser(userName);
    }
}
