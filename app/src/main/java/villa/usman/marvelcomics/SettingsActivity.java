package villa.usman.marvelcomics;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import es.dmoral.toasty.Toasty;
import villa.usman.marvelcomics.common.Constants;
import static villa.usman.marvelcomics.common.Constants.APIPasswordKey;
import static villa.usman.marvelcomics.common.Constants.APIUserNameKey;
import static villa.usman.marvelcomics.common.Constants.ServerKey;

public class SettingsActivity extends AppCompatActivity {
    EditText url,username,password;
    Button btnSaveSettings,btnVerifyAll;
    SharedPreferences sharedpreferences,personalpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        btnSaveSettings = findViewById(R.id.btnSave);
        url = findViewById(R.id.et_APIServer);
        username = findViewById(R.id.et_APIUserName);
        password = findViewById(R.id.et_Password);
        personalpreferences = getSharedPreferences(Constants.ProfilePREFERENCES, Context.MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(Constants.ConfigurationPREFERENCES, Context.MODE_PRIVATE);
        btnSaveSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SaveSettings();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.removeItem(R.id.action_settings);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Logout")
                        .setMessage("Are you sure to Logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sharedpreferences.edit().clear().commit();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void SaveSettings(){
        try{
            if(url.getText().toString().isEmpty()){
                Toasty.warning(getApplicationContext(),"Enter API URL",Toasty.LENGTH_LONG).show();
            }else if(username.getText().toString().isEmpty()){
                Toasty.warning(getApplicationContext(),"Enter API UserName",Toasty.LENGTH_LONG).show();
            }else if(password.getText().toString().isEmpty()){
                Toasty.warning(getApplicationContext(),"Enter API Password",Toasty.LENGTH_LONG).show();
            }else {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(ServerKey, url.getText().toString());
                editor.putString(APIUserNameKey, username.getText().toString());
                editor.putString(APIPasswordKey, password.getText().toString());
                editor.commit();
                Toasty.success(getApplicationContext(), "Save Successfully", Toasty.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        }catch (Exception ex){
            Toasty.error(getApplicationContext(),ex.getMessage(),Toasty.LENGTH_LONG).show();
        }
    }
}