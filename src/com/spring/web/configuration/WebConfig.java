package com.spring.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.web.")
public class WebConfig {
	
//	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
	  
//	  @Override
//	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    super.addResourceHandlers(registry);
//	  }
	  
	  // Tiles
	  @Bean
	  public TilesConfigurer tilesConfigurer() {
	    TilesConfigurer tiles = new TilesConfigurer();
	    tiles.setDefinitions(new String[] {
	        "/WEB-INF/layouts/default.xml",
	        "/WEB-INF/templates/**/default.jsp",
	        "/WEB-INF/tiles/**"
	    });
	    tiles.setCheckRefresh(true);
	    return tiles;
	  }
	  
	  @Bean
	  public ViewResolver viewResolver() {
	    return new TilesViewResolver();
	  }

}
