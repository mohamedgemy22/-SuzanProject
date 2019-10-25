package com.enggemy22.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SociaFragment extends BottomSheetDialogFragment implements View.OnClickListener {
View view;
private ImageView mimageFacebook;
    private ImageView mimageLocation;
    private ImageView mimageInstgram;
    private ImageView mimagewhatsApp;
    private TextView mtextFacebook;
    private TextView mtextLocation;
    private TextView mtextInsgram;
    private TextView mtextWhatsApp;
    public SociaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_socia, container, false);
        intiate();
        return view;
    }

    private void intiate() {
        mimageFacebook= view.findViewById(R.id.facebook);
        mimageInstgram= view.findViewById(R.id.insgram);
        mimagewhatsApp=view.findViewById(R.id.whatsapp);
        mimageLocation= view.findViewById(R.id.location);
        mimageLocation.setOnClickListener(this);
        mimageFacebook.setOnClickListener(this);
        mimagewhatsApp.setOnClickListener(this);
        mimageInstgram.setOnClickListener(this);
        mtextFacebook= view.findViewById(R.id.facebookTexet);
        mtextLocation= view.findViewById(R.id.locationTexet);
        mtextInsgram= view.findViewById(R.id.insgramTexet);
        mtextWhatsApp= view.findViewById(R.id.whatsappTexet);
        mtextLocation.setOnClickListener(this);
        mtextFacebook.setOnClickListener(this);
        mtextInsgram.setOnClickListener(this);
        mtextWhatsApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.facebook:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100005013582297"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/mostafamohamed.kamel.98")));
                }
                break;
            case R.id.insgram:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.instagram.com/gemy7427/" + "gemy7427"));
                    intent.setPackage("com.instagram.android");
                    startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/gemy7427/" + "gemy7427")));
                }
                break;
            case R.id.whatsapp:
                String url = "https://api.whatsapp.com/send?phone="+"201016183525";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.location:
                Intent ilo= new Intent(getActivity().getApplicationContext(), SouzanLocation.class);
                startActivity(ilo);
                break;
            case R.id.facebookTexet:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100005013582297"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/mostafamohamed.kamel.98")));
                }
                break;
            case R.id.insgramTexet:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.instagram.com/gemy7427/" + "gemy7427"));
                    intent.setPackage("com.instagram.android");
                    startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/gemy7427/" + "gemy7427")));
                }
                break;
            case R.id.whatsappTexet:
                String url2 = "https://api.whatsapp.com/send?phone="+"201016183525";
                Intent iwh = new Intent(Intent.ACTION_VIEW);
                iwh.setData(Uri.parse(url2));
                startActivity(iwh);
                break;
            case R.id.locationTexet:
                Intent in= new Intent(getActivity().getApplicationContext(), SouzanLocation.class);
                startActivity(in);
                break;
        }

    }
}
