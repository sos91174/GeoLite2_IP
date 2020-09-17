import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;



public class IP {

    public static void main(String[] args) {

        // IP V4
        String ip = "113.87.18.136";
        // IP V6 也可以的
        DatabaseReader reader = null;
        CityResponse response = null;
        try {
            File database = new File("D:\\Downloads\\GeoLite2-City_20200915\\GeoLite2-City.mmdb");
            // 讀取數據庫內容
            reader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            // 讀取查詢內容
            response = reader.city(ipAddress);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

        }
    }
}