package gotopark.com.SAlotto.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gotopark.com.SAlotto.R;
import gotopark.com.SAlotto.module.numtoimg;

public class OneCardAdapter2 extends ArrayAdapter<Card> {
    private static final String TAG = "OneCardAdapter";
    private List<Card> cardList = new ArrayList<Card>();

    public OneCardAdapter2(@NonNull Context context, int resource) {
        super(context, resource);
    }


    static class CardViewHolder {

        TextView line1;
        TextView Rtext1;
        TextView Rtext2;
        TextView Rtext3;
        TextView Rtext4;
        TextView Rtext5;
        TextView Rtext6;

    }

    @Override
    public void add(Card object) {

        cardList.add(object);

        super.add(object);

    }

    @Override
    public int getCount() {

        return this.cardList.size();

    }

    @Override
    public Card getItem(int index) {

        return this.cardList.get(index);

    }

    @SuppressLint("WrongViewCast")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;

        String[] Lotnum = new String[6];
        String sLotnum;

        if (row == null) {

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            row = inflater.inflate(R.layout.tab1_lot_list, parent, false);
            viewHolder = new CardViewHolder();

            viewHolder.line1 = row.findViewById(R.id.line1);

            viewHolder.Rtext1 = row.findViewById(R.id.Rtext1);
            viewHolder.Rtext2 = row.findViewById(R.id.Rtext2);
            viewHolder.Rtext3 = row.findViewById(R.id.Rtext3);
            viewHolder.Rtext4 = row.findViewById(R.id.Rtext4);
            viewHolder.Rtext5 = row.findViewById(R.id.Rtext5);
            viewHolder.Rtext6 = row.findViewById(R.id.Rtext6);

            row.setTag(viewHolder);


        } else {


            viewHolder = (CardViewHolder) row.getTag();

        }

        Card card = getItem(position);

        assert card != null;
        sLotnum = card.getLine2().replace(" ", "");
        Log.e(TAG, "========sLotnum========>" + sLotnum);

        Lotnum = sLotnum.split(",");


        int select = card.getLine5();
//        Log.e(TAG,"================>"+ Arrays.toString(Lotnum));
//
        Log.e(TAG, "========select========>" + select);
//        Log.e(TAG,"========Lotnum========>"+Lotnum[1]);

        assert card != null;
        viewHolder.line1.setText(card.getLine1());

        switch (select) {
            case 1:

                viewHolder.Rtext1.setText(Lotnum[0]);
                viewHolder.Rtext2.setText(Lotnum[1]);
                viewHolder.Rtext3.setText(Lotnum[2]);
                viewHolder.Rtext4.setText(Lotnum[3]);
                viewHolder.Rtext5.setText(Lotnum[4]);

                viewHolder.Rtext1.setBackgroundResource(R.drawable.dailyball2);
                viewHolder.Rtext2.setBackgroundResource(R.drawable.dailyball2);
                viewHolder.Rtext3.setBackgroundResource(R.drawable.dailyball2);
                viewHolder.Rtext4.setBackgroundResource(R.drawable.dailyball2);
                viewHolder.Rtext5.setBackgroundResource(R.drawable.dailyball2);

                break;

            case 2:
                numtoimg NumtoI = new numtoimg();

                int dball1;
                int dball2;
                int dball3;
                int dball4;
                int dball5;
                int dball6;

                viewHolder.Rtext1.setText(Lotnum[0]);
                viewHolder.Rtext2.setText(Lotnum[1]);
                viewHolder.Rtext3.setText(Lotnum[2]);
                viewHolder.Rtext4.setText(Lotnum[3]);
                viewHolder.Rtext5.setText(Lotnum[4]);
                viewHolder.Rtext6.setText(Lotnum[5]);

                dball1 = Integer.parseInt(Lotnum[0]);
                dball2 = Integer.parseInt(Lotnum[1]);
                dball3 = Integer.parseInt(Lotnum[2]);
                dball4 = Integer.parseInt(Lotnum[3]);
                dball5 = Integer.parseInt(Lotnum[4]);
                dball6 = Integer.parseInt(Lotnum[5]);

                dball1 = NumtoI.Numimg(dball1);
                dball2 = NumtoI.Numimg(dball2);
                dball3 = NumtoI.Numimg(dball3);
                dball4 = NumtoI.Numimg(dball4);
                dball5 = NumtoI.Numimg(dball5);
                dball6 = NumtoI.Numimg(dball6);

                viewHolder.Rtext1.setBackgroundResource(dball1);
                viewHolder.Rtext2.setBackgroundResource(dball2);
                viewHolder.Rtext3.setBackgroundResource(dball3);
                viewHolder.Rtext4.setBackgroundResource(dball4);
                viewHolder.Rtext5.setBackgroundResource(dball5);
                viewHolder.Rtext6.setBackgroundResource(dball6);

                break;

            case 3:

                viewHolder.Rtext1.setText(Lotnum[0]);
                viewHolder.Rtext2.setText(Lotnum[1]);
                viewHolder.Rtext3.setText(Lotnum[2]);
                viewHolder.Rtext4.setText(Lotnum[3]);
                viewHolder.Rtext5.setText(Lotnum[4]);
                viewHolder.Rtext6.setText(Lotnum[5]);

                viewHolder.Rtext1.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext2.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext3.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext4.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext5.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext6.setBackgroundResource(R.drawable.pball2);

                break;
        }

        return row;

    }

}