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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonSiguiente;
    private Button buttonMostrar;
    private Button buttonOrdenar;
    ArrayList<Integer> listaNumero = new ArrayList<>();
    ArrayList<Integer> listaIndice = new ArrayList<>();
    ListView listaOriginal;
    ListView listaOrdenado;
    ListView listaValorIndice;


    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        if(data != null){
                            buttonMostrar.setEnabled(true);
                            buttonOrdenar.setEnabled(true);
                            listaNumero = data.getIntegerArrayListExtra("result");


                        }else{
                            Toast.makeText(MainActivity.this,"NO EXISTEN DATOS",Toast.LENGTH_LONG).show();
                        }
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
        listaOriginal = findViewById(R.id.listViewVectorOriginal);
        listaValorIndice = findViewById(R.id.listViewVectorIndices);
        listaOrdenado= findViewById(R.id.listViewVectorOrdenado);

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

                ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(MainActivity.this,
                        android.R.layout.simple_list_item_1, OrdenarDescendente(listaNumero));
                listaOrdenado.setAdapter(adapter2);

            }
        });

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(MainActivity.this,
                        android.R.layout.simple_list_item_1, listaNumero);
               listaOriginal.setAdapter(adapter);




            }
        });


    }


    public static ArrayList<Integer> OrdenarDescendente( ArrayList<Integer> vectorOriginal)
    {
        int i, n, temp;

        n= vectorOriginal.size();
        ArrayList<Integer> vectorIndice = new ArrayList<Integer>();
        ArrayList<Integer> vectorAux = new ArrayList<Integer>();


        for (i=0 ; i<vectorOriginal.size(); i++){
           vectorAux.add(i, vectorOriginal.get(i));
        }
        i=0;
        do
        {

            if (vectorAux.get(i) < vectorAux.get(i+1))
            {
                temp = vectorAux.get(i);
                vectorAux.add(i, vectorAux.get(i+1));
                vectorAux.add(i+1, temp);
                i = 0;

            }
            else
            {
                i++;
            }

        }while(i<n-1);

        return vectorAux;

    }





}