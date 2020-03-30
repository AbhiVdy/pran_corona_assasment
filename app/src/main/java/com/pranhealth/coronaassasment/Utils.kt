package com.pranhealth.coronaassasment

import java.util.*

class Utils {
    companion object{
        var tempLocale : Locale? = null
    }
    enum class LanguageEnum(val value: String) {
        ENGLISH("en"), HINDI("hi"), MARATHI("mr")
    }

    enum class AgeEnum(val value: Int) {
        BELOW_FIFTEEN(1), FIFTEEN_TO_FORTY(1), FORTY_TO_SIXTY(1), ABOVE_SIXTY(2)
    }

    enum class GenderEnum(val value: Int) {
        MALE(0), FEMALE(0), OTHER(0)
    }

    enum class FeverEnum(val value: Int) {
        NORMAL(0), FEVER(1), HIGH_FEVER(2)
    }

    enum class SymptomsEnum(val value: Int) {
        COUGH(2), SMELL(1), THROAT(2), WEAKNESS(1), APPETITE(0)
    }

    enum class AdditionalSymptomsEnum(val value: Int) {
        COUGH(3), BREATHLESS(2), DROWSINESS(1), CHEST_PAIN(1), WEAKNESS(2)
    }

    enum class TravelEnum(val value: Int) {
        NO_HISTORY(0), NO_CONTACT_WITH_SYMPTOMS(0), TRAVEL_HISTORY(3), CONTACT_HISTORY(2)
    }

    enum class HistoryEnum(val value: Int) {
        DIABETES(3), HIGH_BP(1), HEART_DISEASE(2), KIDNEY(2), ASTHAMA (3), STROKE(1), REDUCED_IMMUNITY(3)
    }

    enum class ProgressEnum(val value: Int) {
        IMPROVED(0), NO_CHANGE(0), WORSEND(2), WORSEND_CONSIDARABLY(3)
    }

    enum class RiskEnum {
        LOW, MEDIUM, HIGH
    }
}