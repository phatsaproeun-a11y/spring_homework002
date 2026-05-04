package org.example._0_proeun_phatsa_spring_homework002.service;

import org.example._0_proeun_phatsa_spring_homework002.model.entity.Posts;
import org.example._0_proeun_phatsa_spring_homework002.model.request.PostRequest;
import java.util.List;

public interface PostService {
    Posts createPost(PostRequest request);
    List<Posts> getAllPosts();
    Posts getPostById(Long id);
    List<Posts> getPostByTitle(String title);
    List<Posts> getPostByAuthor(String author);
    Posts updateById(Long id, PostRequest request);
    void deleteById(Long id);
}