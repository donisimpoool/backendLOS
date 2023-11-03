package com.ikkat.los.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HTTPSCertifiedHelper {
	
	public static URI trustedURL(String strurl) {
	TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };
	
	
	 try {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	 }catch (Exception e) {
         e.printStackTrace();
     }
	 
		// Now you can access an https URL without having the certificate in the truststore
	     try {
	    	 URI url = new URI(strurl);
	         System.out.println("HTTPS URL Status : does not have the certificate in the truststore");
	         return url;
	     } catch (URISyntaxException e) {
	         e.printStackTrace();
	     }
	     return null;
	}
    
}
