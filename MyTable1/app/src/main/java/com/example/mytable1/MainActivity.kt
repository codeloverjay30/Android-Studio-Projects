package com.example.mytable1

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.ComponentActivity

const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.test1)
        //setContentView(R.layout.test2)
        //setContentView(R.layout.test3)
        // setContentView(R.layout.test4)
        //setContentView(R.layout.test5)
        //setContentView(R.layout.test6)
        //setContentView(R.layout.test7)
        //setContentView(R.layout.test8)
        setContentView(R.layout.test9)
        //setContentView(R.layout.test10)
        //setContentView(R.layout.test11)

        //setContentView(R.layout.main);

        var index = 0
        val examination_tableLayout = findViewById<TableLayout>(R.id.examination_tablelayout)


        findViewById<Button>(R.id.add_an_item_button)
            .setOnClickListener {

                val input_raw_date = findViewById<EditText>(R.id.examination_date).text.toString()
                val input_item = findViewById<EditText>(R.id.examination_item).text.toString()
                val input_value = findViewById<EditText>(R.id.examination_value).text.toString()
                var new_item_flag = true


                if(input_raw_date.length == 8 && isInteger(input_raw_date)){
                    //val input_parsed_date =  simpleDateFormat.parse(input_raw_date)
                    findViewById<TextView>(R.id.invalid_date_message).visibility = View.INVISIBLE
                }else{
                    findViewById<TextView>(R.id.invalid_date_message).visibility = View.VISIBLE
                    new_item_flag = false
                }

                if(input_item.isNotEmpty()) {
                    Log.d(TAG, "input_item:" + input_item)
                    findViewById<TextView>(R.id.invalid_item_message).visibility = View.INVISIBLE
                }else{
                   findViewById<TextView>(R.id.invalid_item_message).visibility = View.VISIBLE
                    new_item_flag = false
                }

                if(input_value.isNotEmpty()) {
                    Log.d(TAG, "input_value:" + input_value)
                    findViewById<TextView>(R.id.invalid_value_message).visibility = View.INVISIBLE
                }else{
                    findViewById<TextView>(R.id.invalid_value_message).visibility = View.VISIBLE
                    new_item_flag = false
                }

                if(new_item_flag){
                /*
                Add new record.
                 */
                    Log.d(TAG,"new_item_flag == true is true")

                    /*
                        Through .addView method.
                     */
                    /*
                    val tablerow1 = TableRow(this)
                    val textView_date = TextView(this)
                    val textView_item = TextView(this)
                    val textView_value = TextView(this)

                    tablerow1.layoutParams =
                        ViewGroup.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT)
                    tablerow1.tag = "tablerow[$index]"
                    index += 1

                    textView_date.text = input_raw_date
                    textView_item.text = input_item
                    textView_value.text = input_value

                    textView_date.layoutParams =
                        ViewGroup.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
                    textView_item.layoutParams =
                        ViewGroup.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
                    textView_value.layoutParams =
                        ViewGroup.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)

                    tablerow1.addView(textView_date)
                    tablerow1.addView(textView_item)
                    tablerow1.addView(textView_value)

                    Log.d(TAG,"After event, tablerow1 tag has n children where n: "+tablerow1.childCount.toString())

                    examination_tableLayout.addView(tablerow1,TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT))

                    Log.d(TAG,"success to add an tablerow1 tag programmatically into examination_tableLayout")
                }else{
                    Log.d(TAG,"new_item_flag == true is false")
                }

                Log.d(TAG,"After event, examination_tableLayout tag has n children where n: "+examination_tableLayout.childCount.toString())
                for(i in 0..examination_tableLayout.childCount-1){
                    val child = examination_tableLayout.getChildAt(i)
                    Log.d(TAG,"The "+i.toString()+"th child has tag: "+child.tag.toString())
                }

                 */
                    /*
                 Through .inflate method
                 */

                    val inflater = getLayoutInflater()
                    val view = inflater.inflate(R.layout.test9,findViewById<ViewGroup>(R.id.examination_tablelayout))


            }
    }
}

fun isInteger(number : Any?) : Boolean{
    val integerChars = '0'..'9'
    if (number == null){
        return false
    }
    val s1 = number.toString()
    if (number is Number){
        return true
    }
    for(i in s1.indices){
        val c = s1[i]
        if(c !in integerChars){
            return false
        }
    }
    return true
}