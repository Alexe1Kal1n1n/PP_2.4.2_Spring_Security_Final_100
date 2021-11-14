package spring.mvc.hibernate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.hibernate.dao.RoleDAO;
import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListRole() {
        return roleDAO.getListRole();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public Role getByName(String roleName) {
        return roleDAO.getByName(roleName);
    }

    @Override
    @Transactional
    public HashSet getRoleSet(String[] role){
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(roleDAO.getByName(roles));
        }
        return (HashSet) roleSet;
    }
}
