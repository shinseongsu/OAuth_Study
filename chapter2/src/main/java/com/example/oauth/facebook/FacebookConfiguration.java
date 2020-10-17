package com.example.oauth.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
@EnableSocial
public class FacebookConfiguration extends SocialConfigurerAdapter {

    @Autowired
    private EnhancedFacebookProperties properties;

    protected ConnectionFactory<?> createConnectionFactory() {
        return new
                CustomFacebookConnectionFactory(this.properties.getAppId(),
                this.properties.getAppSecret(),
                this.properties.getApiVersion());
    }

}
