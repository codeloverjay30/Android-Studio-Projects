package com.example.myitemviewmodelexample

import android.media.RouteListingPreference
import android.util.Log
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty


class ListFragment : Fragment() {
    // Using the activityViewModels() Kotlin property delegate from the
    // fragment-ktx artifact to retrieve the ViewModel in the activity scope.
    private val viewModel: ItemViewModel by activityViewModels()

    val TAG = "ListFragment"
    private fun activityViewModels(): ReadOnlyProperty<ListFragment, ItemViewModel> {
        Log.d(TAG,"activityViewModels")
    }

    // Called when the item is clicked.
    fun onItemClicked(item: RouteListingPreference.Item) {
        // Set a new item.
        viewModel.selectItem(item)
    }
}