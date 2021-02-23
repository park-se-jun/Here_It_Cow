package org.techtown.example2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragNight extends Fragment {
    private View view;
    public static FragNight newInstance(){
        FragNight fragNight = new FragNight();
        return fragNight;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_night,container,false);
        return view;
    }
}
