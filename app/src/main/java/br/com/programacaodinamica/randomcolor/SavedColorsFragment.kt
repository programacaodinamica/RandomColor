package br.com.programacaodinamica.randomcolor

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.programacaodinamica.randomcolor.commom.generateRandomColor
import br.com.programacaodinamica.randomcolor.model.NamedColor
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
        setUpRecyclerView()
    }


    private fun setUpListeners(){
        refresh_button.setOnClickListener {
            savedColorsViewModel.randomColor.value = generateRandomColor()
        }

        save_button.setOnClickListener {
            val colorId = savedColorsViewModel.randomColor.value
            if (colorId != null) {
                val color = NamedColor(
                    colorId,
                    color_name_edittext.text.toString()
                )
                savedColorsViewModel.saveColor(color)

                color_name_edittext.setText("")
                savedColorsViewModel.randomColor.value = generateRandomColor()
            }
        }
    }

    private fun subscribe(){
        savedColorsViewModel.randomColor.observe(this, Observer {
            random_color_cardview.setCardBackgroundColor(it)
        })

        savedColorsViewModel.colors.observe(this, Observer {
            val adapter = colors_list.adapter
            if (adapter is ColorAdapter){
                adapter.setData(it)
            }
        })
    }

    private fun setUpRecyclerView(){
        colors_list.adapter = ColorAdapter()
        colors_list.layoutManager = LinearLayoutManager(context)
    }

}
