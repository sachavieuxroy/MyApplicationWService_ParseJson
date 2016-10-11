package google.android.com.myapplicationwservice_parsexml;

        import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class Asynchrone extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection httpUrlConnection = null;
            String result="";
            try {
                // Créer une instance de la classe URL à l’aide de l’adresse cible
                URL url = new URL(params[0]);
                //Ouvrir une connexion pour  obtenir une instance de la classe HttpURLConnection
                httpUrlConnection = (HttpURLConnection) url.openConnection();
                // Obtenir un flux et de construire l’objet StringBuilder à partir du contenu du fichier
                MyBufferedInputStream inStream = new  MyBufferedInputStream(httpUrlConnection.getInputStream());
                result=inStream.readToEnd();
                Log.v("HttpConnection", "read String = " + result);
                // Fermer la connexion
                httpUrlConnection.disconnect();
            } catch (MalformedURLException me) {
                me.printStackTrace();
            } catch (IOException io) {
                io.printStackTrace();
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
        }

    }
    public void reception(View v){
        Asynchrone as=new Asynchrone();
        as.execute("http://10.0.2.2/formation1/document.txt" );
    }

}
