package com.pranhealth.coronaassasment

class Utils {
    enum class LanguageEnum {
        ENGLISH, HINDI, MARATHI
    }

    enum class AgeEnum(val value: Int) {
        BELOW_FIFTEEN(1), FIFTEEN_TO_FORTY(0), FORTY_TO_SIXTY(1), ABOVE_SIXTY(2)
    }

    enum class GenderEnum(val value: Int) {
        MALE(0), FEMALE(0), OTHER(0)
    }

    enum class FeverEnum(val value: Int) {
        NORMAL(0), FEVER(1), HIGH_FEVER(2)
    }

    enum class SymptomsEnum(val value: Int) {
        COUGH(0), SMELL(0), THROAT(0), WEAKNESS(0), APPETITE(0)
    }

    enum class AdditionalSymptomsEnum(val value: Int) {
        COUGH(0), BREATHLESS(0), BREATHING(0), DROWSINESS(0), CHEST_PAIN(0), WEAKNESS(0)
    }

    enum class TravelEnum(val value: Int) {
        NO_HISTORY(0), NO_CONTACT_WITH_SYMPTOMS(0), TRAVEL_HISTORY(2), CONTACT_HISTORY(2)
    }

    enum class HistoryEnum(val value: Int) {
        DIABETES(1), HIGH_BP(1), HEART_DISEASE(1), KIDNEY(1), LUNGS(1), STROKE(1), REDUCED_IMMUNITY(1)
    }

    enum class ProgressEnum(val value: Int) {
        IMPROVED(0), NO_CHANGE(0), WORSEND(2), WORSEND_CONSIDARABLY(3)
    }
}