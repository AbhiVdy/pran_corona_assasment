package com.pranhealth.coronaassasment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*
import java.util.*

class LaunchActivity : AppCompatActivity() {

    private var selectedLan: Utils.LanguageEnum = Utils.LanguageEnum.ENGLISH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        init()
    }

    private fun init() {
        tvEng.setOnClickListener { navigateToMain(Utils.LanguageEnum.ENGLISH) }
        tvHindi.setOnClickListener { navigateToMain(Utils.LanguageEnum.HINDI) }
        tvMarathi.setOnClickListener { navigateToMain(Utils.LanguageEnum.MARATHI) }
    }

   /* private fun updateLocale(language: String) {


            val res = this.resources
            val config = Configuration(res.configuration)
            config.locale = locale
            res.updateConfiguration(config, res.displayMetrics)
    }*/

    private fun navigateToMain(locale: Utils.LanguageEnum) {

        val local = Locale(locale.value)
        Locale.setDefault(local)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("lang", locale.value)
        startActivity(intent)
    }

}
