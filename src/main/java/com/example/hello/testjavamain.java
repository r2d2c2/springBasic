package com.example.hello;

public class testjavamain {
    public static void main(String[] args) {
        System.out.println(fun(1,2));
        //System.out.println(fun(b=1,a=2));//python에서는 가능하지만 java에서는 안됨
    }
    static String fun (int a,int b){
        return "a값은 %d 이고 b의값은 %d 입니다.".formatted(a,b);
        //c#의 $"{a}"과 같은 기능은 없다
    }

}
