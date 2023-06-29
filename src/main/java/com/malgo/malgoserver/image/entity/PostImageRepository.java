package com.malgo.malgoserver.image.entity;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.grouppost.GroupPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long> {
    Optional<GroupImage> findByGroupPost(GroupPost groupPost);
}
