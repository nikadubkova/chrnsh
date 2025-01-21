import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    // Задача 1: Четное или нечетное число
    println("Задача 1: Четное или нечетное число")
    print("Введите целое число: ")
    val num1 = readLine()?.toIntOrNull()
    if (num1 != null) {
        if (num1 % 2 == 0) {
            println("$num1 - четное число.")
        } else {
            println("$num1 - нечетное число.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")


    // Задача 2: Минимальное из трех чисел
    println("Задача 2: Минимальное из трех чисел")
    print("Введите три целых числа через пробел: ")
    val input2 = readLine()?.split(" ")
    if (input2 != null && input2.size == 3) {
        val nums2 = input2.map { it.toIntOrNull() }
        if (nums2.all { it != null }) {
            val minNum = nums2.filterNotNull().minOrNull()
            println("Минимальное число: $minNum")
        } else {
            println("Ошибка ввода чисел.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 3: Таблица умножения на 5
    println("Задача 3: Таблица умножения на 5")
    for (i in 1..10) {
        println("5 x $i = ${5 * i}")
    }
    println("--------------------")

    // Задача 4: Сумма чисел от 1 до N
    println("Задача 4: Сумма чисел от 1 до N")
    print("Введите целое число N: ")
    val num4 = readLine()?.toIntOrNull()
    if (num4 != null && num4 > 0) {
        var sum4 = 0
        for (i in 1..num4) {
            sum4 += i
        }
        println("Сумма чисел от 1 до $num4: $sum4")
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")


    // Задача 5: Числа Фибоначчи
    println("Задача 5: Числа Фибоначчи")
    print("Введите целое число N: ")
    val num5 = readLine()?.toIntOrNull()
    if (num5 != null && num5 > 0) {
        var a = 0
        var b = 1
        print("Первые $num5 чисел Фибоначчи: ")
        for (i in 1..num5) {
            print("$a ")
            val next = a + b
            a = b
            b = next
        }
        println()

    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 6: Проверка простого числа
    println("Задача 6: Проверка простого числа")
    print("Введите целое число: ")
    val num6 = readLine()?.toIntOrNull()
    if (num6 != null) {
        var isPrime = true
        if (num6 <= 1) {
            isPrime = false
        } else {
            for (i in 2..sqrt(num6.toDouble()).toInt()) {
                if (num6 % i == 0) {
                    isPrime = false
                    break
                }
            }
        }
        if (isPrime) {
            println("$num6 - простое число.")
        } else {
            println("$num6 - не простое число.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 7: Обратный порядок чисел
    println("Задача 7: Обратный порядок чисел")
    print("Введите целое число N: ")
    val num7 = readLine()?.toIntOrNull()
    if (num7 != null && num7 > 0) {
        print("Числа от $num7 до 1: ")
        for (i in num7 downTo 1) {
            print("$i ")
        }
        println()
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 8: Сумма четных чисел в диапазоне
    println("Задача 8: Сумма четных чисел в диапазоне")
    print("Введите два целых числа A и B через пробел: ")
    val input8 = readLine()?.split(" ")
    if (input8 != null && input8.size == 2) {
        val nums8 = input8.map { it.toIntOrNull() }
        if (nums8.all { it != null }) {
            val a = nums8[0]!!;
            val b = nums8[1]!!
            var sum8 = 0
            for (i in a..b) {
                if (i % 2 == 0) {
                    sum8 += i
                }
            }
            println("Сумма четных чисел от $a до $b: $sum8")
        } else {
            println("Ошибка ввода чисел.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 9: Реверс строки
    println("Задача 9: Реверс строки")
    print("Введите строку: ")
    val str9 = readLine()
    if (str9 != null) {
        println("Строка в обратном порядке: ${str9.reversed()}")
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 10: Количество цифр в числе
    println("Задача 10: Количество цифр в числе")
    print("Введите целое число: ")
    val num10 = readLine()?.toIntOrNull()
    if (num10 != null) {
        println("Количество цифр в числе $num10: ${num10.toString().length}")
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 11: Факториал числа
    println("Задача 11: Факториал числа")
    print("Введите целое число N: ")
    val num11 = readLine()?.toIntOrNull()
    if (num11 != null && num11 >= 0) {
        var factorial: Long = 1
        for (i in 1..num11) {
            factorial *= i.toLong()
        }
        println("Факториал числа $num11: $factorial")

    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 12: Сумма цифр числа
    println("Задача 12: Сумма цифр числа")
    print("Введите целое число: ")
    val num12 = readLine()?.toIntOrNull()
    if (num12 != null) {
        var sum12 = 0
        var temp = num12
        while (temp > 0) {
            sum12 += temp % 10
            temp /= 10
        }
        println("Сумма цифр числа $num12: $sum12")
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 13: Палиндром
    println("Задача 13: Палиндром")
    print("Введите строку: ")
    val str13 = readLine()
    if (str13 != null) {
        val reversedStr = str13.reversed()
        if (str13.equals(reversedStr, ignoreCase = true)) {
            println("Строка '$str13' является палиндромом.")
        } else {
            println("Строка '$str13' не является палиндромом.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")


    // Задача 14: Найти максимальное число в массиве
    println("Задача 14: Найти максимальное число в массиве")
    print("Введите размер массива: ")
    val size14 = readLine()?.toIntOrNull()

    if (size14 != null && size14 > 0){
        print("Введите элементы массива через пробел: ")
        val input14 = readLine()?.split(" ")
        if(input14 != null && input14.size == size14){
            val numbers14 = input14.map { it.toIntOrNull() }
            if(numbers14.all{ it != null })
            {
                val maxNum = numbers14.filterNotNull().maxOrNull()
                println("Максимальное число в массиве: $maxNum")
            } else {
                println("Ошибка ввода чисел")
            }
        }else {
            println("Ошибка ввода")
        }

    } else {
        println("Ошибка ввода размера массива.")
    }
    println("--------------------")

    // Задача 15: Сумма всех элементов массива
    println("Задача 15: Сумма всех элементов массива")
    print("Введите размер массива: ")
    val size15 = readLine()?.toIntOrNull()
    if (size15 != null && size15 > 0) {
        print("Введите элементы массива через пробел: ")
        val input15 = readLine()?.split(" ")
        if(input15 != null && input15.size == size15)
        {
            val numbers15 = input15.map { it.toIntOrNull() }
            if (numbers15.all {it != null}){
                val sum15 = numbers15.filterNotNull().sum()
                println("Сумма элементов массива: $sum15")
            } else {
                println("Ошибка ввода чисел.")
            }

        } else {
            println("Ошибка ввода")
        }
    } else {
        println("Ошибка ввода размера массива.")
    }
    println("--------------------")

    // Задача 16: Количество положительных и отрицательных чисел
    println("Задача 16: Количество положительных и отрицательных чисел")
    print("Введите размер массива: ")
    val size16 = readLine()?.toIntOrNull()
    if (size16 != null && size16 > 0) {
        print("Введите элементы массива через пробел: ")
        val input16 = readLine()?.split(" ")
        if(input16 != null && input16.size == size16)
        {
            val numbers16 = input16.map { it.toIntOrNull() }
            if(numbers16.all{ it!= null}) {
                var positiveCount = 0
                var negativeCount = 0

                for (num in numbers16.filterNotNull()) {
                    if (num > 0) {
                        positiveCount++
                    } else if (num < 0) {
                        negativeCount++
                    }
                }

                println("Количество положительных чисел: $positiveCount")
                println("Количество отрицательных чисел: $negativeCount")
            } else {
                println("Ошибка ввода чисел.")
            }

        } else {
            println("Ошибка ввода.")
        }
    } else {
        println("Ошибка ввода размера массива.")
    }
    println("--------------------")


    // Задача 17: Простые числа в диапазоне
    println("Задача 17: Простые числа в диапазоне")
    print("Введите два целых числа A и B через пробел: ")
    val input17 = readLine()?.split(" ")
    if (input17 != null && input17.size == 2) {
        val nums17 = input17.map{ it.toIntOrNull()}
        if (nums17.all{ it != null}) {
            val a = nums17[0]!!
            val b = nums17[1]!!

            print("Простые числа в диапазоне от $a до $b: ")
            for (i in a..b) {
                var isPrime = true
                if (i <= 1) {
                    isPrime = false
                } else {
                    for (j in 2..sqrt(i.toDouble()).toInt()) {
                        if (i % j == 0) {
                            isPrime = false
                            break
                        }
                    }
                }
                if (isPrime) {
                    print("$i ")
                }
            }
            println()
        } else {
            println("Ошибка ввода чисел.")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 18: Подсчет гласных и согласных в строке
    println("Задача 18: Подсчет гласных и согласных в строке")
    print("Введите строку: ")
    val str18 = readLine()
    if(str18 != null) {
        var vowels = 0
        var consonants = 0
        val lowered = str18.toLowerCase()

        for (char in lowered) {
            if (char in "aeiouyауоыэеиюя") {
                vowels++
            } else if (char in 'a'..'z' || char in 'а'..'я') {
                consonants++
            }
        }

        println("Гласных букв: $vowels")
        println("Согласных букв: $consonants")
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")

    // Задача 19: Перестановка слов в строке
    println("Задача 19: Перестановка слов в строке")
    print("Введите строку из нескольких слов: ")
    val str19 = readLine()
    if (str19 != null) {
        val words = str19.split(" ")
        val reversedWords = words.reversed().joinToString(" ")
        println("Строка со словами в обратном порядке: $reversedWords")

    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")


    // Задача 20: Число Армстронга
    println("Задача 20: Число Армстронга")
    print("Введите целое число: ")
    val num20 = readLine()?.toIntOrNull()
    if (num20 != null) {
        val numStr = num20.toString()
        val numDigits = numStr.length
        var sumOfPowers = 0.0
        for(digitChar in numStr){
            val digit = digitChar.toString().toInt()
            sumOfPowers += digit.toDouble().pow(numDigits.toDouble())
        }
        if (sumOfPowers.toInt() == num20){
            println("$num20 является числом Армстронга")
        } else {
            println("$num20 не является числом Армстронга")
        }
    } else {
        println("Ошибка ввода.")
    }
    println("--------------------")
}