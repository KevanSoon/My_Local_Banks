package sg.edu.rp.c346.id19013989.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        int check = v.getId();

        if(check == R.id.textViewDBS) {
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");



        }
        else if(check == R.id.textViewOCBC) {
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Contact the bank");

        }
        else if(check == R.id.textViewUOB) {
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Contact the bank");

        }




    }
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()== 0) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        }
        else if (item.getItemId()== 1) {
            Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
            startActivity(intent);
            return true;
        }

        else if(item.getItemId() == 2) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;

        }
        else if (item.getItemId() == 3) {
            Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == 4) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);
            return true;

        }
        else if (item.getItemId() == 5) {
            Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse(("tel: " + "18002222121")));
            startActivity(intent);
            return true;

        }

        return super.onContextItemSelected(item);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
