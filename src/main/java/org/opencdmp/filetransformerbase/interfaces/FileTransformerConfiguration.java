package org.opencdmp.filetransformerbase.interfaces;


import org.opencdmp.commonmodels.enums.PluginEntityType;
import org.opencdmp.commonmodels.models.ConfigurationField;
import org.opencdmp.commonmodels.models.semantics.SemanticsManifest;
import org.opencdmp.filetransformerbase.models.misc.FileFormat;

import java.util.List;

public class FileTransformerConfiguration {
    private String fileTransformerId;
    private List<FileFormat> exportVariants;
    private List<PluginEntityType> exportEntityTypes;
    private List<FileFormat> importVariants;
    private List<PluginEntityType> importEntityTypes;
    private boolean useSharedStorage;
    private List<ConfigurationField> configurationFields;
    private List<ConfigurationField> userConfigurationFields;
    /** The semantic keys the plugin reads, for editors to show what it can do with a template or blueprint; optional. */
    private SemanticsManifest semantics;

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

    public List<PluginEntityType> getExportEntityTypes() {
        return exportEntityTypes;
    }

    public void setExportEntityTypes(List<PluginEntityType> exportEntityTypes) {
        this.exportEntityTypes = exportEntityTypes;
    }

    public List<PluginEntityType> getImportEntityTypes() {
        return importEntityTypes;
    }

    public void setImportEntityTypes(List<PluginEntityType> importEntityTypes) {
        this.importEntityTypes = importEntityTypes;
    }

    public List<ConfigurationField> getConfigurationFields() {
        return configurationFields;
    }

    public void setConfigurationFields(List<ConfigurationField> configurationFields) {
        this.configurationFields = configurationFields;
    }

    public List<ConfigurationField> getUserConfigurationFields() {
        return userConfigurationFields;
    }

    public void setUserConfigurationFields(List<ConfigurationField> userConfigurationFields) {
        this.userConfigurationFields = userConfigurationFields;
    }

    public SemanticsManifest getSemantics() {
        return semantics;
    }

    public void setSemantics(SemanticsManifest semantics) {
        this.semantics = semantics;
    }
}
