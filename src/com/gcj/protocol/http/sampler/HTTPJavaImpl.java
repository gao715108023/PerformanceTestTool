package com.gcj.protocol.http.sampler;

import com.gcj.protocol.http.util.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HTTPJavaImpl extends HTTPAbstractImpl {

    private static final Log LOG = LogFactory.getLog(HTTPJavaImpl.class);

    private HTTPSamplerMsg[] httpSamplerMsgs;


    public HTTPJavaImpl() {
        // TODO Auto-generated constructor stub
    }

    protected URL setupURL(String domain, int port, String protocol, String path, List<String[]> arguments) throws UnsupportedEncodingException, MalformedURLException {
        StringBuilder sb = new StringBuilder();
        for (String[] argument : arguments) {
            sb.append(argument[0]).append("=").append(URLEncoder.encode(argument[1], HTTPConstants.CONTENTENCODING)).append("&");
        }
        sb.delete(sb.length() - 1, sb.length());
        String getURL = protocol + "://" + domain + ":" + port + path + "?" + sb.toString();
        return new URL(getURL);
    }

    protected HttpURLConnection setupConnection(URL u, String method) throws IOException {

        final HttpURLConnection conn;
        conn = (HttpURLConnection) u.openConnection();
        conn.setInstanceFollowRedirects(getAutoRedirects());
        int cto = getConnectTimeout();
        if (cto > 0) {
            conn.setConnectTimeout(cto);
        }
        int rto = getResponseTimeout();
        if (rto > 0) {
            conn.setReadTimeout(rto);
        }

        if (getUseKeepAlive()) {
            conn.setRequestProperty(HTTPConstants.HEADER_CONNECTION, HTTPConstants.KEEP_ALIVE);
        } else {
            conn.setRequestProperty(HTTPConstants.HEADER_CONNECTION, HTTPConstants.CONNECTION_CLOSE);
        }

        conn.setRequestMethod(method);

        return conn;
    }

    private void setConnectionHeaders(HttpURLConnection conn, URL u) {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HTTPSamplerMsg httpSamplerMsg = new HTTPSamplerMsg();
        httpSamplerMsg.setDomain("10.15.144.71");
        httpSamplerMsg.setPort(80);
        httpSamplerMsg.setProtocol("http");
        httpSamplerMsg.setContentEncoding("utf-8");
        httpSamplerMsg.setPath("/sys/v8/find");
        httpSamplerMsg.setMethod("GET");
        httpSamplerMsg.setFollowRedirects(true);
        httpSamplerMsg.setAutoRedirects(false);
        List<String[]> arguments = new ArrayList<String[]>();
        String[] argument = {"id", "v8_headline01_200000344891"};
        arguments.add(argument);
        HTTPJavaImpl httpJava = new HTTPJavaImpl();
        try {
            URL url = httpJava.setupURL(httpSamplerMsg.getDomain(), httpSamplerMsg.getPort(), httpSamplerMsg.getProtocol(), httpSamplerMsg.getPath(), arguments);
            LOG.info(url.toString());
            HttpURLConnection httpURLConnection = httpJava.setupConnection(url, httpSamplerMsg.getMethod());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}