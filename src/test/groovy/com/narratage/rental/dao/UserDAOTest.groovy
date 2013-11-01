package com.narratage.rental.dao

import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.CoreMatchers.is

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
class UserDAOTest {

    @Autowired
    UserDAO userDAO

    @Test
    public void findOne(){

        //given


        //when
        User user = userDAO.findOne(3L)

        //then
        assertThat(user.gradeId.gradeName,is("우수회원"))


    }
}
