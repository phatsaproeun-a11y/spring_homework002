package org.example._0_proeun_phatsa_spring_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._0_proeun_phatsa_spring_homework002.model.entity.Posts;
import org.example._0_proeun_phatsa_spring_homework002.model.request.PostRequest;
import org.example._0_proeun_phatsa_spring_homework002.model.response.ApiResponse;
import org.example._0_proeun_phatsa_spring_homework002.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    // GET all posts
    @GetMapping
    public ResponseEntity<ApiResponse<List<Posts>>> getAllPosts() {
        List<Posts> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("get all posts is successfully!", posts, 200, LocalDateTime.now())
        );
    }

    // POST create post
    @PostMapping
    public ResponseEntity<ApiResponse<Posts>> createPost(@RequestBody PostRequest postRequest) {
        Posts createdPost = postService.createPost(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("create post is successfully!", createdPost, 201, LocalDateTime.now())
        );
    }

    // GET post by id
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Posts>> getPostById(@PathVariable Long id) {
        Posts post = postService.getPostById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("get post by id is successfully!", post, 200, LocalDateTime.now())
        );
    }

    // GET posts by title
    @GetMapping("title")
    public ResponseEntity<ApiResponse<List<Posts>>> getPostByTitle(@RequestParam String title) {
        List<Posts> posts = postService.getPostByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("get post by title is successfully!", posts, 200, LocalDateTime.now())
        );
    }

    // GET posts by author
    @GetMapping("author")
    public ResponseEntity<ApiResponse<List<Posts>>> getPostByAuthor(@RequestParam String author) {
        List<Posts> posts = postService.getPostByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("get post by author is successfully!", posts, 200, LocalDateTime.now())
        );
    }

    // PUT update post by id
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Posts>> updateById(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        Posts updatedPost = postService.updateById(id, postRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("update post is successfully!", updatedPost, 200, LocalDateTime.now())
        );
    }

    // DELETE post by id
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("delete post is successfully!", null, 200, LocalDateTime.now())
        );
    }
}