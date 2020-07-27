package springCrud.service;

import org.springframework.stereotype.Service;
import springCrud.DAO.RoleDAO;
import springCrud.model.Role;

@Service
public class RoleServiceImp implements RoleService {

  private final RoleDAO roleDao;

  public RoleServiceImp(RoleDAO roleDao) {
    this.roleDao = roleDao;
  }

  @Override
  public Role getRole(Long id) {
    return roleDao.getRole(id);
  }
}
