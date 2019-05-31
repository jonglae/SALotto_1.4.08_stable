package gotopark.com.SAlotto;

/**
 * Created by ravi on 20/02/18.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gotopark.com.SAlotto.database.model.Note;
import gotopark.com.SAlotto.module.numtoimg;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Note> notesList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView note;
        TextView BallType;
        TextView dot;
        TextView timestamp;
        TextView lstext1;
        TextView MAgroup;

        TextView Rtext1;
        TextView Rtext2;
        TextView Rtext3;
        TextView Rtext4;
        TextView Rtext5;
        TextView Rtext6;

        MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.note);
            dot = view.findViewById(R.id.dot);
            lstext1 = view.findViewById(R.id.lsttxt1);
            BallType = view.findViewById(R.id.Balltype);


            Rtext1 = view.findViewById(R.id.Rtext1);
            Rtext2 = view.findViewById(R.id.Rtext2);
            Rtext3 = view.findViewById(R.id.Rtext3);
            Rtext4 = view.findViewById(R.id.Rtext4);
            Rtext5 = view.findViewById(R.id.Rtext5);
            Rtext6 = view.findViewById(R.id.Rtext6);

            MAgroup = view.findViewById(R.id.MAgroup);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }


    NotesAdapter(Context context, List<Note> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.MAgroup.setTextColor(Color.parseColor("#42A02B"));

        String[] lotnum = note.getNote().split(",");

        String Ball = note.getBalltype();


        switch(Ball){

            case "Daily Lotto":

                holder.BallType.setText(note.getBalltype());

                holder.Rtext1.setText(lotnum[0]);
                holder.Rtext2.setText(lotnum[1]);
                holder.Rtext3.setText(lotnum[2]);
                holder.Rtext4.setText(lotnum[3]);
                holder.Rtext5.setText(lotnum[4]);


                holder.Rtext1.setBackgroundResource(R.drawable.dailyball2);
                holder.Rtext2.setBackgroundResource(R.drawable.dailyball2);
                holder.Rtext3.setBackgroundResource(R.drawable.dailyball2);
                holder.Rtext4.setBackgroundResource(R.drawable.dailyball2);
                holder.Rtext5.setBackgroundResource(R.drawable.dailyball2);


                break;

            case "Lotto/plus 1 2":
                numtoimg NumtoI = new numtoimg();


                int dball1;
                int dball2;
                int dball3;
                int dball4;
                int dball5;
                int dball6;

                holder.Rtext1.setText(lotnum[0]);
                holder.Rtext2.setText(lotnum[1]);
                holder.Rtext3.setText(lotnum[2]);
                holder.Rtext4.setText(lotnum[3]);
                holder.Rtext5.setText(lotnum[4]);
                holder.Rtext6.setText(lotnum[5]);


                dball1 = Integer.parseInt(lotnum[0]);
                dball2 = Integer.parseInt(lotnum[1]);
                dball3 = Integer.parseInt(lotnum[2]);
                dball4 = Integer.parseInt(lotnum[3]);
                dball5 = Integer.parseInt(lotnum[4]);
                dball6 = Integer.parseInt(lotnum[5]);

                dball1 = NumtoI.Numimg(dball1);
                dball2 = NumtoI.Numimg(dball2);
                dball3 = NumtoI.Numimg(dball3);
                dball4 = NumtoI.Numimg(dball4);
                dball5 = NumtoI.Numimg(dball5);
                dball6 = NumtoI.Numimg(dball6);

                holder.Rtext1.setBackgroundResource(dball1);
                holder.Rtext2.setBackgroundResource(dball2);
                holder.Rtext3.setBackgroundResource(dball3);
                holder.Rtext4.setBackgroundResource(dball4);
                holder.Rtext5.setBackgroundResource(dball5);
                holder.Rtext6.setBackgroundResource(dball6);

                break;
                
            case  "PowerBall/Plus":

                holder.Rtext1.setText(lotnum[0]);
                holder.Rtext2.setText(lotnum[1]);
                holder.Rtext3.setText(lotnum[2]);
                holder.Rtext4.setText(lotnum[3]);
                holder.Rtext5.setText(lotnum[4]);
                holder.Rtext6.setText(lotnum[5]);

                holder.Rtext1.setBackgroundResource(R.drawable.pball1);
                holder.Rtext2.setBackgroundResource(R.drawable.pball1);
                holder.Rtext3.setBackgroundResource(R.drawable.pball1);
                holder.Rtext4.setBackgroundResource(R.drawable.pball1);
                holder.Rtext5.setBackgroundResource(R.drawable.pball1);
                holder.Rtext6.setBackgroundResource(R.drawable.pball2);


                break;
        }


//        holder.note.setText(note.getNote());
        holder.BallType.setText(note.getBalltype());

        holder.lstext1.setText(note.getAlot());
        holder.MAgroup.setText(note.getMagroup());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmtOut = new SimpleDateFormat("-- dd / MM (HH:mm) --");
            return fmtOut.format(date);
        } catch (ParseException ignored) {

        }

        return "";
    }
}
