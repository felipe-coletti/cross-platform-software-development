package com.petapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetAppApplication

fun main(args: Array<String>) {
	runApplication<PetAppApplication>(*args)
}
