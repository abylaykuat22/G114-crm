package kz.bitlab.G114crm.controllers;

import kz.bitlab.G114crm.repositories.ApplicationRequestRepo;
import kz.bitlab.G114crm.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
  @Autowired
  private ApplicationRequestService applicationRequestService;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("zayavki", applicationRequestService.getAppReqs());
    return "home";
  }

  @GetMapping("details/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    model.addAttribute("appReq", applicationRequestService.getAppReqById(id));
    return "details";
  }
}
