package org.opencdmp.filetransformerbase.models.misc;

import com.fasterxml.jackson.annotation.JsonValue;

import org.opencdmp.commonmodels.enums.EnumUtils;
import org.opencdmp.commonmodels.enums.EnumValueProvider;

import java.util.Map;

public enum TemplateValidationIssueLevel implements EnumValueProvider<Short> {
    Error((short) 0),
    Warning((short) 1);

    private final Short value;
    private static final Map<Short, TemplateValidationIssueLevel> map = EnumUtils.getEnumValueMap(TemplateValidationIssueLevel.class);

    TemplateValidationIssueLevel(Short value) {
        this.value = value;
    }

    @JsonValue
    public Short getValue() {
        return this.value;
    }

    public static TemplateValidationIssueLevel of(Short i) {
        return map.get(i);
    }
}
