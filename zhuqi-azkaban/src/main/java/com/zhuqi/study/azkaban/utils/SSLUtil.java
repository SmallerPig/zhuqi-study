package com.zhuqi.study.azkaban.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public final class SSLUtil {

    private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[] { new X509TrustManager() {

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType)
        {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType)
        {
        }
    } };

    public static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException
    {
        final SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, UNQUESTIONING_TRUST_MANAGER, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException
    {
        SSLContext.getInstance("SSL").init(null, null, null);
    }

    private SSLUtil()
    {
        throw new UnsupportedOperationException("Do not instantiate libraries.");
    }
}
