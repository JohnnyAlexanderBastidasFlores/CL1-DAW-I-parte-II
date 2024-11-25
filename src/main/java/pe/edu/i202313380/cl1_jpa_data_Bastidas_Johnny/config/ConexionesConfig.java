package pe.edu.i202313380.cl1_jpa_data_Bastidas_Johnny.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        // Configuración del pool de conexiones
        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(4 * 60 * 1000);
        hikariConfig.setConnectionTimeout(45 * 1000);

        return new HikariDataSource(hikariConfig);
    }
}
