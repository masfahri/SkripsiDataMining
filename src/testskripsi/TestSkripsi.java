/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testskripsi;

import java.util.List;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author sayam
 */
public class TestSkripsi {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {
        // Configuration
        ConfigurationBuilder cb =  new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("fiZtq8TJTHng1UUuWPCfivK08")
                .setOAuthConsumerSecret("SUrht0tOeMxk68xTQva9zgUSBgSLaZZXhRxnQv2BtoWg805wPB")
                .setOAuthAccessToken("968645356543082496-wwCcZ4lGTVYbAP2rVWB1d5RAI2iFl4k")
                .setOAuthAccessTokenSecret("jy8PCnpJgd1jMtrbAU5WMHwzww1hBjQixKHlcdz4hNBob");
        Double lat = -6.178306;
        Double lng = 106.631889;
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        Query query = new Query("Persija");
        
        QueryResult result = twitter.search(query);

//Get Tweets        
        for(Status st : result.getTweets()) {
            System.out.println("Username: "+st.getUser().getScreenName()+"\n");
            System.out.println("Name: "+st.getUser().getName()+"\n");
            System.out.println("Tweet: "+st.getText()+"\n");
            System.out.println("Tanggal Tweet: "+st.getCreatedAt()+"\n");
            System.out.println("Location Tweet: "+st.getUser().getLocation()+"\n");
            System.out.println("Language Tweet: "+st.getLang()+"\n");
            System.out.println("================================");
            
//            String sql = "INSERT into "
        }
    }
}
