package com.narratage.rental.user.service

import com.narratage.rental.user.dao.UserDAO
import com.narratage.rental.user.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    UserDAO userDAO

    /**
     * 사용자 등록
     * @param user
     * @return
     */
    def addUser (User user){
        userDAO.save(user)
    }

    User findByUserId (Long id){
        User user = userDAO.findOne(id)
        user
    }


}
