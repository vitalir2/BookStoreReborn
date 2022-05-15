import components.Header
import di.useCaseModule
import kotlinx.browser.document
import mui.material.styles.ThemeProvider
import org.koin.core.context.GlobalContext.startKoin
import page.CartPage
import page.LoginPage
import page.MainPage
import page.description.BookDescriptionPage
import react.FC
import react.Props
import react.create
import react.dom.render
import react.router.Outlet
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import style.BookStoreTheme

fun main() {
    startKoin {
        modules(useCaseModule)
    }
    render(
        element = App.create(),
        container = document.createElement("div").also { document.body!!.appendChild(it) }
    )
}

private val App = FC<Props> {
    ThemeProvider {
        theme = BookStoreTheme

        MainRouter()
    }
}

private val MainRouter = FC<Props> {
    BrowserRouter {
        Routes {
            Route {
                path = "/"
                element = AppContainer.create()

                Route {
                    index = true
                    element = MainPage.reactComponent.create()
                }

                Route {
                    path = "cart"
                    element = CartPage.create()
                }
                Route {
                    path = "login"
                    element = LoginPage.create()
                }
                Route {
                    path = BookDescriptionPage.route
                    element = BookDescriptionPage.reactComponent.create()
                }
            }
        }
    }
}

private val AppContainer = FC<Props> {
    Header()
    Outlet()
}
