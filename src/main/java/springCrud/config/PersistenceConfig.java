package springCrud.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("springCrud")
public class PersistenceConfig {

  private Environment env;

  @Autowired
  public void setEnvironment(Environment environment) {
    this.env = environment;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.connection.driver_class",
        env.getRequiredProperty("hibernate.connection.driver_class"));
    properties.put("hibernate.connection.url", env.getRequiredProperty("hibernate.connection.url"));
    properties.put("hibernate.connection.username",
        env.getRequiredProperty("hibernate.connection.username"));
    properties.put("hibernate.connection.password",
        env.getRequiredProperty("hibernate.connection.password"));
    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.connection.CharSet",
        env.getRequiredProperty("hibernate.connection.CharSet"));
    properties.put("hibernate.connection.characterEncoding",
        env.getRequiredProperty("hibernate.connection.characterEncoding"));
    properties.put("hibernate.connection.useUnicode",
        env.getRequiredProperty("hibernate.connection.useUnicode"));
    properties.put("hibernate.enable_lazy_load_no_trans",
        env.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
    return properties;
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("hibernate.connection.driver_class"));
    dataSource.setUrl(env.getRequiredProperty("hibernate.connection.url"));
    dataSource.setUsername(env.getRequiredProperty("hibernate.connection.username"));
    dataSource.setPassword(env.getRequiredProperty("hibernate.connection.password"));
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(getDataSource());
    sessionFactory.setPackagesToScan("springCrud.model");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}
