package springCrud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.UserDAO;
import springCrud.model.User;

@Service
public class UserServiceImp implements UserService {

  @Autowired
  private UserDAO userDAO;


  @Override
  @Transactional
  public void createUser(User newUser) {
    this.userDAO.createUser(newUser);
  }

  @Override
  @Transactional
  public void deleteUser(Long uid) {
    userDAO.deleteUser(uid);
  }

  @Override
  @Transactional
  public void updateUser(User user) {
    userDAO.updateUser(user);
  }

  @Override
  @Transactional
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }

  @Override
  @Transactional
  public User getUserById(Long id) {
    return userDAO.getUserById(id);
  }
}
