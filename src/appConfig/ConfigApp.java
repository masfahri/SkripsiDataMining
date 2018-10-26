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
    private static String consumerToken;
    private static String consumerTokenSecret;
    private static String tweetDummy;

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

    public static String getConsumerToken() {
        return consumerToken;
    }

    public static void setConsumerToken(String consumerToken) {
        ConfigApp.consumerToken = consumerToken;
    }

    public static String getConsumerTokenSecret() {
        return consumerTokenSecret;
    }

    public static void setConsumerTokenSecret(String consumerTokenSecret) {
        ConfigApp.consumerTokenSecret = consumerTokenSecret;
    }

    public static String getTweetDummy() {
        return tweetDummy;
    }

    public static void setTweetDummy(String tweetDummy) {
        ConfigApp.tweetDummy = tweetDummy;
    }
    
    
    
}
