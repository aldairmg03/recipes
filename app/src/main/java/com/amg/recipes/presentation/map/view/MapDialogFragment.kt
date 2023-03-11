package com.amg.recipes.presentation.map.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.amg.recipes.R
import com.amg.recipes.presentation.map.viewModel.MapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapDialogFragment(
    private val title: String,
    private val latLng: LatLng
) : DialogFragment(),
    OnMapReadyCallback {

    companion object {
        const val TAG = "MapDialogFragment"
    }

    private val mapViewModel: MapViewModel by viewModels()

    private var googleMap: GoogleMap? = null

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        initMap()
        initObservers()
    }

    private fun initObservers() {
        with(mapViewModel) {
            marker.observe(viewLifecycleOwner) {
                showAddressLocation(it.first, it.second)
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(mMap: GoogleMap) {
        googleMap = mMap
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15f))
        mMap.isMyLocationEnabled = false
        mMap.uiSettings.isMyLocationButtonEnabled = false
        mapViewModel.mapReady(title, latLng)
    }

    private fun initMap() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapLocation) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    private fun showAddressLocation(title: String, latLng: LatLng) {
        moveCameraToAddress(latLng)
        paintMarker(title, latLng)
    }

    private fun paintMarker(title: String, position: LatLng) {
        googleMap?.clear()
        googleMap?.addMarker(
            MarkerOptions()
                .position(position)
                .title(title)
        )
    }

    private fun moveCameraToAddress(position: LatLng) {
        googleMap?.animateCamera(
            CameraUpdateFactory.newLatLng(
                position
            )
        )
    }


}