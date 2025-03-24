package app.screens

import app.data.Note
import app.utils.InputHelper

class CreateNoteScreen() {

    fun show(): Note {
        val name = InputHelper.getInputName()
        val text = InputHelper.getInputText()
        return Note(name, text)
    }
}