package com.mb.EmpMangApp.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties
@Configuration
public class PropertyConfig {
	private HashMap<String, String> properties= new HashMap<String, String>();
	
}
