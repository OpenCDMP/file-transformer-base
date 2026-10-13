package org.opencdmp.filetransformerbase.models.misc;

public class TemplateValidationIssueModel {
    private TemplateValidationIssueLevel level;
    private String code;
    private String message;

    public TemplateValidationIssueModel() {
    }

    public TemplateValidationIssueModel(TemplateValidationIssueLevel level, String code, String message) {
        this.level = level;
        this.code = code;
        this.message = message;
    }

    public TemplateValidationIssueLevel getLevel() {
        return level;
    }

    public void setLevel(TemplateValidationIssueLevel level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
