package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


@SuppressLint("StaticFieldLeak")
public class Jsoup_Lotto extends AsyncTask<Void, Void, Void> {

    private Elements winperson3;
    private Elements winperson4;

    @Override
    public Void doInBackground(Void... params) {

//https 설정 ssl hanshare fail 적용 위한 code -->start
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @SuppressLint("TrustAllX509TrustManager")
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            assert sc != null;
            sc.init(null, trustAllCerts, new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//https 설정 ssl hanshare fail 적용 위한 code --> End

        String url = MainActivity.CONTEXT.getString(R.string.active_one);

        try {
            // Connect to the web site
            Document document = Jsoup.connect(url)
                    .timeout(0)
                    .get();

            if (document != null) {

                // Get the html document title

                winperson4 = document.select(MainActivity.CONTEXT.getString(R.string.jsoup_q1));
                winperson3 = document.select(MainActivity.CONTEXT.getString(R.string.jsoup_q4));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onPostExecute(Void result) {

        if (winperson4 != null) {

            Log.e("==============", "=========" + winperson4);


            String[] pbnum3 = new String[winperson3.size()];
            for (int i = 0; i < winperson3.size(); i++) {
                pbnum3[i] = winperson3.get(i).text();
            }

            /** 리스트 뷰 출력 출력 */
            Node.setWin_Result(pbnum3);

            Log.d("==========", "============>" + pbnum3[0]);
            Log.d("==========", "============>" + pbnum3[1]);
            Log.d("==========", "============>" + pbnum3[2]);
            Log.d("==========", "============>" + pbnum3[3]);
            Log.d("==========", "============>" + pbnum3[4]);

        }

    }
}
