package com.pinal.practicaltaskandroid.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pinal.practicaltaskandroid.Model.CateGoryModel;
import com.pinal.practicaltaskandroid.Model.ShopByCategory;
import com.pinal.practicaltaskandroid.R;
import com.pinal.practicaltaskandroid.adapter.CategoryAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    String cat_url = "https://app-interview.easyglue.in/category_repository.json";
    private RecyclerView reccate;
    String bannerUrl;
    private ArrayList<CateGoryModel.Category> menuList = new ArrayList<>();
    private ArrayList<CateGoryModel.Child> childArrayList = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        reccate = view.findViewById(R.id.reccate);

        getShopByCategory();

        return view;
    }

    public void getShopByCategory() {
        menuList = new ArrayList<>();
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, cat_url, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
//                    CateGoryModel cateGoryModel = new CateGoryModel();
//                    cateGoryModel.banner_image = obj.getString("banner_image");
                    JSONArray optJSONArray = obj.getJSONArray("categories");

                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);

                        CateGoryModel.Category dataList = new CateGoryModel.Category();
                        dataList.category_name = jsonObject.getString("category_name");

                        dataList.child = new ArrayList<>();

                        JSONArray arraylist = jsonObject.getJSONArray("child");
                        for (int j = 0; j < arraylist.length(); j++) {
                            CateGoryModel.Child sublist = new CateGoryModel.Child();
                            JSONObject jsonObjectsub = arraylist.getJSONObject(j);
                            sublist.category_id = jsonObjectsub.getString("category_id");
                            sublist.category_name = jsonObjectsub.getString("category_name");
                            dataList.child.add(sublist);
                            childArrayList.add(sublist);
                        }
                        menuList.add(dataList);
                    }
                    CategoryAdapter recTop2Adapter = new CategoryAdapter(getActivity(), menuList,childArrayList);
                    reccate.setAdapter(recTop2Adapter);

                    Log.e("sssssss", "onResponse: "+String.valueOf(menuList.size()));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("ssss", "onResponse: "+e.getMessage() );
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Please Check Your Internet Connection...", Toast.LENGTH_SHORT).show();
            }
        });
        MyRequestQueue.add(MyStringRequest);
    }


}