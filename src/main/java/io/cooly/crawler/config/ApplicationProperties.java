package io.cooly.crawler.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Parser.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.coolys.config.CoolybotProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
