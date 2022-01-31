package components

import csstype.Color
import csstype.em
import kotlinext.js.jso
import mui.icons.material.SearchOutlined
import mui.material.*
import react.FC
import react.Props
import react.create
import style.Colors

val SearchBar = FC<Props> {
    FormControl {
        sx = jso {
            width = 20.em
            backgroundColor = Color(Colors.white)
        }
        variant = FormControlVariant.outlined

        OutlinedInput {
            sx = jso {
                paddingLeft = 0.5.em
                paddingTop = 0.1.em
                paddingBottom = 0.1.em

                fontSize = 1.2.em

            }
            id = "searchbar-input"
            type = "text"
            value = ""
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
            SearchOutlined()
        }
    }
}