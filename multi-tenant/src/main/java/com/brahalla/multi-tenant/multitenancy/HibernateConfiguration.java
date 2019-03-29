package com.brahalla.multitenant.multitenancy;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class HibernateConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(HibernateConfiguration.class);

  @Autowired
  private JpaProperties jpaProperties;

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    return new HibernateJpaVendorAdapter();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
    DataSource dataSource,
    MultiTenantConnectionProvider multiTenantConnectionProvider,
    CurrentTenantIdentifierResolver currentTenantIdentifierResolver
  ) {
    Map<String, Object> properties = new HashMap<>();
    properties.putAll(jpaProperties.getProperties());
    properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
    properties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
    properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
    properties.put(Environment.HBM2DDL_AUTO, "create");

    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan("com.brahalla");
    em.setJpaVendorAdapter(jpaVendorAdapter());
    em.setJpaPropertyMap(properties);
    return em;
  }

}
