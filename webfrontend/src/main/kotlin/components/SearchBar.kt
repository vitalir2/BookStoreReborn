package components

import csstype.Color
import csstype.em
import csstype.rem
import kotlinext.js.jso
import mui.icons.material.SearchOutlined
import mui.material.*
import react.FC
import react.Props
import react.create
import react.dom.html.ButtonType
import react.useState
import style.Colors

val SearchBar = FC<Props> {
    FormControl {
        val (text, setText) = useState("")

        sx = jso {
            width = 20.em
            height = 2.rem
            margin = 0.5.rem

            backgroundColor = Color(Colors.white)
        }
        variant = FormControlVariant.outlined

        OutlinedInput {
            sx = jso {
                height = 2.rem
                paddingLeft = 0.5.em
            }
            id = "searchbar-input"
            type = "text"
            value = text
            onChange = { event ->
                setText(event.target.asDynamic().value as String)
            }
            placeholder = "search by author"
            endAdornment = SearchInputAdornment.create()
        }

    }
}

val SearchInputAdornment = FC<Props> {
    InputAdornment {
        sx = jso {
            color = Color(Colors.black)
        }
        position = InputAdornmentPosition.end

        IconButton {
            type = ButtonType.submit
            onClick = {
                // TODO: Do search
            }

            SearchOutlined()
        }
    }
}