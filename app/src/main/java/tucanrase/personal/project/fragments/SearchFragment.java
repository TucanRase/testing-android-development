package tucanrase.personal.project.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tucanrase.personal.project.ActivityTest;
import tucanrase.personal.project.R;
import tucanrase.personal.project.SearchAdapter;
import tucanrase.personal.project.WeatherApi;
import tucanrase.personal.project.models.Search;

public class SearchFragment extends Fragment {
    RecyclerView searchRecycler;
    List<Search> searches = new ArrayList<>();
    SearchAdapter adapter;
    TextInputLayout tilSearch;
    CardView pbSearch;

    public SearchFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        pbSearch = view.findViewById(R.id.loadingHome);
        searchRecycler = view.findViewById(R.id.searchRecycler);
        searchRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SearchAdapter(getContext(), searches);
        searchRecycler.setAdapter(adapter);
        tilSearch = view.findViewById(R.id.tilSearch);

        adapter.setOnItemClickListener(new SearchAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Bundle bundle = new Bundle();
                bundle.putString("location", searches.get(position).getUrl());
                HomeFragment home = new HomeFragment();
                home.setArguments(bundle);
                ((ActivityTest) getActivity()).replaceFragment(home);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        tilSearch.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String location = tilSearch.getEditText().getText().toString().trim();
                if (s.length() != 0 && s.length() >= 3)
                    fetchSearch(location);
            }
        });

        return view;
    }

    void fetchSearch(String location) {
        pbSearch.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.weatherapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<List<Search>> call = weatherApi.getSearch("13084a48383d4912bce114058220303", location);
        call.enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
                if (response.isSuccessful()) {
                    searches.clear();
                    searches.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
        pbSearch.setVisibility(View.GONE);
    }
}