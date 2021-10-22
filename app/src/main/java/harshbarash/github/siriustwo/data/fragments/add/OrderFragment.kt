package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentOrderBinding


class OrderFragment : Fragment(R.layout.fragment_order) {


    private lateinit var binding: FragmentOrderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)

        val args: OrderFragmentArgs by navArgs()
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
        val data = args.data
        val dataTime = args.dataTime


        binding.data1.text = roomandtoilet.toString()
        binding.data2.text = price.toString()
        binding.data3.text = room.toString()
        binding.data4.text = toilet.toString()
        binding.data5.text = order.toString()
        binding.data6.text = orderPrice.toString()
        binding.data7.text = orderTime.toString()
        binding.data8.text = city.toString()
        binding.data9.text = street.toString()
        binding.data10.text = house.toString()
        binding.data11.text = flat.toString()
        binding.data12.text = corpus.toString()
        binding.data13.text = entrance.toString()
        binding.data14.text = comment.toString()
        binding.data15.text = data.toString()
        binding.data16.text = dataTime.toString()


        binding.data16.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

    }

    private fun dataTransmission() {

        val args: OrderFragmentArgs by navArgs()
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
        val data = args.data
        val dataTime = args.dataTime



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