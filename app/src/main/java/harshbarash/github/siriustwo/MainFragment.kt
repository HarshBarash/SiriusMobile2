package harshbarash.github.siriustwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import harshbarash.github.siriustwo.databinding.FragmentMainBinding
import harshbarash.github.siriustwo.databinding.FragmentOnBoarding2Binding


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