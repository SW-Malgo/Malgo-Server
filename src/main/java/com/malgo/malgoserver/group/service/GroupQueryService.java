package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.dto.GroupDetailResponseDto;
import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import com.malgo.malgoserver.groupmembers.GroupMembers;
import com.malgo.malgoserver.groupmembers.GroupMembersRepository;
import com.malgo.malgoserver.grouppost.GroupPost;
import com.malgo.malgoserver.grouppost.GroupPostRepository;
import com.malgo.malgoserver.image.entity.PostImageRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.keywordgroup.KeywordGroupRepository;
import com.malgo.malgoserver.member.Member;
import com.malgo.malgoserver.member.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GroupQueryService {

	private final GroupRepository groupRepository;
	private final KeywordRepository keywordRepository;
	private final KeywordGroupRepository keywordGroupRepository;
	private final GroupPostRepository groupPostRepository;
	private final PostImageRepository postImageRepository;
	private final GroupMembersRepository groupMembersRepository;
	private final MemberRepository memberRepository;

	public List<Group> queryGroup(List<Long> keywordIds, Boolean withKeyword) {

		List<Keyword> keywords =
				keywordIds.stream()
						.map(
								id ->
										keywordRepository
												.findById(id)
												.orElseThrow(() -> new IllegalArgumentException()))
						.collect(Collectors.toList());

		if (withKeyword == true) {
			return keywords.stream()
					.flatMap(ks -> keywordGroupRepository.findAllByKeyword(ks).stream())
					.map(
							kg ->
									groupRepository
											.findById(kg.getGroup().getId())
											.orElseThrow(() -> new IllegalArgumentException()))
					.collect(Collectors.toList());
		}
		if (withKeyword == false) {
			return keywords.stream()
					.flatMap(ks -> keywordGroupRepository.findAllByKeywordNot(ks).stream())
					.map(
							kg ->
									groupRepository
											.findById(kg.getGroup().getId())
											.orElseThrow(() -> new IllegalArgumentException()))
					.collect(Collectors.toList());
		}

		throw new IllegalArgumentException();
	}

	public GroupDetailResponseDto getGroupDetail(Long id) {

		Group group = groupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

		List<GroupPost> posts = groupPostRepository.findAllByGroup_Id(id);
		List<String> images =
				posts.stream()
						.flatMap(p -> postImageRepository.findByGroupPost(p).stream())
						.map(pi -> pi.getSource())
						.collect(Collectors.toList());

		return GroupDetailResponseDto.builder()
				.groupName(group.getName())
				.groupContent(group.getGroupContent())
				.images(images)
				.members(getMembers(id))
				.memberCount(getMemberCount(id))
				.build();
	}

	public int getMemberCount(Long groupId) {

		Group group =
				groupRepository.findById(groupId).orElseThrow(() -> new IllegalArgumentException());
		List<GroupMembers> groupMembersList = groupMembersRepository.findByGroup(group);

		return groupMembersList.size();
	}

	public List<Member> getMembers(Long groupId) {
		Group group =
				groupRepository.findById(groupId).orElseThrow(() -> new IllegalArgumentException());
		List<GroupMembers> groupMembersList = groupMembersRepository.findByGroup(group);
		return groupMembersList.stream()
				.map(m -> memberRepository.findOne(m.getMember().getId()))
				.collect(Collectors.toList());
	}
}
