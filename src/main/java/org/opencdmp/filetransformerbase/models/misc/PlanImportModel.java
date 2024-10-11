package org.opencdmp.filetransformerbase.models.misc;

import org.opencdmp.commonmodels.models.FileEnvelopeModel;
import org.opencdmp.commonmodels.models.planblueprint.PlanBlueprintModel;

import java.util.List;

public class PlanImportModel {
    private PlanBlueprintModel blueprintModel;

    private List<DescriptionImportModel> descriptions;

    FileEnvelopeModel file;


    public PlanBlueprintModel getBlueprintModel() {
        return blueprintModel;
    }

    public void setBlueprintModel(PlanBlueprintModel blueprintModel) {
        this.blueprintModel = blueprintModel;
    }

    public List<DescriptionImportModel> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionImportModel> descriptions) {
        this.descriptions = descriptions;
    }

    public FileEnvelopeModel getFile() {
        return file;
    }

    public void setFile(FileEnvelopeModel file) {
        this.file = file;
    }
}
