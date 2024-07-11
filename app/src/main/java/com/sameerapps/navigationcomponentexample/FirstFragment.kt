package com.sameerapps.navigationcomponentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.sameerapps.navigationcomponentexample.models.User


class FirstFragment : Fragment() {
    lateinit var editFirstName: EditText
    lateinit var editLastName: EditText
    lateinit var btnSend: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       editFirstName = view.findViewById(R.id.editFirstName)
        editLastName = view.findViewById(R.id.editLastName)
        btnSend = view.findViewById(R.id.btnSend)
        btnSend.setOnClickListener{
            val user = User(editFirstName.text.toString(), editLastName.text.toString())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(user)
            findNavController().navigate(action)
        }
        view.findViewById<TextView>(R.id.textView).text = "${this.hashCode()}"
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}