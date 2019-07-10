package com.redbee.oauth2.controllers;

import com.redbee.oauth2.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@RestController
public class LoginController {

  @RequestMapping("/login")
  public ModelAndView loginPage() {
    return new ModelAndView("login");
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return new ModelAndView("redirect:/login?logout");
  }

  @RequestMapping("/")
  public ModelAndView root(Map<String, Object> model, Principal principal) {
    model.put("approvals", null);
    model.put("clientDetails", null);
    return new ModelAndView("index", model);

  }


//  @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
//  public String postLogin(Model model, HttpSession session) {
//    UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//    validatePrinciple(authentication.getPrincipal());
//    User loggedInUser = (User) authentication.getPrincipal();
//    model.addAttribute("currentUser", loggedInUser.getName());
//    session.setAttribute("userId", loggedInUser.getId());
//    return "redirect:/wallPage";
//  }
//  private void validatePrinciple(Object principal) {
//    if (!(principal instanceof User)) {
//      throw new  IllegalArgumentException("Principal can not be null!");
//    }
//  }
}

