package com.example.oauth.facebook;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookAdapter;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class CustomFacebookConnectionFactory extends OAuth2ConnectionFactory<Facebook> {

    /**
     * Create a {@link OAuth2ConnectionFactory}.
     *
     * @param appId      the provider id e.g. "facebook"
     * @param appSecret the ServiceProvider model for conducting the authorization flow and obtaining a native service API instance.
     * @param apiVersion      the ApiAdapter for mapping the provider-specific service API model to the uniform {@link Connection} interface.
     */
    public CustomFacebookConnectionFactory(String appId, String appSecret, String apiVersion) {
        super("facebook"
                , new CustomFacebookServiceProvider(appId, appSecret, apiVersion)
                , new FacebookAdapter());
    }
}
