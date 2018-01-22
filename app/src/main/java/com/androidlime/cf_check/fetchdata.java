package com.androidlime.cf_check;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.androidlime.cf_check.MainActivity.mEdit;


/**
 * Created by awan-ur-rahman on 1/20/2018.
 */

public class fetchdata extends AsyncTask<Void,Void,Void> {
    String data1="";
    String dataParsed1="";
    String singleParsed1="";
    String temporary1;
    String handle1;


    @Override
    protected Void doInBackground(Void... voids) {

        handle1= mEdit.getText().toString();

        try {
            temporary1="http://codeforces.com/api/user.info?handles="+handle1;
            URL url = new URL(temporary1);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream =httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null) {
                line=bufferedReader.readLine();
                data1=data1+line;
            }
            JSONObject J = new JSONObject(data1);
            JSONArray JA=J.getJSONArray("result");
            for(int i = JA.length()-1 ;i >=0; i--){
                JSONObject JO = (JSONObject) JA.get(i);

                singleParsed1 = "Handle          : " + JO.get("handle")+ "\n" +
                                 "Current Rank   : " + JO.get("rank")+ "\n" +
                                 "Current Rating : " + JO.get("rating")+ "\n" +
                                 "Contribution   : " + JO.get("contribution")+ "\n"+
                                 "MaxRank        : " + JO.get("maxRank")+ "\n"+
                                 "MaxRating      : " + JO.get("maxRating")+ "\n" +

                                 "Country        : " + JO.get("country")+ "\n";




                dataParsed1 = dataParsed1 + singleParsed1 +"\n" ;



            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.dataParsed1);
    }

}
