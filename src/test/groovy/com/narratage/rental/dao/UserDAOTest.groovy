package com.narratage.rental.dao

import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import com.narratage.rental.user.domain.UserGrade
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

    @Test
    public void findByPhoneNumTest(){

        //given
        String phoneNum = "010-1111-1111"

        //when
        List<User> users = userDAO.findByPhoneNum(phoneNum)

        //then
        assertThat(users.size(), is(3))
    }

    @Test
    public void save(){

        User user = new User()
        UserGrade userGrade = new UserGrade()
        userGrade.id = 2L

        user.gradeId = userGrade
        user.sex = "1"
        user.address = "test"
        user.age = 22
        user.name = "이름"
        user.content = "테스트"
        user.phoneNum = "011-1111-1111"
        user.status = "N"

        userDAO.save(user)

    }


}
