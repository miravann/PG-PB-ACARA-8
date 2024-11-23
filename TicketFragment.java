package com.example.concertticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.example.concertticket.databinding.FragmentTicketBinding;

public class TicketFragment extends Fragment {

    private FragmentTicketBinding binding;
    private boolean ticketPurchased = false;

    public TicketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout using View Binding
        binding = FragmentTicketBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting Buy Ticket button action
        binding.buyTicketButton.setOnClickListener(v -> {
            if (ticketPurchased) {
                // Display a Toast message if already purchased
                Toast.makeText(requireContext(), "Ticket has already been purchased", Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to OrderFragment
                NavDirections action = TicketFragmentDirections.actionTicketFragmentToOrderFragment();
                NavHostFragment.findNavController(TicketFragment.this).navigate(action);
            }
        });

        // Set ticket image and text
        binding.ticketImage.setImageResource(R.drawable.gambartiket);
        binding.orderTicketText.setText("Order Ticket");
    }

    public void onTicketOrdered() {
        // Set ticketPurchased to true after ordering
        ticketPurchased = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
    }
}
