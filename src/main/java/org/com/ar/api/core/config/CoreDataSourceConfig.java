package org.com.ar.api.core.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class CoreDataSourceConfig {

    private final CoreDatabaseProperties coreDatabaseProperties;

    public CoreDataSourceConfig(CoreDatabaseProperties coreDatabaseProperties) {
        this.coreDatabaseProperties = coreDatabaseProperties;
    }

    @Bean
    @Primary    
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(coreDatabaseProperties.getUrl())
                .username(coreDatabaseProperties.getUsername())
                .password(coreDatabaseProperties.getPassword())
                .driverClassName(coreDatabaseProperties.getDriverClassName())
                .build();
    }
}
