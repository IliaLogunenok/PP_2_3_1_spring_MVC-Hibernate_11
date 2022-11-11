package web.UserDAO;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//Вместо этого класса используется UserRepository
@Component
@Transactional
public class UserDAO {

    private int dynamicId;
    public List<User> userList;

    {
        userList = new ArrayList<>();

        userList.add(new User(++dynamicId,"Name_1", "Surname_1"));
        userList.add(new User(++dynamicId,"Name_2", "Surname_2"));
        userList.add(new User(++dynamicId,"Name_3", "Surname_3"));
        userList.add(new User(++dynamicId,"Name_4", "Surname_4"));
        userList.add(new User(++dynamicId,"Name_5", "Surname_5"));
    }

    public List<User> index() {
        return userList;
    }

    public User show (int id) {
         return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++dynamicId);
        userList.add(user);
    }

    public void update (int id, User updateUser) {
        User userToBeUpdate = show(id);

        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname(updateUser.getSurname());
    }

    public void delete (int id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
