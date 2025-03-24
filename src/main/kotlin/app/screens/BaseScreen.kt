package app.screens

import app.data.Item
import app.utils.ActionHelper

abstract class BaseScreen {
    protected val itemsList = ArrayList<Item>()

    open fun show() {
        updateItems()

        when (val num = ActionHelper.getNumber(itemsList)) {
            0 -> create()
            itemsList.size - 1 -> exit()
            else -> open(num)
        }
    }

    abstract fun updateItems()
    open fun create() {}
    open fun open(num: Int) {}

    fun exit() {
        return
    }
}