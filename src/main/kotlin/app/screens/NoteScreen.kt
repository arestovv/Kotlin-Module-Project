package app.screens

import app.data.Item
import app.data.Note
import app.utils.ActionHelper
import app.utils.PrintHelper

class NoteScreen(private val note: Note) : BaseScreen() {

    override fun show() {
        updateItems()
        PrintHelper.printMessage(note.text)
        ActionHelper.getNumber(itemsList)
        exit()
    }

    override fun updateItems() {
        itemsList.clear()
        itemsList.add(Item("0. Выход"))
    }
}