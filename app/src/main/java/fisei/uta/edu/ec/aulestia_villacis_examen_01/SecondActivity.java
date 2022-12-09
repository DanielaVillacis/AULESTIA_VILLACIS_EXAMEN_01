package fisei.uta.edu.ec.aulestia_villacis_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    EditText edtNumeroIngresado;
    ListView listaNumeros;
    Button botonIngresar;
    Button botonCerrar;
    ArrayList<Integer> numerosListaRV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide();

        listaNumeros = findViewById(R.id.listViewNumeros);
        botonCerrar = findViewById(R.id.buttonCerrar);
        botonIngresar = findViewById(R.id.buttonIngresar);
        edtNumeroIngresado = findViewById(R.id.editTextNumero);
        Context context = this;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, loadDate());

        listViewData.setAdapter(adapter);



        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux = numeroIngresado.getText().toString();

                if(aux.equals("")){
                    Toast.makeText(ActivityIngresarDatos.this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                }else {
                    int num = Integer.valueOf(aux);
                    if(num == 0){
                        Toast.makeText(ActivityIngresarDatos.this, "Número no puede ser 0", Toast.LENGTH_SHORT).show();
                    }else{
                        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(ActivityIngresarDatos.this,
                                android.R.layout.simple_list_item_1, loadLista(num));
                        listaOriginal.setAdapter(adapter);
                    }
                }

            }
        });
    }
    }



}