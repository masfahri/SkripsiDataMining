/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testskripsi;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import static testskripsi.TestSkripsi.conn;

/**
 *
 * @author sayam
 */
public class ConvertDate {
    
    public static void main(String[] args) {
//        nomor();
    }
    
    public static void ConvertDate() {
        try {
            String[] tempPesanMasuk;
            ArrayList arrDate = new ArrayList();
            Date date;
            Locale lokal = Locale.US;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", lokal);
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tweet_dummy");
            String tanggal, partTanggal, partTahun, fullTanggal, id, tweet, user;
            String partBulan = "";
            String bulan = "Bulan Jan Feb Mar Apr Mei Jun Jul Ags Sep Okt Nov Des";
            String[] splitBulan = bulan.split(" ");
            int angka = 0;
            
            while(rs.next()) {
                tanggal = rs.getString("waktu");
                id = rs.getString("id");
                tanggal = rs.getString("waktu");
                id = rs.getString("user");
                tweet = rs.getString("tweet");
                
                tempPesanMasuk = tanggal.split(" ");
                partTanggal = tempPesanMasuk[2];
                partTahun = tempPesanMasuk[5];
                
                for (int i = 1; i < splitBulan.length; i++) {
                    if (splitBulan[i].equals(tempPesanMasuk[1])) {
                        partBulan = Integer.toString(i);
                    }
                }
                
                fullTanggal = partTahun + "-" + partBulan + "-" + partTanggal;
                date = sdf.parse(fullTanggal);
                System.out.println(sdf.format(date));
            }
            
        } catch (Exception e) {
            
        }
    }

    private static void nomor() {
        
    }
    
}
