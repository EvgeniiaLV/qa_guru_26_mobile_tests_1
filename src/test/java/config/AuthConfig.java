package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/auth.properties"})
public interface AuthConfig extends Config {
    @Key("user")
    String getUser();

    @Key("key")
    String getKey();
}