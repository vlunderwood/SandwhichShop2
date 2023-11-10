package dmacc.config;

//@author valei - vlunderwood CIS175 - Fall 2023 Nov 02, 2023

import org.springframework.context.annotation.Bean;



import org.springframework.context.annotation.Configuration;

import dmacc.beans.Menu;



@Configuration
public class MenuBeanConfig {
	@Bean
	public Menu menu() {
		Menu menu = new Menu();
		return menu;
		
	}
}