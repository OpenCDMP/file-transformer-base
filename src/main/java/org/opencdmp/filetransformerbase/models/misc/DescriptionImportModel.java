package org.opencdmp.filetransformerbase.models.misc;

import org.opencdmp.commonmodels.models.FileEnvelopeModel;
import org.opencdmp.commonmodels.models.descriptiotemplate.DescriptionTemplateModel;

import java.util.UUID;

public class DescriptionImportModel {
    private DescriptionTemplateModel descriptionTemplate;

    private String sectionId;

    private String id;

    FileEnvelopeModel file;


    public DescriptionTemplateModel getDescriptionTemplate() {
        return descriptionTemplate;
    }

    public void setDescriptionTemplate(DescriptionTemplateModel descriptionTemplate) {
        this.descriptionTemplate = descriptionTemplate;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FileEnvelopeModel getFile() {
        return file;
    }

    public void setFile(FileEnvelopeModel file) {
        this.file = file;
    }
}
