package com.eahm.jetpackcomponentsexp.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.eahm.jetpackcomponentsexp.BR
import com.eahm.jetpackcomponentsexp.enums.Gender

class CustomerViewModel(
    private var name: String,
    private var phone: String,
    private var address: String,
    private var gender: Gender,
    private var enterpriseEdition: Boolean,
    private var subscriber: Boolean
) : BaseObservable() {

    //region bindable methods
    @Bindable
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        if (this.name != name) {
            this.name = name
            notifyPropertyChanged(BR.name)
        }
    }

    @Bindable
    fun getPhone(): String {
        return phone
    }

    fun setPhone(phone: String) {
        if (this.phone != phone) {
            this.phone = phone
            notifyPropertyChanged(BR.phone)
        }
    }

    @Bindable
    fun getAddress(): String {
        return address
    }

    fun setAddress(address: String) {
        if (this.address != address) {
            this.address = address
        }
    }

    @Bindable
    fun getGender(): Gender {
        return gender
    }

    fun setGender(gender: Gender) {
        if (this.gender !== gender) {
            this.gender = gender
            notifyPropertyChanged(BR.gender)
        }
    }

    @Bindable
    fun isEnterpriseEdition(): Boolean {
        return enterpriseEdition
    }

    fun setEnterpriseEdition(isEnterpriseEdition: Boolean) {
        // Avoid infinite loops checking if the new value is different from the current
        if (this.enterpriseEdition != isEnterpriseEdition) {
            this.enterpriseEdition = isEnterpriseEdition

            // We have to notify every time the value has changed
            notifyPropertyChanged(BR.enterpriseEdition)
        }
    }

    @Bindable
    fun isSubscriber(): Boolean {
        return subscriber
    }

    fun setSubscriber(subscriber: Boolean) {
        // Avoid infinite loops checking if the new value is different from the current
        if (this.subscriber != subscriber) {
            this.subscriber = subscriber

            // We have to notify every time the value has changed
            notifyPropertyChanged(BR.subscriber)
        }
    }

    //endregion bindable methods

}