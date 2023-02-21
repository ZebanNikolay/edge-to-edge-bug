package com.zebannikolay.edgetoedge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.zebannikolay.edgetoedge.databinding.FragmentSecondBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        // Add window insets listener to handle insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { root, insets ->
            // Update paddings or margins, and it invokes requestLayout()
            root.requestLayout()
            return@setOnApplyWindowInsetsListener insets
        }

        lifecycle.coroutineScope.launch {
            val mainContainer = requireActivity().findViewById<View>(android.R.id.content)
            val insetsControllerCompat = WindowInsetsControllerCompat(requireActivity().window, mainContainer)

            delay(500)
            // Change system bars behavior to show transient bars by swipe
            insetsControllerCompat.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

            delay(500)
            // Invoke show() to show system bars
            insetsControllerCompat.show(WindowInsetsCompat.Type.systemBars())
            // Change back system bars behavior to default
            insetsControllerCompat.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_DEFAULT

            // Show toast to notify that steps are done
            Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
