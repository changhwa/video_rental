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

        //TODO 좀 더 효과적인 validation은 불가능할까?
        if (user.phoneNum == null || user.name == null){
            return null
        }

        userDAO.save(user)
    }

    User findByUserId (Long id){
        User user = userDAO.findOne(id)
        user
    }

    /**
     * 사용자 이름으로 찾기
     * @param name
     * @return
     */
    List<User> findByUserName(String name){
        List<User> users = userDAO.findByNameLike(name)
        users
    }

    /**
     * 사용자 전화번호로 찾기
     * @param phoneNum
     * @return
     */
    List<User> findByUserPhoneNum(String phoneNum){
        List<User> users = userDAO.findByPhoneNum(phoneNum)
        users
    }

    /**
     * 사용자정보 삭제
     * @param id
     */
    def deleteUser(Long id){
        //TODO 사용자 삭제시 확인해야하는 정보가 있는지?
        userDAO.delete(id)
    }

}
