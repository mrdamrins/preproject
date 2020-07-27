package springCrud.DAO;

import java.util.List;
import springCrud.model.User;

public interface UserDAO {

  List<User> getAllUsers();

  void createUser(User newUser);

  void deleteUser(User user);

  void updateUser(User user);

  User getUserById(Long uid);

  User getUserByUsername(String username);
}