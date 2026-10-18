package com.shammad.mspost.model.request;

import jakarta.validation.constraints.NotBlank;

public record CreatePostRequest(
        @NotBlank
        String content
) {
}
