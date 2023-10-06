package com.example.triviamania.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triviamania.Adapters.StagesAdapter
import com.example.triviamania.Models.StagesModel
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentandroidLevelsBinding

class Android_LevelsFragment : Fragment() {

    private lateinit var binding:FragmentandroidLevelsBinding
    private var isNotExpanded = false

    private lateinit var easylist:ArrayList<StagesModel>
    private lateinit var mediumlist:ArrayList<StagesModel>
    private lateinit var hardlist:ArrayList<StagesModel>
    private lateinit var vhardlist:ArrayList<StagesModel>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentandroidLevelsBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            easylist = ArrayList()
            mediumlist = ArrayList()
            hardlist = ArrayList()
            vhardlist = ArrayList()
            easystagesRV.layoutManager = LinearLayoutManager(requireContext())
            mediumstagesRV.layoutManager = LinearLayoutManager(requireContext())
            hardRV.layoutManager = LinearLayoutManager(requireContext())
            vhardRV.layoutManager = LinearLayoutManager(requireContext())

            (1..2).forEach {
                easylist.add(StagesModel("Stage $it"))  //40  60q
            }

            (3..5).forEach {
                mediumlist.add(StagesModel("Stage $it")) // 70 83 97
            }

            (6..9).forEach {
                hardlist.add(StagesModel("Stage $it")) // 80 80 80 80
            }

            (10..14).forEach {
                vhardlist.add(StagesModel("Stage $it")) // 90 90 90 90 90
            }

            val easyadapter = StagesAdapter(requireContext(),easylist)
            val mediumadapter = StagesAdapter(requireContext(),mediumlist)
            val hardadapter = StagesAdapter(requireContext(),hardlist)
            val vhardadapter = StagesAdapter(requireContext(),vhardlist)

            easystagesRV.adapter = easyadapter
            mediumstagesRV.adapter = mediumadapter
            hardRV.adapter = hardadapter
            vhardRV.adapter = vhardadapter


            stageeasyViewImgId.setOnClickListener {
                toggle(stageeasyViewImgId,easystagesRV)
            }
            stgsMediumIV.setOnClickListener{
                toggle(stgsMediumIV,mediumstagesRV)
            }
            stgsHardIV.setOnClickListener{
                toggle(stgsHardIV,hardRV)
            }
            stgsvhardIV.setOnClickListener{
                toggle(stgsvhardIV,vhardRV)
            }





        }


    }


    fun toggle(image:ImageView,rview: RecyclerView) {
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


