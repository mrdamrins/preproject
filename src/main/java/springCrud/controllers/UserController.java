package springCrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springCrud.model.User;
import springCrud.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

  private final UserService userService;

  private UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/")
  public String listAllUsersPage(ModelMap modelMap) {
    modelMap.addAttribute("userList", userService.getAllUsers());
    return "allUsersList";
  }

  @GetMapping(value = "newUserFrom")
  public String viewAddUser() {
    return "addUser";
  }

  @PostMapping(value = "newUserCreator")
  public String addUser(User user) {
    userService.createUser(user);
    return "redirect:/";
  }

  @PostMapping(value = "delete")
  public String deleteUser(@RequestParam Long userId) {
    userService.deleteUser(userId);
    return "redirect:/";
  }

  @PostMapping(value = "/editForm")
  public String getEdit(User user, Model model) {
    model.addAttribute("user", user);
    return "editUser";
  }

  @PostMapping(value = "/editUser")
  public String editUser(User user) {
    userService.updateUser(user);
    return "redirect:/";
  }
}