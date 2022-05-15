package di

import client.GetBooksUseCase
import client.GetBooksUseCaseImpl
import client.GetPaginatedBooksUseCase
import client.GetPaginatedBooksUseCaseImpl
import org.koin.dsl.module
import usecases.GetBookByTitleUseCase

val useCaseModule = module {
    single<GetBooksUseCase> { GetBooksUseCaseImpl() }
    single<GetPaginatedBooksUseCase> { GetPaginatedBooksUseCaseImpl() }
    single { GetBookByTitleUseCase() }
}
