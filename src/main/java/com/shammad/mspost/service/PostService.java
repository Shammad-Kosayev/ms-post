package com.shammad.mspost.service;

import com.shammad.mspost.domain.entity.PostEntity;
import com.shammad.mspost.domain.entity.UserEntity;
import com.shammad.mspost.domain.repository.PostRepository;
//import com.shammad.mspost.kafka.producer.PostProducer;
import com.shammad.mspost.mapper.PostMapper;
import com.shammad.mspost.model.request.CreatePostRequest;
import com.shammad.mspost.model.response.CreatePostResponse;
import com.shammad.mspost.model.response.PostResponse;
import com.shammad.mspost.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
//    private final PostProducer postProducer;
    private final PostMapper postMapper;
    private final UserUtil userUtil; // to simulate fetching authenticated user

    @Transactional(readOnly = true)
    public PostResponse getPostById(long postId) {
        return postRepository.findWithPosterById(postId)
                .map(postMapper::toPostResponse)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
    }

    @Transactional(rollbackFor = Exception.class)
    public CreatePostResponse createPost(CreatePostRequest request) {
        UserEntity activeUser = userUtil.getActiveUser();

        PostEntity newPost = new PostEntity();
//        newPost.setPoster(activeUser);
        newPost.setContent(request.content());

        PostEntity savedPost = postRepository.save(newPost);

//        // Fire publish only after successful commit to DB
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
//            @Override
//            public void afterCommit() {
//                postProducer.publishPostCreated(postMapper.toPostCreatedEvent(savedPost));
//            }
//        });

        return postMapper.toCreatePostResponse(savedPost);
    }
}
