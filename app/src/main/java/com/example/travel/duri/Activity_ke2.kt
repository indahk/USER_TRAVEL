package com.example.travel.duri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel.R
import com.example.travel.pku.TravelRecyclerAdapter
import kotlinx.android.synthetic.main.list_travel1.*


class Activity_ke2: AppCompatActivity() {
    private  lateinit var travelAdapter: TravelRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pku)
        initRecyclerView()
        tambahDataSet()
    }
    private  fun tambahDataSet(){
        val data = SumberDataDuri.buatSetData()
        travelAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recyler_view.apply {
            layoutManager = LinearLayoutManager(this@Activity_ke2)
            val spacingAtas = DekorSpasiGambar(20)
            addItemDecoration(spacingAtas)
            travelAdapter = TravelRecyclerAdapter()
            adapter = travelAdapter
        }
    }
}