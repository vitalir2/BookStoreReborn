package page

import react.FC
import react.Props

interface PageObject<PROPS : Props> {
    val reactComponent: FC<PROPS>
    val route: String
}

fun <PROPS : Props> PageObject<PROPS>.toPath(vararg vars: Pair<String, String>): String {
    var result = route
    for ((name, value) in vars) {
        val newResult = result.replace(":$name", value)
        if (newResult == result) {
            error("Cannot replace variable with name=$name")
        }
        result = newResult
    }
    return result
}
