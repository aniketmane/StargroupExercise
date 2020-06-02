package com.example.stargroupexercise.ui.view.detail
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.stargroupexercise.BR

class StationDetailViewModel : BaseObservable() {
    private var stationFullName: String = ""
    private var from: String = ""
    private var to: String = ""
    private var directions: String = ""
    private var expArrivalTime: String = ""
    private var expDeparture: String = ""
    private var status: String = ""

    @Bindable
    fun getStationFullName(): String {
        return stationFullName
    }

    fun setStationFullName(value: String) {
        if (stationFullName != value) {
            stationFullName = value
            notifyPropertyChanged(BR.stationFullName)
        }
    }

    @Bindable
    fun getFrom(): String {
        return from
    }

    fun setFrom(value: String) {
        if (from != value) {
            from = value
            notifyPropertyChanged(BR.from)
        }
    }

    @Bindable
    fun getTo(): String {
        return to
    }

    fun setTo(value: String) {
        if (to != value) {
            to = value
            notifyPropertyChanged(BR.to)
        }
    }

    @Bindable
    fun getDirections(): String {
        return directions
    }

    fun setDirections(value: String) {
        if (directions != value) {
            directions = value
            notifyPropertyChanged(BR.directions)
        }
    }

    @Bindable
    fun getExpArrivalTime(): String {
        return expArrivalTime
    }

    fun setExpArrivalTime(value: String) {
        if (expArrivalTime != value) {
            expArrivalTime = value
            notifyPropertyChanged(BR.expArrivalTime)
        }
    }

    @Bindable
    fun getExpDeparture(): String {
        return expDeparture
    }

    fun setExpDeparture(value: String) {
        if (expDeparture != value) {
            expDeparture = value
            notifyPropertyChanged(BR.expDeparture)
        }
    }

    @Bindable
    fun getStatus(): String {
        return status.toString()
    }

    fun setStatus(value: String) {
        if (status != value) {
            status = value
            notifyPropertyChanged(BR.status)
        }
    }


}