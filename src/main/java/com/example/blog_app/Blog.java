package com.example.blog_app;

public class Blog {
  private final Long id;
  private final String title;
  private final String content;

  public Blog(Long id,String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }
  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getTitle() {
    return title;
  }
  
}
