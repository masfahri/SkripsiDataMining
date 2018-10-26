/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sayam
 */
public class ConfigTwitter {
    
    private static String ConsumerKey;
    private static String ConsumerSecret;
    private static String AccessToken;
    private static String AccessTokenSecret;

    public static String getConsumerKey() {
        return ConsumerKey;
    }

    public static void setConsumerKey(String ConsumerKey) {
        ConfigTwitter.ConsumerKey = ConsumerKey;
    }

    public static String getConsumerSecret() {
        return ConsumerSecret;
    }

    public static void setConsumerSecret(String ConsumerSecret) {
        ConfigTwitter.ConsumerSecret = ConsumerSecret;
    }

    public static String getAccessToken() {
        return AccessToken;
    }

    public static void setAccessToken(String AccessToken) {
        ConfigTwitter.AccessToken = AccessToken;
    }

    public static String getAccessTokenSecret() {
        return AccessTokenSecret;
    }

    public static void setAccessTokenSecret(String AccessTokenSecret) {
        ConfigTwitter.AccessTokenSecret = AccessTokenSecret;
    }
    
}
