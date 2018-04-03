package ir.esam.esamlibrary.chipsList.categoryChipsList;

import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.R;
import ir.esam.esamlibrary.chipsList.ChipsListAdapter;
import ir.esam.esamlibrary.chipsList.ChipsListItem;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class CategoryChipsListAdapter extends ChipsListAdapter<CategoryChipsListAdapter.ViewHolder,
        CategoryChipsListItem> {

    @Override
    public int getLayout(int viewType) {
        return R.layout.category_chips_list_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, CategoryChipsListItem dataSet,
                                 int viewType) {
        holder.txtTitle.setText(dataSet.getTitle());
        holder.imgProductImage.setImageDrawable(dataSet.getImage());
    }

    @Override
    public ViewHolder onCreateViewHolder(View rootView, int viewType) {
        return new ViewHolder(rootView);
    }



    public class ViewHolder extends ChipsListViewHolder {

        EsTextView txtTitle;
        CircleImageView imgProductImage;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imgProductImage = itemView.findViewById(R.id.img_category_image);
        }
    }

    public class ChipsListViewHolder extends ChipsListAdapter.ViewHolder implements View.OnClickListener{

        public ChipsListViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }
    }

}
