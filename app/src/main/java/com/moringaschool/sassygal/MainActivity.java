//package com.moringaschool.sassygal;
//
//import static android.provider.AlarmClock.EXTRA_MESSAGE;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class MainActivity extends AppCompatActivity {
//   @BindView(R.id.button)
//   Button button;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ButterKnife.bind(this);
//        Button button = (Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        }
//
//    }
//
//
//
//
//
//
//