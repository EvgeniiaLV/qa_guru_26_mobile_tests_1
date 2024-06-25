package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${platform}.properties"})
public interface DeviceConfig extends Config {
    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOSVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("url")
    String getURL();
}
