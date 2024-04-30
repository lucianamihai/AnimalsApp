import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.animalsapp.R

class AnimalDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            val animalName = args.getString(ARG_ANIMAL_NAME)
            val continentName = args.getString(ARG_CONTINENT_NAME)

            view.findViewById<TextView>(R.id.animalTextView).apply {
                text = animalName
                setTextColor(getTextColorForContinent(continentName))
            }

            view.findViewById<TextView>(R.id.continentTextView).apply {
                text = continentName
                setTextColor(getTextColorForContinent(continentName))
            }
            val backgroundColor = when (continentName) {
                "Africa" -> R.color.yellow
                "Antarctica" -> R.color.blue
                "Australia" -> R.color.purple
                "Asia" -> R.color.red
                "Europe" -> R.color.green
                "North America" -> R.color.brown
                "South America" -> R.color.orange
                else -> R.color.red
            }
            view.setBackgroundResource(backgroundColor)

        }
    }


    private fun getTextColorForContinent(continentName: String?): Int {
        return when (continentName) {
            "Africa" -> Color.BLACK
            "Antarctica" -> Color.WHITE
            "Australia" -> Color.WHITE
            "Asia" -> Color.WHITE
            "Europe" -> Color.WHITE
            "North America" -> Color.WHITE
            "South America" -> Color.BLACK
            else -> Color.BLACK
        }
    }
    companion object {
        const val ARG_ANIMAL_NAME = "animalName"
        const val ARG_CONTINENT_NAME = "continentName"

        fun newInstance(animalName: String, continentName: String): AnimalDetailFragment {
            val fragment = AnimalDetailFragment()
            val args = Bundle().apply {
                putString(ARG_ANIMAL_NAME, animalName)
                putString(ARG_CONTINENT_NAME, continentName)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
