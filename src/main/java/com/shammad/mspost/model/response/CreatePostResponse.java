package com.shammad.mspost.model.response;

import java.time.Instant;

public record CreatePostResponse(
        long postId,
//        long posterId,
        String content,
        long likeCount,
        long commentCount,
        long saveCount,
        Instant createdAt
) {
}
