package com.malgo.malgoserver.groupmembers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {
}
