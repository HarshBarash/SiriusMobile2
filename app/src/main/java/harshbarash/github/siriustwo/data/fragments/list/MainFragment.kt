package harshbarash.github.siriustwo.data.fragments.list

import android.graphics.Color
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
        mOrderViewModel.readAllData.observe(
            viewLifecycleOwner,
            Observer { order -> adapter.setData(order) })

        binding.rectBuy.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_roomFragment)
        }

        if (mOrderViewModel.readAllData.value?.isEmpty() == true) {
            recyclerView.visibility = View.INVISIBLE
            binding.womanClear.visibility = View.VISIBLE
            binding.imageView4.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.textView2.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.imageView5.visibility = View.VISIBLE
            binding.textView4.visibility = View.VISIBLE
            binding.rectBuy.visibility = View.VISIBLE
            binding.purchaiseTv.visibility = View.VISIBLE
            binding.imageView7.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            binding.womanClear.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.textView2.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.textView4.visibility = View.INVISIBLE
            binding.rectBuy.visibility = View.INVISIBLE
            binding.purchaiseTv.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.textView3.visibility = View.INVISIBLE
        }
        binding.actualBtn.setOnClickListener {
            binding.actualBtn.setTextColor(resources.getColor(R.color.activeBottomNavIconColor))
            binding.completedBtn.setTextColor(resources.getColor(R.color.InactiveBottomNavIconColor))
            if (mOrderViewModel.readAllData.value?.isEmpty() == true) {
                recyclerView.visibility = View.INVISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                binding.womanClear.visibility = View.INVISIBLE
                binding.imageView4.visibility = View.INVISIBLE
                binding.imageView3.visibility = View.INVISIBLE
                binding.textView2.visibility = View.INVISIBLE
                binding.imageView3.visibility = View.INVISIBLE
                binding.imageView5.visibility = View.INVISIBLE
                binding.textView4.visibility = View.INVISIBLE
                binding.rectBuy.visibility = View.INVISIBLE
                binding.purchaiseTv.visibility = View.INVISIBLE
                binding.imageView7.visibility = View.INVISIBLE
                binding.textView3.visibility = View.INVISIBLE
            }
        }
        binding.completedBtn.setOnClickListener {
            recyclerView.visibility = View.INVISIBLE
            binding.womanClear.visibility = View.VISIBLE
            binding.imageView4.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.textView2.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.imageView5.visibility = View.VISIBLE
            binding.textView4.visibility = View.VISIBLE
            binding.rectBuy.visibility = View.VISIBLE
            binding.purchaiseTv.visibility = View.VISIBLE
            binding.imageView7.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.completedBtn.setTextColor(resources.getColor(R.color.activeBottomNavIconColor))
            binding.actualBtn.setTextColor(resources.getColor(R.color.InactiveBottomNavIconColor))

        }


    }
}