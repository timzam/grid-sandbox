package gridSandbox.data.input

data class BoxTask constructor(
    val outputFileName: String,
    val title: String,
) {

    fun toPageTask(): PageTask {
        val bodyText = "$title!"
        val page = Page(title, bodyText)
        return PageTask(outputFileName, page)
    }

}
