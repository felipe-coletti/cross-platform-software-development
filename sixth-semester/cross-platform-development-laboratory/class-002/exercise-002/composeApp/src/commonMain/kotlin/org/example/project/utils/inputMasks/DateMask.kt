package org.example.project.utils.inputMasks

fun applyDateMask(input: String): String {
    val digits = input.filter { it.isDigit() }
    return buildString {
        for ((i, c) in digits.withIndex()) {
            append(c)
            if (i == 1 || i == 3) append('/')
            if (i == 7) break
        }
    }
}
