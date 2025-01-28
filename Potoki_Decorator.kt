// Задача 1
import java.io.*

fun main() {
    val inputFile = "D:/IdeaProjects/Potoki_Decorator/src/input.txt"
    val outputFile = "D:/IdeaProjects/Potoki_Decorator/src/output.txt"

    try {
        processFile(inputFile, outputFile)
        println("Файл успешно обработан и записан в '$outputFile'")
    } catch (e: IOException) {
        println("Произошла ошибка при работе с файлами: ${e.message}")
    } catch (e: FileNotFoundException) {
        println("Файл '$inputFile' не найден: ${e.message}")
    }
}

fun processFile(inputFile: String, outputFile: String) {
    BufferedReader(FileReader(inputFile)).use { reader ->
        BufferedWriter(FileWriter(outputFile)).use { writer ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val upperCaseLine = line?.uppercase() ?: ""
                writer.write(upperCaseLine)
                writer.newLine()
            }
        }
    }
}


// Задача 2
//interface TextProcessor {
//    fun process(text: String): String
//}
//
//// SimpleTextProcessor.kt
//class SimpleTextProcessor : TextProcessor {
//    override fun process(text: String): String {
//        return text
//    }
//}
//
//// Decorators.kt
//class UpperCaseDecorator(private val processor: TextProcessor) : TextProcessor {
//    override fun process(text: String): String {
//        return processor.process(text).uppercase()
//    }
//}
//
//class TrimDecorator(private val processor: TextProcessor) : TextProcessor {
//    override fun process(text: String): String {
//        return processor.process(text).trim()
//    }
//}
//
//class ReplaceDecorator(private val processor: TextProcessor) : TextProcessor {
//    override fun process(text: String): String {
//        return processor.process(text).replace(" ", "_")
//    }
//}
//// Main.kt
//fun main() {
//    val text = "  hello world  "
//    println("Исходный текст: '$text'")
//
//    // Декоратор для преобразования в верхний регистр
//    var upperCaseProcessor: TextProcessor = UpperCaseDecorator(SimpleTextProcessor())
//    println("Верхний регистр: '${upperCaseProcessor.process(text)}'")
//
//    // Декоратор для обрезки пробелов
//    var trimmedProcessor: TextProcessor = TrimDecorator(SimpleTextProcessor())
//    println("Обрезанный текст: '${trimmedProcessor.process(text)}'")
//
//    // Декоратор для замены пробелов
//    var replaceProcessor: TextProcessor = ReplaceDecorator(SimpleTextProcessor())
//    println("Замена пробелов: '${replaceProcessor.process(text)}'")
//
//
//    // Комбинирование декораторов
//    var combinedProcessor: TextProcessor = ReplaceDecorator(TrimDecorator(UpperCaseDecorator(SimpleTextProcessor())))
//    println("Комбинированные декораторы: '${combinedProcessor.process(text)}'")
//
//
//    var combinedProcessor2: TextProcessor = TrimDecorator(ReplaceDecorator(UpperCaseDecorator(SimpleTextProcessor())))
//    println("Комбинированные декораторы 2: '${combinedProcessor2.process(text)}'")
//
//
//    var combinedProcessor3: TextProcessor = UpperCaseDecorator(TrimDecorator(ReplaceDecorator(SimpleTextProcessor())))
//    println("Комбинированные декораторы 3: '${combinedProcessor3.process(text)}'")
//
//
//    var combinedProcessor4: TextProcessor = TrimDecorator(UpperCaseDecorator(ReplaceDecorator(SimpleTextProcessor())))
//    println("Комбинированные декораторы 4: '${combinedProcessor4.process(text)}'")
//
//}


//// Задача 3
//import java.io.*
//import java.nio.ByteBuffer
//import java.nio.channels.FileChannel
//import java.nio.file.Files
//import java.nio.file.Path
//import java.nio.file.Paths
//import java.nio.file.StandardOpenOption
//
//fun main() {
//    val inputFile = "large_file.txt"
//    val outputFileIO = "output_io.txt"
//    val outputFileNIO = "output_nio.txt"
//
//    // Создаем большой файл для тестирования
//    createLargeFile(inputFile, 2 * 1024 * 1024) // 2MB
//
//    println("Начало тестирования производительности IO и NIO...")
//
//    // Тестирование IO
//    val ioTime = measureTimeMillis {
//        readAndWriteIO(inputFile, outputFileIO)
//    }
//    println("Время выполнения IO: $ioTime мс")
//
//
//    // Тестирование NIO
//    val nioTime = measureTimeMillis {
//        readAndWriteNIO(inputFile, outputFileNIO)
//    }
//    println("Время выполнения NIO: $nioTime мс")
//
//    // Сравнение результатов
//    println("\nРезультаты:")
//    println("IO время: $ioTime мс")
//    println("NIO время: $nioTime мс")
//
//    if (ioTime < nioTime) {
//        println("IO быстрее чем NIO в данном тесте.")
//    } else if (nioTime < ioTime){
//        println("NIO быстрее чем IO в данном тесте.")
//    }else{
//        println("NIO и IO показали одинаковую скорость работы.")
//    }
//}
//
//fun createLargeFile(filePath: String, sizeBytes: Long) {
//    val random = java.util.Random()
//    val buffer = ByteArray(1024)
//    FileOutputStream(filePath).use { output ->
//        var written = 0L
//        while (written < sizeBytes) {
//            random.nextBytes(buffer)
//            val writeSize = minOf(buffer.size.toLong(), sizeBytes - written).toInt()
//            output.write(buffer, 0, writeSize)
//            written += writeSize
//        }
//    }
//}
//
//fun readAndWriteIO(inputFile: String, outputFile: String) {
//    BufferedReader(FileReader(inputFile)).use { reader ->
//        BufferedWriter(FileWriter(outputFile)).use { writer ->
//            reader.forEachLine { line ->
//                writer.write(line)
//                writer.newLine()
//            }
//        }
//    }
//}
//
//fun readAndWriteNIO(inputFile: String, outputFile: String) {
//    val inputPath = Paths.get(inputFile)
//    val outputPath = Paths.get(outputFile)
//
//    FileChannel.open(inputPath, StandardOpenOption.READ).use { inputChannel ->
//        FileChannel.open(outputPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { outputChannel ->
//            val buffer = ByteBuffer.allocate(8192)
//            while (inputChannel.read(buffer) != -1) {
//                buffer.flip()
//                outputChannel.write(buffer)
//                buffer.clear()
//            }
//        }
//    }
//}
//inline fun measureTimeMillis(block: () -> Unit): Long {
//    val start = System.currentTimeMillis()
//    block()
//    val end = System.currentTimeMillis()
//    return end - start
//}


//// Задача 4
//import java.io.FileInputStream
//import java.io.FileOutputStream
//import java.io.IOException
//import java.nio.channels.FileChannel
//import java.nio.file.Files
//import java.nio.file.Path
//import java.nio.file.Paths
//import kotlin.system.measureTimeMillis
//
//fun main() {
//    val sourceFile = "source.txt"
//    val destinationFile = "destination.txt"
//
//    // Создание тестового файла размером 2Гб
//    createLargeFile(sourceFile, 2L * 1024 * 1024 * 1024)
//
//    try {
//        val nioTime = measureTimeMillis {
//            copyFileNIO(sourceFile, destinationFile)
//        }
//        println("Файл успешно скопирован с помощью NIO за ${nioTime} ms")
//
//        val ioTime = measureTimeMillis {
//            copyFileIO(sourceFile, "destination_io.txt")
//        }
//        println("Файл успешно скопирован с помощью IO за ${ioTime} ms")
//
//    } catch (e: IOException) {
//        println("Произошла ошибка при копировании файла: ${e.message}")
//    } finally {
//        // Удаление тестового файла
//        deleteFile(sourceFile)
//    }
//}
//
//
//fun createLargeFile(fileName: String, size: Long) {
//    val path: Path = Paths.get(fileName)
//    try {
//        Files.createFile(path)
//        FileOutputStream(fileName).use { output ->
//            val buffer = ByteArray(1024 * 1024)
//            var bytesWritten: Long = 0
//            while (bytesWritten < size){
//                val bytesToWrite =  if(size - bytesWritten > buffer.size) buffer.size else (size - bytesWritten).toInt()
//                output.write(buffer, 0 , bytesToWrite)
//                bytesWritten += bytesToWrite;
//            }
//        }
//    } catch (e: IOException) {
//        println("Произошла ошибка при создании файла: ${e.message}")
//    }
//}
//
//
//fun copyFileNIO(source: String, dest: String) {
//    FileInputStream(source).use { srcStream ->
//        FileOutputStream(dest).use { destStream ->
//            val srcChannel = srcStream.channel
//            val destChannel = destStream.channel
//            srcChannel.transferTo(0, srcChannel.size(), destChannel)
//        }
//    }
//}
//fun copyFileIO(source: String, dest: String) {
//    FileInputStream(source).use { srcStream ->
//        FileOutputStream(dest).use { destStream ->
//            val buffer = ByteArray(1024 * 1024)
//            var bytesRead = srcStream.read(buffer)
//            while (bytesRead != -1)
//            {
//                destStream.write(buffer, 0, bytesRead)
//                bytesRead = srcStream.read(buffer)
//            }
//        }
//    }
//}
//
//fun deleteFile(fileName: String) {
//    val path: Path = Paths.get(fileName)
//    try {
//        Files.deleteIfExists(path)
//        println("Файл '$fileName' успешно удален.")
//    } catch (e: IOException) {
//        println("Произошла ошибка при удалении файла: ${e.message}")
//    }
//}


//// Задача 5
//import java.nio.ByteBuffer
//import java.nio.channels.AsynchronousFileChannel
//import java.nio.channels.CompletionHandler
//import java.nio.file.Paths
//import java.nio.file.StandardOpenOption
//
//fun main() {
//    // Путь к файлу
//    val filePath = Paths.get("D:/IdeaProjects/Potoki_Decorator/src/z5.txt")
//
//    // Открываем файл для асинхронного чтения
//    val fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ)
//
//    // Буфер для чтения данных
//    val buffer = ByteBuffer.allocate(1024)
//
//    // Позиция в файле, с которой начинаем чтение
//    val position = 0L
//
//    // Асинхронное чтение файла
//    fileChannel.read(buffer, position, buffer, object : CompletionHandler<Int, ByteBuffer> {
//        override fun completed(result: Int, attachment: ByteBuffer) {
//            if (result != -1) {
//                // Переводим буфер в режим чтения
//                attachment.flip()
//
//                // Преобразуем байты в строку и выводим на консоль
//                val data = ByteArray(attachment.remaining())
//                attachment.get(data)
//                println(String(data))
//
//                // Очищаем буфер для следующего чтения
//                attachment.clear()
//
//                // Обновляем позицию для следующего чтения
//                val newPosition = position + result
//
//                // Продолжаем чтение с новой позиции
//                fileChannel.read(attachment, newPosition, attachment, this)
//            } else {
//                // Если достигнут конец файла, закрываем канал
//                fileChannel.close()
//                println("Чтение файла завершено.")
//            }
//        }
//
//        override fun failed(exc: Throwable, attachment: ByteBuffer) {
//            // Обработка ошибок
//            println("Ошибка при чтении файла: ${exc.message}")
//            fileChannel.close()
//        }
//    })
//
//    // Ожидаем завершения асинхронных операций (для демонстрации)
//    Thread.sleep(1000)
//}



