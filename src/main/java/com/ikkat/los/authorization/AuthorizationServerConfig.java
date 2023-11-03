package com.ikkat.los.authorization;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	private String mkmkmkm;
//	@Autowired
//	private TokenStore tokenStore;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Value("${spring.datasource.username}")
//	private String user;
//	
//	@Value("${spring.datasource.password}")
//	private String password;
//	
//	@Value("${value.url_db_authorization}")
//	private String urldb;
//	
//	
//	@Override
//	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//		configurer.jdbc(dataSource());
//	}
//	
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore)
//				.authenticationManager(authenticationManager)
//				.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
//	}
//	
//	public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl(urldb);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        
//        return dataSource;
//    }
}
