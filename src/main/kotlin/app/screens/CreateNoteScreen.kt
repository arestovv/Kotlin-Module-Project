package app.screens

import app.data.Note
import app.utils.InputHelper

class CreateNoteScreen: BaseScreen() {

    fun create(): Note {
        val name = InputHelper.getInputName()
        val text = InputHelper.getInputText()
        return Note(name, text)
    }
}