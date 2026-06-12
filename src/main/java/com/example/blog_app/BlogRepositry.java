package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositry {
  private final JdbcClient jdbcClient;

  public BlogRepositry(JdbcClient jdbcClient){
    this.jdbcClient = jdbcClient;
  }
  // タイトルと文章の呼び出し
  public List<Blog> findAll(){
    return jdbcClient.sql("SELECT id,title,content FROM posts")
    .query(Blog.class).list();
  }

  //新しい記事の保存
  public void save(Blog blog){
    jdbcClient.sql("INSERT INTO posts (id, title, content) VALUES (:id, :title, :content)")
    .param("id", blog.getId())
    .param("title", blog.getTitle())
    .param("content",blog.getContent())
    .update();
  }

  //詳細
  public Optional<Blog> findById(Long id) {
  return jdbcClient.sql("SELECT id, title, content FROM posts WHERE id = :id")
      .param("id", id)
      .query(Blog.class)
      .optional();
}
}
