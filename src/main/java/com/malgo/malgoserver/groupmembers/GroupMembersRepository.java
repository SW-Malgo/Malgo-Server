package com.malgo.malgoserver.groupmembers;

import com.malgo.malgoserver.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {
    List<GroupMembers> findByGroup(Group group);
}
