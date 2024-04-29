package com.example.animalsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.R
import com.example.animalsapp.AnimalModel
import com.example.animalsapp.EContinent
import android.view.Gravity

class AnimalListAdapter(private val animalList: List<AnimalModel>) :
    RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = when (EContinent.values()[viewType]) {
            EContinent.AFRICA -> inflater.inflate(R.layout.item_africa, parent, false)
            EContinent.ANTARCTICA -> inflater.inflate(R.layout.item_antarctica, parent, false)
            EContinent.AUSTRALIA -> inflater.inflate(R.layout.item_australia, parent, false)
            EContinent.ASIA -> inflater.inflate(R.layout.item_asia, parent, false)
            EContinent.EUROPE -> inflater.inflate(R.layout.item_europe, parent, false)
            EContinent.NORTH_AMERICA -> inflater.inflate(R.layout.item_north_america, parent, false)
            EContinent.SOUTH_AMERICA -> inflater.inflate(R.layout.item_south_america, parent, false)
        }
        return AnimalViewHolder(view)
    }
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animalList[position])
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun getItemViewType(position: Int): Int {
        return animalList[position].continent.ordinal
    }
    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val animalTextView: TextView = itemView.findViewById(R.id.animalTextView)
        private val continentTextView: TextView = itemView.findViewById(R.id.continentTextView)

        fun bind(animal: AnimalModel) {
            animalTextView.text = animal.name
            if(animal.continent.name=="AFRICA")
                continentTextView.text = "Africa"
            if(animal.continent.name=="ANTARCTICA")
                continentTextView.text = "Antarctica"
            if(animal.continent.name=="AUSTRALIA")
                continentTextView.text = "Australia"
            if(animal.continent.name=="ASIA")
                continentTextView.text = "Asia"
            if(animal.continent.name=="EUROPE")
                continentTextView.text = "Europe"
            if(animal.continent.name=="NORTH_AMERICA")
                continentTextView.text = "North America"
            if(animal.continent.name=="SOUTH_AMERICA")
                continentTextView.text = "South America"



        }
    }
}