package app.screens

import app.data.Archive
import app.data.Item

class ChoseArchiveScreen : BaseScreen() {
    private val archiveList = ArrayList<Archive>()

    override fun create() {
        val archive = CreateArchiveScreen().show()
        archiveList.add(archive)
        show()
    }

    override fun open(num: Int) {
        val parent = archiveList[num - 1]
        ChoseNoteScreen(parent).show()
        show()
    }

    override fun updateItems() {
        itemsList.clear()
        itemsList.add(Item(ITEM_FIRST_ARCHIVE))
        for ((index, item) in archiveList.withIndex()) {
            itemsList.add(Item("${index + 1}. ${item.name}"))
        }
        itemsList.add(Item("${archiveList.size + 1}$ITEM_EXIT"))
    }

    companion object {
        private const val ITEM_FIRST_ARCHIVE = "Список архивов:\n0. Создать архив"
        private const val ITEM_EXIT = ". Выход"
    }
}