package petclinic.extpropsconf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropsConfig {

    @Autowired
    private Environment environment;

    @Value(("${guru.user}"))
    String user;
    @Value(("${guru.password}"))
    String password;
    @Value(("${guru.url}"))
    String url;


    @Value(("${guru.jms.user}"))
    String jmsUser;

    @Value(("${guru.jms.password}"))
    String jmsPass;
    @Value(("${guru.jms.url}"))
    String jmsUrl;




    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(environment.getProperty("USER"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJms fakeJms() {
        FakeJms fakeJms = new FakeJms();
        fakeJms.setJmsUser(jmsUser);
        fakeJms.setJmsPassword(jmsPass);
        fakeJms.setJmsUrl(jmsUrl);
        return fakeJms;
    }


    //    второй вариант вместо использования аннотации PropertySource сконфигурировать бин PSPC
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        configurer.setLocation(new ClassPathResource("datasource.properties"));
//        return configurer;
//    }
}
