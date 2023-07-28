package kz.bitlab.G114crm.controllers;

import kz.bitlab.G114crm.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("zayavki", DBManager.getArList());
    return "home";
  }

  @GetMapping("details/{id}")
  public String detailsPage(@PathVariable Long id) {
    System.out.println(id);
    return "details";
  }
}
