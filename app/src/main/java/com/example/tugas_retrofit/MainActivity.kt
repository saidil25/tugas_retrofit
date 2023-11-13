package com.example.tugas_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_retrofit.model.ListData
import com.example.tugas_retrofit.model.ListModel
import com.example.tugas_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listModelAdapter: ListModelAdapter
    private var listData: MutableList<ListData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_list)
        listModelAdapter = ListModelAdapter(listData)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = listModelAdapter


        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        val apiService = ApiClient.getInstance()

        apiService.getListiItem().enqueue(object : Callback<ListModel> {
            override fun onResponse(call: Call<ListModel>, response: Response<ListModel>) {
                if (response.isSuccessful) {

                    listData.addAll(response.body()?.result.orEmpty())
                    listModelAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ListModel>, t: Throwable) {

                Log.e("MainActivity", "Error fetching data", t)
            }
        })
    }
}
