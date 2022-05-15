package components.common

import csstype.em
import csstype.rem
import mui.icons.material.SearchOutlined
import mui.material.FormControl
import mui.material.FormControlVariant
import mui.material.IconButton
import mui.material.InputAdornment
import mui.material.InputAdornmentPosition
import mui.material.OutlinedInput
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.dom.html.ButtonType
import react.useState
import style.BookStoreTheme

val SearchBar = FC<Props> {
    FormControl {
        val (text, setText) = useState("")

        sx {
            width = 20.em
            height = 2.rem
            margin = 0.5.rem

            backgroundColor = BookStoreTheme.palette.common.white
        }
        variant = FormControlVariant.outlined

        OutlinedInput {
            sx {
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
        sx {
            color = BookStoreTheme.palette.common.black
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
