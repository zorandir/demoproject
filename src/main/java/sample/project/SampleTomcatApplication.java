package sample.project;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleTomcatApplication {

    private static Log logger = LogFactory.getLog(SampleTomcatApplication.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleTomcatApplication.class, args);
    }

}
