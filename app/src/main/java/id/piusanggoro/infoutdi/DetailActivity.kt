package id.piusanggoro.infoutdi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.piusanggoro.infoutdi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    var idPengguna = ""

    companion object {
        const val PENGGUNA = "nama_pengguna"
        const val WEB_PREFIX = "https://github.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // menampilkan layout: activity_detail menggunakan konsep/metode binding
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mengambil data yg dikirimkan melalui intent
        // jika data ada, dan sesuai dengan key variabel PENGGUNA
        idPengguna = intent?.extras?.getString(PENGGUNA).toString()
        // judul dalam AppBar --> title
        title = "Hai " + idPengguna

        binding.teksDetailPengguna.text = idPengguna

        binding.tombolGithub.setOnClickListener { cekGithub() }
        binding.tombolTentang.setOnClickListener{ keTentangPengguna() }
    }

    private fun cekGithub() {
        // menggunakan intent implisit
        // dengan variabel queryUrl, data didalamnya web_prefix + idPengguna
        val queryUrl: Uri = Uri.parse("${DetailActivity.WEB_PREFIX}${idPengguna}")
        // menyiapkan variabel intent, dengan parameter
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // aktifkan intent
        startActivity(intent)
    }

    private fun keTentangPengguna(){
        val intentPengguna = Intent(this, PenggunaActivity::class.java)
        startActivity(intentPengguna)
    }
}