package app.utils

import app.data.Item
import java.util.Scanner

class InputHelper {

    companion object {
        private const val MESSAGE_NUMBER_NOT_FOUND =
            "Меню с таким номером не найдено, повторите ввод"
        private const val MESSAGE_NUMBER_NOT_CORRECT = "Для действия введите цифру"
        private const val MESSAGE_INPUT_NAME = "Введите имя"
        private const val MESSAGE_INPUT_TEXT = "Введите текст"
        private const val MESSAGE_NAME_IS_EMPTY = "Имя не может быть пустым, повторите ввод"
        private const val MESSAGE_TEXT_IS_EMPTY = "Текст не может быть пустым, повторите ввод"

        private val scanner: Scanner = Scanner(System.`in`)

        fun getInputNum(items: ArrayList<Item>): Int {
            while (true) {
                if (scanner.hasNextInt()) {
                    val input = scanner.nextInt()
                    if (input >= 0 && input <= (items.size - 1)) {
                        return input
                    } else {
                        PrintHelper.printMessage(MESSAGE_NUMBER_NOT_FOUND)
                        return -1
                    }
                } else {
                    PrintHelper.printMessage(MESSAGE_NUMBER_NOT_CORRECT)
                    scanner.next()
                    return -1
                }
            }
        }

        fun getInputName(): String {
            return getInput(MESSAGE_INPUT_NAME, MESSAGE_NAME_IS_EMPTY)
        }

        fun getInputText(): String {
            return getInput(MESSAGE_INPUT_TEXT, MESSAGE_TEXT_IS_EMPTY)
        }

        private fun getInput(infoMessage: String, errorMessage: String): String {
            PrintHelper.printMessage(infoMessage)
            var name = scanner.next()

            while (name.isEmpty()) {
                PrintHelper.printMessage(errorMessage)
                name = scanner.next()
            }
            return name
        }
    }
}