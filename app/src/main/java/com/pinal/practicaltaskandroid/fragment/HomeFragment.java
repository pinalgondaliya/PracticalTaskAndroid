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
import com.pinal.practicaltaskandroid.MainActivity;
import com.pinal.practicaltaskandroid.Model.Design;
import com.pinal.practicaltaskandroid.Model.RangePattern;
import com.pinal.practicaltaskandroid.Model.ShopByCategory;
import com.pinal.practicaltaskandroid.Model.ShopByFabric;
import com.pinal.practicaltaskandroid.Model.StickyMenu;
import com.pinal.practicaltaskandroid.R;
import com.pinal.practicaltaskandroid.adapter.RecShoCatAdapter;
import com.pinal.practicaltaskandroid.adapter.RecShoDesignAdapter;
import com.pinal.practicaltaskandroid.adapter.RecShoFabAdapter;
import com.pinal.practicaltaskandroid.adapter.RecShoRangeAdapter;
import com.pinal.practicaltaskandroid.adapter.RecTop1Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recTop1,recShopCat,recShopCat2,recShopFab,recShopFab2,recrange1,recrange2,recdesign1,recdesign2;
    List<StickyMenu.Menu> menuList = new ArrayList<>();
    List<ShopByCategory> shopByCategories = new ArrayList<>();
    private String Url="https://app-interview.easyglue.in/top_repository.json";
    private String shopUrl="https://app-interview.easyglue.in/middle_repository.json";
    private List<ShopByFabric> shopByfabric = new ArrayList<>();
    private List<RangePattern> shopByRange = new ArrayList<>();
    private List<RangePattern> shopByRange2 = new ArrayList<>();
    private String rangeUrl="https://app-interview.easyglue.in/bottom_repository.json";
    private List<Design> designlist = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view =  inflater.inflate(R.layout.activity_main, container, false);
        recTop1  = view.findViewById(R.id.recTop1);
        recShopCat  = view.findViewById(R.id.recShopCat);
        recShopCat2  = view.findViewById(R.id.recShopCat2);
        recShopFab  = view.findViewById(R.id.recShopFab);
        recShopFab2  = view.findViewById(R.id.recShopFab2);
        recrange1  = view.findViewById(R.id.recrange1);
        recrange2  = view.findViewById(R.id.recrange2);
        recdesign1  = view.findViewById(R.id.recdesign1);

        getStickyMenuData();
        getShopByCategory();
        getShopByFabric();
        getRangePAttern();
        getDeasign();

        return view;
    }


    public void getStickyMenuData() {
        menuList = new ArrayList<>();
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, Url, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray optJSONArray = obj.getJSONArray("main_sticky_menu");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);
                        StickyMenu.Menu dataList = new StickyMenu.Menu();
                        dataList.title = jsonObject.getString("title");
                        dataList.image = jsonObject.getString("image");
                        dataList.sort_order = jsonObject.getString("sort_order");
                        dataList.slider_images = new ArrayList();
                        JSONArray arraylist = jsonObject.getJSONArray("slider_images");
                        for (int j = 0; j < arraylist.length(); j++) {
                            StickyMenu.SliderImage sublist = new StickyMenu.SliderImage();
                            JSONObject jsonObjectsub = arraylist.getJSONObject(j);
                            sublist.title = jsonObjectsub.getString("title");
                            sublist.image =jsonObjectsub.getString("image");
//                            dataList.stickers.add(sublist);
                        }
                        menuList.add(dataList);
                    }
                    setRectViews();
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public void getShopByCategory() {
        menuList = new ArrayList<>();
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, shopUrl, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray optJSONArray = obj.getJSONArray("shop_by_category");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);
                        ShopByCategory dataList = new ShopByCategory();
                        dataList.name = jsonObject.getString("name");
                        dataList.image = jsonObject.getString("image");
                        dataList.sort_order = jsonObject.getString("sort_order");
                        dataList.tint_color = jsonObject.getString("tint_color");
                        shopByCategories.add(dataList);
                    }
                    List<ShopByCategory> filteredList = new ArrayList<>();
                    for (ShopByCategory menu : shopByCategories) {
                        if (Integer.parseInt(menu.getSort_order()) <= 3) {
                            filteredList.add(menu);
                        }
                    }

                    // Sort the filtered list
                    Collections.sort(filteredList, new Comparator<ShopByCategory>() {
                        @Override
                        public int compare(ShopByCategory menu1, ShopByCategory menu2) {
                            return Integer.compare(Integer.parseInt(menu1.getSort_order()), Integer.parseInt(menu2.getSort_order()));
                        }
                    });
                    RecShoCatAdapter recTop1Adapter = new RecShoCatAdapter(getActivity(),filteredList,3);
                    recShopCat.setAdapter(recTop1Adapter);

                    List<ShopByCategory> filteredList1 = new ArrayList<>();
                    for (ShopByCategory menu : shopByCategories) {
                        if (Integer.parseInt(menu.getSort_order()) > 3) {
                            filteredList1.add(menu);
                        }
                    }

                    Collections.sort(filteredList1, new Comparator<ShopByCategory>() {
                        @Override
                        public int compare(ShopByCategory menu1, ShopByCategory menu2) {
                            return Integer.compare(Integer.parseInt(menu1.getSort_order()), Integer.parseInt(menu2.getSort_order()));
                        }
                    });

                    RecShoCatAdapter recTop2Adapter = new RecShoCatAdapter(getActivity(),filteredList,3);
                    recShopCat2.setAdapter(recTop2Adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public void getShopByFabric() {
        shopByfabric = new ArrayList<>();
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, shopUrl, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray optJSONArray = obj.getJSONArray("shop_by_fabric");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);
                        ShopByFabric dataList = new ShopByFabric();
                        dataList.fabric_id = jsonObject.getString("fabric_id");
                        dataList.name = jsonObject.getString("name");
                        dataList.image = jsonObject.getString("image");
                        dataList.sort_order = jsonObject.getString("sort_order");
                        dataList.tint_color = jsonObject.getString("tint_color");
                        shopByfabric.add(dataList);
                    }

                    List<ShopByFabric> filteredList = new ArrayList<>();
                    for (ShopByFabric menu : shopByfabric) {
                        if (Integer.parseInt(menu.getFabric_id()) <= 3) {
                            filteredList.add(menu);
                        }
                    }

                    Collections.sort(filteredList, new Comparator<ShopByFabric>() {
                        @Override
                        public int compare(ShopByFabric menu1, ShopByFabric menu2) {
                            return Integer.compare(Integer.parseInt(menu1.getSort_order()), Integer.parseInt(menu2.getSort_order()));
                        }
                    });
                    RecShoFabAdapter recTop1Adapter = new RecShoFabAdapter(getActivity(),filteredList,3);
                    recShopFab.setAdapter(recTop1Adapter);

                    List<ShopByFabric> filteredList1 = new ArrayList<>();
                    for (ShopByFabric menu : shopByfabric) {
                        if (Integer.parseInt(menu.getFabric_id()) > 3) {
                            filteredList1.add(menu);
                        }
                    }

                    Collections.sort(filteredList1, new Comparator<ShopByFabric>() {
                        @Override
                        public int compare(ShopByFabric menu1, ShopByFabric menu2) {
                            return Integer.compare(Integer.parseInt(menu1.getSort_order()), Integer.parseInt(menu2.getSort_order()));
                        }
                    });
                    RecShoFabAdapter recTop2Adapter = new RecShoFabAdapter(getActivity(),filteredList1,3);
                    recShopFab2.setAdapter(recTop2Adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public void getRangePAttern() {
        shopByRange = new ArrayList<>();
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, rangeUrl, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray optJSONArray = obj.getJSONArray("range_of_pattern");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);
                        RangePattern dataList = new RangePattern();
                        dataList.product_id = jsonObject.getString("product_id");
                        dataList.name = jsonObject.getString("name");
                        dataList.image = jsonObject.getString("image");
                        if (i <= 5) {
                            shopByRange.add(dataList);
                        }else if (i > 5){
                            shopByRange2.add(dataList);
                        }
                    }

                    RecShoRangeAdapter recTop1Adapter = new RecShoRangeAdapter(getActivity(),shopByRange,3);
                    recrange1.setAdapter(recTop1Adapter);

                    RecShoRangeAdapter recTop2Adapter = new RecShoRangeAdapter(getActivity(),shopByRange2,3);
                    recrange2.setAdapter(recTop2Adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("sss", "onResponse: "+e.getMessage() );
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

    public void getDeasign() {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest MyStringRequest = new StringRequest(1, rangeUrl, new Response.Listener<String>() { // from class: com.example.photoareditor.Activity.EditorActivity.57
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray optJSONArray = obj.getJSONArray("design_occasion");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jsonObject = optJSONArray.getJSONObject(i);
                        Design dataList = new Design();
                        dataList.product_id = jsonObject.getString("product_id");
                        dataList.name = jsonObject.getString("name");
                        dataList.image = jsonObject.getString("image");
                        dataList.sub_name = jsonObject.getString("sub_name");
                        dataList.cta = jsonObject.getString("cta");
                        designlist.add(dataList);
                    }
                    RecShoDesignAdapter recTop1Adapter = new RecShoDesignAdapter(getActivity(),designlist,3);
                    recdesign1.setAdapter(recTop1Adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
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



    private void setRectViews() {
        Collections.sort(menuList, new Comparator<StickyMenu.Menu>() {
            @Override
            public int compare(StickyMenu.Menu menu1, StickyMenu.Menu menu2) {
                return Integer.compare(Integer.parseInt(menu1.getSortOrder()), Integer.parseInt(menu2.getSortOrder()));
            }
        });
        RecTop1Adapter recTop1Adapter = new RecTop1Adapter(getActivity(), this.menuList);
        recTop1.setAdapter(recTop1Adapter);
    }
}