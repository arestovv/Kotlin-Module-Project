package app.screens

import app.data.Archive
import app.utils.InputHelper

class CreateArchiveScreen {

    fun show(): Archive {
        val name = InputHelper.getInputName()
        return Archive(name)
    }
}