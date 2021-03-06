package study.pmoreira.bitsandpizzas;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_top, container, false);

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(Pizza.getPizzaNames(), Pizza.getPizzaImages());

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        RecyclerView pizzaRecycler = (RecyclerView) layout.findViewById(R.id.pizza_recycler);
        pizzaRecycler.setAdapter(adapter);
        pizzaRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return layout;
    }

}
