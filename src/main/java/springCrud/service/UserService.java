package springCrud.service;


import springCrud.model.User;

import java.util.List;

public interface UserService {

  void createUser(User newUser);

  void deleteUser(Long uid);

  void updateUser(User user);

  List<User> getAllUsers();

  User getUserById(Long id);

}