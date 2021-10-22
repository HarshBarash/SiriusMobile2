package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentAdditionallyBinding


class AdditionallyFragment : Fragment(R.layout.fragment_additionally) {


    private lateinit var binding: FragmentAdditionallyBinding
    var additionallyPrice:Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdditionallyBinding.bind(view)


        val args: RoomFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet

        binding.btnonadress.setOnClickListener {

            val WashDishes = binding.cbWashDishes.isChecked
            val WashMicrowave = binding.cbWashMicrowave.isChecked
            val CleaningOfCloathes = binding.cbCleaningOfCloathes.isChecked
            val WashBath = binding.cbWashBath.isChecked
            val RemoveScale = binding.cbRemoveScale.isChecked
            val WashPetTray = binding.cbWashPetTray.isChecked
            val CleaningWool = binding.cbCleaningWool.isChecked
            val Removesomething = binding.cbRemovesomething.isChecked
            val Cleaning = binding.cbCleaning.isChecked

            //когда-то мне станет стыдно, а времени будет много todo
            val order = ( if(WashDishes)  "Помыть плиту" else "" ) +
                    ( if(WashMicrowave) "Помыть внутри микроволновки" else "") +
                    ( if(CleaningOfCloathes) "Химчистка одежды" else "") +
                    ( if(WashBath) "Помыть ванну" else "") +
                    ( if(RemoveScale) "Убрать накипь" else "") +
                    ( if(WashPetTray) "Мытье лотка питомца" else "") +
                    ( if(CleaningWool) "Очистка от шерсти" else "") +
                    ( if(Removesomething) "Убрать что-то ещё" else "") +
                    ( if(Cleaning) "Химчистка одежды" else "")

            val orderPrice = ( if(WashDishes)  320 else 0 ) +
                    ( if(WashMicrowave) 120 else 0 ) +
                    ( if(CleaningOfCloathes) 320 else 0) +
                    ( if(WashBath) 320 else 0) +
                    ( if(RemoveScale) 800 else 0) +
                    ( if(WashPetTray) 320 else 0) +
                    ( if(CleaningWool) 120 else 0) +
                    ( if(Removesomething) 320 else 0) +
                    ( if(Cleaning) 500 else 0)

            val orderTime = (( if(WashDishes)  20 else 0 ) +
                    ( if(WashMicrowave) 20 else 0 ) +
                    ( if(CleaningOfCloathes) 20 else 0) +
                    ( if(WashBath) 15 else 0) +
                    ( if(RemoveScale) 30 else 0) +
                    ( if(WashPetTray) 10 else 0) +
                    ( if(CleaningWool) 10 else 0) +
                    ( if(Removesomething) 10 else 0) +
                    ( if(Cleaning) 20 else 0) /60)

            binding.debugbro.text = order
            binding.debugbro2.text = orderPrice.toString()
            binding.debugbro3.text = (orderTime + roomandtoilet).toString()

            dataTransmission()
        }
    }

        private fun dataTransmission() {

        val args: RoomFragmentArgs by navArgs()
        val roomandtoilet = args.roomandtoilet
        val price = args.price
        val room = args.room
        val toilet = args.toilet
        val order = binding.debugbro.text.toString()
        val orderPrice = binding.debugbro2.text.toString()
        val orderTime = binding.debugbro3.text.toString()



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