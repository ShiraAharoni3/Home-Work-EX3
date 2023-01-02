    public class City
    {

        String Name ;
        String DistrictsName ;
        String []StreetsName = new String[3];


        public void CityDetails( String City_Name , String Districts_Name , String[] Street_Name )
        {
            Name = City_Name ;
            DistrictsName = Districts_Name ;
            StreetsName = Street_Name ;


        }
        void ShowCityDetails()
        {
          System.out.printf("City Name: %s\nDistricts Name:  %s\nStreet Name:  %s\n" , Name  , DistrictsName , StreetsName);

        }


    }
