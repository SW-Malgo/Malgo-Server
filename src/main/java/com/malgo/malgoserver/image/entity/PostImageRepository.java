package com.malgo.malgoserver.image.entity;

import com.malgo.malgoserver.grouppost.GroupPost;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long> {
	Optional<GroupImage> findByGroupPost(GroupPost groupPost);
}
