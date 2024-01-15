package com.example.hello.beanfind;

import com.example.hello.member.MemberRepository;
import com.example.hello.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입은 둘이상 있으면 중복 오류 출력")
    void findBeanByTypeDuplicate(){
        //ac.getBean(MemberRepository.class);//실제 에러
        assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(MemberRepository.class));
        //에러 확인
    }
    @Test
    @DisplayName("이름으로 조회")
    void findBeanName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String ,MemberRepository> beans=ac.getBeansOfType(MemberRepository.class);
        //이름과 : 값으로 =같은 타입의 빈을 담기
        for (String key : beans.keySet()) {
            System.out.println("key = " + key+" value = "+beans.get(key));
        }
        System.out.println("beans = " + beans);
        assertThat(beans.size()).isEqualTo(2);//빈리스트의 크기가 같냐
    }

    @Configuration//테스트 코드에서만 적용
    static class SameBeanConfig{
        @Bean//값이 중복되는 빈 생성
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
