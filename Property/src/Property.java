    public class Property
    {

        int Room ;
        String Street ;
        String City ;
        int Price ;
        int Kind ;
        int BuyingOrRenting ;
        int HomeNumber ;
        int FloorNumber ;
        String TheUserThatPublishTheProperty ;
        String PhoneNumber ;

        public
        Property( String City_Name , String Street_Name, int Home_number , int Floor_Number , int Room_number ,
                   int Kind_Of_Property , int Price_ , int Renting , String User_Name_Publish , String Phone_Number )
        {
            City = City_Name ;
            Street = Street_Name ;
            Room = Room_number ;
            Price = Price_ ;
            Kind = Kind_Of_Property ;
            BuyingOrRenting = Renting ;
            HomeNumber = Home_number ;
            FloorNumber = Floor_Number ;
            TheUserThatPublishTheProperty = User_Name_Publish ;
            PhoneNumber = Phone_Number ;

        }
        void ShowPropertyDetails()
        {
            String regular = "Regular";
            String Broket = "Broker";
            String rent   = "rent";
            String sale   = "sale";
            String tmp = "";
            String tmpByingOrRent = "";
            System.out.printf("City Name: %s\nStreet Name:  %s\nRoom Number:  %d\nPrice:  %s\nKind of property: %s\n" +
                    "Offered for rent: %s\nHome NUmber: %s\nFloor Number: %d\nThe user publish: %s\n" ,  City , Street ,
                         Room ,Price ,Kind ,BuyingOrRenting ,HomeNumber ,FloorNumber ,TheUserThatPublishTheProperty );


            if( Kind == 1 ) tmp = regular ;
            else if (Kind == 2) tmp = "Penthouse";
            else tmp = "Private house" ;


            tmpByingOrRent = ( BuyingOrRenting == 1 ) ? rent : sale ;

            System.out.printf("%s - %s %d\n" ,City , Street , HomeNumber );
            System.out.printf("%s apartment - for %s : %d rooms %d floor \n" , tmp ,tmpByingOrRent , Room , FloorNumber ) ;
            System.out.printf("Price : %d\n" ,Price );
            System.out.printf("Contact info :%s %s %d\n" ,TheUserThatPublishTheProperty , PhoneNumber , HomeNumber );
        }

        public void PropertyDetails(int floor, int numOfRoom, int numOfProperty, String thePropertyIsForSaleOrRent, int propertyPrice) {
        }
    }
