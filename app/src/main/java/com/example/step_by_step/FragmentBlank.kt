package com.example.step_by_step

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FragmentBlank : Fragment(R.layout.fragment_blank) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.fragmentBlank).text =
            arguments?.getInt(bundleParameter).toString()
    }

    companion object {
        val bundleParameter = "bundleParameter"
        fun newInstance(number: Int): FragmentBlank {
            val fragment = FragmentBlank()
            val bundle = Bundle()
            fragment.arguments = bundle
            bundle.putInt(bundleParameter, number)
            return fragment
        }
    }
}
