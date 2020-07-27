package springCrud.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import springCrud.model.User;

@Controller
public class UserController {

  @GetMapping(value = "/welcomepage")
  public String getUserPage(ModelMap modelMap) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    modelMap.put("user", user);
    return "welcomepage";
  }

  @GetMapping(value = "/login")
  public String getLoginPage() {
    return "/login";
  }
}
