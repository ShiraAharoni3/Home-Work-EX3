import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RealState
        {
            User []userArray = new User[100] ;
            City []citiesArray = new City[10];

            Property []propertiesArray = new Property[100];
            int propertyIndex = 0 ;

            public static final String[] CITIES = {"Jerusalem" , "Kiryat Shmona" , "Tel Aviv" , "Beer Sheva" ,"Ashkelon" , "Hod Hasharon" , "Eilat" , "Rishon Lezion ", "Lod" , "Zefat" } ;

            public static final String[] DISTRICTS = { " Negev" , "South" , "Center" , "Sharon" , "North" } ;
            String[] JerusalemStreets = { "Talpiot " , "Malha " , "Arnona"};
            String[] KiryatShmonaStreets   = { "Nisim " , "Rambam " , "Harzit"};
            String[] TelAvivStreets = { "Bialik " , "Dizengoff " , "Bograshov"};
            String[] BeerShevaStreets = { "Suburbs " , "Gimel" , "Ramot"};
            String[] AshkelonStreets = { "Argaman " , " Agmon" , "Amishav"};
            String[] HodHasharonStreets  = { "Dganit " , "HaAvoda " , "Bikurim"};
            String[] EilatStreets  = { "Ofarim " , " Bnei israel" , "Hatmarim"};
            String[] RishonLezionStreets = { "Brenner " , "Through Haim Herzog " , "Jabotinsky"};
            String[] LodStreets = { "Edison " , " Afarsek" , "Aba Hillel Silver"};
            String[] ZefatStreets = { "Maor Haim" , "Nof HaKineret " , "Ramat Razim"};

            String[][] citiesStreetsArray = { JerusalemStreets , KiryatShmonaStreets , TelAvivStreets , BeerShevaStreets ,
                    AshkelonStreets , HodHasharonStreets , EilatStreets , RishonLezionStreets , LodStreets , ZefatStreets };
            int index = 0 ;

  //          Property property;

            public RealState()
            {
                for( int i = 0 ; i < 10 ; i++ ) {
                    citiesArray[i] = new City();
                }
                for ( int i = 0 ; i < 100 ; i++)
                {
                    userArray[i] = new User();
                }

                citiesArray[0].CityDetails( (String) "Eilat", (String)"Negev" ,EilatStreets  );
                citiesArray[1].CityDetails( (String) "Ashkelon", (String)"South" ,AshkelonStreets  );
                citiesArray[2].CityDetails( (String) "Beer Sheva", (String)"South" ,BeerShevaStreets  );
                citiesArray[3].CityDetails( (String) "Tel Aviv", (String)"Center" ,TelAvivStreets  );
                citiesArray[4].CityDetails( (String) "Rishon Lezion", (String)"Center" ,RishonLezionStreets  );
                citiesArray[5].CityDetails( (String) "Jerusalem", (String)"Center" ,JerusalemStreets  );
                citiesArray[6].CityDetails( (String) "Lod", (String)"Center" ,LodStreets  );
                citiesArray[7].CityDetails( (String) "Hod Hasharon", (String)"Sharon" ,HodHasharonStreets  );
                citiesArray[8].CityDetails( (String) "Kiryat Shmona", (String)"North" ,KiryatShmonaStreets  );
                citiesArray[9].CityDetails( (String) "Zefat", (String)"North" ,ZefatStreets  );
            }
            public User createUser()
            {
                User userTemp = new User();
                userTemp.BrokerOrUser   =  userTitle() == 1 ? (String)"Regular" : (String)"Broker" ;
                userTemp.UserName       = getUserName();
                userTemp.PhoneNumber    = getPhoneNumber() ;
                userTemp.Password       = getPassword();
                return userTemp ;
            }
            public void UserLoginMenu()
            {
                User user = getUserCharacters() ;
                int subMenu = 0;

                if( user != null  )
                {
                    subMenu = getUserChoiceFromLogInMenu();

                    userLogin( user  , subMenu );

                }
                else
                    System.out.println("This user is not in the system\n");

            }

            public void printAllProperties( )
            {
                int i = 0 ;
                for ( i = 0; i < index ; i++)
                {
                    propertiesArray[i].ShowPropertyDetails();
                }
            }

            public void printProperties(  )
            {
                Scanner scanner = new Scanner(System.in);
                String userName = "";
                System.out.println("Please enter your user name : ");
                userName = scanner.next();
                int i = 0 ;
                for ( i = 0; i < index ; i ++)
                {
                    if (propertiesArray[i].TheUserThatPublishTheProperty == userName)
                    {
                        propertiesArray[i].ShowPropertyDetails();
                    }
                }
            }
            public  Property[] search()
            {
                Scanner scanner = new Scanner( System.in);
                int i = 0 ;
                int numberOfRoom ;
                int thePropertyIsForSaleOrRent ;
                int DesiredPriceRange ;
                int minimumPrice = 0 ;
                int maximumPrice = 0 ;
                Property []returnArray = new Property[10];
                int index = 0 ;
                System.out.println("Enter filter parameters to search for the desired property according to the following questions. Note that if you do not have a filter value insert 999");
                System.out.println("How many rooms?");
                numberOfRoom = scanner.nextInt();
                System.out.println("Desired Price Range");
                System.out.println("Minimum price :");
                minimumPrice = scanner.nextInt();
                System.out.println("Maximum price :");
                maximumPrice = scanner.nextInt();
                System.out.println("Is the property for sale or rent?\n 1- Sale\n 2- Rent");
                thePropertyIsForSaleOrRent = scanner.nextInt();
                for ( i = 0 ; i < index ; i++)
                {
                    if (    ( propertiesArray[i].BuyingOrRenting == thePropertyIsForSaleOrRent || thePropertyIsForSaleOrRent == 999) &&
                            ( propertiesArray[i].Price >= minimumPrice || minimumPrice == 999 ) &&
                            ( propertiesArray[i].Price <= maximumPrice || maximumPrice == 999 ) &&
                            ( propertiesArray[i].Room == numberOfRoom  || numberOfRoom == 999 )               )
                    {
                        propertiesArray[i].ShowPropertyDetails();
                        returnArray[index] = new Property(  propertiesArray[i].City , propertiesArray[i].Street ,
                                                            propertiesArray[i].HomeNumber , propertiesArray[i].FloorNumber ,
                                                            propertiesArray[i].Room ,propertiesArray[i].Kind ,
                                                            propertiesArray[i].Price ,propertiesArray[i].BuyingOrRenting ,
                                                            propertiesArray[i].TheUserThatPublishTheProperty , propertiesArray[i].PhoneNumber);
                        index++;

                     }
                }

                return returnArray;
            }

            public void removeProperty( )
            {
                Scanner scanner = new Scanner(System.in);
                String UserName = "";
                System.out.println("Please enter your user name : ");
                int [] arrayInt = new int[5];
                int i = 0 ;
                int j = 0 ;
                int deleteIndex = 0 ;
                int userNo = 0 ;
                for ( i = 0; i < index ; i ++)
                {
                    if (propertiesArray[i].TheUserThatPublishTheProperty == UserName)
                    {
                        arrayInt[j++] = i ;
                        propertiesArray[i].ShowPropertyDetails();
                    }
                }
                if (j == 0)
                {
                    System.out.printf( "No assets were found in the system published by you " );
                }
                System.out.printf( "Please enter number between 0 , %d" , j-1);
                userNo = scanner.nextInt();
                deleteIndex = arrayInt[userNo] ;

                propertiesArray[deleteIndex] = propertiesArray[propertyIndex];
                propertyIndex--;
            }

            public User checkIfUserExistInSystem( String UsrName , String password )
            {
                boolean res = false ;
                int i = 0 ;

                if( this.index == 0  ) {
                    System.out.println("There is no user in the system \n");
                    return null ;
                }

                for( i = 0 ; i < index ; i++ )
                {
                    if( ( userArray[i].UserName == UsrName ) && ( userArray[i].Password == password ))
                    {
                        res = true ;
                        break;
                    }
                }
                if( res )
                   return (  userArray[i] );

                return null ;
            }

            public User getUserCharacters( )
            {
                String UserName;
                String Password ;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your user name:");
                UserName = scanner.next();
                System.out.println("Enter your password :");
                Password = scanner.next();

                return checkIfUserExistInSystem( UserName , Password );
            }

            public int  getUserChoiceFromLogInMenu()
            {
                int userLogInChoice = 0 ;
                Scanner scanner = new Scanner(System.in);
                System.out.println( "Please enter your choice for continue use in the system \n");
                System.out.println( "To publish a new property press 1 \n");
                System.out.println( "To remove advertising on the property, press 2 \n" );
                System.out.println( "To display all assets in the system, press 3 \n");
                System.out.println( "To display all properties published by you, press 4 \n");
                System.out.println( "To search for a property by parameters, press 5 \n");
                System.out.println( "To log out and return to the main menu press 6 \n");
                userLogInChoice = scanner.nextInt();

                return userLogInChoice ;
            }
            public void printAllCitiesInSystem()
            {
                for( int i = 0 ; i < 10 ; i++ )
                {
                    System.out.println( CITIES[i] + "\n");
                }
            }

            public void printAllStreetsOfCity( String [] streetsArray )
            {
                for( int i = 0 ; i < 3 ; i++ )
                {
                    System.out.println( streetsArray[i] + "\n");
                }
            }


            public boolean GetAddressFromUser ( User user )
            {
                String cityUser = "";
                String Street = "" ;
                int propertyType = 0 ;
                int floor = 0 ;
//                int NoOfProperty = 0 ;
                int rentOrSell ;
                int price = 0 ;
                boolean res = false;
                int i = 0 ;
                int numOfRoom ;
                int numOfProperty ;
                int thePropertyIsForSaleOrRent ;
                int propertyPrice ;


                Scanner scanner = new Scanner( System.in );

                while ( true )
                {
                    printAllCitiesInSystem();
                    System.out.println("please Enter City name of your property from the list above : ");
                    cityUser = scanner.next();
                    for ( i = 0; i < 10; i++)
                    {
                        if (CITIES[i] == cityUser )
                        {
                            //UsrProperty.City = cityUser ;
                            res = true;
                            break;
                        }
                    }
                    if( res )
                        break;
                }
                while( true )
                {
                    printAllStreetsOfCity( citiesStreetsArray[i] );
                    System.out.println("please Enter Street name from the list above : ");
                    Street = scanner.next();
                    for (int j = 0; j < 10; j++)
                    {
                        if (citiesStreetsArray[i][j] == Street )
                        {
                            res = true;
                            break;
                        }
                    }
                    if( res )
                        break;
                }
                while( propertyType < 1 || propertyType > 3)
                {
                    System.out.println("please enter property Type  ( 1 - Home 2 - Building 3 - Penthouse  : ");
                    propertyType = scanner.nextInt();
                }
                if( propertyType == 2 )
                {
                    System.out.println("please enter floor No : ");
                    floor = scanner.nextInt();
                }

                System.out.println("How many rooms are there in the property?");
                numOfRoom = scanner.nextInt();
                System.out.println("What is the property number?");
                numOfProperty = scanner.nextInt();
                System.out.println("Is the property for sale or rent?\n 1- Sale\n 2- Rent");
                thePropertyIsForSaleOrRent = scanner.nextInt();
                System.out.println("What is the price of the property?");
                propertyPrice = scanner.nextInt();

                propertiesArray[propertyIndex] = new Property(cityUser , Street , numOfProperty, floor , numOfRoom ,
                        propertyType , propertyPrice , thePropertyIsForSaleOrRent , user.UserName , user.PhoneNumber );

//                propertiesArray[0].PropertyDetails(floor, numOfRoom , numOfProperty ,(String)thePropertyIsForSaleOrRent , propertyPrice );

                propertyIndex++ ;

                return true ;
            }


            public boolean checkPostLimit( User usr )
            {
                int postLimit = ( usr.BrokerOrUser == "Regular" ) ? 2 : 5 ;
                if (usr.NoOfAdvertise >= postLimit)
                {
                    System.out.println("you are not allow to advertise ");
                    return false ;
                }
                return true;
            }
            public boolean postNewProperty(User user ) {
                if (!checkPostLimit(user))
                    return false;

                return GetAddressFromUser(user);

            }

            public void userLogin( User logInUser , int userChoice )
            {

                switch( userChoice )
                {
                    case 1:
                        postNewProperty( logInUser );
                        break;
                    case 2:
                        removeProperty();
                        break;
                    case 3 :
                        printAllProperties( );
                        break;
                    case 4 :
                        printProperties( );
                        break;
                    case 5 :
                         search();
                        break;
                    case 6 :
                        //goToMainMenu();
                        break;
                    default :
                        break;
                }
            }

            public  String getUserName()
            {
                String userName;
                boolean res = true ;

                while( true ) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println(" Enter desired username :");
                    userName = scanner.next();
                    for (int i = 0; i < this.index; i++) {
                        if (userArray[i].UserName == userName) ;
                        {
                            res = false ;
                            System.out.println("this name already been use please choose different username :");
                            break;
                        }
                    }
                    if( res == true )
                        break;
                }
                return userName ;
            }

            public  String getPassword()
            {
                String password ="";
                boolean condition = false ;
                while( condition == false )
                {
                    System.out.println( " Please enter desired password.\n" + "Note, the password must be at least 5 characters long,"
                            + " and include at least one of the following characters: $ or % or _  " );
                    Scanner scanner = new Scanner(System.in);
                    password = scanner.next();
                    condition = isPasswordValid(password) ;

                }
                System.out.println(password);
                return password ;
            }


            public boolean isPasswordValid( String Password )
            {
                char[] charToSearch = {'%', '$', '_'};
                String matches = ("[a-zA-Z]+");
                boolean result = false ;
                boolean password_valid = false ;
                boolean res = true;
                int y = Password.length();
                Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");

                Matcher matcher = pattern.matcher(Password);
                result = matcher.matches();
/*                if (matcher.matches()) {
                    System.out.println("string '"+Password + "' contains at least one alphabets/letters");
                } else {
                    System.out.println("string '"+Password + "' doesn't contains any alphabets/letters value");
                }
*/
                password_valid =( (  Password.contains("$") || Password.contains("_") || Password.contains("%")) && result );

                if(  ( Password.length() < 5 ) || ( !password_valid ) )
                {
                    System.out.println("you have entered wrong password ");
                    res = false;
                }
                return res ;
            }


            public String getPhoneNumber()
            {
                boolean condition = false ;
                String phone = ""  ;
                while( condition == false ){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println( " Please enter your phone number :" ) ;
                    phone = scanner.next();
                    condition = isPhoneNumberValid (phone) ;

                }
                System.out.println(phone);
                return phone ;
            }

            public  boolean isPhoneNumberValid( String phoneNumber)
            {
                        boolean res = true ;

                        while (res = true)
                        {
                            int x = phoneNumber.length();
                            if (phoneNumber.length() != 10)
                            {
                                System.out.println("you have entered wrong phone Number ( length ) ");
                                res = false;
                                return res;
                            }
                            else
                            {
                                char[] stringArray = phoneNumber.toCharArray();
                                res = true;
                                //for ( int i = 0 ; i <= numberLength ; i++)
                                if (phoneNumber.length() == 10)
                                {
                                    if (stringArray[0] != '0' && stringArray[1] != '5')
                                    {
                                        res = false;
                                        return res;
                                    }
                                    else
                                    {
                                        stringArray[0] = 0;
                                        stringArray[1] = 5;

                                        res = true;
                                        for (int j = 2; j < 10; j++)
                                        {

                                            if (stringArray[j] < '0' || stringArray[j] > '9')
                                            {
                                                res = false;
                                                break;
                                            }
                                        }

                                    }
                                }
                                //System.out.println(phoneNumber);
                                break;
                            }
                        }
                        return res ;

            }



            public  int  userTitle()
            {
                int userTitle = 0 ;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your user title ( 1 - Regula 2 - Broker ) : " );
                userTitle = scanner.nextInt();
                return userTitle ;
            }


        }
