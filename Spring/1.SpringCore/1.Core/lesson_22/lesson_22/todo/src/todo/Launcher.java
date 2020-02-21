package todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"todo/app-context.xml"};
        
        
        ApplicationContext context = new ClassPathXmlApplicationContext(contextPaths);

		((ConfigurableApplicationContext)context).close();// закрытие контекста вручную
    }
}