import components.Header
import di.useCaseModule
import kotlinx.browser.document
import mui.material.styles.ThemeProvider
import org.koin.core.context.GlobalContext.startKoin
import page.CartPage
import page.LoginPage
import page.MainPage
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
        element = MainRouter.create(),
        container = document.createElement("div").also { document.body!!.appendChild(it) }
    )
}

private val MainRouter = FC<Props> {
    BrowserRouter {
        Routes {
            Route {
                path = "/"
                element = BookStoreApp.create()

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
            }
        }
    }
}

private val BookStoreApp = FC<Props> {
    ThemeProvider {
        theme = BookStoreTheme

        Header()
        Outlet()
    }
}
