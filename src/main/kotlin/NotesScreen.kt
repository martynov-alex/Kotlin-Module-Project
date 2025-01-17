class NotesScreen {
    private val utils = Utils()

    fun run(archivesMenuIndex: Int) {
        val archiveIndex = archivesMenuIndex - 1
        val archives = RepositoryObject.getArchives()
        val chosenArchive = archives[archiveIndex]

        val archiveName = chosenArchive.name
        val notes = chosenArchive.notes

        while (true) {
            val numberOfNotes = notes.size
            utils.showMenu(entities = notes, archiveName = archiveName)
            val menuIndex = utils.readNumber(numberOfNotes)
            if (menuIndex == 0) {
                NoteMakeScreen().addNote(archiveIndex)
            } else if (menuIndex == (numberOfNotes + 1)) {
                break
            } else {
                val noteIndex = menuIndex - 1
                println("======")
                println("Имя заметки: ${notes[noteIndex].name}")
                println("Текст: ${notes[noteIndex].text}")
            }
        }
    }
}