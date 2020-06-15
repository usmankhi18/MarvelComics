package villa.usman.marvelcomics.common;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import es.dmoral.toasty.Toasty;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class CommonMethods {
    ConnectivityManager connectivityManager;
    boolean connected = false;

    public boolean isEmail(String text) {
        CharSequence email = text;
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean isValidMobile(String phone) {
        if(Pattern.matches("^03\\d{2}-\\d{7}$", phone)) {
            return true;
        }
        return false;
    }

    public int GetSpinnerId(Spinner spinner, String value){
        int id = 0;
        if(spinner.getAdapter().getCount()>0){
            for(int i=0;i<spinner.getAdapter().getCount();i++){
                if(spinner.getAdapter().getItem(i).toString().equalsIgnoreCase(value)){
                    return i;
                }
            }
        }
        return id;
    }

    public boolean isValidCNIC(String cnic){
        if(Pattern.matches("^\\d{5}-\\d{7}-\\d{1}$", cnic)) {
            return true;
        }
        return false;
    }

    public boolean isOnline(Context context) {
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;


        } catch (Exception e) {
            Toasty.error(context,"CheckConnectivity Exception: " + e.getMessage(), Toasty.LENGTH_LONG).show();
            Log.v("connectivity", e.toString());
        }
        return connected;
    }

    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean checkPermission(final Context context)
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>= Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("External storage permission is necessary");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public Date DateConvertFromString(String strdate, Context context){
        Date date = Calendar.getInstance().getTime();
        try{
            date = new SimpleDateFormat("yyyy-MM-DD").parse(strdate);
        }catch (Exception ex){
            Toasty.error(context,ex.getMessage(),Toasty.LENGTH_LONG).show();
        }
        return date;
    }

    public static int getDiffYears(Date from, Date to) {
        Calendar start = getCalendar(from);
        Calendar end = getCalendar(to);
        int diff = end.get(YEAR) - start.get(YEAR);
        if (start.get(MONTH) > end.get(MONTH) ||
                (start.get(MONTH) == end.get(MONTH) && start.get(DATE) > end.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
