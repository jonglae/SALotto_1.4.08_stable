package gotopark.com.SAlotto.listview;

import android.content.Context;
import android.graphics.Color;
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

public class OneCardArrayAdapter extends ArrayAdapter<Card> {
    private static final String TAG = "OneCardArrayAdapter";
    public List<Card> cardList = new ArrayList<Card>();

    public OneCardArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class CardViewHolder {

        TextView line1;
        TextView line2;
        TextView line3;
        TextView line4;
        TextView line5;
        TextView line6;


        TextView Rtext1;
        TextView Rtext2;
        TextView Rtext3;
        TextView Rtext4;
        TextView Rtext5;
        TextView Rtext6;
        TextView Rtext7;
        TextView textplus;


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
            row = inflater.inflate(R.layout.list_item_card1, parent, false);

            viewHolder = new CardViewHolder();

            viewHolder.line1 = row.findViewById(R.id.line1);
            viewHolder.line2 = row.findViewById(R.id.line2);
            viewHolder.line3 = row.findViewById(R.id.line3);
            viewHolder.line4 = row.findViewById(R.id.line4);
//            viewHolder.line5 = row.findViewById(R.id.line5);
            viewHolder.line6 = row.findViewById(R.id.line6);

            viewHolder.Rtext1 = row.findViewById(R.id.Rtext1);
            viewHolder.Rtext2 = row.findViewById(R.id.Rtext2);
            viewHolder.Rtext3 = row.findViewById(R.id.Rtext3);
            viewHolder.Rtext4 = row.findViewById(R.id.Rtext4);
            viewHolder.Rtext5 = row.findViewById(R.id.Rtext5);
            viewHolder.Rtext6 = row.findViewById(R.id.Rtext6);
            viewHolder.Rtext7 = row.findViewById(R.id.Rtext7);
            viewHolder.textplus = row.findViewById(R.id.text_plus);


            row.setTag(viewHolder);


        } else {


            viewHolder = (CardViewHolder) row.getTag();

        }

        Card card = getItem(position);
        assert card != null;
        sLotnum = card.getLine3().replace(" ", ",");
        Log.e(TAG, "========sLotnum========>" + sLotnum);

        Lotnum = sLotnum.split(",");


        int select = card.getLine5();


        assert card != null;
        viewHolder.line1.setText(card.getLine1());
        viewHolder.line1.setText(card.getLine1());
        viewHolder.line2.setText(card.getLine2());
        viewHolder.line3.setText(card.getLine3());
        viewHolder.line4.setText(card.getLine4());
//        viewHolder.line5.setText(card.getLine5());
        viewHolder.line6.setText(card.getLine6());

        switch (select) {
            //daily lotto
            case 1:

                viewHolder.Rtext1.setTextColor(Color.parseColor("#FFFFFF"));
                viewHolder.Rtext2.setTextColor(Color.parseColor("#FFFFFF"));
                viewHolder.Rtext3.setTextColor(Color.parseColor("#FFFFFF"));
                viewHolder.Rtext4.setTextColor(Color.parseColor("#FFFFFF"));
                viewHolder.Rtext5.setTextColor(Color.parseColor("#FFFFFF"));

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

                //lotto
            case 2:
                numtoimg NumtoI = new numtoimg();

                int dball1;
                int dball2;
                int dball3;
                int dball4;
                int dball5;
                int dball6;
                int dball7;

                viewHolder.Rtext6.setTextColor(Color.parseColor("#000000"));


                viewHolder.Rtext1.setText(Lotnum[0]);
                viewHolder.Rtext2.setText(Lotnum[1]);
                viewHolder.Rtext3.setText(Lotnum[2]);
                viewHolder.Rtext4.setText(Lotnum[3]);
                viewHolder.Rtext5.setText(Lotnum[4]);
                viewHolder.Rtext6.setText(Lotnum[5]);
                viewHolder.textplus.setText("+");
                viewHolder.Rtext7.setText(Lotnum[6]);

                dball1 = Integer.parseInt(Lotnum[0]);
                dball2 = Integer.parseInt(Lotnum[1]);
                dball3 = Integer.parseInt(Lotnum[2]);
                dball4 = Integer.parseInt(Lotnum[3]);
                dball5 = Integer.parseInt(Lotnum[4]);
                dball6 = Integer.parseInt(Lotnum[5]);
                dball7 = Integer.parseInt(Lotnum[6]);

                dball1 = NumtoI.Numimg(dball1);
                dball2 = NumtoI.Numimg(dball2);
                dball3 = NumtoI.Numimg(dball3);
                dball4 = NumtoI.Numimg(dball4);
                dball5 = NumtoI.Numimg(dball5);
                dball6 = NumtoI.Numimg(dball6);
                dball7 = NumtoI.Numimg(dball7);

                viewHolder.Rtext1.setBackgroundResource(dball1);
                viewHolder.Rtext2.setBackgroundResource(dball2);
                viewHolder.Rtext3.setBackgroundResource(dball3);
                viewHolder.Rtext4.setBackgroundResource(dball4);
                viewHolder.Rtext5.setBackgroundResource(dball5);
                viewHolder.Rtext6.setBackgroundResource(dball6);
                viewHolder.Rtext7.setBackgroundResource(dball7);

                viewHolder.Rtext6.setVisibility(View.VISIBLE);
                viewHolder.textplus.setVisibility(View.VISIBLE);
                break;

                //powerball
            case 3:
                viewHolder.Rtext6.setVisibility(View.GONE);
                viewHolder.textplus.setVisibility(View.GONE);


                viewHolder.Rtext1.setTextColor(Color.parseColor("#000000"));
                viewHolder.Rtext2.setTextColor(Color.parseColor("#000000"));
                viewHolder.Rtext3.setTextColor(Color.parseColor("#000000"));
                viewHolder.Rtext4.setTextColor(Color.parseColor("#000000"));
                viewHolder.Rtext5.setTextColor(Color.parseColor("#000000"));

                viewHolder.Rtext1.setText(Lotnum[0]);
                viewHolder.Rtext2.setText(Lotnum[1]);
                viewHolder.Rtext3.setText(Lotnum[2]);
                viewHolder.Rtext4.setText(Lotnum[3]);
                viewHolder.Rtext5.setText(Lotnum[4]);

//                viewHolder.Rtext6.setText("+");
                viewHolder.Rtext7.setText(Lotnum[5]);

                viewHolder.Rtext1.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext2.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext3.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext4.setBackgroundResource(R.drawable.pball1);
                viewHolder.Rtext5.setBackgroundResource(R.drawable.pball1);
//                viewHolder.Rtext6.setBackgroundResource(R.drawable.pball2);
                viewHolder.Rtext7.setBackgroundResource(R.drawable.pball2);

                break;


        }

        return row;

    }

}
