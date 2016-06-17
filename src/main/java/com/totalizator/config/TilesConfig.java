package com.totalizator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * Created by kasyanov on 6/17/2016.
 */


@Configuration
public class TilesConfig {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {
				"/WEB-INF/tiles-definitions.xml"
		});
		return configurer;
	}
}
