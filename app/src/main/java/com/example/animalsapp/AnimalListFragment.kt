package com.example.animalsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.AnimalListAdapter
import com.example.animalsapp.AnimalModel
import com.example.animalsapp.EContinent

class AnimalListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimalList()
    }

    private fun setupAnimalList() {
        val layoutManager = LinearLayoutManager(context)

        val animalList = getAnimals()
        val adapter = AnimalListAdapter(animalList)

        view?.findViewById<RecyclerView>(R.id.rv_animal_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }private fun getAnimals(): List<AnimalModel> {
        return listOf(
            AnimalModel("Kangaroo", EContinent.AUSTRALIA),
            AnimalModel("Wolf", EContinent.EUROPE),
            AnimalModel("Brown Bear", EContinent.EUROPE),
            AnimalModel("Snow Leopard", EContinent.ASIA),
            AnimalModel("Seal", EContinent.ANTARCTICA),
            AnimalModel("Whale", EContinent.ANTARCTICA),
            AnimalModel("Platypus", EContinent.AUSTRALIA),
            AnimalModel("Moose", EContinent.EUROPE),
            AnimalModel("Cheetah", EContinent.AFRICA),
            AnimalModel("Orca", EContinent.ANTARCTICA),
            AnimalModel("Red Panda", EContinent.ASIA),
            AnimalModel("Penguin", EContinent.ANTARCTICA),
            AnimalModel("Beaver", EContinent.NORTH_AMERICA),
            AnimalModel("Elephant Seal", EContinent.ANTARCTICA),
            AnimalModel("Bald Eagle", EContinent.NORTH_AMERICA),
            AnimalModel("Alligator", EContinent.NORTH_AMERICA),
            AnimalModel("Indian Rhino", EContinent.ASIA),
            AnimalModel("Bison", EContinent.NORTH_AMERICA),
            AnimalModel("Panda", EContinent.ASIA),
            AnimalModel("Wild Boar", EContinent.EUROPE),
            AnimalModel("Polar Bear", EContinent.ANTARCTICA),
            AnimalModel("Giraffe", EContinent.AFRICA),
            AnimalModel("Jaguar", EContinent.SOUTH_AMERICA),
            AnimalModel("Moose", EContinent.NORTH_AMERICA),
            AnimalModel("Arctic Fox", EContinent.ANTARCTICA),
            AnimalModel("Koala", EContinent.AUSTRALIA),
            AnimalModel("Anaconda", EContinent.SOUTH_AMERICA),
            AnimalModel("Tiger", EContinent.ASIA),
            AnimalModel("Lion", EContinent.AFRICA),
            AnimalModel("Bear", EContinent.EUROPE),
            AnimalModel("Condor", EContinent.SOUTH_AMERICA),
            AnimalModel("Gorilla", EContinent.AFRICA),
            AnimalModel("Kookaburra", EContinent.AUSTRALIA),
            AnimalModel("Capybara", EContinent.SOUTH_AMERICA),
            AnimalModel("Llama", EContinent.SOUTH_AMERICA),
            AnimalModel("Leopard", EContinent.AFRICA),
            AnimalModel("Snow Petrel", EContinent.ANTARCTICA),
            AnimalModel("Elephant", EContinent.ASIA),
            AnimalModel("Albatross", EContinent.ANTARCTICA),
            AnimalModel("Fox", EContinent.EUROPE),
            AnimalModel("Emu", EContinent.AUSTRALIA),
            AnimalModel("Dingo", EContinent.AUSTRALIA),
            AnimalModel("Tapir", EContinent.SOUTH_AMERICA),
            AnimalModel("Gibbon", EContinent.ASIA),
            AnimalModel("Cassowary", EContinent.AUSTRALIA),
            AnimalModel("Anteater", EContinent.SOUTH_AMERICA),
            AnimalModel("Puma", EContinent.NORTH_AMERICA),
            AnimalModel("Black Bear", EContinent.NORTH_AMERICA),
            AnimalModel("Elephant", EContinent.AFRICA),
            AnimalModel("Bengal Tiger", EContinent.ASIA),
            AnimalModel("Anaconda", EContinent.SOUTH_AMERICA),
            AnimalModel("Mountain Lion", EContinent.NORTH_AMERICA),
            AnimalModel("Toucan", EContinent.SOUTH_AMERICA),
            AnimalModel("European Bison", EContinent.EUROPE),
            AnimalModel("Rhino", EContinent.AFRICA),
            AnimalModel("Lynx", EContinent.EUROPE),
            AnimalModel("Tasmanian Devil", EContinent.AUSTRALIA),
            AnimalModel("Sloth", EContinent.SOUTH_AMERICA),
            AnimalModel("Condor", EContinent.SOUTH_AMERICA),
            AnimalModel("Beaver", EContinent.EUROPE),
            AnimalModel("Elephant", EContinent.ASIA),
            AnimalModel("Anaconda", EContinent.SOUTH_AMERICA),
            AnimalModel("Anaconda", EContinent.SOUTH_AMERICA)
        )
    }


}
