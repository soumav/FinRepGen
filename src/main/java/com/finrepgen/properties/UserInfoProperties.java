package com.finrepgen.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "userinfo")
public class UserInfoProperties {
	
	    private String xsdpath = "";

		public String getXsdpath() {
			return xsdpath;
		}

		public void setXsdpath(String xsdpath) {
			this.xsdpath = xsdpath;
		}

	    
}
