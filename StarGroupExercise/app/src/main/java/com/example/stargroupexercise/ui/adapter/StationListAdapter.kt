package com.example.stargroupexercise.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stargroupexercise.R
import com.example.stargroupexercise.data.model.ObjStationData
import com.example.stargroupexercise.utils.debounceClick
import kotlinx.android.synthetic.main.station_list_item.view.*

class StationListAdapter(
    private val station: ArrayList<ObjStationData>
    , private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<StationListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(station: ObjStationData, clickListener: OnItemClickListener) {
            itemView.tvStationName.text = station.Destination
            itemView.tvStationTime.text = station.Destinationtime
            itemView.debounceClick {
                clickListener.onItemClicked(station)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.station_list_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = station.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(station[position], itemClickListener)

    fun addData(list: List<ObjStationData>) {
        if (station.isNotEmpty()) station.clear()
        station.addAll(list)
    }

    interface OnItemClickListener {
        fun onItemClicked(stationData: ObjStationData)
    }

}