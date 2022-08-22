package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes: MutableLiveData<List<Shoe>> = MutableLiveData()
    val shoes: LiveData<List<Shoe>> = _shoes

    val shoeName: MutableLiveData<String> = MutableLiveData("")
    val shoeSize: MutableLiveData<String> = MutableLiveData("")
    val company: MutableLiveData<String> = MutableLiveData("")
    val description: MutableLiveData<String> = MutableLiveData("")

    init {
        addShoe(
            "Red Shoe",
            43.5,
            "Red Company",
            "Very Good Shoe"
        )
        addShoe(
            "Red Shoe",
            43.5,
            "Red Company",
            "Very Good Shoe"
        )
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoes.value = _shoes.value?.plus(shoe) ?: listOf(shoe)
    }


    fun isShoeInputsEmpty(): Boolean {
        if (shoeName.value?.isEmpty() == true ||
            shoeSize.value?.isEmpty() == true ||
            company.value?.isEmpty() == true ||
            description.value?.isEmpty() == true
        ) {
            return true
        }
        addShoe(
            shoeName.value!!,
            shoeSize.value?.toDouble()!!,
            company.value!!,
            description.value!!
        )
        return false
    }


}