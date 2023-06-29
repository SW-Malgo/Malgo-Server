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
		return String.join(DELIMITER, (CharSequence) attribute);
	}

	@Override
	public List<Long> convertToEntityAttribute(String dbData) {
		return Arrays.stream(dbData.split(DELIMITER))
				.mapToLong(Long::parseLong)
				.boxed()
				.collect(Collectors.toList());
	}
}
