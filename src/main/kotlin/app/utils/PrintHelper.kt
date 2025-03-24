package app.utils

import app.data.Item

class PrintHelper {

    companion object {
        fun printItems(itemsList: ArrayList<Item>) {
            for (item in itemsList)
                println(item.name)
        }

        fun printMessage(message: String) {
            println(message)
        }
    }
}

