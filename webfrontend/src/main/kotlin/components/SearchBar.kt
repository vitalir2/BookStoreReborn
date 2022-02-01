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
import style.Colors

val SearchBar = FC<Props> {
    FormControl {
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