package com.malgo.malgoserver.keyword.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class KeywordConverter implements AttributeConverter<List<Long>, String> {

	private final String DELIMITER = ",";

	@Override
	public String convertToDatabaseColumn(List<Long> attribute) {
		StringBuilder target = new StringBuilder();
		for (Long id : attribute) {
			target.append(id).append(DELIMITER);
		}
		if (target.length() == 0) {
			return "";
		} else {
			return target.substring(0, target.length() - 1);
		}
	}

	@Override
	public List<Long> convertToEntityAttribute(String dbData) {
		if (dbData.equals("")) {
			return List.of();
		}
		return Arrays.stream(dbData.split(DELIMITER))
				.mapToLong(Long::parseLong)
				.boxed()
				.collect(Collectors.toList());
	}
}
