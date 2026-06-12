package com.example.blog_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class VisitController {
  @GetMapping("/visit")
  public String visit(HttpSession session){
    Integer count =(Integer) session.getAttribute("count");
    if (count == null) {
      count = 0;
    }
    count = count +1;
    session.setAttribute("count", count);
    return "訪問回数:" + count;
  }
  
}
