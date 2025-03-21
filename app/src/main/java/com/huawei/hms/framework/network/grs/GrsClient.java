package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final C2359c grsClientGlobal;
    private int queryTimeout;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = C2360d.m6844a(grsBaseInfo, context);
        this.queryTimeout = grsBaseInfo.getQueryTimeout();
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        C2359c c2359c = this.grsClientGlobal;
        if (c2359c == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            c2359c.m6841a(str, str2, iQueryUrlCallBack, this.queryTimeout);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        C2359c c2359c = this.grsClientGlobal;
        if (c2359c == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            c2359c.m6840a(str, iQueryUrlsCallBack, this.queryTimeout);
        }
    }

    public void clearSp() {
        C2359c c2359c = this.grsClientGlobal;
        if (c2359c == null) {
            return;
        }
        c2359c.m6839a();
    }

    public boolean forceExpire() {
        C2359c c2359c = this.grsClientGlobal;
        if (c2359c == null) {
            return false;
        }
        return c2359c.m6843b();
    }

    public String synGetGrsUrl(String str, String str2) {
        C2359c c2359c = this.grsClientGlobal;
        return c2359c == null ? "" : c2359c.m6837a(str, str2, this.queryTimeout);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        C2359c c2359c = this.grsClientGlobal;
        return c2359c == null ? new HashMap() : c2359c.m6838a(str, this.queryTimeout);
    }
}
