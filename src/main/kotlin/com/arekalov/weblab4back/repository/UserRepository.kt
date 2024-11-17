package com.arekalov.weblab4back.repository

import com.arekalov.weblab4back.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByLogin(login: String): User?
}