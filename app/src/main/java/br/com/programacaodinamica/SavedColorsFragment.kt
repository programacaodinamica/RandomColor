package br.com.programacaodinamica

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import br.com.programacaodinamica.randomcolor.R
import br.com.programacaodinamica.randomcolor.commom.generateRandomColor
import kotlinx.android.synthetic.main.saved_colors_fragment.*

class SavedColorsFragment : Fragment() {

    companion object {
        fun newInstance() = SavedColorsFragment()
    }

    private lateinit var savedColorsViewModel: SavedColorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.saved_colors_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            savedColorsViewModel = ViewModelProviders.of(it).get(SavedColorsViewModel::class.java)
        }
        setUpListeners()
        subscribe()
    }


    private fun setUpListeners(){
        refresh_button.setOnClickListener {
            savedColorsViewModel.randomColor.value = generateRandomColor()
        }
    }

    private fun subscribe(){
        savedColorsViewModel.randomColor.observe(this, Observer {
            random_color_cardview.setCardBackgroundColor(it)
        })
    }

}
