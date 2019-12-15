package iak.com.Dhammapada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by M13x5aY on 13/05/2017.
 */

public class TargetActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_target);
        
        ImageView icon = (ImageView) findViewById(R.id.img);
        TextView title = (TextView) findViewById(R.id.txt);
        final TextView item = (TextView) findViewById(R.id.itm);


        Bundle bundle=getIntent().getExtras();
        String text = bundle.getString("title");
        int image = bundle.getInt("icon");
       String subitem = bundle.getString("item");

        icon.setImageResource(image);
        title.setText(text);
       item.setText(subitem);

        Button bt;
        bt=(Button)findViewById (R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("tex/plain");
                Bundle bundle=getIntent().getExtras();
                String shareBody = bundle.getString("item");
                String shareSub = bundle.getString("title");
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
        //Toast.makeText(getApplicationContext(),"title",Toast.LENGTH_SHORT).show();
    }
}
