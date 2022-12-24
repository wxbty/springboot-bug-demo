package consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableDubbo
@SpringBootApplication
public class ConsumerApplication {

    @DubboReference
    private GameService gameService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        ConsumerApplication bean =  (ConsumerApplication) context.getBean("consumerApplication");
        System.out.println(bean.play());
        context.close();
     }

    public String play() {
//        UserSpecifiedAddressUtil.setAddress(new Address("127.0.0.1", 20885, true));
        return gameService.play("feiguohai");
    }

}
