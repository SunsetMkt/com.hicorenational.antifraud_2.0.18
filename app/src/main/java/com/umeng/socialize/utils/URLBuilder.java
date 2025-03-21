package com.umeng.socialize.utils;

import android.content.Context;
import android.os.Build;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;

/* loaded from: classes2.dex */
public class URLBuilder {
    private String imei;
    private String mac;
    private String model;

    /* renamed from: network, reason: collision with root package name */
    private String f25898network;

    /* renamed from: os */
    private String f13817os;
    private String protoversion;
    private String sdkversion;

    /* renamed from: ts */
    private String f13818ts;
    private String mReqType = "0";
    private String mHost = null;
    private String mPath = null;
    private String mAppkey = null;
    private String mEntityKey = null;
    private String mOpId = null;
    private String mUID = null;
    private String mSessionId = null;
    private String mPlatfrom = null;

    public URLBuilder(Context context) {
        this.imei = null;
        this.mac = null;
        this.f25898network = null;
        this.model = null;
        this.sdkversion = null;
        this.f13817os = null;
        this.f13818ts = null;
        this.protoversion = null;
        this.imei = DeviceConfig.getDeviceId(context);
        this.mac = DeviceConfig.getMac(context);
        this.f25898network = DeviceConfig.getNetworkAccessMode(context)[0];
        this.model = Build.MODEL;
        this.sdkversion = "7.3.2";
        this.f13817os = "Android";
        this.f13818ts = String.valueOf(System.currentTimeMillis());
        this.protoversion = SocializeConstants.PROTOCOL_VERSON;
    }

    private String buildParams() {
        StringBuilder sb = new StringBuilder();
        sb.append("via=");
        sb.append(this.mPlatfrom.toLowerCase());
        sb.append("&opid=");
        sb.append(this.mOpId);
        sb.append("&ak=");
        sb.append(this.mAppkey);
        sb.append("&pcv=");
        sb.append(this.protoversion);
        sb.append("&tp=");
        sb.append(this.mReqType);
        if (this.imei != null) {
            sb.append("&imei=");
            sb.append(this.imei);
        }
        if (this.mac != null) {
            sb.append("&mac=");
            sb.append(this.mac);
        }
        if (this.f25898network != null) {
            sb.append("&en=");
            sb.append(this.f25898network);
        }
        if (this.model != null) {
            sb.append("&de=");
            sb.append(this.model);
        }
        if (this.sdkversion != null) {
            sb.append("&sdkv=");
            sb.append(this.sdkversion);
        }
        if (this.f13817os != null) {
            sb.append("&os=");
            sb.append(this.f13817os);
        }
        if (this.f13818ts != null) {
            sb.append("&dt=");
            sb.append(this.f13818ts);
        }
        if (this.mUID != null) {
            sb.append("&uid=");
            sb.append(this.mUID);
        }
        if (this.mEntityKey != null) {
            sb.append("&ek=");
            sb.append(this.mEntityKey);
        }
        if (this.mSessionId != null) {
            sb.append("&sid=");
            sb.append(this.mSessionId);
        }
        return sb.toString();
    }

    public URLBuilder setAppkey(String str) {
        this.mAppkey = str;
        return this;
    }

    public URLBuilder setEntityKey(String str) {
        this.mEntityKey = str;
        return this;
    }

    public URLBuilder setHost(String str) {
        this.mHost = str;
        return this;
    }

    public URLBuilder setPath(String str) {
        this.mPath = str;
        return this;
    }

    /* renamed from: to */
    public String m12720to() {
        return this.mHost + this.mPath + this.mAppkey + "/" + this.mEntityKey + "/?" + buildParams();
    }

    public String toEncript() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mHost);
        sb.append(this.mPath);
        sb.append(this.mAppkey);
        sb.append("/");
        sb.append(this.mEntityKey);
        sb.append("/?");
        String buildParams = buildParams();
        try {
            sb.append(buildParams);
        } catch (Exception unused) {
            sb.append(buildParams);
        }
        return sb.toString();
    }

    public URLBuilder withMedia(SHARE_MEDIA share_media) {
        this.mPlatfrom = share_media.toString();
        return this;
    }

    public URLBuilder withOpId(String str) {
        this.mOpId = str;
        return this;
    }

    public URLBuilder withSessionId(String str) {
        this.mSessionId = str;
        return this;
    }

    public URLBuilder withUID(String str) {
        this.mUID = str;
        return this;
    }
}
