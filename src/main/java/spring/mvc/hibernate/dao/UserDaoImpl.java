package spring.mvc.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc.hibernate.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from User o where o.id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUser(String userName) {
        return entityManager.createQuery(
                        "SELECT user FROM User user WHERE user.username =:username", User.class)
                .setParameter("username", userName)
                .getSingleResult();
    }
}


/*
public User getUser(String userName) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.username =:username", User.class);
        return query
                .setParameter("username", userName)
                .getSingleResult();
    }
 */