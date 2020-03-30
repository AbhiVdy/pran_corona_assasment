package com.pranhealth.coronaassasment

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_assasment.*
import java.util.*


class AssasmentActivity : AppCompatActivity() {

    private var riskStatus: Utils.RiskEnum? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        languageToLoad = bundle?.getSerializable("lang") as String
        riskStatus = bundle.getSerializable("status") as Utils.RiskEnum
        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        setContentView(R.layout.activity_assasment)
        setRiskAssasment()

        btnBack.setOnClickListener{
            val intent = Intent(this, LaunchActivity::class.java)
            startActivity(intent)
        }

        tvHelpline.setOnClickListener {
            val u = Uri.parse("tel:" + "01123978046")
            val i = Intent(Intent.ACTION_DIAL, u)
            startActivity(i)
        }
    }

    private fun setRiskAssasment() {
        when (riskStatus) {
            Utils.RiskEnum.LOW -> {
                tvRiskAssasment.text = getString(R.string.risk_low)
                tvRiskAssasment.setTextColor(ContextCompat.getColor(this, R.color.textLow))
            }
            Utils.RiskEnum.MEDIUM -> {
                tvRiskAssasment.text = getString(R.string.risk_medium)
                tvRiskAssasment.setTextColor(ContextCompat.getColor(this, R.color.textMedium))
            }
            Utils.RiskEnum.HIGH -> {
                tvRiskAssasment.text = getString(R.string.risk_high)
                tvRiskAssasment.setTextColor(ContextCompat.getColor(this, R.color.textHigh))
            }
        }
    }
}
