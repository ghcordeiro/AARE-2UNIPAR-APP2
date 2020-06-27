package br.unipar.calendariofgts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity {

    private EditText edCPF;
    private EditText edDataNasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCPF = findViewById(R.id.edCPF);
        SimpleMaskFormatter simplemaskCPF = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher maskcpf = new MaskTextWatcher(edCPF, simplemaskCPF);

        edDataNasc = findViewById(R.id.edDataNasc);
        SimpleMaskFormatter simplemaskData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskData = new MaskTextWatcher(edDataNasc, simplemaskData);


        edCPF.addTextChangedListener(maskcpf);
        edDataNasc.addTextChangedListener(maskData);

    }

    public void btnVerificarOnClick(View view) {
        edDataNasc = findViewById(R.id.edDataNasc);
        System.out.println(MainActivity.this.edDataNasc.getText().toString());
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putString("dataNasc", edDataNasc.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}