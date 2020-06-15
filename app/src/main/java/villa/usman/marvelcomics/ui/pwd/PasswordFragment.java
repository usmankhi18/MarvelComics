package villa.usman.marvelcomics.ui.pwd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import org.json.JSONException;
import org.json.JSONObject;
import es.dmoral.toasty.Toasty;
import villa.usman.marvelcomics.R;
import villa.usman.marvelcomics.common.CommonMethods;
import villa.usman.marvelcomics.common.Constants;
import villa.usman.marvelcomics.common.Network;
import villa.usman.marvelcomics.models.LoginResponse;
import villa.usman.marvelcomics.models.ResponseListner;

public class PasswordFragment extends Fragment {
    Button btnChangePwd;
    EditText et_CurrentPassword,et_Password,et_RePassword;
    ProgressBar progressBar;
    SharedPreferences sharedpreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pwd, container, false);
        Network.getInstance(getContext());
        btnChangePwd = root.findViewById(R.id.btnChangePwd);
        et_RePassword = root.findViewById(R.id.etRePassword);
        et_Password = root.findViewById(R.id.etPassword);
        et_CurrentPassword = root.findViewById(R.id.etCurrentPassword);
        progressBar = root.findViewById(R.id.progressBar);
        sharedpreferences = getActivity().getSharedPreferences(Constants.ProfilePREFERENCES, Context.MODE_PRIVATE);
        btnChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePassword();
            }
        });
        return root;
    }

    private void ChangePassword(){
        try{
            if(et_Password.getText().toString().isEmpty()){
                Toasty.warning(getContext(),"Please Enter New Password",Toasty.LENGTH_LONG).show();
                return;
            }else if(et_RePassword.getText().toString().isEmpty()){
                Toasty.warning(getContext(),"Please Enter Re-Password",Toasty.LENGTH_LONG).show();
                return;
            }else if(et_CurrentPassword.getText().toString().isEmpty()){
                Toasty.warning(getContext(),"Please Enter Current Password",Toasty.LENGTH_LONG).show();
                return;
            }else if(et_Password.getText().toString().equalsIgnoreCase(et_CurrentPassword.getText().toString())){
                Toasty.warning(getContext(),"New Password should not used before.",Toasty.LENGTH_LONG).show();
                return;
            } else if(!et_Password.getText().toString().equalsIgnoreCase(et_RePassword.getText().toString())){
                Toasty.warning(getContext(),"Password does not match",Toasty.LENGTH_LONG).show();
                return;
            }
            else{
                if (new CommonMethods().isOnline(getContext())) {
                    CallChangePwdAPI();
                } else {
                    Toasty.error(getContext(), "Internet Not Connected", Toasty.LENGTH_LONG).show();
                }
            }
        }catch (Exception ex) {
            Toasty.error(getContext(), ex.getMessage(), Toasty.LENGTH_LONG).show();
        }
    }

    private void CallChangePwdAPI(){
        try{
            progressBar.setVisibility(View.VISIBLE);
            String url = Constants.ChangePassword;
            JSONObject postparams = new JSONObject();
            JSONObject postcredentials = new JSONObject();
            postcredentials.put("APIUserName", Constants.APIUserName);
            postcredentials.put("APIPassword", Constants.APIPassword);
            postparams.put("APICredentials",postcredentials);
            postparams.put("MemberID", Integer.valueOf(sharedpreferences.getString("MemberID","0")));
            postparams.put("CurrentPassword", et_CurrentPassword.getText().toString());
            postparams.put("NewPassword", et_Password.getText().toString());
            Network.getInstance().CallJSONRequestPOSTAPI(url, postparams);
            SaveResponse();
        }catch(Exception ex){
            Toasty.error(getContext(),ex.getMessage(),Toasty.LENGTH_LONG).show();
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
                            LoginResponse.setIsPasswordAutoGen(false);
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("IsPasswordAutoGen", String.valueOf(LoginResponse.getIsPasswordAutoGen()));
                            editor.commit();
                            Toasty.success(getContext(),"Password Change Successfully!!",Toasty.LENGTH_LONG).show();
                        } else {
                            Toasty.error(getActivity().getApplicationContext(), responseMessage, Toasty.LENGTH_LONG).show();
                        }
                    }else{
                        Toasty.error(getActivity().getApplicationContext(), responseCode, Toasty.LENGTH_LONG).show();
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