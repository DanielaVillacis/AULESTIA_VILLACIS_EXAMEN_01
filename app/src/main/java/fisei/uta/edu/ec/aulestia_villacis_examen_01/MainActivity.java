package fisei.uta.edu.ec.aulestia_villacis_examen_01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSiguiente;
    private Button buttonMostrar;
    private Button buttonOrdenar;

    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK){


                        Intent data = result.getData();
                        String[] resultado = data.getDataString().split("_");
                        //resultados.setEnabled(true);


                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializar
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        buttonMostrar = findViewById(R.id.buttonMostrar);
        buttonOrdenar = findViewById(R.id.buttonOrdenar);

        buttonMostrar.setEnabled(false);
        buttonOrdenar.setEnabled(false);


        buttonSiguiente.setOnClickListener(new View.OnClickListener(){
                @Override
                  public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                      activityResult.launch(intent);
                     }
                    }
        );

        buttonOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}