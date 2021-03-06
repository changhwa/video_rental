package com.narratage.rental.user.service


import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.mockito.BDDMockito.given
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService()

    @Mock
    UserDAO userDAO

    //성공하는 user
    User sUser

    //실패하는 user
    User fUser

    @Before
    public void setUp(){

        //성공하는 정보
        sUser = new User()
        sUser.id = 4L
        sUser.name = "홍길동"
        sUser.age = 20
        sUser.address = "대전광역시"
        sUser.sex = "1"
        sUser.content = "테스트 입니다."
        sUser.phoneNum = "010-1111-1111"


        //실패하는 정보
        fUser = new User()
        fUser.id = 5L
        fUser.sex = "2"
    }

    @Test
    public void testAddUserFail(){

        //given
        given(userDAO.save(fUser)).willReturn(fUser)

        //when
        userService.addUser(fUser)

        //then
        verify(userDAO, never()).save(fUser)

    }

    @Test
    public void getUserList(){

        List<User> userList = new ArrayList<>()
        userList.add(sUser)

        //given
        given(userDAO.findAllByStatus("N")).willReturn(userList)

        //when
        List<User> users = userService.getUserList()

        //then
        assertThat(users.size(), is(1))
    }



    @Test
    public void findByUserId(){

        //given
        Long id = sUser.id
        given(userDAO.findOne(id)).willReturn(sUser)

        //when
        User user = userService.findByUserId(id)

        //then
        assertThat(sUser.name,is(user.name))
    }

    @Test
    public void findByUserName(){

        List<User> userList = new ArrayList<>()
        userList.add(sUser)

        //given
        String name = sUser.name
        given(userDAO.findByNameLike(name)).willReturn(userList)

        //when
        List<User> users = userService.findByUserName(name)

        //then
        assertThat(users.size(), is(1))

    }

    @Test
    public void findByUserPhoneNum(){

        List<User> userList = new ArrayList<>()
        userList.add(sUser)
        userList.add(sUser)

        //given
        String phoneNum = sUser.phoneNum
        given(userDAO.findByPhoneNum(phoneNum)).willReturn(userList)

        //when
        List<User> users = userService.findByUserPhoneNum(phoneNum)

        //then
        assertThat(users.size(), is(2))

    }


    @Test
    public void deleteUser(){

        //given


        //when
        userService.deleteUser(sUser)

        //then
        verify(userDAO).delete(sUser)

    }




}
