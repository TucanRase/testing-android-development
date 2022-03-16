package tucanrase.personal.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tucanrase.personal.project.models.Search;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolderSearch> {

    List<Search> searches = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public SearchAdapter(Context context, List<Search> searches) {
        this.mInflater = LayoutInflater.from(context);
        this.searches = searches;
    }

    @Override
    public ViewHolderSearch onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_search_list, parent, false);
        return new ViewHolderSearch(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderSearch holder, int position) {
        holder.setValues(searches.get(position));
    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class ViewHolderSearch extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNameSearch, tvRegion, tvCountry, tvLat, tvLon;

        public ViewHolderSearch(View itemView) {
            super(itemView);
            tvNameSearch = itemView.findViewById(R.id.tvNameSearch);
            tvRegion = itemView.findViewById(R.id.tvRegion);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvLat = itemView.findViewById(R.id.tvLat);
            tvLon = itemView.findViewById(R.id.tvLon);
            itemView.setOnClickListener(this);
        }

        public void setValues(Search search) {
            tvNameSearch.setText(search.getName());
            tvRegion.setText(search.getRegion());
            tvCountry.setText(search.getCountry());
            tvLat.setText(String.valueOf(search.getLat()));
            tvLon.setText(String.valueOf(search.getLon()));
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    Search getItem(int id) {
        return searches.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
