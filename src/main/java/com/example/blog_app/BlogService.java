package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
  private final BlogRepositry blogRepositry;

  public BlogService (BlogRepositry blogRepositry){
    this.blogRepositry = blogRepositry;
  }

  // findAll()呼び出し
  public List<Blog> findAll(){
    return blogRepositry.findAll();
  }

  // 追加可能ならsavaメソッドへ
  public void add(BlogForm form){
    if (form.getTitle() == null || form.getContent() == null) {
      throw new IllegalArgumentException( );
    }
    blogRepositry.save(new Blog(null,form.getTitle(),form.getContent()));
  }

  //詳細
  public Optional<Blog> findById(Long id) {
  return blogRepositry.findById(id);
  }
}
