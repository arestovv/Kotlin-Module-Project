package app.screens

import app.data.Archive
import app.data.Item
import app.utils.ActionHelper

class ChoseArchiveScreen : BaseScreen() {
    private val choseNoteScreen = ChoseNoteScreen()
    private val createArchiveScreen = CreateArchiveScreen()
    private val archiveList = ArrayList<Archive>()

    fun show() {
        updateListItems()

        val createItem = 0
        val exitItem = itemsList.size - 2
        when (val num = ActionHelper.choseNumberAction(itemsList)) {
            createItem -> createItem()
            exitItem -> exit()
            else -> openItem(num)
        }
    }

    private fun createItem() {
        val archive = createArchiveScreen.create()
        archiveList.add(archive)
        show()
    }

    private fun openItem(num: Int) {
        val parent = archiveList[num - 1]
        choseNoteScreen.show(parent)
        show()
    }

    private fun updateListItems() {
        itemsList.clear()
        itemsList.add(Item(ITEM_LIST_ARCHIVE))
        itemsList.add(Item(ITEM_CREATE_ARCHIVE))
        for ((index, item) in archiveList.withIndex()) {
            itemsList.add(Item("${index + 1}. ${item.name}"))
        }
        itemsList.add(Item("${archiveList.size + 1}$ITEM_EXIT"))
    }

    companion object {
        private const val  ITEM_LIST_ARCHIVE = "Список архивов:"
        private const val  ITEM_CREATE_ARCHIVE = "0. Создать архив"
        private const val  ITEM_EXIT = ". Выход"
    }
}