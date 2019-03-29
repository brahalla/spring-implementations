package com.brahalla.multitenant.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class ThreadLocalCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {
  private static final Logger logger = LoggerFactory.getLogger(ThreadLocalCurrentTenantIdentifierResolver.class);
  private final String defaultTenant = "public";

  @Override
  public String resolveCurrentTenantIdentifier() {
    String tenant = ThreadLocalTenantContext.getTenant();
    if (tenant != null) {
      return tenant;
    } else {
      return this.defaultTenant;
    }
  }

  @Override
  public boolean validateExistingCurrentSessions() {
    return true;
  }

}
