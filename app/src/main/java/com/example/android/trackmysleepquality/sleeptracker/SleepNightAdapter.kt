package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {
    var data = listOf<SleepNight>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val singleNight = data[position]
        holder.bind(singleNight)

    }


    override fun getItemCount() = data.size


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sleepQuality:TextView = itemView.findViewById(R.id.sleep_length)
        private val quality:TextView = itemView.findViewById(R.id.quality_string)
        private val imageQuality :ImageView = itemView.findViewById(R.id.quality_image)

        fun bind(singleNight: SleepNight) {
            val res = itemView.context.resources
            sleepQuality.text = convertDurationToFormatted(singleNight.startTimeMilli, singleNight.endTimeMilli, res)
            quality.text = convertNumericQualityToString(singleNight.sleepQuality, res)
            imageQuality.setImageResource(when (singleNight.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.llist_item_sleep_night, parent, false)
                return ViewHolder(view)
            }
        }
    }




}