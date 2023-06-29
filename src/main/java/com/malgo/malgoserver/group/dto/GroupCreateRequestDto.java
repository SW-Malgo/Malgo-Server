package com.malgo.malgoserver.group.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreateRequestDto {

	//	private List<MultipartFile> images;

	private String groupName;

	private String groupContents;

	private List<String> keywords;
}
