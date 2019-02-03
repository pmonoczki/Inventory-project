/**
 * @author Pal Monoczki
 * @version 1.0
 */

package com.codecool;

/**
 * Lods the inventory project
 *
 * @param args controls the program by arguments
 */
public class Main {
    public static void main(String[] args) {


        try {
            System.out.println(
                    System.getProperty("user.dir"));

            PersistentStore ps = new PersistentStore();
            StoreManager sm = new StoreManager();
            DBStore ds = new DBStore();

            sm.addStorage(ds);

            sm.addBookProduct("test", 1500, 142);


            System.out.println(sm.listProducts());
        } catch (NoStorageException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }
}







