package villa.usman.marvelcomics.common;

public class Constants {
    public static final int DELAY_LENGTH = 3000;
    public static final String ProfilePREFERENCES = "ProfilePREFERENCES";
    public static final String ConfigurationPREFERENCES = "ConfigurationPREFERENCES" ;
    public static final String Error = "Error";
    public static final String Success = "Success";
    public static final String NoData = "Data Not Exist";
    public static String Server = "http://Ehsaas.somee.com/api/";
    public static String APIUserName = "admin";
    public static String APIPassword = "admin123";
    public static String UserAPI = "User/";
    public static String LocationAPI = "Location/";
    public static String CitizenAPI = "Citizens/";
    public static String DashboardAPI = "Dashboard/";
    public static String GetMemberLogin = Server+UserAPI+"GetMemberLogin";
    public static String ResetPassword = Server+UserAPI+"ResetPassword";
    public static String ChangePassword = Server+UserAPI+"ChangePassword";
    public static String GetLocations = Server+ LocationAPI +"GetLocations";
    public static String InsertCitizens = Server + CitizenAPI+"InsertCitizen";
    public static String VerifyAllCitizens = Server + CitizenAPI+"VerifyAllCitizens";
    public static String GetStatistics = Server + DashboardAPI + "GetStatistics";
    public static final String ServerKey = "ServerKey";
    public static final String APIUserNameKey = "APIUserNameKey";
    public static final String APIPasswordKey = "APIPasswordKey";
    public static final String AdminEmail = "usman.khan@zultec.com";
    public static final String PhoneNumberMask = "####-#######";
    public static final String CNICMask = "#####-#######-#";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EhsaasDB";
    public static final String TRIPLEDESKEY = "MCJDYEKVHDHHFDSHDFKSYEYY";
    public static final String INITIALISATIONVECTOR = "JHGFDFDS";
}
