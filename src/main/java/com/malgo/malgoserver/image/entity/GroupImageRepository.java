package com.malgo.malgoserver.image.entity;

import com.malgo.malgoserver.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupImageRepository extends JpaRepository<GroupImage, Long> {
    Optional<GroupImage> findByGroup(Group group);
}
