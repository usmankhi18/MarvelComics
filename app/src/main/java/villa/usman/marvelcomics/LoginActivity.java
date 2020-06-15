package villa.usman.marvelcomics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import es.dmoral.toasty.Toasty;
import villa.usman.marvelcomics.common.CommonMethods;
import villa.usman.marvelcomics.common.Constants;
import villa.usman.marvelcomics.common.Network;
import villa.usman.marvelcomics.models.LoginResponse;
import villa.usman.marvelcomics.models.ResponseListner;

public class LoginActivity extends Activity {
    Button btnLogin;
    EditText et_Email,et_Password;
    TextView tv_register;
    ProgressBar progressBar;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Network.getInstance(this);
        btnLogin = findViewById(R.id.btnLogin);
        et_Email = findViewById(R.id.etUsername);
        et_Password = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressBar);
        tv_register = findViewById(R.id.tvSignUp);
        sharedpreferences = getSharedPreferences(Constants.ProfilePREFERENCES, Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(et_Email.getText().toString());
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    private void Login(String email){
        try{
            if(email.isEmpty()){
                Toasty.warning(getApplicationContext(),"Please Enter Email",Toasty.LENGTH_LONG).show();
            }
            else if (new CommonMethods().isEmail(email) == false) {
                Toasty.warning(getApplicationContext(),"Enter valid email!",Toasty.LENGTH_LONG).show();
            }else if(et_Password.getText().toString().isEmpty()){
                Toasty.warning(getApplicationContext(),"Please Enter Password",Toasty.LENGTH_LONG).show();
                return;
            }else{
                if (new CommonMethods().isOnline(getApplicationContext())) {
                    CallLoginAPI();
                } else {
                    Toasty.error(getApplicationContext(), "Internet Not Connected", Toasty.LENGTH_LONG).show();
                }
            }
        }catch (Exception ex) {
            Toasty.error(getApplicationContext(), ex.getMessage(), Toasty.LENGTH_LONG).show();
        }
    }

    private void CallLoginAPI(){
        try{
            progressBar.setVisibility(View.VISIBLE);
            String url = Constants.GetMemberLogin;
            JSONObject postparams = new JSONObject();
            JSONObject postcredentials = new JSONObject();
            postcredentials.put("APIUserName", Constants.APIUserName);
            postcredentials.put("APIPassword", Constants.APIPassword);
            postparams.put("APICredentials",postcredentials);
            postparams.put("Email", et_Email.getText());
            postparams.put("Password", et_Password.getText().toString());
            Network.getInstance().CallJSONRequestPOSTAPI(url, postparams);
            SaveResponse();
        }catch(Exception ex){
            Toasty.error(getApplicationContext(),ex.getMessage(),Toasty.LENGTH_LONG).show();
        }
    }

    private void SaveResponse(){
        Handler handler;
        if(!ResponseListner.getObject().toString().equalsIgnoreCase("{}")) {
            try {
                try {
                    progressBar.setVisibility(View.GONE);
                    String responseCode = ResponseListner.getObject().getString("ResponseCode");
                    if(!responseCode.equalsIgnoreCase(Constants.Error)) {
                        String responseMessage = ResponseListner.getObject().getString("ResponseMessage");
                        if (responseCode.equalsIgnoreCase("00") && responseMessage.equalsIgnoreCase(Constants.Success)) {
                            JSONObject responseData = ResponseListner.getObject().getJSONObject("ResponseData");
                            JSONObject loginResponse = responseData.getJSONObject("LoginResp");
                            LoginResponse.setMemberID(loginResponse.getInt("MemberID"));
                            LoginResponse.setMemberName(loginResponse.getString("MemberName"));
                            LoginResponse.setUserName(loginResponse.getString("UserName"));
                            LoginResponse.setEmail(loginResponse.getString("Email"));
                            LoginResponse.setIsActive(loginResponse.getBoolean("IsActive"));
                            LoginResponse.setIsPasswordAutoGen(loginResponse.getBoolean("IsPasswordAutoGen"));
                            LoginResponse.setProvinceID(loginResponse.getInt("ProvinceID"));
                            LoginResponse.setProvinceName(loginResponse.getString("ProvinceName"));
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("MemberID", String.valueOf(LoginResponse.getMemberID()));
                            editor.putString("MemberName", LoginResponse.getMemberName());
                            editor.putString("UserName", LoginResponse.getUserName());
                            editor.putString("Email", LoginResponse.getEmail());
                            editor.putString("IsActive", String.valueOf(LoginResponse.getIsActive()));
                            editor.putString("IsPasswordAutoGen", String.valueOf(LoginResponse.getIsPasswordAutoGen()));
                            editor.putString("ProvinceID",String.valueOf(LoginResponse.getProvinceID()));
                            editor.putString("ProvinceName",LoginResponse.getProvinceName());
                            editor.commit();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                            Toasty.error(getApplicationContext(), responseMessage, Toasty.LENGTH_LONG).show();
                        }
                    }else{
                        Toasty.error(getApplicationContext(), responseCode, Toasty.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Log.d("Error", e.getMessage());
                }
            } catch (Exception e) {

            }
        }else{
            handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SaveResponse();
                }},Constants.DELAY_LENGTH);
        }
    }
}