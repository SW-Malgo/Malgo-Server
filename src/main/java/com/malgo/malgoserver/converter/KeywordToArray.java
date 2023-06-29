package com.malgo.malgoserver.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class KeywordToArray implements AttributeConverter<List<Long>, String> {

	private final String DELIMITER = ",";

	public String convertToDatabaseColumn(List<Long> attribute) {
		return String.join(DELIMITER, (CharSequence) attribute);
	}

	@Override
	public List<Long> convertToEntityAttribute(String dbData) {
		String[] arr = dbData.split(DELIMITER);
		return Arrays.stream(arr).mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
	}
}
