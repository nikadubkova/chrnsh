import java.io.File
import java.util.Locale
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.abs

const val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдежзийклмнопрстуфхцчшщъыьэюяАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789"

fun main() {
    while(true) {
        println("Выберите действие:")
        println("1. Шифрование текста")
        println("2. Расшифровка текста с помощью ключа")
        println("3. Расшифровка текста с помощью brute force")
        println("4. Расшифровка текста с помощью статистического анализа")
        println("5. Выход")

        when (readLine()?.toIntOrNull()) {
            1 -> encryptText()
            2 -> decryptTextWithKey()
            3 -> decryptTextBruteForce()
            4 -> decryptTextStatisticalAnalysis()
            5 -> return
            else -> println("Неверный ввод. Попробуйте еще раз.")
        }
    }
}

// Валидация пути файла
fun validateFilePath(path: String): Boolean {
    return try {
        val file = File(path)
        if (!file.exists()) {
            println("Ошибка: файл по пути '$path' не существует.")
            return false
        }
        if (file.isDirectory) {
            println("Ошибка: указанный путь является директорией.")
            return false
        }
        true
    } catch (e: Exception) {
        println("Ошибка при проверке пути файла: ${e.message}")
        false
    }
}


// Валидация ключа
fun validateKey(key: Int): Boolean {
    if (key < 0 || key >= ALPHABET.length) {
        println("Ошибка: ключ должен быть от 0 до ${ALPHABET.length - 1}.")
        return false
    }
    return true
}


// Шифрование текста
fun encryptText() {
    println("Введите путь к файлу с оригинальным текстом:")
    val originalFilePath = readLine() ?: return
    if (!validateFilePath(originalFilePath)) return

    println("Введите путь для сохранения зашифрованного текста:")
    val encryptedFilePath = readLine() ?: return

    println("Введите ключ шифрования (целое число):")
    val key = readLine()?.toIntOrNull() ?: return
    if (!validateKey(key)) return

    try {
        val originalText = File(originalFilePath).readText()
        val encryptedText = caesarCipher(originalText, key)
        File(encryptedFilePath).writeText(encryptedText)
        println("Текст успешно зашифрован и сохранен в файл '$encryptedFilePath'.")

    } catch (e: Exception) {
        println("Ошибка при шифровании: ${e.message}")
    }
}

// Расшифровка текста с помощью ключа
fun decryptTextWithKey() {
    println("Введите путь к зашифрованному файлу:")
    val encryptedFilePath = readLine() ?: return
    if (!validateFilePath(encryptedFilePath)) return

    println("Введите путь для сохранения расшифрованного текста:")
    val decryptedFilePath = readLine() ?: return

    println("Введите ключ расшифровки (целое число):")
    val key = readLine()?.toIntOrNull() ?: return
    if (!validateKey(key)) return


    try {
        val encryptedText = File(encryptedFilePath).readText()
        val decryptedText = caesarCipher(encryptedText, -key) // Для расшифровки сдвигаем в обратную сторону
        File(decryptedFilePath).writeText(decryptedText)
        println("Текст успешно расшифрован и сохранен в файл '$decryptedFilePath'.")

    } catch (e: Exception) {
        println("Ошибка при расшифровке: ${e.message}")
    }
}

// Шифрование/расшифровка текста
fun caesarCipher(text: String, key: Int): String {
    return text.map { char ->
        if (ALPHABET.contains(char)) {
            val index = ALPHABET.indexOf(char)
            val newIndex = (index + key + ALPHABET.length) % ALPHABET.length
            ALPHABET[newIndex]
        } else {
            char
        }
    }.joinToString("")
}

// Расшифровка текста brute force
fun decryptTextBruteForce() {
    println("Введите путь к зашифрованному файлу:")
    val encryptedFilePath = readLine() ?: return
    if (!validateFilePath(encryptedFilePath)) return

    println("Введите путь для сохранения расшифрованного текста:")
    val decryptedFilePath = readLine() ?: return

    println("Введите (необязательно) путь к файлу с примером текста (или просто нажмите Enter):")
    val exampleFilePath = readLine()

    try {
        val encryptedText = File(encryptedFilePath).readText()
        val decryptedTexts = findBestBruteForceDecryption(encryptedText, exampleFilePath)
        if(decryptedTexts.isNotEmpty()){
            println("Возможные варианты расшифровки:")
            decryptedTexts.forEachIndexed{index, (key, text) ->
                File(decryptedFilePath + "_$index.txt").writeText(text)
                println("Ключ: $key \nФайл: ${decryptedFilePath + "_$index.txt"}")
            }
        } else {
            println("Не удалось найти расшифрованный текст, проверьте корректность входных данных")
        }
    } catch (e: Exception) {
        println("Ошибка при расшифровке brute force: ${e.message}")
    }
}


fun findBestBruteForceDecryption(encryptedText: String, exampleFilePath: String?): List<Pair<Int, String>> {
    val possibleDecryptions = mutableListOf<Pair<Int,String>>()

    if(exampleFilePath == null || !validateFilePath(exampleFilePath)){
        for(key in 0 until ALPHABET.length){
            val decryptedText = caesarCipher(encryptedText, -key)
            possibleDecryptions.add(key to decryptedText)
        }
        return possibleDecryptions
    }


    val exampleText = try {
        File(exampleFilePath).readText()
    }catch (e: Exception) {
        println("Ошибка при чтении примера файла: ${e.message}")
        return emptyList()
    }


    var bestScore = 0.0
    var bestDecryption = mutableListOf<Pair<Int,String>>()


    for(key in 0 until ALPHABET.length){
        val decryptedText = caesarCipher(encryptedText, -key)
        val score = calculateTextSimilarity(decryptedText, exampleText)
        if(score > bestScore){
            bestScore = score
            bestDecryption.clear()
            bestDecryption.add(key to decryptedText)
        } else if (abs(score-bestScore) < 0.001){
            bestDecryption.add(key to decryptedText)
        }

    }

    return bestDecryption

}


fun calculateTextSimilarity(text1: String, text2: String): Double {
    val text1Chars = text1.filter { ALPHABET.contains(it) }.lowercase().groupingBy { it }.eachCount()
    val text2Chars = text2.filter { ALPHABET.contains(it) }.lowercase().groupingBy { it }.eachCount()

    val commonChars = text1Chars.keys.filter { text2Chars.containsKey(it) }

    if (commonChars.isEmpty()){
        return 0.0
    }

    val similarityScore = commonChars.sumOf {
        val text1Count = text1Chars[it] ?: 0
        val text2Count = text2Chars[it] ?: 0
        (text1Count.toDouble() * text2Count.toDouble())
    }


    val maxLength = text1Chars.size * text2Chars.size
    if(maxLength == 0){
        return 0.0
    }
    return similarityScore / maxLength

}

// Расшифровка текста статистическим анализом
fun decryptTextStatisticalAnalysis() {
    println("Введите путь к зашифрованному файлу:")
    val encryptedFilePath = readLine() ?: return
    if (!validateFilePath(encryptedFilePath)) return

    println("Введите путь для сохранения расшифрованного текста:")
    val decryptedFilePath = readLine() ?: return

    println("Введите (необязательно) путь к файлу с примером текста (или просто нажмите Enter):")
    val exampleFilePath = readLine()

    try {
        val encryptedText = File(encryptedFilePath).readText()
        val decryptedText =  findBestStatisticalDecryption(encryptedText, exampleFilePath)

        if(decryptedText != null){
            File(decryptedFilePath).writeText(decryptedText.second)
            println("Текст успешно расшифрован и сохранен в файл '$decryptedFilePath' с ключом ${decryptedText.first}.")
        } else {
            println("Не удалось расшифровать текст, проверьте входные данные.")
        }
    } catch (e: Exception) {
        println("Ошибка при статистическом анализе: ${e.message}")
    }
}

fun findBestStatisticalDecryption(encryptedText: String, exampleFilePath: String?): Pair<Int,String>?{

    if(exampleFilePath == null || !validateFilePath(exampleFilePath)){
        println("Требуется файл с примером текста для статистического анализа.")
        return null
    }


    val exampleText = try {
        File(exampleFilePath).readText()
    }catch (e: Exception) {
        println("Ошибка при чтении примера файла: ${e.message}")
        return null
    }

    var bestScore = 0.0
    var bestDecryption: Pair<Int,String>? = null


    for(key in 0 until ALPHABET.length){
        val decryptedText = caesarCipher(encryptedText, -key)
        val score = calculateTextSimilarity(decryptedText, exampleText)
        if(score > bestScore){
            bestScore = score
            bestDecryption = key to decryptedText
        }

    }

    return bestDecryption

}

