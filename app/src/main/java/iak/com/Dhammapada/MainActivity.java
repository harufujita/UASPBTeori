package iak.com.Dhammapada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);

        final ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather(R.drawable.merpati,"1. Yamakavaggo","Syair Berpasangan (1 - 20)"));
        data.add(new Weather(R.drawable.kewaspadaan,"2. Appamādavaggo","kewaspadaan (21 - 32)"));
        data.add(new Weather(R.drawable.mind,"3. Cittavaggo","Pikiran (33 - 43)"));
        data.add(new Weather(R.drawable.bunga,"4. Pupphavaggo","Bunga Bunga (44 - 59)"));
        data.add(new Weather(R.drawable.roangbodoh,"5. Bālavaggo","Orang Bodoh (60 - 75)"));
        data.add(new Weather(R.drawable.download,"6. Paṇḍitavaggo","Orang Bijaksana (76 - 89)"));
        data.add(new Weather(R.drawable.arahat,"7. Arahantavaggo","Arahanta (90 - 99)"));
        data.add(new Weather(R.drawable.seribu,"8. Sahassavaggo","Ribuan (100 - 115)"));



        WeatherAdapter adapter = new WeatherAdapter(this, R.layout.list_view, data);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weather weather=data.get(position);
                Intent toTarget = new Intent(getApplicationContext(),TargetActivity.class);
                toTarget.putExtra("title", weather.title);
                toTarget.putExtra("icon", weather.icon);
                toTarget.putExtra("item", weather.item);
                startActivity(toTarget);

            }
        });
    }
}
