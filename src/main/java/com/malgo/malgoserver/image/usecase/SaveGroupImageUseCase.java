package com.malgo.malgoserver.image.usecase;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.image.entity.GroupImage;
import com.malgo.malgoserver.image.entity.GroupImageRepository;
import com.malgo.malgoserver.image.util.FileNameGenerator;
import com.malgo.malgoserver.image.util.ObjectMetadataGenerator;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SaveGroupImageUseCase {

	private static final String S3_BUCKET_DIRECTORY_NAME = "group";

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	private final GroupImageRepository groupImageRepository;
	private final AmazonS3 amazonS3Client;
	private final ObjectMetadataGenerator objectMetadataGenerator;
	private final FileNameGenerator fileNameGenerator;

	public void execute(MultipartFile multipartFile, Long groupId, Boolean thumbnail) {
		ObjectMetadata objectMetadata =
				objectMetadataGenerator.generate(multipartFile.getContentType(), multipartFile.getSize());

		String fileName =
				fileNameGenerator.generate(S3_BUCKET_DIRECTORY_NAME, multipartFile.getOriginalFilename());

		try (InputStream inputStream = multipartFile.getInputStream()) {
			amazonS3Client.putObject(
					new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
							.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			log.error("S3 파일 업로드에 실패했습니다. {}", e.getMessage());
			throw new IllegalStateException("S3 파일 업로드에 실패했습니다.");
		}

		String source = amazonS3Client.getUrl(bucket, fileName).toString();

		groupImageRepository.save(
				GroupImage.builder()
						.source(source)
						.group(Group.builder().id(groupId).build())
						.thumbnail(thumbnail)
						.build());
	}
}
