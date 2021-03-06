package com.example.saribulantech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TambahDataInventory : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambahdata_inventory)

        // actionbar
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.title = "Tambah Data Inventory"
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        val inputTambahNamaInventory = findViewById<EditText>(R.id.inputTambahNamaInventory)
        val inputTambahJumlahInventory = findViewById<EditText>(R.id.inputTambahJumlahInventory)
        val btnTambahdataInventory = findViewById<Button>(R.id.buttonTambahDatainventory)
        btnTambahdataInventory.setOnClickListener {
            if (inputTambahJumlahInventory.text.toString()
                    .isNotEmpty() && inputTambahNamaInventory.text.toString().isNotEmpty()
            ) {
                if (inputTambahJumlahInventory.text.toString().toInt() < 0) {
                    Toast.makeText(this, "Jumlah tidak boleh negatif", Toast.LENGTH_SHORT).show()
                } else {
                    database = FirebaseDatabase.getInstance().getReference("INVENTORY")
                    val inventory = Inventory(
                        inputTambahNamaInventory.text.toString(),
                        inputTambahJumlahInventory.text.toString()
                    )
                    database.child(inputTambahNamaInventory.text.toString()).setValue(inventory)
                        .addOnSuccessListener {
                            inputTambahJumlahInventory.text.clear()
                            inputTambahNamaInventory.text.clear()
                            Toast.makeText(
                                this,
                                "Inventory berhasil ditambahkan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }.addOnFailureListener {
                        Toast.makeText(this, "Gagal disimpan", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Nama dan jumlah inventory harus ada!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}