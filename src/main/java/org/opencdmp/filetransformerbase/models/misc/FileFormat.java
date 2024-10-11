package org.opencdmp.filetransformerbase.models.misc;

public class FileFormat {
    private String format;
    private Boolean hasLogo;
    private String icon;

    public FileFormat(String format, Boolean hasLogo, String icon) {
        this.format = format;
        this.hasLogo = hasLogo;
        this.icon = icon;
    }

    public FileFormat() {
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getHasLogo() {
        return hasLogo;
    }

    public void setHasLogo(Boolean hasLogo) {
        this.hasLogo = hasLogo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
