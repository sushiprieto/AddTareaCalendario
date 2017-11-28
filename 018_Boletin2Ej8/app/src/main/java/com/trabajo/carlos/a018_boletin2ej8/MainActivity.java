package com.trabajo.carlos.a018_boletin2ej8;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnEvento;
    private EditText edtEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEvento = findViewById(R.id.btnEvento);
        edtEvento = findViewById(R.id.edtEvento);



        btnEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto = edtEvento.getText().toString();

                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", texto);
                startActivity(intent);
            }
        });



    }
}
