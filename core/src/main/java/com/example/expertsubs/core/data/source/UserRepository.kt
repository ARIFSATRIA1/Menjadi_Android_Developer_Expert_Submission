package com.example.expertsubs.core.data.source



import com.example.expertsubs.core.data.source.local.LocalDataSource
import com.example.expertsubs.core.data.source.remote.RemoteSource
import com.example.expertsubs.core.data.source.remote.network.ApiResponse
import com.example.expertsubs.core.data.source.remote.response.ItemsItem
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.repository.IUserRepository
import com.example.expertsubs.core.utils.AppExecutors
import com.example.expertsubs.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val remoteSource: RemoteSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IUserRepository{

    // to get all list github users from network and get from a local data source
    override fun getAllGithubUsers(): Flow<Resource<List<Users>>> =
        object : NetworkResources<List<Users>, List<ItemsItem>>() {
            override fun loadFromDB(): Flow<List<Users>> = localDataSource.getAllAnime().map {
                DataMapper.mapEntitiesToDomain(it)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ItemsItem>>> {
                return remoteSource.getAllUser()
            }

            override suspend fun saveCallResult(data: List<ItemsItem>) {
                val userList = DataMapper.mapResponsesToEntities(data)
                appExecutors.diskIO().execute{localDataSource.insertTourism(userList)}
            }

            override fun shouldFetch(data: List<Users>?): Boolean {
               data == null || data.isNotEmpty()
                return true
            }
        }.asFlow()

    // function to get a favorite a github users to localdata source
    override fun getFavoriteGithubUsers(): Flow<List<Users>> = localDataSource.getFavoriteAnime().map {
        DataMapper.mapEntitiesToDomain(it)
    }


    // function to set a favorite users to local data source
    override fun setFavoriteGithubUsers(users: Users, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(users)
        appExecutors.diskIO().execute{localDataSource.setFavoriteAnime(tourismEntity, state)}
    }


}