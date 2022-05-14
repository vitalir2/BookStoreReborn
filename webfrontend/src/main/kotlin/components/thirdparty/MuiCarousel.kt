@file:JsModule("react-material-ui-carousel")
@file:JsNonModule
@file:Suppress("MaxLineLength")

import components.thirdparty.CarouselAnimation
import mui.system.PropsWithSx
import react.FC
import react.PropsWithChildren
import react.PropsWithClassName
import react.PropsWithStyle
import react.ReactNode
import react.dom.aria.AriaAttributes

external interface CarouselProps : PropsWithChildren, PropsWithSx {
    override var children: ReactNode?

    /** Defines custom class name(s), that will be added to Carousel element */
    var className: String?

    /** Defines which child (assuming there are more than 1 children) will be displayed. Next and Previous Buttons as well as Indicators will work normally after the first render. When this prop is updated the carousel will display the chosen child. Use this prop to programmatically set the active child. If (index > children.length) then if (strictIndexing) index = last element. index */
    var index: Number?

    /** Defines the carousel's height in `px`. If this is not set, the carousel's height will be the height of its children. */
    var height: dynamic

    /** Defines whether index can be bigger than children length */
    var strictIndexing: Boolean?

    /** Defines if the component will auto scroll between children */
    var autoPlay: Boolean?

    /** Defines if auto scrolling will continue while mousing over carousel */
    var stopAutoPlayOnHover: Boolean?

    /** Defines the interval in ms between active child changes (autoPlay) */
    var interval: Number?

    /** Defines the animation style of the Carousel  */
    var animation: CarouselAnimation

    /** Defines the duration of the animations. For more information refer to the [Material UI Documentation for Transitions](https://material-ui.com/components/transitions/) */
    var duration: Number?

    /** Defines if swiping left and right (in touch devices) triggers `next` and `prev` behaviour */
    var swipe: Boolean?

    /** Defines the existence of bullet indicators */
    var indicators: Boolean?

    /** Defines if the next/previous buttons will always be visible or not */
    var navButtonsAlwaysVisible: Boolean?

    /**	Defines if the next/previous buttons will always be invisible or not */
    var navButtonsAlwaysInvisible: Boolean?

    /** Defines if the next button will be visible on the last slide, and the previous button on the first slide. Auto-play also stops on the last slide. Indicators continue to work normally. */
    var cycleNavigation: Boolean?

    /** Defines if the the next/previous button wrappers will cover the full height of the Item element and show buttons on full height hover */
    var fullHeightHover: Boolean?

    /** Used to customize the div surrounding the nav `IconButtons`. Use this to position the buttons onto, below, outside, e.t.c. the carousel. */
    var navButtonsWrapperProps: CarouselNavProps?

    /** Used to customize the actual nav `IconButton`s */
    var navButtonsProps: CarouselNavProps?

    /** Defines the element inside the nav "next" `IconButton`. Refer to [MaterialUI Button Documentation](https://material-ui.com/components/buttons/) for more examples.
     * It is advised to use Material UI Icons, but you could use any element (`<img/>`, `<div/>`, ...) you like. */
    @Suppress("VariableNaming")
    var NextIcon: ReactNode?

    /** Defines the element inside the nav "prev" `IconButton`. Refer to [MaterialUI Button Documentation](https://material-ui.com/components/buttons/) for more examples.
     * It is advised to use Material UI Icons, but you could use any element (`<img/>`, `<div/>`, ...) you like. */
    @Suppress("VariableNaming")
    var PrevIcon: ReactNode?

    /** Gives full control of the nav buttons. Should return a button that uses the given `onClick`.
     * Works in tandem with all other customization options (`navButtonsProps`, `navButtonsWrapperProps`, `navButtonsAlwaysVisible`, `navButtonsAlwaysInvisible`, `fullHeightHover` ...).
     * Refer to the [example section](README.md) for more information */
    @Suppress("VariableNaming")
    var NavButton: dynamic // (onClick: Function, next, prev: Boolean, style: React.CSSProps, className: String) -> ReactNode | undefined

    /** Used to customize the indicators container/wrapper.
     * Type: `{className: string, style: React.CSSProperties}` */
    var indicatorContainerProps: CarouselNavProps?

    /** Used to customize the **non-active** indicator `IconButton`s.
     * Type: `{className: string, style: React.CSSProperties}` */
    var indicatorIconButtonProps: CarouselNavProps?

    /** Used to customize the **active** indicator `IconButton`.
     * Type: `{className: string, style: React.CSSProperties}` */
    var activeIndicatorIconButtonProps: CarouselNavProps?

    /** Function that is called **after** internal `setActive()` method.
     * The `setActive()` method is called when the next and previous buttons are pressed,
     * when an indicator is pressed, or when the `index` prop changes. First argument is the child
     * **we are going to display**, while the second argument is the child **that was previously displayed**. Will be c */
    var onChange: dynamic // (now: Number?, previous: Number?) -> Any

    /** Defines if `onChange` prop will be called when the carousel renders for the first time. In `componentDidMount` */
    var changeOnFirstRender: Boolean?

    /** Function that is called **after** internal `next()` method. First argument is the child **we are going to display**, while the second argument is the child **that was previously displayed** */
    var next: dynamic // (now: Number?, previous: Number?) -> Any

    /** Function that is called **after** internal `prev()` method. First argument is the child **we are going to display**, while the second argument is the child **that was previously displayed** */
    var prev: dynamic // (now: Number?, previous: Number?) -> Any

    /** Defines the element inside the indicator `IconButton`s Refer to [MaterialUI Button Documentation](https://material-ui.com/components/buttons/) for more examples.
     * It is advised to use Material UI Icons, but you could use any element (`<img/>`, `<div/>`, ...) you like.*/
    @Suppress("VariableNaming")
    var IndicatorIcon: ReactNode?
}

external interface CarouselNavProps : PropsWithClassName, PropsWithStyle, AriaAttributes

/**
 * [Github Wiki](https://github.com/Learus/react-material-ui-carousel/blob/master/README.md)
 */
@JsName("default")
external val Carousel: FC<CarouselProps>
