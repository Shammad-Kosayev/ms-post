package com.shammad.mspost.domain.repository;

import com.shammad.mspost.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @EntityGraph(attributePaths = {"poster"})
    Optional<PostEntity> findWithPosterById(Long aLong);
}
