package com.pranhealth.coronaassasment

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

private var defaultLocale: Locale = Locale.ENGLISH
private lateinit var dataModel: DataModel

private var symptomList = ArrayList<Utils.SymptomsEnum>()
private var symptomTextList = ArrayList<String>()
private var addSymptomsList = ArrayList<Utils.AdditionalSymptomsEnum>()
private var addSymptomsTextList = ArrayList<String>()
private var historyList = ArrayList<Utils.HistoryEnum>()
private var historyTextList = ArrayList<String>()

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataModel = DataModel()
        defineListeners()
    }

    private fun defineListeners() {
        //Lang
        tvEng.setOnClickListener(this)
        tvMarathi.setOnClickListener(this)
        tvHindi.setOnClickListener(this)
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
        tvAddSytmBreathing.setOnClickListener(this)
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
            //Lang
            R.id.tvEng -> setLang(Utils.LanguageEnum.ENGLISH)
            R.id.tvMarathi -> setLang(Utils.LanguageEnum.MARATHI)
            R.id.tvHindi -> setLang(Utils.LanguageEnum.HINDI)
            //Age
            R.id.tvBelowFifteen -> updateAgeLayout(Utils.AgeEnum.BELOW_FIFTEEN)
            R.id.tvFifteenToForty -> updateAgeLayout(Utils.AgeEnum.FIFTEEN_TO_FORTY)
            R.id.tvFortyToSixty -> updateAgeLayout(Utils.AgeEnum.FORTY_TO_SIXTY)
            R.id.tvAbvSixty -> updateAgeLayout(Utils.AgeEnum.ABOVE_SIXTY)
            //Gender
            R.id.tvGenderMale -> updateGenderLayout(Utils.GenderEnum.MALE)
            R.id.tvGenderFemale -> updateGenderLayout(Utils.GenderEnum.FEMALE)
            R.id.tvGenderOther -> updateGenderLayout(Utils.GenderEnum.OTHER)
            //Fever
            R.id.tvFeverNormal -> updateFeverLayout(Utils.FeverEnum.NORMAL)
            R.id.tvFever -> updateFeverLayout(Utils.FeverEnum.FEVER)
            R.id.tvFeverHigh -> updateFeverLayout(Utils.FeverEnum.HIGH_FEVER)
            R.id.tvFeverNext -> updateFeverLayout(null)
            //Symptoms
            R.id.tvSytmAppetite -> updateSymptomLayout(Utils.SymptomsEnum.APPETITE, tvSytmAppetite)
            R.id.tvSytmCough -> updateSymptomLayout(Utils.SymptomsEnum.COUGH, tvSytmCough)
            R.id.tvSytmSmell -> updateSymptomLayout(Utils.SymptomsEnum.SMELL, tvSytmSmell)
            R.id.tvSytmThroat -> updateSymptomLayout(Utils.SymptomsEnum.THROAT, tvSytmThroat)
            R.id.tvSytmWeak -> updateSymptomLayout(Utils.SymptomsEnum.WEAKNESS, tvSytmWeak)
            R.id.tvSytmNext -> updateSymptomLayout(null, null)
            //Additional Symptoms
            R.id.tvAddSytmBreathing -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.BREATHING, tvAddSytmBreathing)
            R.id.tvAddSytmBreathless -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.BREATHLESS, tvAddSytmBreathless)
            R.id.tvAddSytmChestPain -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.CHEST_PAIN, tvAddSytmChestPain)
            R.id.tvAddSytmCough -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.COUGH, tvAddSytmCough)
            R.id.tvAddSytmDrowsiness -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.DROWSINESS, tvAddSytmDrowsiness)
            R.id.tvAddSytmWeakness -> updateAdditionalSymptomsLayout(Utils.AdditionalSymptomsEnum.WEAKNESS, tvAddSytmWeakness)
            R.id.tvAddSytmNext -> updateAdditionalSymptomsLayout(null, null)
            //Travel
            R.id.tvTravelNone -> updateTravelHistoryLayout(Utils.TravelEnum.NO_HISTORY)
            R.id.tvTravelNoContact -> updateTravelHistoryLayout(Utils.TravelEnum.NO_CONTACT_WITH_SYMPTOMS)
            R.id.tvTravel -> updateTravelHistoryLayout(Utils.TravelEnum.TRAVEL_HISTORY)
            R.id.tvTravelContact -> updateTravelHistoryLayout(Utils.TravelEnum.CONTACT_HISTORY)
            //History
            R.id.tvHisBP -> updateHistoryLayout(Utils.HistoryEnum.HIGH_BP, tvHisBP)
            R.id.tvHisDiabtes -> updateHistoryLayout(Utils.HistoryEnum.DIABETES, tvHisDiabtes)
            R.id.tvHisHeart -> updateHistoryLayout(Utils.HistoryEnum.HEART_DISEASE, tvHisHeart)
            R.id.tvHisImmunity -> updateHistoryLayout(Utils.HistoryEnum.REDUCED_IMMUNITY, tvHisImmunity)
            R.id.tvHisKidney -> updateHistoryLayout(Utils.HistoryEnum.KIDNEY, tvHisKidney)
            R.id.tvHisLungs -> updateHistoryLayout(Utils.HistoryEnum.LUNGS, tvHisLungs)
            R.id.tvHisStroke -> updateHistoryLayout(Utils.HistoryEnum.STROKE, tvHisStroke)
            R.id.tvHistNext -> updateHistoryLayout(null, null)
            //Progress
            R.id.tvProImproved -> updateHealthProgress(Utils.ProgressEnum.IMPROVED)
            R.id.tvProNoChange -> updateHealthProgress(Utils.ProgressEnum.NO_CHANGE)
            R.id.tvProWorsend -> updateHealthProgress(Utils.ProgressEnum.WORSEND)
            R.id.tvProWorsendCons -> updateHealthProgress(Utils.ProgressEnum.WORSEND_CONSIDARABLY)
        }
    }

    private fun updateHealthProgress(value: Utils.ProgressEnum) {
        tvProImproved.visibility = View.GONE
        tvProNoChange.visibility = View.GONE
        tvProWorsend.visibility = View.GONE
        tvProWorsendCons.visibility = View.GONE
        when (value) {
            Utils.ProgressEnum.IMPROVED -> tvProImproved.visibility = View.VISIBLE
            Utils.ProgressEnum.NO_CHANGE -> tvProNoChange.visibility = View.VISIBLE
            Utils.ProgressEnum.WORSEND -> tvProWorsend.visibility = View.VISIBLE
            Utils.ProgressEnum.WORSEND_CONSIDARABLY -> tvProWorsendCons.visibility = View.VISIBLE
        }
        dataModel.progress = value
        //Navigate TO next screen
    }

    private fun updateHistoryLayout(value: Utils.HistoryEnum?, view: TextView?) {
        value?.let {
            historyList.add(it)
            historyTextList.add(view?.text.toString())
            tvHistNext.text = "Confirm"
        } ?: run {
            if (historyTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in historyTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvHisBP.text = concatStr.subSequence(0, concatStr.length - 2)
                tvHisDiabtes.visibility = View.GONE
                llHistory2.visibility = View.GONE
                llHistory3.visibility = View.GONE
                llHistory4.visibility = View.GONE
            } else {
                llHistory1.visibility = View.GONE
                llHistory2.visibility = View.GONE
                llHistory3.visibility = View.GONE
                tvHisImmunity.visibility = View.GONE
            }
            dataModel.medHistory = historyList
            llProgress.visibility = View.VISIBLE
            svMain.focusOnView(llProgress)
        }
    }

    private fun updateTravelHistoryLayout(value: Utils.TravelEnum) {
        when (value) {
            Utils.TravelEnum.NO_HISTORY -> {
                tvTravelNoContact.visibility = View.GONE
                tvTravel.visibility = View.GONE
                tvTravelContact.visibility = View.GONE
            }
            Utils.TravelEnum.NO_CONTACT_WITH_SYMPTOMS -> {
                tvTravelNone.visibility = View.GONE
                tvTravel.visibility = View.GONE
                tvTravelContact.visibility = View.GONE
            }
            Utils.TravelEnum.TRAVEL_HISTORY -> {
                tvTravelNone.visibility = View.GONE
                tvTravelNoContact.visibility = View.GONE
                tvTravelContact.visibility = View.GONE
            }
            Utils.TravelEnum.CONTACT_HISTORY -> {
                tvTravelNone.visibility = View.GONE
                tvTravelNoContact.visibility = View.GONE
                tvTravel.visibility = View.GONE
            }
        }
        dataModel.travelHistory = value
        llHistory.visibility = View.VISIBLE
        svMain.focusOnView(llHistory)
    }

    private fun updateAdditionalSymptomsLayout(value: Utils.AdditionalSymptomsEnum?, view: TextView?) {
        value?.let {
            addSymptomsList.add(it)
            addSymptomsTextList.add(view?.text.toString())
            view?.setTextAppearance(R.style.styleSelectBtn)
            tvAddSytmNext.text = "Confirm"
        } ?: run {
            if (addSymptomsTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in addSymptomsTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvAddSytmBreathless.text = concatStr.substring(0, concatStr.length - 2)
                tvAddSytmCough.visibility = View.GONE
                llAddSytm2.visibility = View.GONE
                llAddSytm3.visibility = View.GONE
                llAddSytm4.visibility = View.GONE
            } else {
                llAddSytm1.visibility = View.GONE
                llAddSytm2.visibility = View.GONE
                llAddSytm3.visibility = View.GONE
                tvAddSytmWeakness.visibility = View.GONE
            }
            dataModel.additionalSymptoms = addSymptomsList
            llTravel.visibility = View.VISIBLE
            svMain.focusOnView(llTravel)
        }
    }

    private fun updateSymptomLayout(value: Utils.SymptomsEnum?, view: TextView?) {
        value?.let {
            when (it) {
                Utils.SymptomsEnum.APPETITE,
                Utils.SymptomsEnum.SMELL,
                Utils.SymptomsEnum.THROAT,
                Utils.SymptomsEnum.WEAKNESS,
                Utils.SymptomsEnum.COUGH -> {
                    symptomList.add(it)
                    symptomTextList.add(view?.text.toString())
                    view?.setTextAppearance(R.style.styleSelectBtn)
                    tvSytmNext.text = "Confirm"
                }
            }
        } ?: run {
            if (symptomTextList.size > 0) {
                val strBuilder = StringBuilder()
                for (item in symptomTextList) {
                    strBuilder.append(item)
                    strBuilder.append(", ")
                }
                val concatStr = strBuilder.toString()
                tvSytmSmell.text = concatStr.substring(0, concatStr.length - 2)
                tvSytmCough.visibility = View.GONE
                llSytmLayout2.visibility = View.GONE
                llSytmLayout3.visibility = View.GONE
            } else {
                llSytmLayout1.visibility = View.GONE
                llSytmLayout2.visibility = View.GONE
            }
            dataModel.sumptons = symptomList
            llAddSymptoms.visibility = View.VISIBLE
            svMain.focusOnView(llAddSymptoms)
        }
    }

    private fun updateFeverLayout(value: Utils.FeverEnum?) {
        value?.let {
            when (it) {
                Utils.FeverEnum.FEVER,
                Utils.FeverEnum.NORMAL -> {
                    tvFeverNormal.visibility = View.GONE
                    llFeverOption2.visibility = View.GONE
                }
                Utils.FeverEnum.HIGH_FEVER -> {
                    llFeverOption1.visibility = View.GONE
                    tvFeverNext.visibility = View.GONE
                }
            }
            dataModel.fever = it
        } ?: run {
            llFeverOption1.visibility = View.GONE
            tvFeverHigh.visibility = View.GONE
        }
        llSymptoms.visibility = View.VISIBLE
        svMain.focusOnView(llSymptoms)
    }

    private fun updateGenderLayout(value: Utils.GenderEnum) {
        when (value) {
            Utils.GenderEnum.MALE -> {
                dataModel.gender = Utils.GenderEnum.MALE
                tvGenderFemale.visibility = View.GONE
                tvGenderOther.visibility = View.GONE
            }
            Utils.GenderEnum.FEMALE -> {
                dataModel.gender = Utils.GenderEnum.FEMALE
                tvGenderMale.visibility = View.GONE
                tvGenderOther.visibility = View.GONE
            }
            Utils.GenderEnum.OTHER -> {
                dataModel.gender = Utils.GenderEnum.MALE
                tvGenderMale.visibility = View.GONE
                tvGenderFemale.visibility = View.GONE
            }
        }
        llFever.visibility = View.VISIBLE
        svMain.focusOnView(llFever)
    }

    private fun updateAgeLayout(value: Utils.AgeEnum) {
        when (value) {
            Utils.AgeEnum.BELOW_FIFTEEN -> {
                tvFifteenToForty.visibility = View.GONE
                tvFortyToSixty.visibility = View.GONE
                tvAbvSixty.visibility = View.GONE
            }
            Utils.AgeEnum.FIFTEEN_TO_FORTY -> {
                tvBelowFifteen.visibility = View.GONE
                tvFortyToSixty.visibility = View.GONE
                tvAbvSixty.visibility = View.GONE
            }
            Utils.AgeEnum.FORTY_TO_SIXTY -> {
                tvBelowFifteen.visibility = View.GONE
                tvFifteenToForty.visibility = View.GONE
                tvAbvSixty.visibility = View.GONE
            }
            Utils.AgeEnum.ABOVE_SIXTY -> {
                tvBelowFifteen.visibility = View.GONE
                tvFifteenToForty.visibility = View.GONE
                tvFortyToSixty.visibility = View.GONE
            }
        }
        dataModel.age = value
        llGender.visibility = View.VISIBLE
        svMain.focusOnView(llGender)
    }

    private fun setLang(value: Utils.LanguageEnum) {
        when (value) {
            Utils.LanguageEnum.ENGLISH -> {
                defaultLocale = Locale("en")
                updateLocale(defaultLocale.language)
                tvEng.visibility = View.VISIBLE
                tvMarathi.visibility = View.GONE
                tvHindi.visibility = View.GONE
            }
            Utils.LanguageEnum.MARATHI -> {
                defaultLocale = Locale("mr")
                updateLocale(defaultLocale.language)
                tvEng.visibility = View.GONE
                tvMarathi.visibility = View.VISIBLE
                tvHindi.visibility = View.GONE
            }
            Utils.LanguageEnum.HINDI -> {
                defaultLocale = Locale("hi")
                updateLocale(defaultLocale.language)
                tvEng.visibility = View.GONE
                tvMarathi.visibility = View.GONE
                tvHindi.visibility = View.VISIBLE
            }
        }
        llAge.visibility = View.VISIBLE
    }

    private fun ScrollView.focusOnView(toView: View) {
        Handler().post(Runnable {
            this.smoothScrollTo(0, toView.top)
        })
    }

    private fun updateLocale(language: String) {
        if (language != "en") {
            recreate()
            val locale = Locale(language)
            Locale.setDefault(locale)

            val res = this.resources
            val config = Configuration(res.configuration)
            config.locale = locale
            res.updateConfiguration(config, res.displayMetrics)
        }
    }

}