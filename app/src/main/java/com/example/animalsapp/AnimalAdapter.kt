package com.example.animalsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.database.Animal

class AnimalAdapter(private val deleteCallback: (Animal) -> Unit) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animalList = listOf<Animal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalList[position]
        holder.bind(animal)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    fun submitList(list: List<Animal>) {
        animalList = list
        notifyDataSetChanged()
    }

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val continentTextView: TextView = itemView.findViewById(R.id.continentTextView)
        private val deleteButton: Button = itemView.findViewById(R.id.deleteButton)

        fun bind(animal: Animal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteButton.setOnClickListener {
                deleteCallback(animal)
            }
        }
    }
}
