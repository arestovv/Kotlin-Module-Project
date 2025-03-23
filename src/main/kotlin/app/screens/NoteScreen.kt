package app.screens

import app.data.Item
import app.data.Note
import app.utils.ActionHelper

class NoteScreen: BaseScreen() {

    fun show(note: Note) {
        updateListItems(note)
        ActionHelper.choseNumberAction(itemsList)
        exit()
    }

    private fun updateListItems(note: Note) {
        itemsList.clear()
        itemsList.add(Item(note.text))
        itemsList.add(Item("0. Выход"))
    }



}