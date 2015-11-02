package domain.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import domain.models.User;
import java.util.List;

/**
 * Created by levshevich_i on 21.10.15.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> get(int start,int limit) {
        return (List<User>)sessionFactory
                .getCurrentSession()
                .createQuery("from domain.models.User")
                .setFirstResult(start)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public User get(String id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from domain.models.User u where u.id = :userId").setString("userId",id).uniqueResult();
    }

    @Override
    public void remove(String id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public int getTotalUsers(){
        return ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from domain.models.User").uniqueResult()).intValue();
    }

}
