package com.example.hello.beanfind;

import com.example.hello.discount.DiscountPolicy;
import com.example.hello.discount.FixDiscountPolicy;
import com.example.hello.discount.ReteDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);
    @Test
    @DisplayName("부모타입 조회시 자식이 둘이상 있으면 중복 오류 발생")
    void findBeanByParentTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(DiscountPolicy.class));
        //실제 태스트코드는 수많은 코드가 있어 sout을 사용하지 않고 o,x만 확인 할수 있도록 개발
    }
    @Test
    @DisplayName("부모타입 조회시 이름으로 구분하여 중복에러 피하기")
    void findBeanByParentTypeName(){
        DiscountPolicy reteDiscountPolicy = ac.getBean("reteDiscountPolicy", DiscountPolicy.class);
       //에러 예외에 에러가 없으면 에러 //assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean("reteDiscountPolicy",DisplayName.class));
        assertThat(reteDiscountPolicy).isInstanceOf(ReteDiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySupType(){
        ReteDiscountPolicy bean = ac.getBean(ReteDiscountPolicy.class);
        assertThat(bean).isInstanceOf(ReteDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String ,DiscountPolicy> beans=ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beans.size()).isEqualTo(2);
        for (String key : beans.keySet()) {
            System.out.println("key = " + key+" value= "+beans.get(key));
        }
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 -Object")
    void findAllBeanByOgjectType(){
        Map<String , Object> beans=ac.getBeansOfType(Object.class);
        for (String key : beans.keySet()) {
            System.out.println("key = " + key+" value= "+beans.get(key));
            //스프링도 Object를 상속 받아서 모든 것이 출력된다
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy reteDiscountPolicy(){
            return new ReteDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }


}
