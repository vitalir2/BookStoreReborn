package page

import react.FC
import react.Props

interface PageObject<PROPS : Props> {
    val reactComponent: FC<PROPS>
}
