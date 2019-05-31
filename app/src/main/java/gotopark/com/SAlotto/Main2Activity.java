package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.icu.text.StringPrepParseException;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import gotopark.com.SAlotto.database.DatabaseHelper;
import gotopark.com.SAlotto.database.model.Note;
import gotopark.com.SAlotto.module.ArrCom;
import gotopark.com.SAlotto.utils.MyDividerItemDecoration;
import gotopark.com.SAlotto.utils.RecyclerTouchListener;

public class Main2Activity extends AppCompatActivity {
    private NotesAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private TextView noNotesView;

    private DatabaseHelper db;

    int tak, tok, trash;
    SoundPool soundpool;

    private ArrCom arrcom;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(this, R.raw.short_click2, 1);
        tok = soundpool.load(this, R.raw.click1_rebert1, 1);
        trash = soundpool.load(this, R.raw.trashbin, 1);

        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        noNotesView = findViewById(R.id.empty_notes_view);
        Button btn1 = findViewById(R.id.btn_clear);

        TextView title = findViewById(R.id.saveTitle);

        title.setText(getString(R.string.app_name) + " Save Numbers List");

        Node node = new Node();

        arrcom = new ArrCom();

        db = new DatabaseHelper(this);

        btn1.setOnClickListener(fun_clear);


        notesList.addAll(db.getAllNotes());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNoteDialog(false, null, -1);
            }
        });

        mAdapter = new NotesAdapter(this, notesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        toggleEmptyNotes();

        /**
         * On long press on RecyclerView item, open alert dialog
         * with options to choose
         * Edit and Delete
         * */
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                soundpool.play(tok, 1, 1, 0, 0, 0);

                String[] ClickNum = new String[6];
                Note n = notesList.get(position);
                String results1 = "";
                String results2 = "";
                String results3 = "";
                String results4 = "";

                String Balltype = n.getBalltype();

                String mlotnum = n.getNote();
                mlotnum = mlotnum.replace(" ", "");
                ClickNum = mlotnum.split(",");

                Log.d("=====Lotto=======", Node.getLotto()[0]);
                Log.d("======Lotto======", Node.getLotto()[1]);
                Log.d("======Lotto======", Node.getLotto()[3]);
                Log.d("======Lotto======", Node.getLotto()[4]);
                Log.d("======Lotto======", Node.getLotto()[5]);
                Log.d("======Balltype======", Balltype);

                switch (Balltype) {

                    case "Daily Lotto":
                        results1 = arrcom.comp(ArrCom.concatenate(Node.getDaily_Lotto() , ClickNum));
                        updateNote2("Daily Lotto : "+ results1,position);

                        break;

                    case "Lotto/plus 1 2":
                        results1 = arrcom.comp(ArrCom.concatenate(Node.getLotto(), ClickNum));
                        results2 = arrcom.comp(ArrCom.concatenate(Node.getLotto_Pluse() , ClickNum));
                        results3 = arrcom.comp(ArrCom.concatenate(Node.getLotto_Pluse2(), ClickNum));

                        updateNote2("Lotto : "+ results1+"\n"+
                                "Lotto Plus : " + results2 +"\n" +
                                "Lotto Plus 2 : "+ results3,position);
                        break;


                    case "PowerBall/Plus":
                        String[] ball5 = new String[5];
                        String[] lastball = new String[1];

                        ball5[0] = ClickNum[0];
                        ball5[1] = ClickNum[1];
                        ball5[2] = ClickNum[2];
                        ball5[3] = ClickNum[3];
                        ball5[4] = ClickNum[4];
                        lastball[0] = ClickNum[5];

                        results1 = arrcom.comp(ArrCom.concatenate(Node.getPowerBall_5Ball(), ball5));
                        results2 = arrcom.comp(ArrCom.concatenate(Node.getPowerBall_last(), lastball));

                        results3 = arrcom.comp(ArrCom.concatenate(Node.getPowerBall_Plus_5Ball(), ball5));
                        results4 = arrcom.comp(ArrCom.concatenate(Node.getPowerBall_Plus_last(), lastball));


                        updateNote2("Powerball : "+ results1+"+"+results2+"\n"+
                                        "Powerball Plus : "+ results3+"+"+results4,position);

                        break;
                }


                Toast.makeText(Main2Activity.this, getString(R.string.select_list), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                soundpool.play(tak, 1, 1, 0, 0, 0);

                showActionsDialog(position);
            }
        }));


        Admob_is();
    }


    public Button.OnClickListener fun_clear = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            soundpool.play(trash, 1, 1, 0, 0, 1);
            for (int i = 0; i < db.getNotesCount(); i++) {
                soundpool.play(trash, 1, 1, 0, 0, 1);
                deleteNote(i);
            }
        }
    };


    /**
     * Updating note in db and updating
     * item in the list by its position
     */
    private void updateNote(String note, int position) {
        Note n = notesList.get(position);
        // updating note text
        n.setNote(note);

        // updating note in db
        db.updateNote(n);

        // refreshing the list
        notesList.set(position, n);
        mAdapter.notifyItemChanged(position);

        toggleEmptyNotes();
    }

    private void updateNote2(String string, int position) {
        Note n = notesList.get(position);

        // updating note text
        n.setAlot(string);

        // updating note in db
        db.updateData(n);

        // refreshing the list
        notesList.set(position, n);
        mAdapter.notifyItemChanged(position);

        toggleEmptyNotes();
    }


    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
    private void deleteNote(int position) {
        // deleting the note from db
        db.deleteNote(notesList.get(position));

        // removing the note from the list
        notesList.remove(position);
        mAdapter.notifyItemRemoved(position);

        toggleEmptyNotes();
    }

    /**
     * Opens dialog with Edit - Delete options
     * Edit - 0
     * Delete - 0
     */
    private void showActionsDialog(final int position) {
//        CharSequence[] colors = new CharSequence[]{"Edit", "Delete"};
        CharSequence[] colors = new CharSequence[]{"Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 정말로 삭제 하시 겠습니까.
        builder.setTitle(getString(R.string.delete_list));
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 1) {
                    showNoteDialog(true, notesList.get(position), position);
                } else {

                    soundpool.play(tok, 1, 1, 0, 0, 0);

                    deleteNote(position);
                }
            }
        });
        builder.show();
    }


    /**
     * Shows alert dialog with EditText options to enter / edit
     * a note.
     * when shouldUpdate=true, it automatically displays old note and changes the
     * button text to UPDATE
     */
    private void showNoteDialog(final boolean shouldUpdate, final Note note, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.note_dialog, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(Main2Activity.this);
        alertDialogBuilderUserInput.setView(view);

        final EditText inputNote = view.findViewById(R.id.note);
        TextView dialogTitle = view.findViewById(R.id.dialog_title);
//        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_note_title) : getString(R.string.lbl_edit_note_title));

        if (shouldUpdate && note != null) {
            inputNote.setText(note.getNote());
        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when no text is entered
                if (TextUtils.isEmpty(inputNote.getText().toString())) {
                    Toast.makeText(Main2Activity.this, "Enter note!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                // check if user updating note
                if (shouldUpdate && note != null) {
                    // update note by it's id
                    updateNote(inputNote.getText().toString(), position);
                } else {
                    // create new note


                }
            }
        });
    }

    /**
     * Toggling list and empty notes view
     */
    private void toggleEmptyNotes() {
        // you can check notesList.size() > 0

        if (db.getNotesCount() > 0) {
            noNotesView.setVisibility(View.GONE);
        } else {
            noNotesView.setVisibility(View.VISIBLE);
        }
    }

    public void Admob_is() {

        AdView mAdView = findViewById(R.id.adView);
        MobileAds.initialize(getApplicationContext(), getString(R.string.google_adsene_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}
