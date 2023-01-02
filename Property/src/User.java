public class User
{

    String UserName ;
    String Password ;
    String PhoneNumber ;
    String BrokerOrUser ;
    int NoOfAdvertise ;

    public
    User( )
    {
        UserName = "" ;
        Password = "" ;
        PhoneNumber = "" ;
        BrokerOrUser = "" ;
        NoOfAdvertise = 0 ;
    }
    void ShowUserDetails()
    {
        System.out.printf("User Name: %s\nPassword:  %s\nPhone Number:  %s\nKind Of User:  %s\n" , UserName  , Password , PhoneNumber , BrokerOrUser);

    }


}
