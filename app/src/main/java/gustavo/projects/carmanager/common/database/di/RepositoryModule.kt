package gustavo.projects.carmanager.common.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gustavo.projects.carmanager.common.database.daos.VehicleDao
import gustavo.projects.carmanager.common.database.repository.VehicleRepository
import gustavo.projects.carmanager.common.database.repository.VehicleRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVehicleRepository(vehicleDao: VehicleDao): VehicleRepository {
        return VehicleRepositoryImpl(vehicleDao)
    }
}