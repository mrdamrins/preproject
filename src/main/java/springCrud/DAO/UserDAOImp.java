package springCrud.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springCrud.model.User;

@Repository
public class UserDAOImp implements UserDAO {

  @PersistenceContext(unitName = "entityManagerFactory")
  private EntityManager entityManager;

  @Override
  public List<User> getAllUsers() {
    return entityManager.createQuery("FROM User", User.class).getResultList();
  }

  @Override
  public void createUser(User newUser) {
    entityManager.persist(newUser);
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
}
