package app.screens

import app.data.Archive
import app.data.Item

class ChoseNoteScreen(private val parent: Archive) : BaseScreen() {

    override fun create() {
        val note = CreateNoteScreen().show()
        parent.noteList.add(note)
        show()
    }

    override fun open(num: Int) {
        val note = parent.noteList[num - 1]
        NoteScreen(note).show()
        show()
    }

    override fun updateItems() {
        itemsList.clear()
        itemsList.add(Item(ITEM_FIRST_NOTES))
        for ((index, item) in parent.noteList.withIndex()) {
            itemsList.add(Item("${index + 1}. ${item.name}"))
        }
        itemsList.add(Item("${parent.noteList.size + 1}$ITEM_EXIT"))
    }

    companion object {
        private const val ITEM_FIRST_NOTES = "Список заметок:\n0. Создать заметку"
        private const val ITEM_EXIT = ". Выход"
    }
}