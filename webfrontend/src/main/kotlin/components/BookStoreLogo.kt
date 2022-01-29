package components

import mui.icons.material.LocalLibrary
import react.FC
import react.Props
import react.dom.html.ReactHTML.h1

val BookStoreLogo = FC<Props> {
    h1 {
        +"BookStore"
    }
    LocalLibrary()
}