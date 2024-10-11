package org.opencdmp.filetransformerbase.models.misc;


import java.util.List;

public class PreprocessingPlanModel {
    private String label;

    private List<PreprocessingDescriptionModel> preprocessingDescriptionModels;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PreprocessingDescriptionModel> getPreprocessingDescriptionModels() {
        return preprocessingDescriptionModels;
    }

    public void setPreprocessingDescriptionModels(List<PreprocessingDescriptionModel> preprocessingDescriptionModels) {
        this.preprocessingDescriptionModels = preprocessingDescriptionModels;
    }
}
