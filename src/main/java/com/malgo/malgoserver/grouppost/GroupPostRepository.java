package com.malgo.malgoserver.grouppost;

import com.malgo.malgoserver.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface GroupPostRepository extends JpaRepository<GroupPost, Long> {
    List<GroupPost> findAllByGroup_Id(Long id);
}
