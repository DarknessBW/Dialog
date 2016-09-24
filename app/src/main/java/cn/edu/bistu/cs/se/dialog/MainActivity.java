package cn.edu.bistu.cs.se.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button bth = (Button)findViewById(R.id.button_hint);
        bth.setOnClickListener(new View.OnClickListener() {
            public void  onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("点击登录输入用户名和密码").setTitle("提示对话框");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮",Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();
            }
        });

        Button btl = (Button)findViewById(R.id.button_login);
        btl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.login_dialog,null))
                        .setTitle("Login")
                        .setPositiveButton("登录",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //EditText etu = (EditText)findViewById(R.id.editTextUserId);
                                //EditText etp = (EditText)findViewById(R.id.editTextPwd);
                                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                                /*
                                if(etu.getText().toString() == "abc" && etp.getText().toString() == "123")
                                    Toast.makeText(MainActivity.this, "登录成功",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(MainActivity.this, "登录失败",Toast.LENGTH_LONG).show();
                                */
                            }
                        })
                        .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                            }
                        });
                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
