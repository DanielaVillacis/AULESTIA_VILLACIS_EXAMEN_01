package fisei.uta.edu.ec.aulestia_villacis_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EditText edtNumeroIngresado;
    ListView listaDevolver;
    Button botonIngresar;
    Button botonCerrar;
    ArrayList<Integer> listaNumero = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       // getSupportActionBar().hide();

        listaDevolver = findViewById(R.id.listViewNumeros);
        botonCerrar = findViewById(R.id.buttonCerrar);
        botonIngresar = findViewById(R.id.buttonIngresar);
        edtNumeroIngresado = findViewById(R.id.editTextNumero);



        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux = edtNumeroIngresado.getText().toString();

                if(aux.equals("")){
                    Toast.makeText(SecondActivity.this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                }else {
                    int num = Integer.valueOf(aux);
                    if(num == 0){
                        Toast.makeText(SecondActivity.this, "Número no puede ser 0", Toast.LENGTH_SHORT).show();
                    }else{
                        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(SecondActivity.this,
                                android.R.layout.simple_list_item_1, loadLista(num));
                        listaDevolver.setAdapter(adapter);
                        edtNumeroIngresado.setText("");
                    }
                }

            }
        });

        botonCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putIntegerArrayListExtra("result",listaNumero);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }


    private List<Integer> loadLista(int num) {
        listaNumero.add(num);
        return listaNumero;
    }



}