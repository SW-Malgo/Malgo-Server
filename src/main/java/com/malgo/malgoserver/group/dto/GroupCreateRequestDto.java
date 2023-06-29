package com.malgo.malgoserver.group.dto;

import com.malgo.malgoserver.keyword.Keyword;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreateRequestDto {

	private List<MultipartFile> images;

	private String groupName;

	private String groupContents;

	private List<Keyword> keywords;
}