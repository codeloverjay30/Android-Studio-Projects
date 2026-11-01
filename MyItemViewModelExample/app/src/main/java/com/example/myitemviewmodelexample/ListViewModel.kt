package com.example.myitemviewmodelexample

import android.media.RouteListingPreference
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.logging.Filter

class ListViewModel : ViewModel() {
    val filters = MutableLiveData<Set<Filter>>()

    private val originalList: LiveData<List<RouteListingPreference.Item>>() =
    val lateinit filteredList: LiveData<List<RouteListingPreference.Item>>

    fun addFilter(filter: Filter) = Unit

    fun removeFilter(filter: Filter) = Unit
}