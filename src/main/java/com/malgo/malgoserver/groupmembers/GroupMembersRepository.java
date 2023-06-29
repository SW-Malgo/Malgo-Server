package com.malgo.malgoserver.groupmembers;

import com.malgo.malgoserver.group.entity.Group;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {
	List<GroupMembers> findByGroup(Group group);
}
