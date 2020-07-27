package springCrud.DAO;

import org.springframework.stereotype.Repository;
import springCrud.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class RoleDAOImp implements RoleDAO {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Role getRole(Long id) {
    return entityManager.getReference(Role.class, id);
  }

}
