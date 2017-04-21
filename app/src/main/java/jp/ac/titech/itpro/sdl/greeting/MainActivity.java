package jp.ac.titech.itpro.sdl.greeting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {


    private TextView outputView;
    private EditText inputName;
    private Button   okButton;

    private final static String KEY_NAME = "MainActivity.name";
    private String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputView = (TextView) findViewById(R.id.output_view);
        inputName = (EditText) findViewById(R.id.input_name);
        okButton = (Button) findViewById(R.id.ok_button);
        okButton.setOnClickListener(this);

        if(savedInstanceState != null){
            name = savedInstanceState.getString(KEY_NAME);
        }

    }

    @Override
    protected void onResume(){
        super.onResume();
        greet();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, name);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_button:
                name = inputName.getText().toString();
                if (name != null && name.length() > 0) {
                    outputView.setText("Hello, " + name + "\nNice to see you!");
                }
            break;
        }
    }

    private void greet(){
        if (name != null && name.length() > 0){
            outputView.setText("Hello, " + name + "\nNice to see you!");
        }
    }

}
