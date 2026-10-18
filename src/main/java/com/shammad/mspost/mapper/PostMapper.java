package com.shammad.mspost.mapper;

import com.shammad.mspost.domain.entity.PostEntity;
//import com.shammad.mspost.domain.entity.UserEntity;
//import com.shammad.mspost.model.kafka.PostCreatedEvent;
import com.shammad.mspost.model.response.CreatePostResponse;
import com.shammad.mspost.model.response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostResponse toPostResponse(PostEntity post) {
//        UserEntity poster = post.getPoster();
        return new PostResponse(
                post.getId(),
//                poster.getId(),
//                poster.getUsername(),
                post.getContent(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getSaveCount(),
                post.getCreatedAt()
        );
    }

    public CreatePostResponse toCreatePostResponse(PostEntity post) {
        return new CreatePostResponse(
                post.getId(),
//                post.getPoster().getId(),
                post.getContent(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getSaveCount(),
                post.getCreatedAt()
        );
    }

//    public PostCreatedEvent toPostCreatedEvent(PostEntity post) {
//        return PostCreatedEvent.of(post.getId(), post.getPoster().getId());
//    }
}
