package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {
    var data = listOf<SleepNight>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.llist_item_sleep_night,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val singleNight = data[position]
        val res = holder.itemView.context.resources
        holder.sleepQuality.text = convertDurationToFormatted(singleNight.startTimeMilli, singleNight.endTimeMilli,res)

    }

    override fun getItemCount() = data.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sleepQuality:TextView = itemView.findViewById(R.id.sleep_length)
        val quality:TextView = itemView.findViewById(R.id.quality_string)
    }


}