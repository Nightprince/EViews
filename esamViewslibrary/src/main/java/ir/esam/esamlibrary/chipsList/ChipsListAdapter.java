package ir.esam.esamlibrary.chipsList;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import ir.esam.esamlibrary.EsAdapter;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public abstract class ChipsListAdapter<ViewHolder extends ChipsListAdapter.ViewHolder, DataSetType extends ChipsListItem>
        extends EsAdapter<ViewHolder, DataSetType> {

    private OnItemClickListener mOnItemClickListener;

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                int position = getLayoutPosition();
                mOnItemClickListener.onClick(view, getDataSets().get(position), position);
            }
        }
    }

    public interface OnItemClickListener {
        void onClick(View view, ChipsListItem item, int position);
    }

}
