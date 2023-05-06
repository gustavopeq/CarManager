package gustavo.projects.carmanager.common.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.carmanager.common.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideVehicleDao(appDatabase: AppDatabase) = appDatabase.vehicleDao()
}