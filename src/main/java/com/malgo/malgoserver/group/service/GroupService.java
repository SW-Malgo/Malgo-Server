package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

	private final GroupRepository groupRepository;

	public Long createGroup(Group group) {
		return groupRepository.save(group).getId();
	}
}
