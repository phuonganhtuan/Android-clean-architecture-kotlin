package com.example.demo_clean_arch.screens.home

import com.example.demo_clean_arch.base.Navigator
import com.example.demo_clean_arch.model.ActivityModel

interface HomeNavigator: Navigator {

    fun toDetail(item: ActivityModel)
}
