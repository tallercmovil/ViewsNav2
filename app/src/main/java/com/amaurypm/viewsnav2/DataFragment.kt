package com.amaurypm.viewsnav2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amaurypm.viewsnav2.databinding.FragmentDataBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "name"
private const val ARG_AGE = "age"

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            age = it.getInt(ARG_AGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Ya con los datos recuperados desde el onCreate los usamos
        binding.tvData.text = "Nombre: $name, $age años"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, age: Int) =
            DataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putInt(ARG_AGE, age)
                }
            }
    }
}