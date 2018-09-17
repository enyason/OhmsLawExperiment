package com.nexdev.enyason.ohmslawexperiment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by enyason on 9/16/18.
 */

public class FragmentOhmsLawExperiment  extends Fragment{


    CanvasOhmsLaw canvasOhmsLaw;


    TextView tvResistance, tvVoltage,tvCurrent,tvResult;

    float valCurrent = 0, valVoltage = 0, valResistance = 1000;

    private float xPointGraph=100, yPointGraph=1100;


    ImageView imageView;



    ArrayList<Float> listVoltage = new ArrayList<Float>();
    ArrayList<Float> listCurrent = new ArrayList<Float>();

    RelativeLayout layout;


    public FragmentOhmsLawExperiment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.layout_ohms_law_experiment,container,false);
       return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    public void setUpAlertDialog(){


        View editTextView = LayoutInflater.from(getContext()).inflate(R.layout.alert_dialog_view,null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Change Voltage Value");

        builder.setView(editTextView);

        final EditText textVoltage = editTextView.findViewById(R.id.editText_voltage);
        textVoltage.setText("2");



        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {

                valVoltage = Float.parseFloat(textVoltage.getText().toString());
                float current = valVoltage/valResistance;

                if (valVoltage > 10) {
                    Toast.makeText(getContext(), "Voltage Entry Exceeded!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }




                if (listCurrent.isEmpty() && listVoltage.isEmpty()) {

                    listVoltage.add(valVoltage);
                    listCurrent.add(current);


//                    communicatorOhmsLaw.result(new OhmsLawResult(valVoltage+"",""+current));


                } else {

                    if (listVoltage.get(listVoltage.size() - 1) > valVoltage || (listVoltage.get(listVoltage.size()-1) == valVoltage)) {
                        Toast.makeText(getContext(), "Voltage Entry failed!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        return;
                    } else {

                        listVoltage.add(valVoltage);
                        listCurrent.add(current);
//                        communicatorOhmsLaw.result(new OhmsLawResult(valVoltage+"",""+current));

                    }



                }


                tvVoltage.setText("V = " + valVoltage + "v");
                tvCurrent.setText("I = "+current+"A");

                yPointGraph = 1100 - (50 * valVoltage);
                xPointGraph = 100 + (50000*current);

                int drawable;
                if (valVoltage > 0) {
                    drawable = R.drawable.ic_ammeter_current;

                } else {
                    drawable = R.drawable.ic_ammeter;

                }


                canvasOhmsLaw.invalidateCanvas(getActivity(), drawable,xPointGraph,yPointGraph);

                Toast.makeText(getContext(),"Added to table",Toast.LENGTH_SHORT).show();

                dialog.dismiss();


            }
        }).show();


    }
}
