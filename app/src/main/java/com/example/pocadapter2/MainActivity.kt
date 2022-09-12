package com.example.pocadapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocadapter2.databinding.ActivityMainBinding
import com.example.pocadapter2.genericadapter.GenericAdapter
import com.example.pocadapter2.genericadapter.GenericItem
import com.example.pocadapter2.items.HeaderItem
import com.example.pocadapter2.items.ImageItem
import com.example.pocadapter2.items.RowItem


const val imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_akt-RGYq3jd3BACqKVave08XvdbgzH5Mcw&usqp=CAU"

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val list = arrayListOf<GenericItem>(
            HeaderItem("Header1"),
        )
        for(i in 1 ..3){
            list.add(RowItem("Row $i"))
        }
        list.add(ImageItem(imageURL))
        list.add(RowItem("Row 4"))

        val adapter = GenericAdapter { item ->
            when (item) {
                is RowItem ->
                    Toast.makeText(this@MainActivity, item.text, Toast.LENGTH_LONG).show()
                else -> Unit
            }
        }
        binding?.apply {

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            adapter.submitList(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
