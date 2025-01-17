package com.intrast.depi_g1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    var scoreA : MutableLiveData<Int> = MutableLiveData(0)
    var scoreB : MutableLiveData<Int> = MutableLiveData(0)

    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA.value = scoreA.value?.plus(1)
        }
        else {
            scoreB.value = scoreB.value?.plus(1)
        }
    }

    fun decrementScore(isTeamA: Boolean) {
        if (isTeamA && scoreA.value!! > 0) {
            scoreA.value = scoreA.value?.minus(1)
        } else if (!isTeamA && scoreB.value!! > 0) {
           scoreB.value = scoreB.value?.minus(1)
        }

    }

    fun resetScore() {
      scoreA.value = 0
        scoreB.value = 0
    }


}