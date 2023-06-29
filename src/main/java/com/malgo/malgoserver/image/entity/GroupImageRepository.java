package com.malgo.malgoserver.image.entity;

import com.malgo.malgoserver.group.entity.Group;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupImageRepository extends JpaRepository<GroupImage, Long> {
	Optional<GroupImage> findByGroup(Group group);
}
