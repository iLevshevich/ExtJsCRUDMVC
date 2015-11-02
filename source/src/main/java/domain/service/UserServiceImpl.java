package domain.service;

import domain.dao.UserDAO;
import domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by levshevich_i on 21.10.15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional(readOnly=true)
    @Override
    public List<User> get(int start,int limit) {
        return userDAO.get(start,limit);
    }

    @Transactional(readOnly=true)
    @Override
    public User get(String id) {
        return userDAO.get(id);
    }

    @Transactional
    @Override
    public void remove(String id) {
        userDAO.remove(id);
    }

    @Transactional(readOnly=true)
    @Override
    public int getTotalUsers(){
        return userDAO.getTotalUsers();
    }
}
