package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
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

        val city = binding.etCity.text.toString()
        val street = binding.etStreet.text.toString()
        val house = binding.etHome.text.toString()
        val flat = binding.etFlat.text.toString()
        val corpus = binding.etCorpus.text.toString()
        val entrance = binding.etEntrance.text.toString()
        val comment = binding.etComment.text.toString()

        val action = AdressFragmentDirections.actionAdressFragmentToDataFragment(
            roomandtoilet,
            price,
            room,
            toilet,
            order,
            orderPrice,
            orderTime,
            city,
            street,
            house,
            flat,
            corpus,
            entrance,
            comment
        )

        findNavController().navigate(action)
    }



}