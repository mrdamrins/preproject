package springCrud.DAO;

import org.springframework.stereotype.Repository;
import springCrud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

  @PersistenceContext
  private EntityManager entityManager;


  @Override
  public List<User> getAllUsers() {
    return entityManager.createQuery("FROM User", User.class).getResultList();
  }

  @Override
  public void createUser(User newUser) {
    entityManager.merge(newUser);
  }

  @Override
  public void deleteUser(Long uid) {
    entityManager.remove(getUserById(uid));
  }

  @Override
  public void updateUser(User user) {
    entityManager.merge(user);
  }

  @Override
  public User getUserById(Long uid) {
    return entityManager.find(User.class, uid);
  }

  @Override
  public User getUserByUsername(String username) {
    TypedQuery<User> user = entityManager
        .createQuery("FROM User WHERE username = :username", User.class)
        .setParameter("username", username);
    return user
        .getResultList()
        .stream()
        .findAny()
        .orElse(null);
  }
}
