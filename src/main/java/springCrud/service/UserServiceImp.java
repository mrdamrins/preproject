package springCrud.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.UserDAO;
import springCrud.model.User;

@Service
public class UserServiceImp implements UserService {

  @Autowired
  private UserDAO userDao;

  @Autowired
  private RoleService roleService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  @Override
  @Transactional
  public boolean createUser(User newUser) {
    User userFromDB = userDao.getUserByUsername(newUser.getUsername());

    if (userFromDB != null) {
      return false;
    }

    newUser.setRoles(Collections.singleton(roleService.getRole(1L)));
    newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
    userDao.createUser(newUser);
    return true;
  }

  @Override
  @Transactional
  public void deleteUser(Long uid) {
    userDao.deleteUser(uid);
  }

  @Override
  @Transactional
  public void updateUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userDao.createUser(user);
  }

  @Override
  @Transactional
  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }

  @Override
  @Transactional
  public User getUserById(Long id) {
    return userDao.getUserById(id);
  }

  @Override
  public User getUserByUsername(String username) {
    return userDao.getUserByUsername(username);
  }
}
