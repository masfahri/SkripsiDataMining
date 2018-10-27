/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appConfig;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static testskripsi.TestSkripsi.conn;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author sayam
 */
public class GetTweet {
    
    private StatusListener statusListener;
    private TwitterStream twitterStream;
    private ConfigurationBuilder configBuilder;
    private String clearStatus;
    
    private final String[] keywords = {
        "jokowi", 
        "maaruf amin", 
        "jokowi maaruf amin",
        "prabowo", 
        "sandiaga", 
        "prabowo sandi"
    };
    
    public void streamTwitter() throws TwitterException, SQLException {

    // twitter4j Config
        configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(ConfigApp.getConsumerKey())
                .setOAuthConsumerSecret(ConfigApp.getConsumerSecret())
                .setOAuthAccessToken(ConfigApp.getAccessToken())
                .setOAuthAccessTokenSecret(ConfigApp.getAccessTokenSecret())
                .setJSONStoreEnabled(true);
        
        // Twitter Listener
         statusListener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                try {
                    System.out.println("Username: "+status.getUser().getScreenName()+"\n");
                    System.out.println("Name: "+status.getUser().getName()+"\n");
                    System.out.println("Tweet: "+status.getText()+"\n");
                    System.out.println("Tanggal Tweet: "+status.getCreatedAt()+"\n");
                    System.out.println("Location Tweet: "+status.getUser().getLocation()+"\n");
                    System.out.println("Language Tweet: "+status.getLang()+"\n");
                    System.out.println("================================");
                    
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate("INSERT into tweet (id_user, username, nama, tweet, tgl_tweet, location_tweet, language_tweet) VALUES ('" 
                            + status.getId() + "','" 
                            + status.getUser().getScreenName() + "','" 
                            + status.getUser().getName() + "','" 
                            + status.getText() + "','" 
                            + status.getCreatedAt() + "','" 
                            + status.getUser().getLocation() + "','" 
                            + status.getLang() + "')");
                    Thread.sleep(20000);
                    //To change body of generated methods, choose Tools | Templates.
                } catch (SQLException | InterruptedException ex) {
                    Logger.getLogger(GetTweet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice sdn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onScrubGeo(long l, long l1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onStallWarning(StallWarning sw) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onException(Exception excptn) {
                try {
                    restartStream();
                } catch (TwitterException | SQLException ex) {
                    Logger.getLogger(GetTweet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        
        FilterQuery fq = new FilterQuery();
        fq.track(keywords);
        
        twitterStream = new TwitterStreamFactory(configBuilder.build()).getInstance();
        twitterStream.addListener(statusListener);
        twitterStream.filter(fq);  
    }
    
    public void stopStream() {
        twitterStream.removeListener(statusListener);
        twitterStream.shutdown();
        twitterStream = null;
    } 

    public void restartStream() throws TwitterException, SQLException {
        stopStream();
        streamTwitter();
    }
    
}
