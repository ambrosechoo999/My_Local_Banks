package sg.edu.rp.c346.id20008189.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDbs;
    TextView tvUob;
    TextView tvOcbc;

    String wordClicked ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs=findViewById(R.id.tvDbs);

        tvOcbc=findViewById(R.id.tvOcbc);

        tvUob = findViewById(R.id.tvUob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");


        if (v == tvDbs) {

            wordClicked ="dbs";

        }
        else if(v==tvOcbc) {
            wordClicked="ocbc";

        }
        else if(v==tvUob){
            wordClicked="uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent i = new Intent();
        if(wordClicked.equalsIgnoreCase("dbs")) {

            if (item.getItemId() == 0) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);



            } else if (item.getItemId() == 1) {
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:18001111111"));
                startActivity(i);


            }
        }
        else if(wordClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0){
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.ocbc.com"));
                startActivity(i);


            }
            else if(item.getItemId()==1){
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:18003633333"));
                startActivity(i);


            }
        }
        else if(wordClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0){
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.uob.com.sg"));
                startActivity(i);


            }
            else if(item.getItemId()==1){
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:18002222121"));
                startActivity(i);




            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText("DBS ");
            tvUob.setText("UOB");
            tvOcbc.setText("OCBC");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}