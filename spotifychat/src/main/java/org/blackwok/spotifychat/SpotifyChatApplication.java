package org.blackwok.spotifychat;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by Jemma on 6/17/17.
 */
public class SpotifyChatApplication extends Application<SpotifyChatConfiguration> {

    public static void main(String... args) throws Exception {
        new SpotifyChatApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SpotifyChatConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<SpotifyChatConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(SpotifyChatConfiguration spotifyChatConfiguration) {
                // this would be the preferred way to set up swagger, you can also construct the object here programtically if you want
                return spotifyChatConfiguration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(SpotifyChatConfiguration configuration, Environment environment) throws Exception {
        // add your resources as usual
        environment.jersey().register(new SpotifyChatResource());
    }
}
