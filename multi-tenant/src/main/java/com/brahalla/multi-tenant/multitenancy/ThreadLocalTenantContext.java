package com.brahalla.multitenant.multitenancy;

public class ThreadLocalTenantContext {
  private static ThreadLocal<String> tenant = new ThreadLocal<String>();

  public static void setTenant(final String name) {
    tenant.set(name);
  }

  public static String getTenant() {
    return tenant.get();
  }
}
