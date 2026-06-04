package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
  
  // ホームの読み込み
  @GetMapping("/")
  public String blogs(){
    return "blogs";
  }

  // newblogsの読み込み
  @GetMapping("/newblogs")
  public String blogsn(){
    return "/newblogs";
  }
  

}
