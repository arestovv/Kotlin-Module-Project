package app.utils

import app.data.Item

class ActionHelper {

    companion object {
        fun getNumber(itemsList: ArrayList<Item>): Int {
            var num: Int = -1
            while (num == -1) {
                PrintHelper.printItems(itemsList)
                num = InputHelper.getInputNum(itemsList)
            }
            return num
        }
    }
}