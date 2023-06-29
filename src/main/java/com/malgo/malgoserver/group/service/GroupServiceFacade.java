package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.image.entity.GroupImage;
import com.malgo.malgoserver.image.entity.GroupImageRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.keywordgroup.KeywordGroup;
import com.malgo.malgoserver.keywordgroup.KeywordGroupRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceFacade {
	private final GroupQueryService groupQueryService;
	private final GroupImageRepository groupImageRepository;
	private final KeywordGroupRepository keywordGroupRepository;
	private final KeywordRepository keywordRepository;

	public List<GroupResponse> execute(List<Long> keywords, Boolean withKeyword) {
		List<Group> groups = groupQueryService.queryGroup(keywords, withKeyword);
		List<GroupImage> collect =
				groups.stream()
						.map(
								g ->
										groupImageRepository
												.findByGroup(g)
												.orElseThrow(() -> new IllegalArgumentException()))
						.collect(Collectors.toList());
		List<List<KeywordGroup>> collect1 =
				groups.stream()
						.map(g -> keywordGroupRepository.findAllByGroup(g))
						.collect(Collectors.toList());
		List<List<Keyword>> collect2 =
				collect1.stream()
						.map(
								lk ->
										lk.stream()
												.map(
														k ->
																keywordRepository
																		.findById(k.getId())
																		.orElseThrow(() -> new IllegalArgumentException()))
												.collect(Collectors.toList()))
						.collect(Collectors.toList());

		List<GroupResponse> groupResponses = new ArrayList<>();
		for (int i = 0; i < groups.size(); i++) {
			groupResponses.add(
					GroupResponse.builder()
							.groupThumbnail(collect.get(i).getSource())
							.groupName(groups.get(i).getName())
							.groupTag(collect2.get(i))
							.groupContent(groups.get(i).getGroupContent())
							.build());
		}

		return groupResponses;
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@ToString
	@Builder(toBuilder = true)
	public static class GroupResponse {
		private String groupThumbnail;
		private String groupName;
		private List<Keyword> groupTag;
		private String groupContent;
	}
}
