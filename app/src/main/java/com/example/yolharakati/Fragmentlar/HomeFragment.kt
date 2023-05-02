package com.example.yolharakati.Fragmentlar

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.yolharakati.Adapters.StateAdapter
import com.example.yolharakati.Models.PagerItem
import com.example.yolharakati.R
import com.example.yolharakati.databinding.FragmentHomeBinding
import com.example.yolharakati.databinding.FragmentKirishBinding
import com.example.yolharakati.databinding.TabItemBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var stateAdapter:StateAdapter
    private lateinit var list: ArrayList<PagerItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list= ArrayList()
        list.add(PagerItem("Ogohlantiruvchi"))
        list.add(PagerItem("Imtiyozli"))
        list.add(PagerItem("Taqiqlovchi"))
        list.add(PagerItem("Buyuruvchi"))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home->{
                    Toast.makeText(context, "Siz bosh menudasiz", Toast.LENGTH_SHORT).show()
                }
                R.id.ic_like->{
                    Toast.makeText(context, "Siz uzizga yoqqan bulimiga uttiz", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.likeFragment)
                }
                R.id.ic_about->{
                    Toast.makeText(context, "Siz ilova haqida berilgan oynaga uttiz", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.aboutFragment)
                }
                R.id.ic_settings->{
                    Toast.makeText(context, "Siz nastiroyka bulimiga uttiz", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.settingsFragment)
                }
            }

            true
        }

        stateAdapter=StateAdapter(list,this)
        binding.myViewpager.adapter=stateAdapter

        //TabLayout Listener
        binding.myTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView=tab?.customView
                customView?.findViewById<TextView>(R.id.tab_item_tv)!!.setTextColor(Color.parseColor("#005CA1"))
                customView.findViewById<TextView>(R.id.tab_item_tv)!!.setBackgroundColor(Color.WHITE)
//                customView.findViewById<TextView>(R.id.tab_item)!!.setBackgroundResource(R.drawable.tab_item_selected_card)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView=tab?.customView
                customView?.findViewById<TextView>(R.id.tab_item_tv)!!.setBackgroundColor(Color.parseColor("#005CA1"))
                customView?.findViewById<TextView>(R.id.tab_item_tv)!!.setTextColor(Color.WHITE)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        //set Tablayout Mediator
        TabLayoutMediator(binding.myTablayout,binding.myViewpager){tab,position->
            val tabItemView= TabItemBinding.inflate(layoutInflater)
            //write tablayout properties
            tabItemView.tabItemTv.text=list[position].type
            tab.customView = tabItemView.root
        }.attach()


        //add Label button
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return binding.root
    }

}