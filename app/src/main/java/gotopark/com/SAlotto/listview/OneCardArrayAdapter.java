package gotopark.com.SAlotto.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gotopark.com.SAlotto.R;

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
//        TextView line5;
        TextView line6;

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
    public Card getItem(int index)
    {

        return this.cardList.get(index);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;

        if (row == null) {

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert inflater != null;
            row = inflater.inflate(R.layout.list_item_card1, parent, false);

            viewHolder = new CardViewHolder();

            viewHolder.line1 = row.findViewById(R.id.line1);
            viewHolder.line2 = row.findViewById(R.id.line2);
            viewHolder.line3 = row.findViewById(R.id.line3);
            viewHolder.line4 = row.findViewById(R.id.line4);
//            viewHolder.line5 = (TextView) row.findViewById(R.id.line5);
            viewHolder.line6 = row.findViewById(R.id.line6);


            row.setTag(viewHolder);


        } else {


            viewHolder = (CardViewHolder)row.getTag();

        }

        Card card = getItem(position);

        assert card != null;
        viewHolder.line1.setText(card.getLine1());
        viewHolder.line2.setText(card.getLine2());
        viewHolder.line3.setText(card.getLine3());
        viewHolder.line4.setText(card.getLine4());
//        viewHolder.line5.setText(card.getLine5());
        viewHolder.line6.setText(card.getLine6());

        return row;

    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {

        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);

    }
}
