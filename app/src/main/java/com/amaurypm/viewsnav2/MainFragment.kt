package com.amaurypm.viewsnav2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amaurypm.viewsnav2.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aquí es cuando ya está visible el fragment en pantalla
        binding.btnNext.setOnClickListener {

            //Navegamos al otro fragment
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.fcvMain,
                DataFragment.newInstance(
                    name = "Beatriz",
                    age = 20
                )
            ).addToBackStack(null).commit()

            /*Toast.makeText(
                requireContext(),
                "Clic en el botón",
                Toast.LENGTH_SHORT
            ).show()*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}