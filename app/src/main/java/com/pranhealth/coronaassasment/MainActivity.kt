package com.pranhealth.coronaassasment

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

private lateinit var dataModel: DataModel

private var symptomList = ArrayList<Utils.SymptomsEnum>()
private var symptomTextList = ArrayList<String>()
private var addSymptomsList = ArrayList<Utils.AdditionalSymptomsEnum>()
private var addSymptomsTextList = ArrayList<String>()
private var historyList = ArrayList<Utils.HistoryEnum>()
private var historyTextList = ArrayList<String>()

var languageToLoad = ""

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        languageToLoad = bundle?.getSerializable("lang") as String
        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        dataModel = DataModel()
        dataModel.clear()
        symptomList.clear()
        symptomTextList.clear()
        addSymptomsList.clear()
        addSymptomsTextList.clear()
        historyList.clear()
        historyTextList.clear()
        setContentView(R.layout.activity_main)
        registerListeners()
    }

    private fun registerListeners() {
        //Age
        tvBelowFifteen.setOnClickListener(this)
        tvFifteenToForty.setOnClickListener(this)
        tvFortyToSixty.setOnClickListener(this)
        tvAbvSixty.setOnClickListener(this)
        //Gender
        tvGenderMale.setOnClickListener(this)
        tvGenderFemale.setOnClickListener(this)
        tvGenderOther.setOnClickListener(this)
        //Fever
        tvFeverNormal.setOnClickListener(this)
        tvFever.setOnClickListener(this)
        tvFeverHigh.setOnClickListener(this)
        tvFeverNext.setOnClickListener(this)
        //Symptoms
        tvSytmAppetite.setOnClickListener(this)
        tvSytmCough.setOnClickListener(this)
        tvSytmNext.setOnClickListener(this)
        tvSytmSmell.setOnClickListener(this)
        tvSytmThroat.setOnClickListener(this)
        tvSytmWeak.setOnClickListener(this)
        //Additional Symptoms
        tvAddSytmBreathless.setOnClickListener(this)
        tvAddSytmChestPain.setOnClickListener(this)
        tvAddSytmCough.setOnClickListener(this)
        tvAddSytmDrowsiness.setOnClickListener(this)
        tvAddSytmWeakness.setOnClickListener(this)
        tvAddSytmNext.setOnClickListener(this)
        //Travel
        tvTravelNone.setOnClickListener(this)
        tvTravelNoContact.setOnClickListener(this)
        tvTravel.setOnClickListener(this)
        tvTravelContact.setOnClickListener(this)
        //History
        tvHisBP.setOnClickListener(this)
        tvHisDiabtes.setOnClickListener(this)
        tvHisHeart.setOnClickListener(this)
        tvHisImmunity.setOnClickListener(this)
        tvHisKidney.setOnClickListener(this)
        tvHisLungs.setOnClickListener(this)
        tvHisStroke.setOnClickListener(this)
        tvHistNext.setOnClickListener(this)
        //Progress
        tvProImproved.setOnClickListener(this)
        tvProNoChange.setOnClickListener(this)
        tvProWorsend.setOnClickListener(this)
        tvProWorsendCons.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            //Age
            R.id.tvBelowFifteen -> updateAgeLayout(Utils.AgeEnum.BELOW_FIFTEEN, tvBelowFifteen)
            R.id.tvFifteenToForty -> updateAgeLayout(Utils.AgeEnum.FIFTEEN_TO_FORTY, tvFifteenToForty)
            R.id.tvFortyToSixty -> updateAgeLayout(Utils.AgeEnum.FORTY_TO_SIXTY, tvFortyToSixty)
            R.id.tvAbvSixty -> updateAgeLayout(Utils.AgeEnum.ABOVE_SIXTY, tvAbvSixty)
            //Gender
            R.id.tvGenderMale -> updateGenderLayout(Utils.GenderEnum.MALE, tvGenderMale)
            R.id.tvGenderFemale -> updateGenderLayout(Utils.GenderEnum.FEMALE, tvGenderFemale)
            R.id.tvGenderOther -> updateGenderLayout(Utils.GenderEnum.OTHER, tvGenderOther)
            //Fever
            R.id.tvFeverNormal -> updateFeverLayout(Utils.FeverEnum.NORMAL, tvFeverNormal)
            R.id.tvFever -> updateFeverLayout(Utils.FeverEnum.FEVER, tvFever)
            R.id.tvFeverHigh -> updateFeverLayout(Utils.FeverEnum.HIGH_FEVER, tvFeverHigh)
            R.id.tvFeverNext -> updateFeverLayout(null, tvFeverNext)
            //Symptoms
            R.id.tvSytmAppetite -> updateSymptomLayout(Utils.SymptomsEnum.APPETITE, tvSytmAppetite)
            R.id.tvSytmCough -> updateSymptomLayout(Utils.SymptomsEnum.COUGH, tvSytmCough)
            R.id.tvSytmSmell -> updateSymptomLayout(Utils.SymptomsEnum.SMELL, tvSytmSmell)
            R.id.tvSytmThroat -> updateSymptomLayout(Utils.SymptomsEnum.THROAT, tvSytmThroat)
            R.id.tvSytmWeak -> updateSymptomLayout(Utils.SymptomsEnum.WEAKNESS, tvSytmWeak)
            R.id.tvSytmNext -> updateSymptomLayout(null, tvSytmNext)
            //Additional Symptoms
            R.id.tvAddSytmBreathless -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.BREATHLESS, tvAddSytmBreathless)
            R.id.tvAddSytmChestPain -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.CHEST_PAIN, tvAddSytmChestPain)
            R.id.tvAddSytmCough -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.COUGH, tvAddSytmCough)
            R.id.tvAddSytmDrowsiness -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.DROWSINESS, tvAddSytmDrowsiness)
            R.id.tvAddSytmWeakness -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.WEAKNESS, tvAddSytmWeakness)
            R.id.tvAddSytmNext -> updateAdditionalSymptomsLayout(null, tvAddSytmNext)
            //Travel
            R.id.tvTravelNone -> updateTravelHistoryLayout(Utils.TravelEnum.NO_HISTORY, tvTravelNone)
            R.id.tvTravelNoContact -> updateTravelHistoryLayout(Utils.TravelEnum.NO_CONTACT_WITH_SYMPTOMS, tvTravelNoContact)
            R.id.tvTravel -> updateTravelHistoryLayout(Utils.TravelEnum.TRAVEL_HISTORY, tvTravel)
            R.id.tvTravelContact -> updateTravelHistoryLayout(Utils.TravelEnum.CONTACT_HISTORY, tvTravelContact)
            //History
            R.id.tvHisBP -> updateHistoryLayout(Utils.HistoryEnum.HIGH_BP, tvHisBP)
            R.id.tvHisDiabtes -> updateHistoryLayout(Utils.HistoryEnum.DIABETES, tvHisDiabtes)
            R.id.tvHisHeart -> updateHistoryLayout(Utils.HistoryEnum.HEART_DISEASE, tvHisHeart)
            R.id.tvHisImmunity -> updateHistoryLayout(Utils.HistoryEnum.REDUCED_IMMUNITY, tvHisImmunity)
            R.id.tvHisKidney -> updateHistoryLayout(Utils.HistoryEnum.KIDNEY, tvHisKidney)
            R.id.tvHisLungs -> updateHistoryLayout(Utils.HistoryEnum.ASTHAMA, tvHisLungs)
            R.id.tvHisStroke -> updateHistoryLayout(Utils.HistoryEnum.STROKE, tvHisStroke)
            R.id.tvHistNext -> updateHistoryLayout(null, tvHistNext)
            //Progress
            R.id.tvProImproved -> updateHealthProgress(Utils.ProgressEnum.IMPROVED, tvProImproved)
            R.id.tvProNoChange -> updateHealthProgress(Utils.ProgressEnum.NO_CHANGE, tvProNoChange)
            R.id.tvProWorsend -> updateHealthProgress(Utils.ProgressEnum.WORSEND, tvProWorsend)
            R.id.tvProWorsendCons -> updateHealthProgress(Utils.ProgressEnum.WORSEND_CONSIDARABLY, tvProWorsendCons)
        }
    }

    private fun calculateRiskAssasment() {
        var symptomsCount = 0
        var additionalSymptomCount = 0
        var medHistoryCount = 0
        var ageCount = 0
        var feverCount = 0
        var travelCount = 0
        var progressCount = 0

        dataModel.age?.let {
            ageCount = it.value
        }
        dataModel.fever?.let {
            feverCount = it.value
        }
        dataModel.travelHistory?.let {
            travelCount = it.value
        }
        dataModel.progress?.let {
            progressCount = it.value
        }

        dataModel.symptoms?.let {
            for (item in it)
                symptomsCount += item.value
        }

        dataModel.additionalSymptoms?.let {
            for (item in it)
                additionalSymptomCount += item.value
        }

        dataModel.medHistory?.let {
            for (item in it)
                medHistoryCount += item.value
        }

        val finalCount = ageCount + feverCount + symptomsCount + additionalSymptomCount + travelCount + medHistoryCount + progressCount
        val status: Utils.RiskEnum
        status = when (finalCount) {
            in 8..15 -> Utils.RiskEnum.MEDIUM
            in 15..30 -> Utils.RiskEnum.HIGH
            else -> Utils.RiskEnum.LOW

        }
        val intent = Intent(this, AssasmentActivity::class.java)
        intent.putExtra("lang", languageToLoad)
        intent.putExtra("status", status)
        startActivity(intent)
    }

    private fun updateHealthProgress(value: Utils.ProgressEnum, view: TextView) {
        tvProgressAns.text = view.text
        tvProgressAns.visibility = View.VISIBLE
        llProgressOptions.visibility = View.GONE
        dataModel.progress = value
        calculateRiskAssasment()
    }

    private fun updateHistoryLayout(value: Utils.HistoryEnum?, view: TextView) {
        value?.let { enumObj ->
            if (historyList.contains(enumObj)) {
                historyList.remove(enumObj)
                historyTextList.remove(view.text.toString())
                setUnSelectedLayout(view)
            } else {
                historyList.add(enumObj)
                historyTextList.add(view.text.toString())
                setSelectedLayout(view)
            }
            if (historyList.size > 0)
                tvHistNext.text = getString(R.string.confirm)
            else
                tvHistNext.text = getString(R.string.noneofthese)
        } ?: run {
            if (historyTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in historyTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvHistoryAns.text = concatStr.subSequence(0, concatStr.length - 2)
            } else {
                tvHistoryAns.text = view.text
            }
            tvHistoryAns.visibility = View.VISIBLE
            llHistoryOptions.visibility = View.GONE
            dataModel.medHistory = historyList
            llProgress.visibility = View.VISIBLE
            svMain.focusOnView(llProgress)
        }
    }

    private fun updateTravelHistoryLayout(value: Utils.TravelEnum, view: TextView) {
        tvTravelAns.text = view.text
        tvTravelAns.visibility = View.VISIBLE
        llTravelOptions.visibility = View.GONE
        dataModel.travelHistory = value
        llHistory.visibility = View.VISIBLE
        svMain.focusOnView(llHistory)
    }

    private fun updateAdditionalSymptomsLayout(value: Utils.AdditionalSymptomsEnum?, view: TextView) {
        value?.let { enumObj ->
            if (addSymptomsList.contains(enumObj)) {
                addSymptomsList.remove(enumObj)
                addSymptomsTextList.remove(view.text.toString())
                setUnSelectedLayout(view)
            } else {
                addSymptomsList.add(enumObj)
                addSymptomsTextList.add(view.text.toString())
                setSelectedLayout(view)
            }
            if (addSymptomsList.size > 0)
                tvAddSytmNext.text = getString(R.string.confirm)
            else
                tvAddSytmNext.text = getString(R.string.noneofthese)
        } ?: run {
            if (addSymptomsTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in addSymptomsTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvAddSytmAns.text = concatStr.substring(0, concatStr.length - 2)
            } else {
                tvAddSytmAns.text = view.text
            }
            tvAddSytmAns.visibility = View.VISIBLE
            llAddSytmOptions.visibility = View.GONE
            dataModel.additionalSymptoms = addSymptomsList
            llTravel.visibility = View.VISIBLE
            svMain.focusOnView(llTravel)
        }
    }

    private fun updateSymptomLayout(value: Utils.SymptomsEnum?, view: TextView) {
        value?.let { enumObj ->
            if (symptomList.contains(enumObj)) {
                symptomList.remove(enumObj)
                symptomTextList.remove(view.text.toString())
                setUnSelectedLayout(view)
            } else {
                symptomList.add(enumObj)
                symptomTextList.add(view.text.toString())
                setSelectedLayout(view)
            }
            if (symptomList.size > 0)
                tvSytmNext.text = getString(R.string.confirm)
            else
                tvSytmNext.text = getString(R.string.noneofthese)

        } ?: run {
            if (symptomTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in symptomTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvSymptomsAns.text = concatStr.substring(0, concatStr.length - 2)
            } else {
                tvSymptomsAns.text = view.text
            }
            tvSymptomsAns.visibility = View.VISIBLE
            llSymptomsOptions.visibility = View.GONE
            dataModel.symptoms = symptomList
            llAddSymptoms.visibility = View.VISIBLE
            svMain.focusOnView(llAddSymptoms)
        }
    }

    private fun updateFeverLayout(value: Utils.FeverEnum?, view: TextView) {
        value?.let {
            dataModel.fever = it
        }
        tvFeverAns.text = view.text
        tvFeverAns.visibility = View.VISIBLE
        llFeverOption1.visibility = View.GONE
        llFeverOption2.visibility = View.GONE
        llSymptoms.visibility = View.VISIBLE
        svMain.focusOnView(llSymptoms)
    }

    private fun updateGenderLayout(value: Utils.GenderEnum, view: TextView) {
        tvGenderAns.text = view.text
        tvGenderAns.visibility = View.VISIBLE
        llGenderOptions.visibility = View.GONE
        dataModel.gender = value
        llFever.visibility = View.VISIBLE
        svMain.focusOnView(llFever)
    }

    private fun updateAgeLayout(value: Utils.AgeEnum, view: TextView) {
        tvAgeAns.text = view.text
        tvAgeAns.visibility = View.VISIBLE
        llAgeOptions.visibility = View.GONE
        dataModel.age = value
        llGender.visibility = View.VISIBLE
        svMain.focusOnView(llGender)
    }

    private fun ScrollView.focusOnView(toView: View) {
        Handler().post(Runnable {
            this.smoothScrollTo(0, toView.top)
        })
    }

    private fun setSelectedLayout(view: TextView) {
        view.setBackgroundResource(R.drawable.bg_textselected)
        view.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    private fun setUnSelectedLayout(view: TextView) {
        view.setBackgroundResource(R.drawable.bg_textwhite)
        view.setTextColor(ContextCompat.getColor(this, R.color.txtcolor))
    }
}