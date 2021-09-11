import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.itis.models.SignUpService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        SignUpService service = applicationContext.getBean(SignUpService.class);

        service.signUp("danil.korotaev02@gmail.com", "123qwerty");
    }
}
