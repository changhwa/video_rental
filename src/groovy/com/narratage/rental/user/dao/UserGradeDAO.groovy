package com.narratage.rental.user.dao

import com.narratage.rental.user.domain.UserGrade
import org.springframework.data.jpa.repository.JpaRepository

public interface UserGradeDAO extends JpaRepository<UserGrade, Long>{

}