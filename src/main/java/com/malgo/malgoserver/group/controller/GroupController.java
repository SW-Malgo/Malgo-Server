package com.malgo.malgoserver.group.controller;

import com.malgo.malgoserver.group.service.GroupQueryService;
import com.malgo.malgoserver.group.service.GroupService;
import com.malgo.malgoserver.group.service.GroupServiceFacade;
import com.malgo.malgoserver.member.Member;
import com.malgo.malgoserver.support.ApiResponse;
import com.malgo.malgoserver.support.ApiResponseGenerator;
import com.malgo.malgoserver.util.CurrentUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/group")
public class GroupController {

    private final GroupQueryService groupQueryService;
    private final GroupServiceFacade groupServiceFacade;
    private final GroupService groupService;

    @GetMapping("/")
    public ApiResponse<ApiResponse.SuccessBody<Result<List<GroupServiceFacade.GroupResponse>>>> queryGroup(
                            @RequestParam(name = "withKeyword") Boolean withKeyword, @CurrentUser Member currentUser) {
        List<GroupServiceFacade.GroupResponse> collection = groupServiceFacade.execute(currentUser.getKeywords(), withKeyword);
        return ApiResponseGenerator.success(new Result(collection), HttpStatus.OK);
    }

//    @PostMapping("/")
//    public ApiResponse<Long> createGroup(@RequestBody GroupCreateRequestDto groupDto, @CurrentUser Member currentUser) {
//
//        Group group = Group.builder()
//                .name(groupDto.getGroupName())
//                .groupContent(groupDto.getGroupContents())
//                .max_count(10l)
//                .ownerId(currentUser.getId())
//                .build();
//        groupService.createGroup(group);
//
//
//
//    }


    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
