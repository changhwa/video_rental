package com.narratage.rental.user.service

import com.narratage.rental.user.dao.UserGradeDAO
import com.narratage.rental.user.domain.User
import com.narratage.rental.user.domain.UserGrade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserGradeService {

    @Autowired
    UserGradeDAO userGradeDAO

    /**
     * 우수회원리스트를 가져온다
     * @return
     */
    public List<User> bestGradeUsers(){
        //기본값 설정시 ID = 3 이 우수회원으로 설정
        UserGrade userGrade = userGradeDAO.findOne(3L)

        if(userGrade != null){
            List<User> users = userGrade.users
            return users
        }

        null
    }

    /**
     * 등급정보를 가져온다
     * @param id
     * @return
     */
    public UserGrade getUserGrade(Long id){
        return userGradeDAO.findOne(id)
    }
}
