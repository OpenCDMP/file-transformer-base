package org.opencdmp.filetransformerbase.models.misc;

import org.opencdmp.commonmodels.models.FileEnvelopeModel;
import org.opencdmp.commonmodels.models.descriptiotemplate.DescriptionTemplateModel;

import java.util.UUID;

public class DescriptionImportModel {
    private DescriptionTemplateModel descriptionTemplate;

    private UUID sectionId;

    private String id;

    FileEnvelopeModel file;


    public DescriptionTemplateModel getDescriptionTemplate() {
        return descriptionTemplate;
    }

    public void setDescriptionTemplate(DescriptionTemplateModel descriptionTemplate) {
        this.descriptionTemplate = descriptionTemplate;
    }

    public UUID getSectionId() {
        return sectionId;
    }

    public void setSectionId(UUID sectionId) {
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
