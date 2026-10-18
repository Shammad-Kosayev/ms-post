package com.shammad.mspost.controller;

import com.shammad.mspost.model.request.CreatePostRequest;
import com.shammad.mspost.model.response.CreatePostResponse;
import com.shammad.mspost.model.response.PostResponse;
import com.shammad.mspost.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable @Min(1) long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public CreatePostResponse createPost(@RequestBody @Valid CreatePostRequest request) {
        return postService.createPost(request);
    }
}
