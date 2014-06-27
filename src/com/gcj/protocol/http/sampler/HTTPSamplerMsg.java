package com.gcj.protocol.http.sampler;

/**
 * Created by gaochuanjun on 14-5-30.
 */
public class HTTPSamplerMsg {

    private String domain;

    private int port;

    private int connectTimeout;

    private int responseTimeout;

    private String protocol;

    private String contentEncoding;

    private String path;

    private String method;

    private boolean followRedirects;

    private boolean autoRedirects;

    private boolean doMultipartPost;

    private boolean monitor;

    private String embeddedUrlRe;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getResponseTimeout() {
        return responseTimeout;
    }

    public void setResponseTimeout(int responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    public void setFollowRedirects(boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    public boolean isAutoRedirects() {
        return autoRedirects;
    }

    public void setAutoRedirects(boolean autoRedirects) {
        this.autoRedirects = autoRedirects;
    }

    public boolean isDoMultipartPost() {
        return doMultipartPost;
    }

    public void setDoMultipartPost(boolean doMultipartPost) {
        this.doMultipartPost = doMultipartPost;
    }

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public String getEmbeddedUrlRe() {
        return embeddedUrlRe;
    }

    public void setEmbeddedUrlRe(String embeddedUrlRe) {
        this.embeddedUrlRe = embeddedUrlRe;
    }
}
