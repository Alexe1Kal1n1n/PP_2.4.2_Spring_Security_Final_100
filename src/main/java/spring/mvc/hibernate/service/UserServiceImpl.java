package spring.mvc.hibernate.service;

import org.springframework.stereotype.Service;
import spring.mvc.hibernate.dao.UserDAO;
import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleService roleService;

    public UserServiceImpl(UserDAO userDAO, RoleService roleService) {
        this.userDAO = userDAO;
        this.roleService = roleService;
//        addDefaultUser();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListUsers() {
        return userDAO.getListUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
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

    @Override
    @Transactional
    public void addDefaultUser() {
        String[] role = {"ROLE_ADMIN"};
        User user1 = new User( "alex", "$2a$10$GGRd0oT3kI6DJFzZB3HTW./zOCTnAPg12.vBItGIS8akLG1GrvgeO",
                "Alex", "Kalinin","alex@mail.ru", roleService.getRoleSet(role));
        user1.setRoles(roleService.getRoleSet(role));
        saveUser(user1);
    }
}


/*
Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleService.findById(1L));

User user2 = new User(2, "kim", "$2a$10$GfEUbTFPYnwF.ARzKqDkh.4ybziR3c.pwr8fnfrnr8BX8UtFnYaqS",
                "Kim", "ChenIn","kim5@chen.com", roleSet);

                String[] role = {"ROLE_ADMIN"};
        User user1 = new User( "alex", "$2a$10$GGRd0oT3kI6DJFzZB3HTW./zOCTnAPg12.vBItGIS8akLG1GrvgeO",
                "Alex", "Kalinin","alex@mail.ru", roleService.getRoleSet(role));
        user1.setRoles(roleService.getRoleSet(role));
        saveUser(user1);
 */