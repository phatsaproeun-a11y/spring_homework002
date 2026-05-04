package org.example._0_proeun_phatsa_spring_homework002.service.impl;

import lombok.RequiredArgsConstructor;
import org.example._0_proeun_phatsa_spring_homework002.model.entity.Posts;
import org.example._0_proeun_phatsa_spring_homework002.model.request.PostRequest;
import org.example._0_proeun_phatsa_spring_homework002.repository.PostRepo;
import org.example._0_proeun_phatsa_spring_homework002.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    // Helper: map PostRequest → Posts
    private Posts mapToEntity(PostRequest request) {
        Posts post = new Posts();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(request.getAuthor());
        post.setCreatedAt(request.getCreatedAt());
        post.setTags(request.getTags());
        return post;
    }

    // i) Create post
    @Override
    public Posts createPost(PostRequest request) {
        Posts post = mapToEntity(request);
        postRepo.save(post);
        return post;
    }

    // ii) Read all posts
    @Override
    public List<Posts> getAllPosts() {
        return postRepo.findAll();
    }

    // iii) Read post by id
    @Override
    public Posts getPostById(Long id) {
        Posts post = postRepo.findById(id);
        if (post == null) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        return post;
    }

    // iv) Read by title
    @Override
    public List<Posts> getPostByTitle(String title) {
        return postRepo.findByTitle(title);
    }

    // v) Read by author
    @Override
    public List<Posts> getPostByAuthor(String author) {
        return postRepo.findByAuthor(author);
    }

    // vi) Update post by id
    @Override
    public Posts updateById(Long id, PostRequest request) {
        Posts existingPost = postRepo.findById(id);
        if (existingPost == null) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        existingPost.setTitle(request.getTitle());
        existingPost.setContent(request.getContent());
        existingPost.setAuthor(request.getAuthor());
        existingPost.setCreatedAt(request.getCreatedAt());
        existingPost.setTags(request.getTags());
        postRepo.updateById(existingPost);
        return existingPost;
    }

    // vii) Delete post by id
    @Override
    public void deleteById(Long id) {
        Posts existingPost = postRepo.findById(id);
        if (existingPost == null) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        postRepo.deleteById(id);
    }
}