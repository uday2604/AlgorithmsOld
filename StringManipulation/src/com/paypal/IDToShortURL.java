package com.paypal;

/**
 * Created by udaypersonal on 9/28/16.
 */
public class IDToShortURL {


    public String idToShortURL(int n)
    {
        // Map to store 62 possible characters
        String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder shorturl = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (n>0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map.charAt(n%62));
            n = n/62;
        }

        // Reverse shortURL to complete base conversion


        return shorturl.reverse().toString();
    }

    public static void main (String[] args) {


        IDToShortURL idToShortURL = new IDToShortURL();
        String res=idToShortURL.idToShortURL(55);
        System.out.println(res);
    }
}
