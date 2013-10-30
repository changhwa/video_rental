package com.narratage.rental.user.dao

import com.narratage.rental.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

public interface UserDAO extends  JpaRepository<User, Long>{


}