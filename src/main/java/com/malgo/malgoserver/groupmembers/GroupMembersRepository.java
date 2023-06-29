package com.malgo.malgoserver.groupmembers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {}
