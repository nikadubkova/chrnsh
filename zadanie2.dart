import 'dart:math';

// 1. Функция для нахождения максимума
int findMax(int a, int b) {
  if (a == b) {
    throw IllegalArgumentException("Числа равны.");
  }
  return a > b ? a : b;
}

// 2. Калькулятор деления
double divide(double a, double b) {
  if (b == 0) {
    throw ArithmeticException("Деление на ноль недопустимо.");
  }
  return a / b;
}

// 3. Конвертер строк в числа
int stringToInt(String str) {
  try {
    return int.parse(str);
  } on FormatException {
    throw NumberFormatException("Строка не может быть преобразована в целое число.");
  }
}

// 4. Проверка возраста
void checkAge(int age) {
  if (age < 0 || age > 150) {
    throw IllegalArgumentException("Недопустимый возраст.");
  }
}

// 5. Нахождение корня
double findSqrt(double num) {
  if (num < 0) {
    throw IllegalArgumentException("Нельзя извлечь корень из отрицательного числа.");
  }
  return sqrt(num);
}


// 6. Факториал
int factorial(int n) {
  if (n < 0) {
    throw IllegalArgumentException("Факториал отрицательного числа не определен.");
  }
  int result = 1;
  for(int i = 1; i <= n; i++){
    result *= i;
  }
  return result;
}

// 7. Проверка массива на нули
void checkArrayForZeroes(List<int> arr) {
  for (int num in arr) {
    if (num == 0) {
      throw IllegalArgumentException("Массив содержит нули.");
    }
  }
}

// 8. Калькулятор возведения в степень
double power(double base, int exponent) {
  if (exponent < 0) {
    throw IllegalArgumentException("Отрицательная степень не поддерживается.");
  }
  return pow(base, exponent).toDouble();
}

// 9. Обрезка строки
String truncateString(String str, int numChars) {
  if (numChars > str.length) {
    throw IllegalArgumentException("Число символов больше длины строки.");
  }
  return str.substring(0, numChars);
}

// 10. Поиск элемента в массиве
int findElement(List<int> arr, int element) {
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == element) {
      return i;
    }
  }
  throw IllegalArgumentException("Элемент не найден в массиве.");
}

// 11. Конвертация в двоичную систему
String toBinary(int number) {
  if (number < 0) {
    throw IllegalArgumentException("Отрицательное число не может быть конвертировано в двоичное представление.");
  }
  return number.toRadixString(2);
}

// 12. Проверка делимости
bool isDivisible(int a, int b) {
  if (b == 0) {
    throw ArithmeticException("Делитель не может быть равен нулю.");
  }
  return a % b == 0;
}

// 13. Чтение элемента списка
T getElementFromList<T>(List<T> list, int index) {
  if (index < 0 || index >= list.length) {
    throw IndexOutOfBoundsException("Индекс выходит за пределы списка.");
  }
  return list[index];
}

// 14. Парольная проверка
void checkPasswordStrength(String password) {
  if (password.length < 8) {
    throw WeakPasswordException("Пароль слишком короткий.");
  }
}


// 15. Проверка даты
void validateDate(String dateStr) {
  final RegExp dateRegex = RegExp(r'^\d{2}\.\d{2}\.\d{4}$');
  if (!dateRegex.hasMatch(dateStr)) {
    throw DateTimeParseException("Некорректный формат даты. Ожидается dd.MM.yyyy");
  }
  List<String> parts = dateStr.split('.');
  int day = int.parse(parts[0]);
  int month = int.parse(parts[1]);
  int year = int.parse(parts[2]);

  if (month < 1 || month > 12) {
    throw DateTimeParseException("Некорректный формат даты. Месяц должен быть от 1 до 12");
  }
  if (day < 1 || day > 31)
    throw DateTimeParseException("Некорректный формат даты. День должен быть от 1 до 31");

  if ((month == 2 && day > 29) ||
      (month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
    throw DateTimeParseException("Некорректный формат даты.");
  }
}

// 16. Конкатенация строк
String concatenateStrings(String? str1, String? str2) {
  if (str1 == null || str2 == null) {
    throw NullPointerException("Одна из строк равна null.");
  }
  return str1 + str2;
}

// 17. Остаток от деления
int getRemainder(int a, int b) {
  if (b == 0) {
    throw ArithmeticException("Делитель не может быть равен нулю.");
  }
  return a % b;
}


// 18. Квадратный корень
double findSquareRoot(double number) {
  if (number < 0) {
    throw IllegalArgumentException("Нельзя извлечь корень из отрицательного числа.");
  }
  return sqrt(number);
}


// 19. Конвертер температуры
double celsiusToFahrenheit(double celsius) {
  if (celsius < -273.15) {
    throw IllegalArgumentException("Температура ниже абсолютного нуля.");
  }
  return (celsius * 9/5) + 32;
}


// 20. Проверка строки на пустоту
void checkStringNotEmpty(String? str) {
  if (str == null || str.isEmpty) {
    throw IllegalArgumentException("Строка пустая или равна null.");
  }
}

void main() {

  // Вызов функции 1
  try {
    print("Задача 1");
    print("--------------------");
    int max = findMax(5, 3);
    print("Максимум: $max");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    int max = findMax(5, 5);
    print("Максимум: $max"); // Не выполнится из-за исключения
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }


  // Вызов функции 2
  try {
    print("Задача 2");
    print("--------------------");
    double result = divide(10, 2);
    print("Результат деления: $result");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    double result = divide(10, 0);
    print("Результат деления: $result");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 3
  try {
    print("Задача 3");
    print("--------------------");
    int number = stringToInt("123");
    print("Число: $number");
  } on NumberFormatException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    int number = stringToInt("abc");
    print("Число: $number");
  } on NumberFormatException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 4
  try {
    print("Задача 4");
    print("--------------------");
    checkAge(25);
    print("Возраст прошел проверку");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    checkAge(-5);
    print("Возраст прошел проверку");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 5
  try {
    print("Задача 5");
    print("--------------------");
    double squareRoot = findSqrt(25);
    print("Квадратный корень: $squareRoot");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    double squareRoot = findSqrt(-25);
    print("Квадратный корень: $squareRoot");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 6
  try {
    print("Задача 6");
    print("--------------------");
    int fact = factorial(5);
    print("Факториал: $fact");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    int fact = factorial(-5);
    print("Факториал: $fact");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 7
  try {
    print("Задача 7");
    print("--------------------");
    checkArrayForZeroes([1, 2, 3]);
    print("Массив прошел проверку.");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    checkArrayForZeroes([1, 0, 3]);
    print("Массив прошел проверку.");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 8
  try {
    print("Задача 8");
    print("--------------------");
    double res = power(2, 3);
    print("Возведение в степень: $res");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    double res = power(2, -3);
    print("Возведение в степень: $res");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 9
  try {
    print("Задача 9");
    print("--------------------");
    String trimmed = truncateString("Hello world", 5);
    print("Обрезанная строка: $trimmed");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    String trimmed = truncateString("Hello world", 20);
    print("Обрезанная строка: $trimmed");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 10
  try {
    print("Задача 10");
    print("--------------------");
    int index = findElement([1, 2, 3, 4, 5], 3);
    print("Индекс элемента: $index");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    int index = findElement([1, 2, 3, 4, 5], 6);
    print("Индекс элемента: $index");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 11
  try {
    print("Задача 11");
    print("--------------------");
    String binary = toBinary(10);
    print("Двоичное представление: $binary");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    String binary = toBinary(-10);
    print("Двоичное представление: $binary");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 12
  try {
    print("Задача 12");
    print("--------------------");
    bool divisible = isDivisible(10, 2);
    print("Делится: $divisible");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    bool divisible = isDivisible(10, 0);
    print("Делится: $divisible");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 13
  try {
    print("Задача 13");
    print("--------------------");
    List<int> list = [1, 2, 3];
    int elem = getElementFromList(list, 1);
    print("Элемент списка: $elem");
  } on IndexOutOfBoundsException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    List<int> list = [1, 2, 3];
    int elem = getElementFromList(list, 5);
    print("Элемент списка: $elem");
  } on IndexOutOfBoundsException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 14
  try {
    print("Задача 14");
    print("--------------------");
    checkPasswordStrength("StrongPwd");
    print("Пароль прошел проверку");
  } on WeakPasswordException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    checkPasswordStrength("Weak");
    print("Пароль прошел проверку");
  } on WeakPasswordException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 15
  try {
    print("Задача 15");
    print("--------------------");
    validateDate("15.10.2023");
    print("Дата корректна");
  } on DateTimeParseException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    validateDate("15-10-2023");
    print("Дата корректна");
  } on DateTimeParseException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 16
  try {
    print("Задача 16");
    print("--------------------");
    String concat = concatenateStrings("Hello", "world");
    print("Результат конкатенации: $concat");
  } on NullPointerException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    String concat = concatenateStrings("Hello", null);
    print("Результат конкатенации: $concat");
  } on NullPointerException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 17
  try {
    print("Задача 17");
    print("--------------------");
    int remainder = getRemainder(10, 3);
    print("Остаток от деления: $remainder");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    int remainder = getRemainder(10, 0);
    print("Остаток от деления: $remainder");
  } on ArithmeticException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 18
  try {
    print("Задача 18");
    print("--------------------");
    double res = findSquareRoot(25);
    print("Квадратный корень: $res");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    double res = findSquareRoot(-25);
    print("Квадратный корень: $res");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 19
  try {
    print("Задача 19");
    print("--------------------");
    double tempFahr = celsiusToFahrenheit(25);
    print("Температура в Фаренгейтах: $tempFahr");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
  }
  try {
    double tempFahr = celsiusToFahrenheit(-300);
    print("Температура в Фаренгейтах: $tempFahr");
  } on IllegalArgumentException catch (e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }

  // Вызов функции 20
  try{
    print("Задача 20");
    print("--------------------");
    checkStringNotEmpty("test");
    print("Строка не пуста.");
  } on IllegalArgumentException catch(e) {
    print("Ошибка: ${e.message}");
  }
  try{
    checkStringNotEmpty("");
    print("Строка не пуста.");
  } on IllegalArgumentException catch(e) {
    print("Ошибка: ${e.message}");
  }
  try{
    checkStringNotEmpty(null);
    print("Строка не пуста.");
  } on IllegalArgumentException catch(e) {
    print("Ошибка: ${e.message}");
    print("--------------------");
  }
}

class WeakPasswordException implements Exception {
  final String message;
  WeakPasswordException(this.message);
}

class NumberFormatException implements Exception {
  final String message;
  NumberFormatException(this.message);
}

class IllegalArgumentException implements Exception {
  final String message;
  IllegalArgumentException(this.message);
}

class ArithmeticException implements Exception {
  final String message;
  ArithmeticException(this.message);
}

class IndexOutOfBoundsException implements Exception{
  final String message;
  IndexOutOfBoundsException(this.message);
}
class NullPointerException implements Exception{
  final String message;
  NullPointerException(this.message);
}
class DateTimeParseException implements Exception {
  final String message;
  DateTimeParseException(this.message);
}