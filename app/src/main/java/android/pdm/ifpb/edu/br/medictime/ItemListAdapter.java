package android.pdm.ifpb.edu.br.medictime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luckschulze on 18/07/16.
 */
public class ItemListAdapter extends BaseAdapter {
    private List<Medicamento> lista;
    private Context context;

    public ItemListAdapter(List<Medicamento> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }
    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Medicamento med = this.lista.get(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.activity_item_list_layout, null);
        }else view = convertView;

        TextView tv = (TextView) view.findViewById(R.id.tvItemList);
        tv.setText(med.getNome());

        return view;
    }
    
}
