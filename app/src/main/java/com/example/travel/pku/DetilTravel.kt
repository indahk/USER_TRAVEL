package com.example.travel.pku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.travel.R
import kotlinx.android.synthetic.main.detil_travel.*

class DetilTravel: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detil_travel)
        if (intent.hasExtra("nama_mobilnya")){
            val foto : String = this.intent.getStringExtra("fotonya").toString()
            val namamobil : String = this.intent.getStringExtra("nama_mobilnya").toString()
            val nohp : String = this.intent.getStringExtra("nohpnya").toString()
            val rute : String = this.intent.getStringExtra("rulenya").toString()
            val fasilitas : String = this.intent.getStringExtra("fasilitasnya").toString()
            val harga : String = this.intent.getStringExtra("harganya").toString()
            val jadwal : String = this.intent.getStringExtra("jadwalnya").toString()
            setDetil(foto, namamobil, nohp, rute, fasilitas, harga, jadwal)
        }
    }

    fun setDetil(foto: String, namamobil: String, nohp:String, rute: String, fasilitas: String, harga: String, jadwal: String) {
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        nama_mobil.text = namamobil
        nomor_hp.text = nohp
        arah.text = rute
        kelebihan.text = fasilitas
        price.text = harga
        keberangkatan.text = jadwal

        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(foto_detil)
    }
}