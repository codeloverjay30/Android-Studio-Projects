package com.example.lista

import android.R
import android.app.ListActivity
import android.os.Bundle
import android.provider.Contacts.People
import android.widget.SimpleCursorAdapter


@Suppress("DEPRECATION")
class MainActivity : ListActivity() {
    public override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.list_example)


        // SOME CODE
        val cursor = contentResolver.query(
            People.CONTENT_URI,
            arrayOf(People._ID, People.NAME, People.NUMBER),
            null,
            null,
            null
        )
        startManagingCursor(cursor)


        // THE DESIRED COLUMNS TO BE BOUND
        val columns = arrayOf(People.NAME, People.NUMBER)
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        val to = intArrayOf(R.id.name_entry, R.id.number_entry)


        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        val mAdapter = SimpleCursorAdapter(this, R.layout.list_example_entry, cursor, columns, to)


        // SET THIS ADAPTER AS YOUR LISTACTIVITY'S ADAPTER
        this.listAdapter = mAdapter
    }
}