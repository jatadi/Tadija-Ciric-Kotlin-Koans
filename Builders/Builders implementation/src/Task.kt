open class Tag(val name: String) {
    protected val children = mutableListOf<Tag>()

    override fun toString() =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit): TABLE {
    val table = TABLE()
    table.init()
    return table
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) {
        val tr = TR()     // Create TR element
        tr.init()         // Initialize it with the lambda
        children.add(tr)  // Add TR to TABLE's children
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) {
        val td = TD()     // Create TD element
        td.init()         // Initialize it with the lambda
        children.add(td)  // Add TD to TR's children
    }
}

class TD : Tag("td")

fun createTable() =
    table {
        tr {
            repeat(2) {
                td {
                }
            }
        }
    }

fun main() {
    println(createTable())
    //<table><tr><td></td><td></td></tr></table>
}
