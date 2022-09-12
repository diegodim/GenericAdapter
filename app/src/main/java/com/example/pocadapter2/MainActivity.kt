package com.example.pocadapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocadapter2.databinding.ActivityMainBinding
import com.example.pocadapter2.genericadapter.GenericAdapter
import com.example.pocadapter2.genericadapter.GenericItem

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val list = arrayListOf<GenericItem>(
            Header("Header1"),
        )
        for(i in 1 ..100){
            list.add(Row("Row $i"))
        }

        val adapter = GenericAdapter { item ->
            when (item) {
                is Row ->
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
