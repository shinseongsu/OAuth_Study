package com.example.oauth.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;

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

    @Bean
    @ConditionalOnMissingBean(Facebook.class)
    @Scope(value= "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repositorry) {
        Connection<Facebook> connection =
                repositorry.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }

    @Bean
    public ConnectController connectContorller(ConnectionFactoryLocator factoryLocator, ConnectionRepository repository) {
        ConnectController controller = new ConnectController(factoryLocator, repository);
        controller.setApplicationUrl("http://localhost:8080");
        return controller;
    }

}
