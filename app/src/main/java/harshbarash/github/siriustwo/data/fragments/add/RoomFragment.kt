package harshbarash.github.siriustwo.data.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import harshbarash.github.siriustwo.R
import harshbarash.github.siriustwo.databinding.FragmentRoomBinding

class RoomFragment : Fragment(R.layout.fragment_room) {

    private lateinit var binding: FragmentRoomBinding
    var textRoom:Int = 1
    var textToilet: Int = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoomBinding.bind(view)

        binding.btntoadditionaly.setOnClickListener {
            //переход дальше
            dataTransmission()
        }

        binding.rgRoom.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                binding.oneRoom.id -> textRoom = binding.oneRoom.text.toString().toInt()
                binding.twoRoom.id -> textRoom = binding.twoRoom.text.toString().toInt()
                binding.threeRoom.id -> textRoom = binding.threeRoom.text.toString().toInt()
                binding.fourRoom.id -> textRoom = binding.fourRoom.text.toString().toInt()
            }
            binding.tvtime.text = textRoom.toString()


            binding.rgToilet.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    binding.oneT.id -> textToilet = binding.oneT.text.toString().toInt()
                    binding.twoT.id -> textToilet = binding.twoT.text.toString().toInt()
                    binding.threeT.id -> textToilet = binding.threeT.text.toString().toInt()
                    binding.fourT.id -> textToilet = binding.fourT.text.toString().toInt()
                }
                binding.tvtime.text = (textRoom + textToilet).toString()

            }
        }
    }

    private fun dataTransmission() {

        val roomandtoilet = binding.tvtime.text.toString().toInt()

        val price = if (roomandtoilet < 3) {
            650
        } else {
            roomandtoilet*200
        }

        val room = textRoom
        val toilet = textToilet


        val action = RoomFragmentDirections.actionRoomFragmentToAdditionallyFragment(roomandtoilet, price, room, toilet)

        findNavController().navigate(action)

    }
    }

