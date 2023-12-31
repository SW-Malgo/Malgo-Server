package com.malgo.malgoserver.group.controller;

import com.malgo.malgoserver.config.security.AuditorHolder;
import com.malgo.malgoserver.group.dto.GroupCreateRequestDto;
import com.malgo.malgoserver.group.dto.GroupDetailResponseDto;
import com.malgo.malgoserver.group.service.GroupQueryService;
import com.malgo.malgoserver.group.service.GroupService;
import com.malgo.malgoserver.group.service.GroupServiceFacade;
import com.malgo.malgoserver.keyword.KeywordService;
import com.malgo.malgoserver.member.Member;
import com.malgo.malgoserver.member.MemberService;
import com.malgo.malgoserver.support.ApiResponse;
import com.malgo.malgoserver.support.ApiResponseGenerator;
import com.malgo.malgoserver.util.token.AuthClaims;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/group")
public class GroupController {

	private final GroupQueryService groupQueryService;
	private final GroupServiceFacade groupServiceFacade;
	private final GroupService groupService;
	private final MemberService memberService;
	private final KeywordService keywordService;

	@GetMapping("/")
	public ApiResponse<ApiResponse.SuccessBody<Result<List<GroupServiceFacade.GroupResponse>>>>
			queryGroup(@RequestParam(name = "withKeyword") Boolean withKeyword) {
		AuthClaims authClaims = AuditorHolder.get();
		Member currentUser = memberService.findMember(authClaims.getMemberId());
		List<GroupServiceFacade.GroupResponse> collection =
				groupServiceFacade.execute(currentUser.getKeywords(), withKeyword);
		return ApiResponseGenerator.success(new Result(collection), HttpStatus.OK);
	}

	@PostMapping("/")
	public ApiResponse<ApiResponse.SuccessBody<Long>> createGroup(
			@RequestBody GroupCreateRequestDto groupDto) {
		return ApiResponseGenerator.success(groupService.createGroup(groupDto), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ApiResponse<ApiResponse.SuccessBody<GroupDetailResponseDto>> groupDetail(
			@PathVariable Long id) {
		GroupDetailResponseDto responseDto = groupQueryService.getGroupDetail(id);
		return ApiResponseGenerator.success(responseDto, HttpStatus.OK);
	}

	@PostMapping("/{groupId}")
	public ApiResponse<ApiResponse.SuccessBody<String>> joinClub(@PathVariable Long groupId) {
		AuthClaims authClaims = AuditorHolder.get();
		groupService.joinGroup(authClaims.getMemberId(), groupId);
		return ApiResponseGenerator.success("join", HttpStatus.OK);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
