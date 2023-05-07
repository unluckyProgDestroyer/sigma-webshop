package hu.sigmalimited.sigmawebshop.feature.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sigmawebshop.filestorage")
public class SigmaWebshopFileStorageProperties {


    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}