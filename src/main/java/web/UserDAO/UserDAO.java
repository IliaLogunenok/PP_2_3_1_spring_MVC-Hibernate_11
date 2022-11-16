package web.UserDAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);

    User show(int id);
}
