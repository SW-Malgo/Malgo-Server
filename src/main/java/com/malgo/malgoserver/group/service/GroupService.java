package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import com.malgo.malgoserver.groupmembers.GroupMembers;
import com.malgo.malgoserver.groupmembers.GroupMembersRepository;
import com.malgo.malgoserver.member.Member;
import com.malgo.malgoserver.member.MemberRepository;
import com.malgo.malgoserver.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final MemberService memberService;
    private final GroupMembersRepository groupMembersRepository;
    private final MemberRepository memberRepository;

    public Long createGroup(Group group) {
        return groupRepository.save(group).getId();
    }

    public void joinGroup(Long memberId, Long groupId) {
        Member member = memberService.findMember(memberId);
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new IllegalArgumentException());

        GroupMembers groupMembers = GroupMembers.builder()
                .member(member)
                .group(group)
                .build();
    }


}
