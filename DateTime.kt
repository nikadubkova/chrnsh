// Задача 1
import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    // Создаем объект LocalDate, представляющий текущую дату
    val currentDate = LocalDate.now()

    // Создаем объект LocalTime, представляющий текущее время
    val currentTime = LocalTime.now()

    // Создаем DateTimeFormatter для нужного формата
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

    // Объединяем дату и время и форматируем вывод
    val dateTimeString = formatter.format(LocalDateTime.of(currentDate, currentTime))

    // Выводим результат
    println(dateTimeString)
}


//// Задача 2
//import java.time.LocalDate
//
//fun compareDates(date1: LocalDate, date2: LocalDate): String {
//    return when {
//        date1.isAfter(date2) -> "$date1 больше чем $date2"
//        date1.isBefore(date2) -> "$date1 меньше чем $date2"
//        else -> "$date1 равна $date2"
//    }
//}
//
//fun main() {
//    val date1 = LocalDate.of(2024, 1, 15)
//    val date2 = LocalDate.of(2023, 12, 25)
//    val date3 = LocalDate.of(2024, 1, 15)
//
//    println(compareDates(date1, date2))
//    println(compareDates(date2, date1))
//    println(compareDates(date1, date3))
//}


//// Задача 3
//import java.time.LocalDate
//import java.time.temporal.ChronoUnit
//
//fun daysUntilNewYear(): Long {
//    val currentDate = LocalDate.now()
//    val currentYear = currentDate.year
//    val newYear = LocalDate.of(currentYear + 1, 1, 1)
//    return ChronoUnit.DAYS.between(currentDate, newYear)
//}
//
//fun main() {
//    val daysLeft = daysUntilNewYear()
//    println("До Нового года осталось $daysLeft дня(-ей).")
//}


//// Задача 4
//import java.util.*
//
//fun isLeapYear(year: Int): Boolean {
//    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
//}
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//    print("Введите год: ")
//    val year = scanner.nextInt()
//    scanner.close()
//
//    if (isLeapYear(year)) {
//        println("$year - високосный год")
//    } else {
//        println("$year - не високосный год")
//    }
//}


//// Задача 5
//import java.time.DayOfWeek
//import java.time.LocalDate
//import java.time.Month
//import java.time.format.DateTimeParseException
//import java.util.*
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//
//    try {
//        print("Введите месяц (число от 1 до 12): ")
//        val monthInput = scanner.nextLine()
//        val month = try {
//            Month.of(monthInput.toInt())
//        } catch (e: NumberFormatException){
//            println("Неверный формат ввода для месяца. Введите число от 1 до 12.")
//            return
//        }  catch (e: DateTimeParseException){
//            println("Неверный ввод для месяца. Введите число от 1 до 12.")
//            return
//        }
//
//        print("Введите год (например, 2023): ")
//        val yearInput = scanner.nextLine()
//
//        val year = try {
//            yearInput.toInt()
//        } catch (e: NumberFormatException) {
//            println("Неверный формат ввода для года. Введите целое число.")
//            return
//        }
//
//        val weekends = countWeekends(month, year)
//        println("Количество выходных в $month $year: $weekends")
//
//    } finally {
//        scanner.close()
//    }
//}
//
//fun countWeekends(month: Month, year: Int): Int {
//    val firstDayOfMonth = LocalDate.of(year, month, 1)
//    val lastDayOfMonth = firstDayOfMonth.lengthOfMonth()
//
//    var weekendCount = 0
//    for (day in 1..lastDayOfMonth) {
//        val currentDate = LocalDate.of(year, month, day)
//        if (currentDate.dayOfWeek == DayOfWeek.SATURDAY || currentDate.dayOfWeek == DayOfWeek.SUNDAY) {
//            weekendCount++
//        }
//    }
//    return weekendCount
//}


//// Задача 6
//fun main() {
//    println("Измерение времени выполнения цикла:")
//    val executionTime = measureExecutionTime {
//        repeat(1_000_000) {
//            //  код, время выполнения которого нужно измерить
//        }
//    }
//    println("Время выполнения: $executionTime мс")
//
//    println("Измерение времени выполнения сложной операции:")
//    val executionTime2 = measureExecutionTime {
//        complexOperation()
//    }
//    println("Время выполнения: $executionTime2 мс")
//}
//
//inline fun measureExecutionTime(block: () -> Unit): Long {
//    val start = System.nanoTime()
//    block()
//    val end = System.nanoTime()
//    return (end - start) / 1_000_000 // Convert nanoseconds to milliseconds
//}
//fun complexOperation(){
//    Thread.sleep(500) // Имитация длительной операции
//    repeat(10000){
//        val result = (0..100000).random()
//    }
//}


//// Задача 7
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//
//fun main() {
//    println("Введите дату в формате дд-мм-гггг:")
//    val inputDate = readLine() ?: ""
//
//    try {
//        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val date = LocalDate.parse(inputDate, formatter)
//        val newDate = date.plusDays(10)
//        val outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
//        val outputDate = newDate.format(outputFormatter)
//        println("Результат: $outputDate")
//    } catch (e: DateTimeParseException) {
//        println("Ошибка: Некорректный формат даты.")
//    }
//}


//// Задача 8
//import java.time.LocalDateTime
//import java.time.ZoneId
//import java.time.ZonedDateTime
//import java.time.format.DateTimeFormatter
//
//fun convertUtcToTimeZone(dateTime: LocalDateTime, targetTimeZone: String): String {
//    // 1. Задаем часовой пояс UTC
//    val utcZone = ZoneId.of("UTC")
//
//    // 2. Создаем ZonedDateTime из LocalDateTime в часовом поясе UTC
//    val utcZonedDateTime = ZonedDateTime.of(dateTime, utcZone)
//
//    // 3. Задаем целевой часовой пояс
//    val targetZone = ZoneId.of(targetTimeZone)
//
//    // 4. Конвертируем ZonedDateTime в целевой часовой пояс
//    val targetZonedDateTime = utcZonedDateTime.withZoneSameInstant(targetZone)
//
//    // 5. Форматируем результат для вывода
//    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")
//    return targetZonedDateTime.format(formatter)
//}
//
//fun main() {
//    // Пример использования
//    val utcDateTime = LocalDateTime.of(2024, 1, 1, 12, 0, 0) // 12:00:00 UTC
//    val targetTimeZone = "Europe/Moscow"
//    val convertedDateTime = convertUtcToTimeZone(utcDateTime, targetTimeZone)
//    println("UTC time: $utcDateTime")
//    println("Time in $targetTimeZone: $convertedDateTime")
//
//
//    val utcDateTime2 = LocalDateTime.of(2024, 1, 20, 18, 30, 0) // 18:30:00 UTC
//    val targetTimeZone2 = "America/New_York"
//    val convertedDateTime2 = convertUtcToTimeZone(utcDateTime2, targetTimeZone2)
//    println("UTC time: $utcDateTime2")
//    println("Time in $targetTimeZone2: $convertedDateTime2")
//}


//// Задача 9
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//import java.util.*
//
//fun main() {
//    val birthDate = readBirthDate()
//    if (birthDate != null) {
//        val age = calculateAge(birthDate)
//        println("Возраст: $age лет")
//    }
//}
//
//
//fun readBirthDate(): LocalDate? {
//    print("Введите дату рождения в формате дд.мм.гггг: ")
//    val input = readlnOrNull()
//    return try {
//        if(input.isNullOrBlank()){
//            println("Некорректный ввод. Пожалуйста, введите дату в формате дд.мм.гггг.")
//            return null;
//        }
//        LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
//    } catch (e: DateTimeParseException) {
//        println("Некорректный формат даты. Пожалуйста, введите дату в формате дд.мм.гггг.")
//        null
//    }
//}
//
//fun calculateAge(birthDate: LocalDate): Int {
//    val today = LocalDate.now()
//    val age = today.year - birthDate.year - if (today.monthValue < birthDate.monthValue ||
//        (today.monthValue == birthDate.monthValue && today.dayOfMonth < birthDate.dayOfMonth)
//    ) 1 else 0
//    return age
//}


//// Задача 10
//import java.time.DayOfWeek
//import java.time.LocalDate
//import java.time.Month
//import java.time.format.DateTimeFormatter
//import java.util.*
//
//fun main() {
//    println("Введите год: ")
//    val year = readLine()?.toIntOrNull()
//
//    println("Введите месяц (1-12): ")
//    val month = readLine()?.toIntOrNull()
//
//    if (year == null || month == null || month < 1 || month > 12) {
//        println("Некорректный ввод года или месяца.")
//        return
//    }
//
//    val selectedMonth = Month.of(month)
//    printCalendar(selectedMonth, year)
//}
//
//fun printCalendar(month: Month, year: Int) {
//    val firstDayOfMonth = LocalDate.of(year, month, 1)
//    val lastDayOfMonth = firstDayOfMonth.lengthOfMonth()
//
//    for (day in 1..lastDayOfMonth) {
//        val date = LocalDate.of(year, month, day)
//        val dayOfWeek = date.dayOfWeek
//        val dayType = if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) "Выходной" else "Рабочий день"
//        println("${date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}: $dayType")
//    }
//}


//// Задача 11
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//import java.time.temporal.ChronoUnit
//import kotlin.random.Random
//
//fun main() {
//    val startDate = readDate("Введите начальную дату (дд-мм-гггг): ")
//    val endDate = readDate("Введите конечную дату (дд-мм-гггг): ")
//
//    if (startDate != null && endDate != null) {
//        if(startDate.isAfter(endDate)){
//            println("Начальная дата не должна быть позже конечной даты.")
//            return
//        }
//        val randomDate = generateRandomDate(startDate, endDate)
//        println("Случайная дата в заданном диапазоне: ${randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}")
//    } else {
//        println("Неверный формат даты. Пожалуйста, введите реальную дату в формате дд-мм-гггг.")
//    }
//}
//
//fun readDate(prompt: String): LocalDate? {
//    print(prompt)
//    val input = readlnOrNull() ?: return null
//    return try {
//        LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
//    } catch (e: DateTimeParseException) {
//        null
//    }
//}
//
//
//fun generateRandomDate(startDate: LocalDate, endDate: LocalDate): LocalDate {
//    val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
//    val randomDay = Random.nextLong(daysBetween + 1)
//    return startDate.plusDays(randomDay)
//}


//// Задача 12
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//import java.time.temporal.ChronoUnit
//import java.time.Duration
//import java.util.*
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//
//    println("Введите дату и время события в формате гггг-мм-дд чч:мм:сс: ")
//    val eventDateTimeString = scanner.nextLine()
//
//    try {
//        val eventDateTime = LocalDateTime.parse(eventDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//        val timeUntilEvent = calculateTimeUntilEvent(eventDateTime)
//        println(timeUntilEvent)
//    } catch (e: DateTimeParseException) {
//        println("Неверный формат даты и времени. Используйте формат гггг-мм-дд чч:мм:сс")
//    } catch (e: Exception) {
//        println("Произошла ошибка: ${e.message}")
//    } finally {
//        scanner.close()
//    }
//}
//
//fun calculateTimeUntilEvent(eventDateTime: LocalDateTime): String {
//    val now = LocalDateTime.now()
//    val duration = Duration.between(now, eventDateTime)
//
//    if (duration.isNegative) {
//        return "Событие уже прошло."
//    }
//
//    val seconds = duration.seconds % 60
//    val minutes = (duration.toMinutes() % 60).toInt()
//    val hours = (duration.toHours() % 24).toInt()
//    val days = duration.toDaysPart().toInt()
//
//
//    return when {
//        days > 0 -> "Осталось: $days дней, $hours часов, $minutes минут, $seconds секунд."
//        hours > 0 -> "Осталось: $hours часов, $minutes минут, $seconds секунд."
//        minutes > 0 -> "Осталось: $minutes минут, $seconds секунд."
//        else -> "Осталось: $seconds секунд."
//    }
//}



//// Задача 13
//import java.time.DayOfWeek
//import java.time.Duration
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//import java.util.Scanner
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//
//    try {
//        print("Введите начало рабочего дня (гггг-мм-дд чч:мм): ")
//        val startTimeStr = scanner.nextLine()
//        val startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//
//        print("Введите конец рабочего дня (гггг-мм-дд чч:мм): ")
//        val endTimeStr = scanner.nextLine()
//        val endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//
//
//        val workingHours = calculateWorkingHours(startTime, endTime)
//        println("Количество рабочих часов: $workingHours")
//    } catch (e: DateTimeParseException) {
//        println("Неверный формат даты и времени. Используйте формат: гггг-мм-дд чч:мм")
//    } catch (e: IllegalArgumentException){
//        println(e.message)
//    }
//    catch (e: Exception) {
//        println("Произошла ошибка: ${e.message}")
//    }
//    finally {
//        scanner.close()
//    }
//}
//
//fun calculateWorkingHours(start: LocalDateTime, end: LocalDateTime): Long {
//    if (start.isAfter(end)) {
//        throw IllegalArgumentException("Время начала не может быть после времени окончания.")
//    }
//    var totalHours = 0L
//    var current = start
//
//    while (current.isBefore(end)){
//        if(current.dayOfWeek != DayOfWeek.SATURDAY && current.dayOfWeek != DayOfWeek.SUNDAY)
//        {
//            totalHours += Duration.between(current, current.plusHours(1)).toHours()
//        }
//        current = current.plusHours(1)
//    }
//
//    return totalHours
//}


//// Задача 14
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.util.Locale
//import java.util.Scanner
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//
//    print("Введите дату в формате гггг-мм-дд: ")
//    val dateString = scanner.nextLine()
//
//    try {
//        val date = LocalDate.parse(dateString)
//
//        print("Введите локаль (например, ru или en): ")
//        val localeString = scanner.nextLine()
//        val locale = Locale(localeString)
//
//
//        val formattedDate = formatDate(date, locale)
//        println("Дата в формате $localeString: $formattedDate")
//
//
//    } catch (e: Exception) {
//        println("Ошибка ввода. Пожалуйста, введите дату в формате гггг-мм-дд и валидную локаль (например, ru или en).")
//    } finally {
//        scanner.close()
//    }
//}
//
//
//fun formatDate(date: LocalDate, locale: Locale): String {
//    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale)
//    return date.format(formatter)
//}


//// Задача 15
//import java.time.DayOfWeek
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//import java.util.*
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
//
//    while (true) {
//        print("Введите дату в формате дд.мм.гггг (или 'выход' для завершения): ")
//        val input = scanner.nextLine()
//
//        if (input.equals("выход", ignoreCase = true)) {
//            break
//        }
//
//        try {
//            val date = LocalDate.parse(input, formatter)
//            val dayOfWeek = getDayOfWeekName(date)
//            println("День недели: $dayOfWeek")
//        } catch (e: DateTimeParseException) {
//            println("Неверный формат даты. Пожалуйста, используйте формат дд.мм.гггг")
//        }
//    }
//
//    scanner.close()
//}
//
//fun getDayOfWeekName(date: LocalDate): String {
//    return when (date.dayOfWeek) {
//        DayOfWeek.MONDAY -> "Понедельник"
//        DayOfWeek.TUESDAY -> "Вторник"
//        DayOfWeek.WEDNESDAY -> "Среда"
//        DayOfWeek.THURSDAY -> "Четверг"
//        DayOfWeek.FRIDAY -> "Пятница"
//        DayOfWeek.SATURDAY -> "Суббота"
//        DayOfWeek.SUNDAY -> "Воскресенье"
//    }
//}