/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appConfig;

/**
 *
 * @author sayamasfahri
 */
public class ConfigApp {
    
    private static String consumerKey;
    private static String consumerSecret;
    private static String AccessToken;
    private static String AccessTokenSecret;

    public static String getConsumerKey() {
        return consumerKey;
    }

    public static void setConsumerKey(String consumerKey) {
        ConfigApp.consumerKey = consumerKey;
    }

    public static String getConsumerSecret() {
        return consumerSecret;
    }

    public static void setConsumerSecret(String consumerSecret) {
        ConfigApp.consumerSecret = consumerSecret;
    }

    public static String getAccessToken() {
        return AccessToken;
    }

    public static void setAccessToken(String AccessToken) {
        ConfigApp.AccessToken = AccessToken;
    }

    public static String getAccessTokenSecret() {
        return AccessTokenSecret;
    }

    public static void setAccessTokenSecret(String AccessTokenSecret) {
        ConfigApp.AccessTokenSecret = AccessTokenSecret;
    }

    public static String getTweetDummy() {
        return tweetDummy;
    }

    public static void setTweetDummy(String tweetDummy) {
        ConfigApp.tweetDummy = tweetDummy;
    }
    private static String tweetDummy;

    
    
    
    
}
