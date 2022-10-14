package com.example.EjercicioEspecial.config;

import com.example.EjercicioEspecial.Registro.ServiceRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerVivoConfig {

    @Bean
    public FactoryBean<?> factoryBean(){
        final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(ServiceRegistry.class);
        return bean;
    }
}
