package com.malgo.malgoserver.group.dto;

import com.malgo.malgoserver.image.entity.GroupImage;
import com.malgo.malgoserver.keyword.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
