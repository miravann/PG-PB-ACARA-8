package com.example.concertticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.example.concertticket.databinding.FragmentOrderBinding;

public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using View Binding
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Populate Spinner with ticket types from resources
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.ticket_type_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.ticketOrderSpinner.setAdapter(adapter);

        // Set up the Buy Ticket button to navigate to TicketFragment
        binding.Btnorderticket.setOnClickListener(v -> {
            String selectedTicketType = binding.ticketOrderSpinner.getSelectedItem().toString();
            Toast.makeText(requireContext(), "Ticket Ordered: " + selectedTicketType, Toast.LENGTH_SHORT).show();

            // Navigate to TicketFragment
            NavDirections action = OrderFragmentDirections.actionOrderFragmentToTicketFragment();
            NavHostFragment.findNavController(OrderFragment.this).navigate(action);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
    }
}
