package com.amg.recipes.presentation.map.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor() : ViewModel() {

    private val _marker = MutableLiveData<Pair<String, LatLng>>()
    val marker: LiveData<Pair<String, LatLng>> get() = _marker

    fun mapReady(title: String, lng: LatLng) {
        _marker.value = Pair(title, lng)
    }

}