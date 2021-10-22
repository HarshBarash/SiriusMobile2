package harshbarash.github.siriustwo.data.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.data.OrderViewModel
import harshbarash.github.siriustwo.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

        private lateinit var binding: FragmentMainBinding
        private lateinit var mOrderViewModel: OrderViewModel

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentMainBinding.bind(view)

            //rv
            val adapter = ListAdapter()
            val recyclerView = binding.recyclerview
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //Viewmodel
            mOrderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
            mOrderViewModel.readAllData.observe(viewLifecycleOwner, Observer { order -> adapter.setData(order)})

            binding.btntoroom.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_roomFragment)
            }
        }
    }