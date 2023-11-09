package com.example.triviamania.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triviamania.Adapters.StagesAdapter
import com.example.triviamania.Models.StagesModel
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentandroidLevelsBinding

class Android_LevelsFragment : Fragment() {

    private lateinit var binding:FragmentandroidLevelsBinding
    private var isNotExpanded = false

    private lateinit var easylist:MutableList<StagesModel>
    private lateinit var mediumlist:MutableList<StagesModel>
    private lateinit var hardlist:MutableList<StagesModel>
    private lateinit var vhardlist:MutableList<StagesModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentandroidLevelsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            easylist = mutableListOf()
            mediumlist = mutableListOf()
            hardlist = mutableListOf()
            vhardlist = mutableListOf()
            easystagesRV.layoutManager = LinearLayoutManager(requireContext())
            mediumstagesRV.layoutManager = LinearLayoutManager(requireContext())
            hardRV.layoutManager = LinearLayoutManager(requireContext())
            vhardRV.layoutManager = LinearLayoutManager(requireContext())

            backImg.setOnClickListener {
                findNavController().popBackStack(R.id.categoriesFragment,false)
            }

            (1..2).forEach {
                easylist.add(StagesModel("Stage $it"))
            }

            (3..5).forEach {
                mediumlist.add(StagesModel("Stage $it"))
            }

            (6..9).forEach {
                hardlist.add(StagesModel("Stage $it"))
            }

            (10..14).forEach {
                vhardlist.add(StagesModel("Stage $it"))
            }

            val easyadapter = StagesAdapter(requireContext(),easylist,R.id.game_Fragment)
            val mediumadapter = StagesAdapter(requireContext(),mediumlist,R.id.game_Fragment)
            val hardadapter = StagesAdapter(requireContext(),hardlist,R.id.game_Fragment)
            val vhardadapter = StagesAdapter(requireContext(),vhardlist,R.id.game_Fragment)

            easystagesRV.adapter = easyadapter
            mediumstagesRV.adapter = mediumadapter
            hardRV.adapter = hardadapter
            vhardRV.adapter = vhardadapter


            easyLL.setOnClickListener {
                toggle(stageeasyViewImgId,easystagesRV)
            }
            mediumLL.setOnClickListener{
                toggle(stgsMediumIV,mediumstagesRV)
            }
            hardLL.setOnClickListener{
                toggle(stgsHardIV,hardRV)
            }
            vhardLL.setOnClickListener{
                toggle(stgsvhardIV,vhardRV)
            }

        }


    }


    private fun toggle(image:ImageView, rview: RecyclerView) {
        if (isNotExpanded) {
            rview.visibility = View.GONE
            image.setImageResource(R.drawable.baseline_keyboard_arrow_right_24)
            isNotExpanded = false
        } else {
            rview.visibility = View.VISIBLE
            image.setImageResource(R.drawable.ic_arrow_down_24)
            isNotExpanded = true
        }
    }


}


