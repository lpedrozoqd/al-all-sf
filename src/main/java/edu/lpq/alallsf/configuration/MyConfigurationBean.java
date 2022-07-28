package edu.lpq.alallsf.configuration;

import edu.lpq.alallsf.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        /**
         * Es aquí donde digo que Implementación
         * representará a la dependencia y se hace
         * más fácil el cambio.
         * */

        //return new MyBeanImplement();
        return new MyBeanTwoImplement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplements();
    }


    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }


}
