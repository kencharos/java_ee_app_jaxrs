package jp.co.ulsystems.app.rs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kentaro.maeda
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(jp.co.ulsystems.app.rs.ApplicationExceptionMapper.class);
        resources.add(jp.co.ulsystems.app.rs.BeanValidationExceptionMapper.class);
        resources.add(jp.co.ulsystems.app.rs.auth.AuthenticationFilter.class);
        resources.add(jp.co.ulsystems.app.rs.login.LoginResource.class);
        resources.add(jp.co.ulsystems.app.rs.login.LogoutResource.class);
        resources.add(jp.co.ulsystems.app.rs.login.WelcomeResource.class);
    }

}
