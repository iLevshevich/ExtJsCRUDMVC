package domain.service;

import domain.models.User;

import java.util.List;

/**
 * Created by levshevich_i on 21.10.15.
 */
public interface UserService {
    public void add(User user);
    public void update(User user);
    public List<User> get(int start,int limit);
    public User get(String id);
    public void remove(String id);
    public int getTotalUsers();
}
