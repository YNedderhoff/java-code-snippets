package xyz.nedderhoff.javacodesnippets.springapi.transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DatabaseContext {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseContext.class);
    @Bean
    public EmbeddedDatabase embeddedDatabase() {
        EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("import.sql")
                .build();
        return db;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(EmbeddedDatabase embeddedDatabase) {
        return new NamedParameterJdbcTemplate(embeddedDatabase);
    }

    @Bean("transactionManager")
    public PlatformTransactionManager txManager(EmbeddedDatabase embeddedDatabase) {
        return new DataSourceTransactionManager(embeddedDatabase);
    }
}
