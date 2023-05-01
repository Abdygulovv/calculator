package com.example.calculator_.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator_.R;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {
    private MaterialButton btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn = requireActivity().findViewById(R.id.btn_CSV);
        btn.setOnClickListener(view1 -> {
            getActivity().finishAffinity();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}