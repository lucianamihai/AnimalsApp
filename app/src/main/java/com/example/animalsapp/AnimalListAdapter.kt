package com.example.animalsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class AnimalListAdapter(
    private val animalList: List<AnimalModel>,
    private val onItemClick: (String, String) -> Unit
) : RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>() {

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
        return AnimalViewHolder(view,onItemClick)
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
    class AnimalViewHolder(itemView: View, private val onItemClick: (String, String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val animalTextView: TextView = itemView.findViewById(R.id.animalTextView)
        private val continentTextView: TextView = itemView.findViewById(R.id.continentTextView)


        fun bind(animal: AnimalModel) {
            animalTextView.text = animal.name
            val continentName = when (animal.continent) {
                EContinent.AFRICA -> "Africa"
                EContinent.ANTARCTICA -> "Antarctica"
                EContinent.AUSTRALIA -> "Australia"
                EContinent.ASIA -> "Asia"
                EContinent.EUROPE -> "Europe"
                EContinent.NORTH_AMERICA -> "North America"
                EContinent.SOUTH_AMERICA -> "South America"
            }
            continentTextView.text = continentName

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {

                    onItemClick.invoke(animal.name, continentName)
                }
            }
        }
    }

}