package aspire.user;

import aspire.common.config.JdbcConfig;
import aspire.common.jackson.AspireJsonFilterProvider;
import aspire.common.jooq.log.JooqLoggerListener;
import aspire.common.utils.Json2Utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.jooq.tools.StopWatchListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;

@ComponentScan(value = "aspire")
@SpringBootApplication
@EnableEurekaClient
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            LOG.debug("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOG.debug("[LOADED BEAN]->" + beanName);
            }

        };
    }

    @Bean
    public DefaultDSLContext dsl(DefaultConfiguration config) {
        return new DefaultDSLContext(config);
    }

    @Bean
    public DefaultConfiguration config(Settings settings, DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setSQLDialect(SQLDialect.MYSQL);
        configuration.setSettings(settings);
        configuration.setExecuteListenerProvider(new DefaultExecuteListenerProvider(new JooqLoggerListener()), new DefaultExecuteListenerProvider(new StopWatchListener()));
        configuration.setConnectionProvider(connectionProvider);
        return configuration;
    }

    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource(DataSource dataSource) {
        return new TransactionAwareDataSourceProxy(dataSource);
    }


    @Bean(initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource dataSource(JdbcConfig jdbcConfig) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getDriverClassName());
        dataSource.setUrl(jdbcConfig.getUrl());
        dataSource.setUsername(jdbcConfig.getUsername());
        dataSource.setPassword(jdbcConfig.getPassword());
        dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        dataSource.setMaxActive(jdbcConfig.getMaxActive());
        dataSource.setInitialSize(jdbcConfig.getInitialSize());
        dataSource.setMaxWait(jdbcConfig.getMaxWait());
        dataSource.setMinIdle(jdbcConfig.getMinIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(jdbcConfig.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(jdbcConfig.getMinEvictableIdleTimeMillis());
        dataSource.setTestWhileIdle(jdbcConfig.isTestWhileIdle());
        dataSource.setTestOnBorrow(jdbcConfig.isTestOnBorrow());
        dataSource.setTestOnReturn(jdbcConfig.isTestOnReturn());
        dataSource.setMaxOpenPreparedStatements(jdbcConfig.getMaxOpenPreparedStatements());
        return dataSource;
    }


    @Bean
    public DataSourceConnectionProvider connectionProvider(TransactionAwareDataSourceProxy transactionAwareDataSource) {
        return new DataSourceConnectionProvider(transactionAwareDataSource);
    }

    @Bean
    public Settings settings() {
        Settings settings =  new Settings()
                .withExecuteLogging(false)
                .withExecuteWithOptimisticLocking(true)
                .withExecuteWithOptimisticLockingExcludeUnversioned(true)
                ;
        return settings;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = Json2Utils.newObjectMapper();
        objectMapper.setFilterProvider(new AspireJsonFilterProvider());
        return objectMapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("[REQUEST DATA] : ");
        return filter;
    }
}
