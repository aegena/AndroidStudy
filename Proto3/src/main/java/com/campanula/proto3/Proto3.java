package com.campanula.proto3;

import com.campanula.study.proto3.Person;

/**
 * @author maweidong
 * @date 2022-06-02
 **/
public class Proto3 {
    public Person person = Person.newBuilder().setEmail("1104107956@qq.com").build();

    public Proto3() {
        System.out.println(person.toString());
    }
}
