package com.narratage.rental.user.domain

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.LazyToOne
import org.hibernate.annotations.LazyToOneOption

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "User_Grade")
class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @NotNull
    String gradeName

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gradeId", cascade=CascadeType.ALL)
    List<User> users = new ArrayList<User>()

}
