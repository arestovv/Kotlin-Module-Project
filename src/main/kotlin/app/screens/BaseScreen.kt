package app.screens

import app.data.Item

abstract class BaseScreen {
    protected val itemsList = ArrayList<Item>()

    fun exit() {
        return
    }
}