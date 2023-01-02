import com.sun.source.tree.BreakTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
    {
        RealState stateMain = new RealState();

//       stateMain.getPassword();
//        stateMain.getUserName();
//        stateMain.getPassword();
//       stateMain.printAllProperties();

        int res = 1 ;
        while ( res == 1 )
        {

            int MenuOption = getUserChoice();
            switch ( MenuOption )
            {
                case 1 :
                    stateMain.userArray[stateMain.index] = stateMain.createUser();
                    stateMain.index += 1;
                break;
                case 2 :
                    stateMain.UserLoginMenu();
                    break ;
                case 3 :
                    res = 0 ;
                    break;
            }


        }
    }
    public static int getUserChoice()
    {
        int userChoice = 0 ;
        Scanner scanner = new Scanner(System.in);
        while ( true) {
            System.out.println(" Please enter your choice from the following: ");
            System.out.println(" 1- new account: ");
            System.out.println(" 2- sing in: ");
            System.out.println(" 3- exit : ");
            userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println(" Your choice is not valid ");
            }
            else
                break;
        }
            return userChoice ;
    }

}