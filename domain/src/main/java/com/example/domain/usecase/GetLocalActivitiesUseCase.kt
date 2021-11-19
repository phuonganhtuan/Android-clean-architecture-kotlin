package com.example.domain.usecase

import com.example.domain.model.DemoDomainEntity
import com.example.domain.repo.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetLocalActivitiesUseCase @Inject constructor(
    private val repository: MainRepository
) : UseCase<GetLocalActivitiesUseCase.Params, Flow<List<DemoDomainEntity>>>() {

    override fun invoke(params: Params): Flow<List<DemoDomainEntity>> {
        return repository.getAllEntities()
    }

    override suspend fun invokeSuspend(params: Params): Flow<List<DemoDomainEntity>> {
        return flowOf(emptyList())
    }

    data class Params(val query: String = "")
}
