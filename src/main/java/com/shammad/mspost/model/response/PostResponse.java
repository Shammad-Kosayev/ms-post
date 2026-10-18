package com.shammad.mspost.model.response;

import java.time.Instant;

public record PostResponse(
        long postId,
//        long posterId,
//        String posterUsername,
        String content,
        long likeCount,
        long commentCount,
        long saveCount,
        Instant createdAt
) {
}
