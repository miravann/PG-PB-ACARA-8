package com.example.concertticket;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.concertticket.databinding.FragmentListBinding;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout using View Binding
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi data destinasi dan tipe tiket
        List<Disaster> disasterList = new ArrayList<>();
        disasterList.add(new Disaster("Yogyakarta", "First Class Ticket"));
        disasterList.add(new Disaster("Bali", "Business Class Ticket"));
        disasterList.add(new Disaster("Bandung", "Economy Class Ticket"));
        disasterList.add(new Disaster("Semarang", "Business Class Ticket"));
        disasterList.add(new Disaster("Bali", "First Class Ticket"));
        disasterList.add(new Disaster("Surabaya", "First Class Ticket"));
        disasterList.add(new Disaster("Jakarta", "First Class Ticket"));
        disasterList.add(new Disaster("Jakarta", "Economy Class Ticket"));
        disasterList.add(new Disaster("Bogor", "First Class Ticket"));
        disasterList.add(new Disaster("Bogor", "Business Class Ticket"));

        // Set up RecyclerView dengan adapter
        DisasterAdapter disasterAdapter = new DisasterAdapter(disasterList);
        binding.ticketlist.setAdapter(disasterAdapter);
        binding.ticketlist.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Hindari memory leaks
    }
}
