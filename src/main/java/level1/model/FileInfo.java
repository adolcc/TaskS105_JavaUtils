package level1.model;

import java.io.Serializable;

public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private boolean isDirectory;

    private long lastModified;

    public FileInfo(String name, boolean isDirectory, long lastModified) {

        this.name = name;
        this.isDirectory = isDirectory;
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "name='" + name + '\'' +
                ", isDirectory=" + isDirectory +
                ", lastModified=" + lastModified +
                '}';
    }

}