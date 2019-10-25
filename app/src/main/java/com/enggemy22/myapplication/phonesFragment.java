package com.enggemy22.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class phonesFragment extends Fragment implements View.OnClickListener {
View view;
    private LinearLayout mLayoutPhone1;
    private LinearLayout mLayoutPhone2;
    private LinearLayout mLayoutPhone3;

    public phonesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_phones, container, false);
        inite();
    return view;
    }

    private void inite() {
        mLayoutPhone1= view.findViewById(R.id.phone1);
        mLayoutPhone2= view.findViewById(R.id.Phone2);
        mLayoutPhone3= view.findViewById(R.id.Phone3);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phone1:
                ShowDailog();
            break;
            case R.id.Phone2:
                break;
            case R.id.Phone3:
                break;
        }
    }

    private void ShowDailog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity().getApplicationContext());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {"هل تريد ارسال رسالة","هل تريد اتصال هاتفي " };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: {
                                sendSms();
                                break;
                            }
                            case 1:{
                                makeCall();
                                break;
                            }
                        }
                    }
                });
        pictureDialog.show();
    }

    private void makeCall() {
    }

    private void sendSms() {
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(Uri.parse("smsto:12346556"));
        it.putExtra("sms_body", "Here you can set the SMS text to be sent");
        Intent intent=Intent.createChooser(it,"Send Sms USING");
        startActivity(intent);
    }
}
