package com.example.travel.pku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_travel1.*


class Activity_ke1: AppCompatActivity() {
    private  lateinit var travelAdapter: TravelRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_travel1)
        initRecyclerView()
        tambahDataSet()
    }
    private  fun tambahDataSet(){
        val data = SumberData.buatSetData()
        travelAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recyler_view.apply {
            layoutManager = LinearLayoutManager(this@Activity_ke1)
            val spacingAtas = DekorSpasiGambar(20)
            addItemDecoration(spacingAtas)
            travelAdapter = TravelRecyclerAdapter()
            adapter = travelAdapter
        }
    }
}