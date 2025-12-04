package com.itson.apimatchmaker_fitchchris;

import api.ProfilesResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(ProfilesResource.class);
        
        return classes;
    }
}
