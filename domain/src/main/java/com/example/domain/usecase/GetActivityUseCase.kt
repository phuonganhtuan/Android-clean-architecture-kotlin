package com.example.domain.usecase

import com.example.domain.model.DemoDomainEntity
import com.example.domain.repo.MainRepository
import javax.inject.Inject

class GetActivityUseCase @Inject constructor(
    private val activityRepository: MainRepository,
) : UseCase<GetActivityUseCase.Params, DemoDomainEntity>() {

    override fun invoke(params: Params): DemoDomainEntity {
        return DemoDomainEntity(0, null, null, null, null, null, null, null)
    }

    override suspend fun invokeSuspend(params: Params): DemoDomainEntity {
        return activityRepository.getRandomActivity()
    }

    data class Params(var query: String = "")
}
