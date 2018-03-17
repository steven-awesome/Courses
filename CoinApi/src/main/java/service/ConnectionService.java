package service;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConnectionService {
    private org.apache.http.client.HttpClient client = new DefaultHttpClient();

    public enum Methods {
        POST ("POST"),
        PUT ("PUT"),
        GET ("GET");

        Methods(String method) {
        }
    }

    private String getSignature(long nonce) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        Mac mac = Mac.getInstance("HmacSHA256");
        String leftKey = String.valueOf(nonce) + "160549" + "SgAPEaueTd";
        byte[] hexkey = leftKey.getBytes("UTF-8");
        byte[] hexvlue = "61455e764f94c71bce141f9b0216763f".getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(hexkey, "HmacSHA256");
        mac.init(key);
        byte[] hmacValue;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        hmacValue = mac.doFinal(hexvlue);
        new BASE64Encoder().encode(new ByteArrayInputStream(hmacValue), outputStream);
        return outputStream.toString();
    }

    private String executePosst(String targetUrl) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        long nonce = new Date().getTime();
        String signature = getSignature(nonce);


        try{
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("key", "SgAPEaueTd"));
            //nameValuePairs.add(new BasicNameValuePair("signature", signature));
            HttpPost request = new HttpPost(targetUrl);
            request.setHeader("SgAPEaueTd", "61455e764f94c71bce141f9b0216763f");
            request.setEntity(new StringEntity("{\"key\":\"SgAPEaueTd\",\"nonce\":"+nonce+",\"signature\":\""+signature+"\"}"));
            request.addHeader("content-type", "application/json");
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null){
                sb.append(line);
            }

            System.out.println(sb.toString()
                    + "\n " + response.getStatusLine());
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }

    public void performGet(String targetUrl, Methods method) throws IOException {

        HttpGet get = new HttpGet(targetUrl);
        get.setHeader("SgAPEaueTd", "61455e764f94c71bce141f9b0216763f");
        HttpResponse response = client.execute(get);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null){
            sb.append(line);
        }

        System.out.println(sb.toString()
                + "\n " + response.getStatusLine());

    }

    public static void main(String[] args){
        ConnectionService connectionService = new ConnectionService();
        try {
            //connectionService.performGet("https://api.quadrigacx.com/v2/ticker?book=eth_cad", Methods.GET);
            connectionService.executePosst("https://api.quadrigacx.com/v2/balance");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
