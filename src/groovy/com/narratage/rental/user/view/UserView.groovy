package com.narratage.rental.user.view

import com.narratage.rental.user.domain.User
import com.narratage.rental.user.service.UserService
import com.narratage.rental.util.EventUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserView {

    @Autowired
    UserService userService


    def key

    public void mainView(){
        println "1. 회원등록"
        println "2. 회원수정"
        println "3. 회원삭제"
        println "4. 회원리스트보기"
        println "5. 회원검색"
        println "6. 우수회원보기"
        print "입력> "
        key = EventUtil.keyEvent()
        println ""
        selectUserMenu(key)
    }

    def userAddView(){

        User user = new User()

        print "이름 : "
        key = EventUtil.keyEvent()
        user.name = key

        println ""

        print "주소 : "
        key = EventUtil.keyEvent()
        user.address = key

        println ""

        print "나이 : "
        key = EventUtil.keyEvent()
        user.age = key

        println ""

        print "성별 : "
        key = EventUtil.keyEvent()
        user.sex = key

        println ""

        print "전화번호 : "
        key = EventUtil.keyEvent()
        user.phoneNum = key

        println ""

        print "기타 : "
        key = EventUtil.keyEvent()
        user.content = key

        println ""

        user = userService.addUser(user)

        if (user == null){
            println "등록에 실패하였습니다"
        } else {
            println "등록하였습니다"
        }

        key = EventUtil.keyEvent()
        mainView()


    }

    def userListView(){

        println "이름  //  전화번호  // 주소 // 기타 // 등급"
        List<User> users = userService.getUserList()

        if(users == null){

            println "사용자가 없습니다"

        } else {

            users.each {user->
                println user.name + "//" + user.phoneNum + "//" + user.address + "//" + user.content + "//" + user.gradeId.gradeName
            }

        }

        key = EventUtil.keyEvent()
        mainView()

    }


    private void selectUserMenu(key){

        switch (key){
            case 1:
                userAddView()
                break
            case 4:
                userListView()
                break
            default :
                break
        }
    }

}
