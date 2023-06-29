package com.malgo.malgoserver.image.util;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.stereotype.Component;

@Component
public class ObjectMetadataGenerator {

	public ObjectMetadata generate(String contentType, Long size) {
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(contentType);
		objectMetadata.setContentLength(size);
		return objectMetadata;
	}
}
