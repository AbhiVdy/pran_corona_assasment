package com.pranhealth.coronaassasment

data class DataModel (
        var age: Utils.AgeEnum? = null,
        var gender: Utils.GenderEnum? = null,
        var fever: Utils.FeverEnum? = null,
        var symptoms: List<Utils.SymptomsEnum>? = null,
        var additionalSymptoms: List<Utils.AdditionalSymptomsEnum>? = null,
        var travelHistory: Utils.TravelEnum? = null,
        var medHistory: List<Utils.HistoryEnum>? = null,
        var progress: Utils.ProgressEnum? = null
) {
    fun clear(){
        age = null
        gender = null
        fever = null
        symptoms = null
        additionalSymptoms = null
        travelHistory = null
        medHistory = null
        progress = null
    }
}