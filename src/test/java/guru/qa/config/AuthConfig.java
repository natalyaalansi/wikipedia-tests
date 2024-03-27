package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config{
    @Config.Key("username")
    String getUsername();

    @Config.Key("accessKey")
    String getPassword();
}
