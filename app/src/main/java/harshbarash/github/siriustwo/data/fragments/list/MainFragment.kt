package harshbarash.github.siriustwo.data.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

        private lateinit var binding: FragmentMainBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentMainBinding.bind(view)

            binding.btntoroom.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_roomFragment)
            }
        }
    }