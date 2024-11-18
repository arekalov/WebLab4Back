package com.arekalov.weblab4back.repository

import com.arekalov.weblab4back.model.Point
import org.springframework.data.jpa.repository.JpaRepository

interface PointRepository : JpaRepository<Point, Long> {
    fun findAllByLogin(login: String): List<Point>
    fun deleteAllByLogin(login: String): List<Point>
}