package pl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import pl.secuirity.IpFilter;

@SpringBootApplication
public class ClassificationApiApplication {

    @Autowired
    private IpFilter ipFilter;

    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(ipFilter);
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/");
        return registrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(ClassificationApiApplication.class, args);
    }

}
