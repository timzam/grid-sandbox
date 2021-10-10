package gridSandbox.data.input

data class SiteTask internal constructor(
    val pageTasks: List<PageTask>,
) {

    constructor(vararg pageTasks: PageTask) : this(pageTasks.toList())

}
