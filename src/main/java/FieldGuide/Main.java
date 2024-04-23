package FieldGuide;

import FieldGuide.model.User;
import FieldGuide.command.*;

public class Main 
{
    public static void main( String[] args ) {
        System.out.println(
        "___           _         _____ _      _     _    ____       _     _      " + "\n" +
        "|_ _|_ __   __| |_   _  |  ___(_) ___| | __| |  / ___|_   _(_) __| | ___ " + "\n" +
        " | || '_ \\ / _` | | | | | |_  | |/ _ \\ |/ _` | | |  _| | | | |/ _` |/ _ \\" + "\n" +
        " | || | | | (_| | |_| | |  _| | |  __/ | (_| | | |_| | |_| | | (_| |  __/" + "\n" +
        "|___|_| |_|\\__,_|\\__, | |_|   |_|\\___|_|\\__,_|  \\____|\\__,_|_|\\__,_|\\___|" + "\n" +
        "                 |___/                                                   "
        );
        
        UserMenu userMenu = new UserMenu();
        User authenticatedUser;
        do {
            authenticatedUser = userMenu.handleMenu();
            if (authenticatedUser != null) {
                AuthenticatedUser authUser = new AuthenticatedUser(authenticatedUser);
                authUser.displayMenu();
            }
        } while (authenticatedUser != null);
    }
}
