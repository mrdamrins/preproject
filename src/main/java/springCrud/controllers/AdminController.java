package springCrud.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springCrud.service.UserService;
import springCrud.model.User;
import springCrud.service.UtilService;

import java.util.List;

@Controller
public class AdminController {

  private final UserService userService;

  public AdminController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/admin")
  public String listUsers(ModelMap modelMap) {
    List<User> users = userService.getAllUsers();
    modelMap.put("users", users);
    return "index";
  }

  @GetMapping(value = "/admin/createUser")
  public String getAddUser() {
    return "createUser";
  }

  @PostMapping(value = "/admin/createUser")
  public String createUser(@ModelAttribute User user) {
    userService.createUser(user);
    return "redirect:/admin";
  }

  @GetMapping(value = "/admin/deleteUser")
  public String deleteUser(@RequestParam(value = "id") Long id) {
    userService.deleteUser(id);
    return "redirect:/admin";
  }

  @GetMapping(value = "/admin/editUser")
  public String editUserGet(@RequestParam(value = "id") Long id, ModelMap modelMap) {
    User user = userService.getUserById(id);
    modelMap.put("user", user);
    return "editUser";
  }

  @RequestMapping(value = "/admin/editUser", method = RequestMethod.POST)
  public String editUserPost(@ModelAttribute User user,
      @RequestParam(value = "role") String[] rolesArr) {
    user.setRoles(UtilService.stringArrToSetRoles(rolesArr));
    userService.updateUser(user);
    return "redirect:/admin";
  }
}