package com.example.recyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurante;
    List<Restaurante> restauranteList;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters

    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria la esquina", "https://st.depositphotos.com/1764882/1275/i/600/depositphotos_12754938-stock-photo-italian-pizza.jpg",4.5f,"Jalapa"));
            restauranteList.add(new Restaurante("Pasteleria el buen gusto","https://t2.rg.ltmcdn.com/es/posts/2/4/9/pastel_de_fresa_23942_orig.jpg",4.0f,"Ciudad de Guatemala"));
            restauranteList.add(new Restaurante("Cafeteria coffe shopp", "https://muchosnegociosrentables.com/wp-content/uploads/2019/04/modelos-de-cafeterias.jpg",5.0f,"Sanarate"));
            restauranteList.add(new Restaurante("Restaurante Chino","https://okdiario.com/img/2021/03/10/recetas-chinas-655x368.jpg",4.9f,"Jalapa"));
            adapterRestaurante = new MyRestauranteRecyclerViewAdapter(context, restauranteList);
            recyclerView.setAdapter(adapterRestaurante);
        }
        return view;
    }
}