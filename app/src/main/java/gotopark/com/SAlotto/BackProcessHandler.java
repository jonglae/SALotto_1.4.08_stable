package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import gun0912.ted.tedadmobdialog.TedAdmobDialog;
import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;
import hotchemi.android.rate.StoreType;

import static android.app.PendingIntent.getActivity;


class BackProcessHandler {


//    private Toast toast;

    @SuppressLint("StaticFieldLeak")
    private static MainActivity activity;
    private static InterstitialAd mInterstitialAd;

    BackProcessHandler(Activity context) {
        activity = (MainActivity) context;
    }

    static void onBackPressed() {

        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(activity.getString(R.string.scr_EXIT_Mesg1))
                .setCancelable(true)
                .setPositiveButton(activity.getString(R.string.scr_EXIT_Mesg2), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        new TedAdmobDialog.Builder(activity, TedAdmobDialog.AdType.BANNER, activity.getString(R.string.banner_ad_unit_id1))
                                .setAdListener(new AdListener() {


                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();


                                    }


                                })
                                .showReviewButton(true)
                                .create()
                                .show();

                    }


                })


                .setNegativeButton(activity.getString(R.string.scr_EXIT_Mesg3), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        AnRate();
                        dialog.cancel();
                        activity.finish();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    static void AnRate() {

        AppRate.with(activity)
                .setStoreType(StoreType.GOOGLEPLAY) //default is Google, other option is Amazon
                .setInstallDays(1) // default 10, 0 means install day.
                .setLaunchTimes(10) // default 10 times.
                .setRemindInterval(2) // default 1 day.
                .setShowLaterButton(true) // default true.
                .setDebug(false) // default false.
                .setCancelable(false) // default false.
                .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
                    @Override
                    public void onClickButton(int which) {
                        Log.d(MainActivity.class.getName(), Integer.toString(which));
                    }
                }).monitor();

        AppRate.showRateDialogIfMeetsConditions(activity);
    }

    //
//     static void Admob_Front() {
//        Log.e("전면_Front_TEST =====> ", "=======================> OK");
//        mInterstitialAd = new InterstitialAd(activity);
//        mInterstitialAd.setAdUnitId(activity.getString(R.string.interstitial_ad_unit_id));
//
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//
//        mInterstitialAd.loadAd(adRequest);
//
//
//    }
//
//    static void Show_front() {
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//
//        }
//    }



    static String frontSay() {

        Random rand = new Random();
        Resources res = activity.getResources();
        String[] sayword = res.getStringArray(R.array.FrontItems);

        int wrdMax = sayword.length;
        int i = rand.nextInt(wrdMax);

        Log.e("=========", Arrays.toString(sayword));

        return sayword[i];
    }
}