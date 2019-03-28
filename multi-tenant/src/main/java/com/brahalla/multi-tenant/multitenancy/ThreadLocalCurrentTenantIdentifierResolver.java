package com.brahalla.multitenant.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLocalCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {
  private static final Logger logger = LoggerFactory.getLogger(ThreadLocalCurrentTenantIdentifierResolver.class);

  @Override
  public String resolveCurrentTenantIdentifier() {
    logger.error("#### RESOLVING TENANT ####");
    return ThreadLocalTenantContext.getTenant();
  }

  @Override
  public boolean validateExistingCurrentSessions() {
    return true;
  }

}
