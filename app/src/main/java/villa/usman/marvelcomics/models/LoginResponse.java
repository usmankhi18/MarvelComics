package villa.usman.marvelcomics.models;

public class LoginResponse {
    private static int MemberID;
    private static String MemberName;
    private static String UserName;
    private static String Email;
    private static Boolean IsActive;
    private static Boolean IsPasswordAutoGen;
    private static int ProvinceID;
    private static String ProvinceName;

    public static int getMemberID() {
        return MemberID;
    }

    public static void setMemberID(int memberID) {
        MemberID = memberID;
    }

    public static String getMemberName() {
        return MemberName;
    }

    public static void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static Boolean getIsActive() {
        return IsActive;
    }

    public static void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }

    public static Boolean getIsPasswordAutoGen() {
        return IsPasswordAutoGen;
    }

    public static void setIsPasswordAutoGen(Boolean isPasswordAutoGen) {
        IsPasswordAutoGen = isPasswordAutoGen;
    }

    public static int getProvinceID() {
        return ProvinceID;
    }

    public static void setProvinceID(int provinceID) {
        ProvinceID = provinceID;
    }

    public static String getProvinceName() {
        return ProvinceName;
    }

    public static void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }
}
