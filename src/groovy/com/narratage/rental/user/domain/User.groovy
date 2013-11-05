package com.narratage.rental.user.domain

import org.hibernate.FetchMode
import org.hibernate.annotations.Fetch
import org.hibernate.validator.constraints.NotEmpty

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name="Users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @NotNull
    String name

    int age

    String sex

    String address

    @NotNull
    @Column(name="phone_num")
    String phoneNum

    String content

    @ManyToOne (optional = false)
    UserGrade gradeId


}
