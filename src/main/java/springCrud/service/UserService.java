package springCrud.service;


import java.util.List;
import springCrud.model.User;

public interface UserService {

  boolean createUser(User newUser);

  void deleteUser(Long uid);

  void updateUser(User user);

  List<User> getAllUsers();

  User getUserById(Long id);

  User getUserByUsername(String username);

}