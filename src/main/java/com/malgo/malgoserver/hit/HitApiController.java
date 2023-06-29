package com.malgo.malgoserver.hit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HitApiController {

	private final HitService hitService;

	//	@GetMapping("/hit/{limit}")
	//	public ApiResponse<ApiResponse.SuccessBody<List<String>>> findHitKeywords(
	//			@PathVariable int limit) {
	//		Map<String, Object> response = hitService.findHitKeywords(limit);
	//		return ApiResponseGenerator.success(
	//				hitService.findHitKeywords(limit), HttpStatus.OK, MessageCode.SUCCESS);
	//	}
}
