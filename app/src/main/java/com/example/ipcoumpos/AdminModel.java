package com.example.ipcoumpos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ipcoumpos.Adapter.setAdminAdpter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminModel extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vv=inflater.inflate(R.layout.activity_admin_model,null,false);


        RecyclerView rr=vv.findViewById(R.id.Admin_recycler);
        rr.setLayoutManager(new LinearLayoutManager(getActivity()));
        String json=getActivity().getIntent().getStringExtra("js");
        ArrayList<String>admintext=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray("["+json+"]");
            JSONObject jsn=(JSONObject) jsonArray.get(0);
            JSONArray jsarray=jsn.getJSONArray("privileges");
            for (int i=0;i<jsarray.length();i++) {

                JSONObject jsonObject = (JSONObject) jsarray.get(i);
                admintext.add(jsonObject.getString("privilegeName").toString());
            }

            setAdminAdpter ss=new setAdminAdpter(getActivity(),admintext);
            rr.setAdapter(ss);
        } catch (JSONException e) {
            e.printStackTrace();
            Toasty(getContext(),e.toString());
        }

        return vv;

    }

    public void Toasty(Context cc,String msg){
        Toast.makeText(cc, ""+msg, Toast.LENGTH_SHORT).show();
    }
}