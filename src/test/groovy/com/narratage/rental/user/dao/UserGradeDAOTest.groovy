package com.narratage.rental.user.dao

import com.narratage.rental.user.domain.User
import com.narratage.rental.user.domain.UserGrade
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.is

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
class UserGradeDAOTest {

    @Autowired
    UserGradeDAO userGradeDAO

    @Test
    public void save(){

        UserGrade userGrade = new UserGrade()
        userGrade.gradeName = "테스터"

        userGradeDAO.save(userGrade)

        List<UserGrade> userGrades = userGradeDAO.findAll()

        assertThat(userGrades.size(), is(4))
    }

    @Test
    public void getBestUsers(){

        UserGrade userGrade = userGradeDAO.findOne(3L)

        List<User> users = userGrade.users

        assertThat(users.size(), is(2))

    }


}
