package com.malgo.malgoserver.grouppost;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPostRepository extends JpaRepository<GroupPost, Long> {
	List<GroupPost> findAllByGroup_Id(Long id);
}
