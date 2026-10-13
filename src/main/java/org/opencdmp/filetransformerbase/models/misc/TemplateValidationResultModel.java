package org.opencdmp.filetransformerbase.models.misc;

import java.util.ArrayList;
import java.util.List;

public class TemplateValidationResultModel {
    private boolean valid;
    private List<TemplateValidationIssueModel> issues = new ArrayList<>();

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<TemplateValidationIssueModel> getIssues() {
        return issues;
    }

    public void setIssues(List<TemplateValidationIssueModel> issues) {
        this.issues = issues;
    }
}
