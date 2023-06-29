package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.config.security.AuditorHolder;
import com.malgo.malgoserver.group.dto.GroupCreateRequestDto;
import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import com.malgo.malgoserver.groupmembers.GroupMembers;
import com.malgo.malgoserver.groupmembers.GroupMembersRepository;
import com.malgo.malgoserver.hit.Hit;
import com.malgo.malgoserver.hit.HitRepository;
import com.malgo.malgoserver.hit.HitService;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.member.Member;
import com.malgo.malgoserver.member.MemberRepository;
import com.malgo.malgoserver.member.MemberService;
import com.malgo.malgoserver.util.token.AuthClaims;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

	private final GroupRepository groupRepository;
	private final MemberService memberService;
	private final HitService hitService;

	public Long createGroup(GroupCreateRequestDto dto) {
		Member currentUser = memberService.findMember(AuditorHolder.get().getMemberId());
		Group group =
				Group.builder()
						.name(dto.getGroupName())
						.groupContent(dto.getGroupContents())
						.max_count(10l)
						.ownerId(currentUser.getId())
						.company(currentUser.getCompany())
						.build();
		groupRepository.save(group);

		List<Hit> hits = new ArrayList<>();
		dto.getKeywords()
				.forEach(
						tag -> {
							hits.add(
									Hit.builder()
											.keyword(Keyword.builder().group(group).tag(tag).build())
											.count(1)
											.build());
						});
		for(int i=0; i<hits.size(); i++){
			hitService.save(hits.get(i));
		}
		return group.getId();
	}

	public void joinGroup(Long memberId, Long groupId) {
		Member member = memberService.findMember(memberId);
		Group group =
				groupRepository.findById(groupId).orElseThrow(() -> new IllegalArgumentException());

		GroupMembers groupMembers = GroupMembers.builder().member(member).group(group).build();
	}
}
