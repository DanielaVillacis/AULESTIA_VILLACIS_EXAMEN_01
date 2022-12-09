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
                            Toast.makeText(MainActivity.this,"NO se trajo los datos",Toast.LENGTH_LONG).show();
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

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(MainActivity.this,
                        android.R.layout.simple_list_item_1, listaNumero);
               listaOriginal.setAdapter(adapter);

                ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(MainActivity.this,
                        android.R.layout.simple_list_item_1, OrdenarDescendente(listaNumero));
                listaValorIndice.setAdapter(adapter2);



            }
        });


    }


    public static ArrayList<Integer> OrdenarDescendente( ArrayList<Integer> vectorOriginal)
    {
        int i, j, n, temp=0;

        n= vectorOriginal.size();
        ArrayList<Integer> vectorIndice = new ArrayList<Integer>();

        for(i=0;i<n;i++)
        {
            for(j=i;j<n;j++)
            {
                if(vectorOriginal.get(i)>vectorOriginal.get(j))
                {
                    temp=vectorOriginal.get(j);
                    vectorIndice.add(j,vectorOriginal.get(i));
                    vectorIndice.add(i,temp);
                }
            }

        }

        return vectorIndice;

    }





}