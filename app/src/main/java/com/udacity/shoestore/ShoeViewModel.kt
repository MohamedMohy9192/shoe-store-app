package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes: MutableLiveData<List<Shoe>> = MutableLiveData()
    val shoes: LiveData<List<Shoe>> = _shoes

    fun addShoe(shoe: Shoe){
       _shoes.value = _shoes.value?.plus(shoe) ?: listOf(shoe)
    }
}