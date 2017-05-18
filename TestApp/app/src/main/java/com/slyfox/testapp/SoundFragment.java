package com.slyfox.testapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class SoundFragment extends Fragment {

    private View myView;
    private CheckBox myButton;
    private MainListener mListener;


    public SoundFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainListener) {
            mListener = (MainListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.sound_fragment, container, false);
        myButton = (CheckBox)myView.findViewById(R.id.checkBox2);
        myButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                mixGrill();
                mListener.changeColor(0);
                mListener.changeColor2(1);
            }
        });
        return myView;
    }

    public void mixGrill(int num) {
        Log.d("t", String.valueOf(num));
        myView.findViewById(R.id.sound_layout).setBackgroundColor(num);
    }
}
