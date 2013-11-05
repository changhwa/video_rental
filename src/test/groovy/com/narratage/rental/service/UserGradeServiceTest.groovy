package com.narratage.rental.service

import com.narratage.rental.user.dao.UserGradeDAO
import com.narratage.rental.user.domain.User
import com.narratage.rental.user.domain.UserGrade
import com.narratage.rental.user.service.UserGradeService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.hamcrest.CoreMatchers.notNullValue
import static org.mockito.BDDMockito.given
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
class UserGradeServiceTest {

    @InjectMocks
    UserGradeService userGradeService = new UserGradeService()

    @Mock
    UserGradeDAO userGradeDAO

    private ArrayList<User> userList

    private UserGrade userGrade

    @Before
    public void setUp() {

        userList = new ArrayList<>()
        userGrade = new UserGrade()

        userList.add(new User())
        userList.add(new User())


        userGrade.users = userList
        userGrade
    }

    @Test
    public void bestGradeUsers(){

        //given
        given(userGradeDAO.findOne(3L)).willReturn(userGrade)

        //when
        List<User> users = userGradeService.bestGradeUsers()

        //then
        assertThat(users.size(), is(2))

    }

    @Test
    public void bestGradeUserNullTest(){

        //given
        given(userGradeDAO.findOne(3L)).willReturn(new UserGrade())

        //when
        List<User> users = userGradeService.bestGradeUsers()

        //then
        assertThat(users,is(notNullValue()))

    }

}
