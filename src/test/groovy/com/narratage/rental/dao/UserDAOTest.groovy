package com.narratage.rental.dao

import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
class UserDAOTest {

    @Autowired
    UserDAO userDAO

    @Test
    public void save(){

        User user = new User();

        user.name = "홍길동"
        user.age = 20
        user.address = "대전광역시"
        user.sex = "1"
        user.content = "테스트 입니다."


        userDAO.save(user)

        List<User> users = userDAO.findAll() as List<User>

        Assert.assertEquals(1, users.size())
    }

}
