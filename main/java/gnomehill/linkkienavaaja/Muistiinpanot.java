package gnomehill.linkkienavaaja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Muistiinpanot extends AppCompatActivity {

    private static final String TAG = Muistiinpanot.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muistiinpanot);
        Intent intent = getIntent();
        tallenna();
    }

    private void kirjoitaTiedostoon(String sisalto) {
        try {
            OutputStreamWriter ulos = new OutputStreamWriter(openFileOutput("muistiinpanot.txt", Context.MODE_PRIVATE));
            ulos.write(sisalto);
            ulos.close();

        }
        catch (IOException e) {
            Log.e(TAG,"Tiedostoon kirjoittaminen epäonnistui: " + e.toString());
        }
    }

    private String lueTiedostosta() {
        String palauta = "";

        try {
            InputStream sisaan = openFileInput("muistiinpanot.txt");

            if(sisaan != null) {
                InputStreamReader sisaanLuku = new InputStreamReader(sisaan);
                BufferedReader puskuri = new BufferedReader(sisaanLuku);
                String otaVastaan = "";
                StringBuilder rakentaja = new StringBuilder();

                while((otaVastaan = puskuri.readLine()) != null) {
                    if(otaVastaan == "") {
                        rakentaja.append(otaVastaan);
                    }
                    else {
                        rakentaja.append(otaVastaan + "\n");
                    }
                }

                sisaan.close();

                palauta = rakentaja.toString();
            }
        }
        catch(FileNotFoundException e) {
            Log.e(TAG, "Tiedostoa ei löytynyt: " + e.toString());
        } catch(IOException e) {
            Log.e(TAG, "Tiedostoa ei voida lukea: " + e.toString());
        }

        return palauta;
    }

    public void tallennaNapista(View view) {
        EditText tekstikenttä;
        tekstikenttä = (EditText) findViewById(R.id.editText4);
        String teksti = tekstikenttä.getText().toString();
        kirjoitaTiedostoon(teksti);
        tekstikenttä.setText("");
        String tallennettuteksti = lueTiedostosta();
        tekstikenttä.append(tallennettuteksti);
    }

    public void tallenna() {
        EditText tekstikenttä;
        tekstikenttä = (EditText) findViewById(R.id.editText4);
        String tallennettuteksti = lueTiedostosta();
        tekstikenttä.append(tallennettuteksti);
    }
}