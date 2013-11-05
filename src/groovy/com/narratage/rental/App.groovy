package com.narratage.rental

import com.narratage.rental.user.view.UserView
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

class App {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext('application-context.xml')
        UserView userView = (UserView) context.getBean("userView")
        userView.mainView()

    }

}
