package com.javabeginnerstutorial.bootdemo.config.oauth2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@ConditionalOnProperty(name="appsecurity.method", havingValue = "OAuth2")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_SERVER_ID = "resource-server-rest-api";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_SERVER_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
    }
}

