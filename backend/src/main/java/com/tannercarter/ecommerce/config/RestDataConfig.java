package com.tannercarter.ecommerce.config;

import com.tannercarter.ecommerce.entities.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * <h1>RestDataConfig</h1>
 *
 * Per course instructions, include this code to configure the REST API
 * endpoints exposed for the project.
 *
 * TODO restrict non-used REST API endpoints
 *
 * @author WGU Course Materials
 * @version 0.1
 * @since 2023-02-27
 */
@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    /**
     * This method exposes standard REST API endpoints for the following classes:
     *  - Country
     *  - Customer
     *  - Division
     *  - Excursion
     *  - Vacation
     *
     * Also sets page configuration parameters.
     *
     * @param config Repository REST configuration
     * @param cors   CORS registry
     */
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config,
            CorsRegistry cors) {

        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Division.class);
        config.exposeIdsFor(Excursion.class);
        config.exposeIdsFor(Vacation.class);

        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);

        cors.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}