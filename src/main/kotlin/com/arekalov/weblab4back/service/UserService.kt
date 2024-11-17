package com.arekalov.weblab4back.service

import com.arekalov.weblab4back.dto.UserDto
import com.arekalov.weblab4back.model.User
import com.arekalov.weblab4back.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun loginUser(userDto: UserDto): ResponseEntity<String> {
        val user =
            userRepository.findByLogin(userDto.login) ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        if (user.password != userDto.password) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
        return ResponseEntity.ok(user.login)
    }

    fun signUpUser(userDto: UserDto): ResponseEntity<String> {
        val exist = userRepository.findByLogin(userDto.login) != null
        if (exist) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        val user = User(login = userDto.login, password = userDto.password)
        return ResponseEntity.ok(userRepository.save(user).login)
    }
}