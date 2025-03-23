package app.screens

import app.data.Archive
import app.data.Item
import app.utils.ActionHelper

class ChoseNoteScreen: BaseScreen() {
    private val createNoteScreen = CreateNoteScreen()
    private val noteScreen = NoteScreen()

    fun show(parent: Archive) {
        updateListItems(parent)

        val createItem = 0
        val exitItem = itemsList.size - 2

        when (val num = ActionHelper.choseNumberAction(itemsList)) {
            createItem -> createItem(parent)
            exitItem -> exit()
            else -> openItem(parent, num)
        }
    }

    private fun createItem(parent: Archive) {
        parent.noteList.add(createNoteScreen.create())
        show(parent)
    }

    private fun openItem(parent: Archive, num: Int) {
        noteScreen.show(parent.noteList[num - 1])
        show(parent)
    }

    private fun updateListItems(parent: Archive) {
        itemsList.clear()
        itemsList.add(Item(ITEM_LIST_NOTES))
        itemsList.add(Item(ITEM_CREATE_NOTE))
        for ((index, item) in parent.noteList.withIndex()) {
            itemsList.add(Item("${index + 1}. ${item.name}"))
        }
        itemsList.add(Item("${parent.noteList.size + 1}$ITEM_EXIT"))
    }

    companion object {
        private const val  ITEM_LIST_NOTES = "Список заметок:"
        private const val  ITEM_CREATE_NOTE = "0. Создать заметку"
        private const val  ITEM_EXIT = ". Выход"
    }
}