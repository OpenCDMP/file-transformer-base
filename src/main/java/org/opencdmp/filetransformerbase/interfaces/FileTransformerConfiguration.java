package org.opencdmp.filetransformerbase.interfaces;


import org.opencdmp.filetransformerbase.enums.FileTransformerEntityType;
import org.opencdmp.filetransformerbase.models.misc.FileFormat;

import java.util.List;

public class FileTransformerConfiguration {
    private String fileTransformerId;
    private List<FileFormat> exportVariants;
    private List<FileTransformerEntityType> exportEntityTypes;
    private List<FileFormat> importVariants;
    private List<FileTransformerEntityType> importEntityTypes;
    private boolean useSharedStorage;

    public String getFileTransformerId() {
        return fileTransformerId;
    }

    public void setFileTransformerId(String fileTransformerId) {
        this.fileTransformerId = fileTransformerId;
    }

    public List<FileFormat> getExportVariants() {
        return exportVariants;
    }

    public void setExportVariants(List<FileFormat> exportVariants) {
        this.exportVariants = exportVariants;
    }

    public List<FileFormat> getImportVariants() {
        return importVariants;
    }

    public void setImportVariants(List<FileFormat> importVariants) {
        this.importVariants = importVariants;
    }

    public boolean isUseSharedStorage() {
        return useSharedStorage;
    }

    public void setUseSharedStorage(boolean useSharedStorage) {
        this.useSharedStorage = useSharedStorage;
    }

    public List<FileTransformerEntityType> getExportEntityTypes() {
        return exportEntityTypes;
    }

    public void setExportEntityTypes(List<FileTransformerEntityType> exportEntityTypes) {
        this.exportEntityTypes = exportEntityTypes;
    }

    public List<FileTransformerEntityType> getImportEntityTypes() {
        return importEntityTypes;
    }

    public void setImportEntityTypes(List<FileTransformerEntityType> importEntityTypes) {
        this.importEntityTypes = importEntityTypes;
    }
}
