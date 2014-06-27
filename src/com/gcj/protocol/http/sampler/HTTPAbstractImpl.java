package com.gcj.protocol.http.sampler;

/**
 * Created by gaochuanjun on 14-5-30.
 */
public abstract class HTTPAbstractImpl {

    protected boolean getAutoRedirects() {

        return false;
    }

    protected int getConnectTimeout() {

        return 0;
    }

    protected int getResponseTimeout() {

        return 0;
    }

    protected boolean getUseKeepAlive() {
        return true;
    }
}
