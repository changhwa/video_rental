package com.narratage.rental.service


import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import com.narratage.rental.user.service.UserService
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService()

    @Mock
    UserDAO userDAO


    User testUser

    @Before
    public void setUp(){

        testUser = new User()

        testUser.id = 1L
        testUser.name = "홍길동"
        testUser.age = 20
        testUser.address = "대전광역시"
        testUser.sex = "1"
        testUser.content = "테스트 입니다."
    }

    @Test
    public void addUser(){

        //given
        when(userDAO.save(testUser)).thenReturn(testUser)

        //when
        userService.addUser(testUser)

        //then
        verify(userDAO).save(testUser)


    }


    @Test
    public void findByUserId(){

        //given
        Long id = testUser.id
        when(userDAO.findOne(id)).thenReturn(testUser)

        //when
        User user = userService.findByUserId(id)

        //then
        Assert.assertEquals(testUser.name, user.name)
    }




}
