package harshbarash.github.siriustwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.databinding.FragmentAdditionallyBinding
import harshbarash.github.siriustwo.databinding.FragmentAdressBinding


class AdressFragment : Fragment(R.layout.fragment_adress) {

    private lateinit var binding: FragmentAdressBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdressBinding.bind(view)

        binding.btnontime.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

    }

    private fun dataTransmission() {

        val args: AdressFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderPrice = args.orderPrice
        val orderTime = args.orderTime

        val action = AdditionallyFragmentDirections.actionAdditionallyFragmentToAdressFragment(
            roomandtoilet,
            price,
            room,
            toilet,
            order,
            orderPrice,
            orderTime
        )

        findNavController().navigate(action)
    }



}