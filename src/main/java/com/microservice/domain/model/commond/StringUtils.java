package com.microservice.domain.model.commond;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringUtils {

	private StringUtils() {
	}

	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

	public static boolean isNumberFormat(String str) {
		return NUMBER_PATTERN.matcher(str).matches();
	}


}
