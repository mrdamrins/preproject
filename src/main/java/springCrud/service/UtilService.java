package springCrud.service;

import java.util.HashSet;
import java.util.Set;
import springCrud.model.Role;

public class UtilService {

  public static Set<Role> stringArrToSetRoles(String[] rolesArr) {

    Set<Role> roles = new HashSet<>();
    for (String role : rolesArr) {
      if (role.equals("ROLE_ADMIN")) {
        Role roleAdmin = new Role(2L, "ROLE_ADMIN");
        roles.add(roleAdmin);
      }
      if (role.equals("ROLE_USER")) {
        Role roleUser = new Role(1L, "ROLE_USER");
        roles.add(roleUser);
      }
    }
    return roles;
  }
}
