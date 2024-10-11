package org.opencdmp.filetransformerbase.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.opencdmp.commonmodels.enums.EnumUtils;
import org.opencdmp.commonmodels.enums.EnumValueProvider;

import java.util.Map;

public enum FileTransformerEntityType implements EnumValueProvider<Short> {
	Plan((short) 0),
	Description((short) 1);

	private final Short value;
	private static final Map<Short, FileTransformerEntityType> map = EnumUtils.getEnumValueMap(FileTransformerEntityType.class);

	private FileTransformerEntityType(Short value) {
		this.value = value;
	}

	@JsonValue
	public Short getValue() {
		return this.value;
	}

	public static FileTransformerEntityType of(Short i) {
		return (FileTransformerEntityType)map.get(i);
	}
}