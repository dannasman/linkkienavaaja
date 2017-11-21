package gnomehill.linkkienavaaja;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.BLACK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mikaNappi(View view) {
        switch (view.getId()) {
            case R.id.Goblin: {
                avaaLinkki("https://greengoblin.cs.hut.fi/csa1111_s2017/authenticate.php");
                break;
            }

            case R.id.Historia: {
                avaaLinkki("https://padlet.com/eero_kitunen/weswicd4f44l");
                break;
            }

            case R.id.Taloustieto: {
                avaaLinkki("https://padlet.com/eero_kitunen/6urdij0meg6d");
                break;
            }

            case R.id.Ryhmanohjaus: {
                avaaLinkki("https://padlet.com/eero_kitunen/2couh0vqwak5");
                break;
            }

            case R.id.Nimenhuuto: {
                avaaLinkki("https://dogsb.nimenhuuto.com/player?set_active_player_to=1295968");
                break;
            }

            case R.id.Wilma: {
                avaaLinkki("https://wilma.espoo.fi/");
                break;
            }
        }
    }

    public void avaaLinkki(String osoite) {
        Uri linkki = Uri.parse(osoite);
        Intent avaa = new Intent(Intent.ACTION_VIEW, linkki);
        startActivity(avaa);
    }
}