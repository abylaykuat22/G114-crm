package kz.bitlab.G114crm.controllers;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.services.ApplicationRequestService;
import kz.bitlab.G114crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private ApplicationRequestService applicationRequestService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("zayavki", applicationRequestService.getAppReqs());
        model.addAttribute("users", userService.getUsers());
        return "home";
    }

    @GetMapping("details/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("appReq", applicationRequestService.getAppReqById(id));
        model.addAttribute("users", userService.getUsers());
        return "details";
    }

    @PostMapping("addAppReq")
    public String addAppReq(ApplicationRequest appReq) {
        applicationRequestService.addAppReq(appReq);
        return "redirect:/";
    }

    @PostMapping("updateHandled/{id}")
    public String updateHandled(@PathVariable Long id) {
        applicationRequestService.updateHandled(id);
        return "redirect:/";
    }

    @PostMapping("editAppReq")
    public String editApplicationRequest(ApplicationRequest appReq) {
        applicationRequestService.editAppReq(appReq);
        return "redirect:/details/" + appReq.getId();
    }

    @PostMapping("deleteAppReq/{id}")
    public String deleteApplicationRequest(@PathVariable Long id) {
        applicationRequestService.deleteAppReqById(id);
        return "redirect:/";
    }
}
