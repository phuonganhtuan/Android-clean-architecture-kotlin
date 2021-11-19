package com.example.demo_clean_arch.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_clean_arch.mapper.Mapper
import com.example.demo_clean_arch.model.ActivityModel
import com.example.domain.model.DemoDomainEntity
import com.example.domain.usecase.GetActivityUseCase
import com.example.domain.usecase.GetLocalActivitiesUseCase
import com.example.domain.usecase.SaveActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getActivityUseCase: GetActivityUseCase,
    private val saveActivityUseCase: SaveActivityUseCase,
    private val activityMapper: Mapper<DemoDomainEntity, ActivityModel>,
    private val activityDomainMapper: Mapper<ActivityModel, DemoDomainEntity>,
    getLocalActivitiesUseCase: GetLocalActivitiesUseCase,
) : ViewModel() {

    val localActivityList: StateFlow<List<ActivityModel>> get() = _localActivityList

    private var _localActivityList =
        getLocalActivitiesUseCase.invoke(GetLocalActivitiesUseCase.Params())
            .map { it.map { activity -> activityMapper.toModel(activity) } }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val isLoading: StateFlow<Boolean> get() = _isLoading
    private val _isLoading = MutableStateFlow(false)

    val errorMsd: StateFlow<String> get() = _errorMsg
    private val _errorMsg = MutableStateFlow("")

    fun getRandomActivity() = viewModelScope.launch {
        _isLoading.value = true
        try {
            flowOf(getActivityUseCase.invokeSuspend(GetActivityUseCase.Params())).collect {
                addEntity(activityMapper.toModel(it))
            }
        } catch (exception: Exception) {
            _errorMsg.value = "Error fetching new activity."
        } finally {
            _isLoading.value = false
        }
    }

    fun resetError() {
        _errorMsg.value = ""
    }

    private fun addEntity(entity: ActivityModel) = viewModelScope.launch {
        saveActivityUseCase.invokeSuspend(
            SaveActivityUseCase.Params(activityDomainMapper.toModel(entity))
        )
    }
}
