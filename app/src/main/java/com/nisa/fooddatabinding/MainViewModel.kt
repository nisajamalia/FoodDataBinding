package com.nisa.fooddatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _likeNumber = MutableLiveData(0)
    private val _unLikeNumber = MutableLiveData(0)
    private val _foodImage = MutableLiveData(R.drawable.food)

    val likeNumbers: LiveData<Int> = _likeNumber
    val unLikeNumbers: LiveData<Int> = _unLikeNumber
    val foodImage : LiveData<Int> = _foodImage



    val popularity: LiveData<MainObservableViewModel.LikeNumbers> =
        Transformations.map(_likeNumber) {
            when {
                it > 9 -> MainObservableViewModel.LikeNumbers.STAR
                it > 5 -> MainObservableViewModel.LikeNumbers.POPULAR
                else -> MainObservableViewModel.LikeNumbers.NORMAL
            }
        }
    val unPopularity: LiveData<MainObservableViewModel.UnLikeNumbers> =
        Transformations.map(_unLikeNumber) {
            when {
                it > 9 -> MainObservableViewModel.UnLikeNumbers.UNSATISFYING
                it > 5 -> MainObservableViewModel.UnLikeNumbers.NOTPOPULAR
                else -> MainObservableViewModel.UnLikeNumbers.NORMAL
            }
        }

    fun onLike() {
        _likeNumber.value = (_likeNumber.value ?: 0) + 1
    }

    fun onUnLike() {
        _unLikeNumber.value = (_unLikeNumber.value ?: 0) + 1
    }




//    val unPopularity {}
}

class MainObservableViewModel : MainBaseObservableViewModel() {
    enum class LikeNumbers {
        NORMAL, POPULAR, STAR
    }

    enum class UnLikeNumbers {
        NORMAL, NOTPOPULAR, UNSATISFYING
    }
}