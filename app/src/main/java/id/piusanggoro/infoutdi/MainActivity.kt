package id.piusanggoro.infoutdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.piusanggoro.infoutdi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // menampilkan layout: activity_main menggunakan konsep/metode binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // memberikan klik listener pada button dengan id: tombolLogin
        // saat button di-klik akan menjalankan fungsi cek Password()
        binding.tombolLogin.setOnClickListener { cekPassword() }
    }

    private fun cekPassword() {
        // mengambil data dari input text (textEdit) dikonversi ke String --> dimasukkan ke variabel
        val namaPengguna = binding.teksPengguna.text.toString()
        val passwordPengguna = binding.teksPassword.text.toString()

        // cek kondisi apakah salah satu isian kosong?
        // jika benar akan menampilkan toast/pop-up
        if (namaPengguna.isEmpty() || passwordPengguna.isEmpty()) {
            Toast.makeText(this, "Mohon masukkan nama dan password", Toast.LENGTH_SHORT).show()
            return
        }

        // cek apakah isian valid atau tidak?
        if(namaPengguna == "qwerty" && passwordPengguna == "123456"){
            // contoh penggunaan intent eksplisit
            // menyiapkan variabel intent dari class Intent, konfigurasi/parameter yg digunakan adalah
            // dari activity yg aktif sekarang (MainActivity ke class DetailActivity
            val intent = Intent(this, DetailActivity::class.java)

            // dalam variabel ditambahkan data dengan key: nama_pengguna,
            // value diambil dari input nama pengguna
            intent.putExtra("nama_pengguna", binding.teksPengguna.text.toString())

            // activity yang baru dijalankan melalui intent
            startActivity(intent)

            // setelah intent dijalankan maka MainActivity di hapus dari backstack
            finish()
        }else{
            Toast.makeText(this, "Nama atau password salah.", Toast.LENGTH_SHORT).show()
            return
        }
    }
}