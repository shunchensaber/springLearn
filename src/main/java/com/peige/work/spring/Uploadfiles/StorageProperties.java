package com.peige.work.spring.Uploadfiles;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @ConfigurationProperties将本类中的属性和配置文件中的属性相互绑定
 */
@Component
@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
