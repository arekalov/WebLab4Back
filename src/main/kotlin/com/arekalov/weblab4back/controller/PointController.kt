package com.arekalov.weblab4back.controller

import com.arekalov.weblab4back.dto.PointUserDto
import com.arekalov.weblab4back.dto.UserDto
import com.arekalov.weblab4back.model.Point
import com.arekalov.weblab4back.service.PointService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/points")
class PointController(private val pointService: PointService) {
    @GetMapping("/hello")
    fun getHello() = "Hello"

    @PostMapping("/getAll")
    fun getAllPoints(@RequestBody userDto: UserDto) =
        pointService.getAllPoints(userDto)

    @PostMapping("/addPoint")
    fun addPoint(@RequestBody pointUserDto: PointUserDto) =
        pointService.addPoint(pointUserDto = pointUserDto)

    @PostMapping("/clearAll")
    fun clearAllPoints(@RequestBody userDto: UserDto): ResponseEntity<List<Point>> =
        pointService.clearAllPoints(userDto)
}