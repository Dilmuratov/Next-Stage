package com.example.subwaysurfdemo

import java.util.*

class Game {
    private val scanner = Scanner(System.`in`)
    private val letters = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    private val targetWord = "TARGET" // Maqsetli soz
    private var score = 0

    fun play() {
        println("Oyin Baslandi!")
        println("Maqsetli sozdi jiynaw ushin hariplerdi jiynan.")
        println("Hareketlerdi kirgizin: W (Joqariga), D (onga), A (shepge), R (Artqa)")
        println("Oyindi toqtatiw ushin exit ti basin")

        while (true) {
            println("\n Maqsetli soz: ${getMaskedWord()}")
            println("Ball: $score")

            val input = scanner.nextLine().uppercase()

            if (input == "EXIT") {
                println("Oyin toxtatildi.")
                break
            }

            handleMovement(input)
            checkCollectedWord()
        }
    }

    private fun handleMovement(input: String) {
        when (input) {
            "U" -> moveUp()
            "D" -> moveDown()
            "L" -> moveLeft()
            "R" -> moveRight()
            else -> println("Qate hareket. Qaytadan kirigzing.")
        }
    }

    private fun moveUp() {
        println("joqariga harakat qilindi.")
    }

    private fun moveDown() {
        println("Tomenge harakat qilindi.")
    }

    private fun moveLeft() {
        println("Shepke harakat qilindi.")
    }

    private fun moveRight() {
        println("Onga harakat qilindi.")
    }

    private fun getMaskedWord(): String {
        val maskedWord = StringBuilder()
        for (letter in targetWord) {
            maskedWord.append(if (letters.contains(letter.toString())) "_" else letter)
        }
        return maskedWord.toString()
    }

    private fun checkCollectedWord() {
        if (targetWord.all { letters.contains(it.toString()) }) {
            score += 10
            println("Soz toplandi! Sizge 10 ball berildi.")
            resetLetters()
        }
    }

    private fun resetLetters() {
        letters.fill("")
    }
}

fun main() {
    val game = Game()
    game.play()
}