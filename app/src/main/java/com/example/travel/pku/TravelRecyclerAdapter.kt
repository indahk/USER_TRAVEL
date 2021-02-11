package com.example.travel.pku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.travel.R
import kotlinx.android.synthetic.main.layout_list_pku.view.*

class TravelRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  var items: List<ListObjTravel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ResepViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_pku, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ResepViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }
    fun submitList(listtravel1: List<ListObjTravel>){
        items = listtravel1
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ResepViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto_detil : ImageView = itemView.gambar_pku
        val nama : TextView = itemView.nama_pku
        //val alat : TextView = itemView.alat_resep
//        val bahan : TextView = itemView.bahan_resep
//        val cara : TextView = itemView.cara_resep
        val klik : RelativeLayout = itemView.findViewById(R.id.rl_klik)

        fun bind(listObjTravel: ListObjTravel) {
            nama.setText(listObjTravel.nama_mobil)
//            alat.setText(listObjResep.alat)
//            bahan.setText(listObjResep.bahan)
//            cara.setText(listObjResep.cara)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjTravel.foto)
                .into(foto_detil)
        }
        fun kalau_diklik(get: ListObjTravel) {
            val position:Int = adapterPosition
            Toast.makeText(itemView.context, "Kamu memilih : ${get.nama_mobil}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, DetilTravel::class.java)
            intent.putExtra("nama_mobilnya", get.nama_mobil)
            intent.putExtra("nohpnya", get.nohp)
            intent.putExtra("rulenya", get.rule)
            intent.putExtra("fasilitasnya", get.fasilitas)
            intent.putExtra("harganya", get.harga)
            intent.putExtra("jadwalnya", get.jadwal)
            intent.putExtra("fotonya", get.foto)
            itemView.context.startActivity(intent)
        }
    }
}