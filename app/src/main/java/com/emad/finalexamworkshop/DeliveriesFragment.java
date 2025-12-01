package com.emad.finalexamworkshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emad.finalexamworkshop.databinding.FragmentDashboardBinding;
import com.emad.finalexamworkshop.databinding.FragmentDeliveriesBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeliveriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveriesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeliveriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeliveriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeliveriesFragment newInstance(String param1, String param2) {
        DeliveriesFragment fragment = new DeliveriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentDeliveriesBinding binding = FragmentDeliveriesBinding.inflate(inflater,container,false);

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Pending");
        categories.add("In Progress");
        categories.add("Completed");


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(CategoryFragment.newInstance("Pending"));
        fragments.add(CategoryFragment.newInstance("In Progress"));
        fragments.add(CategoryFragment.newInstance("Completed"));

        binding.categoryVp.setAdapter(new CategoryAdapter(requireActivity(), fragments));

        new TabLayoutMediator(binding.categoryTl, binding.categoryVp, (tab, position) -> {
            tab.setText(categories.get(position));
        }).attach();

        return binding.getRoot();
    }
}