package com.example.pocadapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocadapter2.databinding.ActivityMainBinding
import com.example.pocadapter2.databinding.ItemRowBinding
import com.example.pocadapter2.genericadapter.GenericAdapter
import com.example.pocadapter2.genericadapter.GenericItem
import com.example.pocadapter2.genericadapter.GenericItemViewBinding
import com.example.pocadapter2.items.HeaderItem
import com.example.pocadapter2.items.ImageItem
import com.example.pocadapter2.items.RowItem


const val IMAGE_URL =
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_akt-RGYq3jd3BACqKVave08XvdbgzH5Mcw&usqp=CAU"

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val list = arrayListOf<GenericItem>(
            HeaderItem("Header"),
            ImageItem(IMAGE_URL)
        )
        for (i in 1..20) {
            list.add(RowItem("Row $i") {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
            } )
        }

        val adapter = GenericAdapter()
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
