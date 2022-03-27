fun main() {
    val options = arrayOf("камень", "ножницы", "бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice,gameChoice)
    }

// ф-ция "выбор игры" создаётся из математического рандома
fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random()*optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>):String{
    var isValidChoice = false
    var userChoice = " "
    // выполнять цикл, пока пользователь не введёт допустимый вариант
    while (!isValidChoice){
        // запросить у пользователя его выбор
        print("Выбери один извариантов:")
        for (item in optionsParam) print(" $item")
        println(".")
        //прочитать пользовательский ввод
        val userInput = readLine()!!.lowercase() // нижний регистр

        //проверить пользовательский ввод (что он не равен null и что он присутсвует в массиве)
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true //если ввод пользователя подошёл, то прерывается цикл
            userChoice = userInput
        }
        // если введён недопустимый вариант, то сообщить об этом пользователю
        if (!isValidChoice) println ("Ты ввел недопустимое значение. Попробуй ещё раз.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String = if (userChoice == gameChoice) "Лол! Это ничья!"
    else if ((userChoice == "камень" && gameChoice == "ножницы") ||
        (userChoice == "бумага" && gameChoice == "камень") ||
        (userChoice == "ножницы" && gameChoice == "бумага")) "Ура! Миссион комплит! Ты выиграл! :)"
    else "Потрачено."
    println("У тебя $userChoice. У меня $gameChoice. $result")
}