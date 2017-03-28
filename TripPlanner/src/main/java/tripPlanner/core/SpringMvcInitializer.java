package tripPlanner.core;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import tripPlanner.config.BeanConfig;





public class SpringMvcInitializer
extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
    return new Class[] { BeanConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
    return null;
}

@Override
protected String[] getServletMappings() {
    return new String[] { "/" };
}

}