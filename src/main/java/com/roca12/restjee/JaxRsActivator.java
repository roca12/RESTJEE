package com.roca12.restjee;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(JaxRsActivator.ROOT_PATH)
public class JaxRsActivator extends Application{
    
    public static final String ROOT_PATH="/api";
    
}
