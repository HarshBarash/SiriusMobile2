package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentDataBinding


class DataFragment : Fragment(R.layout.fragment_data) {


    private lateinit var binding: FragmentDataBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDataBinding.bind(view)

        binding.btnNext.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

        binding.backAdress.setOnClickListener {
            findNavController().navigate(R.id.action_dataFragment_to_adressFragment)
        }

        val args: DataFragmentArgs by navArgs()
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderTime = args.orderTime.toInt()
        val orderPrice = args.orderPrice

        val titleR = ( if(room < 2) { " Комната" }
        else if (room >= 2 && room < 5) { " Комнаты" }
        else { " Комнат"})

        val titleS = ( if(toilet < 2) { " Санузел" }
        else if (toilet >= 2 && toilet < 5) { " Санузла" }
        else { " Санузлов"})

        val titleH = ( if(orderTime < 2) { " час" }
        else if (orderTime >= 2 && orderTime < 5 ) { " часa" }
        else { " часов"})

        binding.tvRoomToiletTimePriceAdress.text = (room.toString() + titleR + ", " + toilet.toString() + titleS + ", " + orderTime + titleH + ", " + orderPrice +  "₽")
    }

    private fun dataTransmission() {

        val args: DataFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = args.order
        val orderPrice = args.orderPrice
        val orderTime = args.orderTime
        val city = args.city
        val street = args.street
        val house = args.house
        val flat = args.flat
        val corpus = args.corpus
        val entrance = args.entrance
        val comment = args.comment
        val data = "3.11"
        val dataTime = "18:00"

        val action = DataFragmentDirections.actionDataFragmentToPayFragment(
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
            comment,
            data,
            dataTime
        )

        findNavController().navigate(action)
    }



}