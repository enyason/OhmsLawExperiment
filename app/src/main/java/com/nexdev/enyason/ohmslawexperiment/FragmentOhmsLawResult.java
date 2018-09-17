package com.nexdev.enyason.ohmslawexperiment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enyason on 9/16/18.
 */

public class FragmentOhmsLawResult extends Fragment {


    List<OhmsLawResult> ohmsLawResults;
    static OhmsLawArrayAdapter arrayAdapter;

    ListView listView;

    public FragmentOhmsLawResult() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ohmsLawResults = new ArrayList<>();
        View view = inflater.inflate(R.layout.layout_ohms_law_result, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayAdapter = new OhmsLawArrayAdapter(getContext(),ohmsLawResults);

        listView = view.findViewById(R.id.list_ohms_law_result);

        listView.setAdapter(arrayAdapter);
    }

    public  static void updateTableInfo(OhmsLawResult result){
        arrayAdapter.add(result);
        arrayAdapter.notifyDataSetChanged();


    }


}
