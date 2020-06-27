package br.unipar.calendariofgts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

import br.unipar.calendariofgts.util.Analise;

public class ResultActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle b = getIntent().getExtras();
        ArrayList<String> resultadoAnalise = new ArrayList<>();
        try {
            assert b != null;
            resultadoAnalise = Analise.retornaResulado(Objects.requireNonNull(b.getString("dataNasc")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextView primeiraParcela = findViewById(R.id.tvPrimeira);
        TextView segundaParcela = findViewById(R.id.tvSegunda);
        TextView terceiraParcela = findViewById(R.id.tvTerceira);

        primeiraParcela.setText("Primeira parcela: " + resultadoAnalise.get(0));
        segundaParcela.setText("Segunda parcela:  " + resultadoAnalise.get(1));
        terceiraParcela.setText("Terceira parcela: " + resultadoAnalise.get(2));
    }

}
