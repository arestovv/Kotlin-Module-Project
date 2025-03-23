package app.screens

import app.data.Archive
import app.utils.InputHelper

class CreateArchiveScreen: BaseScreen(){

    fun create(): Archive{
        val name = InputHelper.getInputName()
        return Archive(name)
    }
}