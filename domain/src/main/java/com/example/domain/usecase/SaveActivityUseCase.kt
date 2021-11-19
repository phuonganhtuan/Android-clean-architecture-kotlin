package com.example.domain.usecase

import com.example.domain.model.DemoDomainEntity
import com.example.domain.repo.MainRepository
import javax.inject.Inject

class SaveActivityUseCase @Inject constructor(
    private val repository: MainRepository,
) : UseCase<SaveActivityUseCase.Params, Any>() {

    override fun invoke(params: Params): Any {
        return Any()
    }

    override suspend fun invokeSuspend(params: Params): Any {
        return repository.addEntity(params.entity)
    }

    data class Params(val entity: DemoDomainEntity)
}
