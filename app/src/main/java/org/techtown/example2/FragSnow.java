package org.techtown.example2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragSnow extends Fragment {
    private View view;
    public static FragSnow newInstance(){
        FragSnow fragSnow = new FragSnow();
        return fragSnow;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_snow,container,false);
        return view;
    }
}
