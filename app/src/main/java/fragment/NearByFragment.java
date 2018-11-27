package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.wolfsoft.propertyui_hotelsearch.R;

import java.util.ArrayList;

import adapter.RecycleAdapter_propertylist;
import model.Property;


/**
 * Created by Wolf Soft on 10/10/2017.
 */

public class NearByFragment extends Fragment {

    View view;

    private String address[]= {"Kalung,Yogykurta","Bantul,Yogykurta","Kalung,Yogykurta","Bantul,Yogykurta"};
    private String bed[]= {"3 bed","3 bed","2 bed","4 bed"};
    private String shower[]= {"3 bath","3 bath ","3 bath" ,"2 bath"};
    private String sqft[]= {"1400 sqft","2000 sqft","1500 sqft","2200 sqft"};
    private String price[]= {"$1,00,000","$1,00,000","$1,00,000","$1,00,000"};
    private int image[]= {R.drawable.buildingone,R.drawable.buidingtwo,R.drawable.buildingthree,R.drawable.outdoorgames};


    private ArrayList<Property> propertyArrayList;
    private RecyclerView recyclerView;
    private RecycleAdapter_propertylist mAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_neabyproperty, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_property);
        propertyArrayList = new ArrayList<>();



        for (int i = 0; i < address.length; i++) {
            Property beanClassForRecyclerView_contacts = new Property(address[i],price[i],bed[i],shower[i],sqft[i],image[i]);

            propertyArrayList.add(beanClassForRecyclerView_contacts);
        }


        mAdapter = new RecycleAdapter_propertylist(getActivity(),propertyArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

}
