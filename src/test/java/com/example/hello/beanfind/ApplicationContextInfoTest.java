package com.example.hello.beanfind;

import com.example.hello.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출려하기")
    void findAllBean(){
        String[] beanDefinitionName=ac.getBeanDefinitionNames();
        for (String beanT : beanDefinitionName) {
            Object bean = ac.getBean(beanT);
            System.out.println("beanT = " + beanT+" object = "+bean);
        }
    }@Test
    @DisplayName("에플리케이션 빈 출려하기")//내가 추가한 Bean 만 출력
    void findApplicationBean(){
        String[] beanDefinitionName=ac.getBeanDefinitionNames();
        for (String beanT : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanT);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                //ROLE_APPLICATION는 사용자 추가 빈 ,ROLE_INFRASTRUCTURE는 스프링 내부 빈
                Object bean = ac.getBean(beanT);
                System.out.println("beanT = " + beanT+" object = "+bean);
            }

        }
    }
}
