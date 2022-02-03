package style

import csstype.Length
import csstype.rem

fun Int.pixelsToRem(): Length = (this * 0.0625).rem
