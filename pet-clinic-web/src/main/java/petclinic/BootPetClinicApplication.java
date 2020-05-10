package petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import petclinic.extpropsconf.FakeDataSource;
import petclinic.extpropsconf.FakeJms;

@SpringBootApplication
public class BootPetClinicApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(BootPetClinicApplication.class, args);
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getUrl());

        FakeJms fakeJms=ctx.getBean(FakeJms.class);
        System.out.println(fakeJms.getJmsUser());
        System.out.println(fakeJms.getJmsPassword());
        System.out.println(fakeJms.getJmsUrl());


    }

}
