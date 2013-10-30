package com.narratage.rental

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

class App {

    static main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext('application-context.xml')


    }

}
