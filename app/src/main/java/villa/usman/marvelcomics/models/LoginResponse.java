package villa.usman.marvelcomics.models;

public class LoginResponse {
    private static int UserID;
    private static String UserName;
    private static String FirstName;
    private static String LastName;
    private static String Gender;
    private static String Email;
    private static boolean IsActive;
    private static String MobileNo;
    private static String DateOfBirth;
    private static String Country;
    private static int RoleID;
    private static String Role;
    private static int StatusID;
    private static String Status;
    private static String ImageUrl;
    private static String CNIC;

    public static int getUserID() {
        return UserID;
    }

    public static void setUserID(int userID) {
        UserID = userID;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setLastName(String lastName) {
        LastName = lastName;
    }

    public static String getGender() {
        return Gender;
    }

    public static void setGender(String gender) {
        Gender = gender;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static boolean getIsActive() {
        return IsActive;
    }

    public static void setIsActive(boolean isActive) {
        IsActive = isActive;
    }

    public static String getMobileNo() {
        return MobileNo;
    }

    public static void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public static String getDateOfBirth() {
        return DateOfBirth;
    }

    public static void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public static String getCountry() {
        return Country;
    }

    public static void setCountry(String country) {
        Country = country;
    }

    public static int getRoleID() {
        return RoleID;
    }

    public static void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public static String getRole() {
        return Role;
    }

    public static void setRole(String role) {
        Role = role;
    }

    public static int getStatusID() {
        return StatusID;
    }

    public static void setStatusID(int statusID) {
        StatusID = statusID;
    }

    public static String getStatus() {
        return Status;
    }

    public static void setStatus(String status) {
        Status = status;
    }

    public static String getImageUrl() {
        return ImageUrl;
    }

    public static void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public static String getCNIC() {
        return CNIC;
    }

    public static void setCNIC(String CNIC) {
        LoginResponse.CNIC = CNIC;
    }
}
