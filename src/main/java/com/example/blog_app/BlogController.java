package com.example.blog_app;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {
  private final BlogService blogService;

  public BlogController(BlogService blogService){
    this.blogService = blogService;
  }
  
  // ホームの読み込み
  @GetMapping("/blogs")
  public String blogs(Model model){
    List<Blog>blogs = blogService.findAll();
    model.addAttribute("blogs",blogs);
    return "blogs";
  }

  // newblogsの読み込み
  @GetMapping("/newblogs")
  public String blogsn(){
    return "/newblogs";
  }

  // loginの読み込み
  // @GetMapping("/login")
  // public String login(){
  //   return "/login";
  // }

  // newloginの読み込み
  // @GetMapping("/newlogin")
  // public String newlogin(){
  //   return "/newlogin";
  // }

  // saveするには
  @PostMapping("/blogs")
  public String BlogForm(@ModelAttribute BlogForm form){
    blogService.add(form);
    return "redirect:/blogs";
  }
  // @GetMapping("/blogs/{id}")
  // public String getMethodName(@RequestParam String param) {
  //     return new String();
  // }
  
  @GetMapping("/blogs/{id}")
  public String detail(@PathVariable Long id, Model model) {
    Optional<Blog> blogOpt = blogService.findById(id);
    if (blogOpt.isEmpty()) {
      return "redirect:/blogs";
    }
    model.addAttribute("blog", blogOpt.get());
    return "/detail";
  }

}
