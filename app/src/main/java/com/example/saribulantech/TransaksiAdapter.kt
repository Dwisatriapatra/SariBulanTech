package com.example.saribulantech

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TransaksiAdapter(private val transaksiList: ArrayList<Transaksi>) :
    RecyclerView.Adapter<TransaksiAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemTahun: TextView = itemView.findViewById(R.id.tv_tahun)
        //var itemBulan: TextView = itemView.findViewById(R.id.tv_bulan)
        var itemNamaPemesan: TextView = itemView.findViewById(R.id.tv_nama_pemesan)
        var itemTanggalPemesanan: TextView = itemView.findViewById(R.id.tv_tanggal_pemesanan)
        var itemAlamat: TextView = itemView.findViewById(R.id.tv_alamat)
        var itemNominalTransaksi: TextView = itemView.findViewById(R.id.tv_nominal_transaksi)
        var itemNote: TextView = itemView.findViewById(R.id.tv_note)
        var itemStatusTransaksi: TextView = itemView.findViewById(R.id.tv_status_transaksi)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_transaksi, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = transaksiList[position]

        holder.itemTahun.text = currentItem.year.toString()
        /*holder.itemBulan.text = currentItem.bulan.toString()*/
        holder.itemNamaPemesan.text = ("Nama: " + currentItem.namaPemesan.toString())
        holder.itemTanggalPemesanan.text = ("Tanggal: " + currentItem.tanggalPemesanan.toString())
        holder.itemAlamat.text = ("Alamat: " + currentItem.alamat.toString())
        holder.itemNominalTransaksi.text = ("Nominal transaksi: " + currentItem.nominalTransaksi.toString())
        holder.itemNote.text = ("Catatan: " + currentItem.notes.toString())
        holder.itemStatusTransaksi.text = ("Status transaksi: " + currentItem.statusTransaksi.toString())

    }

    override fun getItemCount(): Int {
        return transaksiList.size
    }


}