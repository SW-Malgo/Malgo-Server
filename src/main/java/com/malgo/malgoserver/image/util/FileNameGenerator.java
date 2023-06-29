package com.malgo.malgoserver.image.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class FileNameGenerator {

	public String generate(String DirectoryName, String originalFileName) {
		return DirectoryName + "/" + UUID.randomUUID() + "." + originalFileName;
	}
}
