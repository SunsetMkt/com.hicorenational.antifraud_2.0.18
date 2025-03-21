package network;

import manager.AccountManager;
import util.C7313q1;
import util.C7328v1;

/* loaded from: classes2.dex */
public class BaseInfo extends BaseBean {
    private String appVersion;
    private String imei;

    /* renamed from: ip */
    private String f21432ip;

    /* renamed from: os */
    private int f21433os;
    private String osVersion;
    private String submitTime;
    private String submitterID;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getImei() {
        return this.imei;
    }

    public String getIp() {
        return this.f21432ip;
    }

    public int getOs() {
        return this.f21433os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public String getSubmitterID() {
        return this.submitterID;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCommonParams() {
        this.f21433os = 0;
        this.osVersion = C7328v1.m26668i();
        this.imei = C7328v1.m26674l();
        this.submitterID = AccountManager.getAccountId();
        this.submitTime = C7328v1.m26658d();
        this.appVersion = C7328v1.m26678o();
        this.f21432ip = C7313q1.m26531c();
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setIp(String str) {
        this.f21432ip = str;
    }

    public void setOs(int i2) {
        this.f21433os = i2;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setSubmitTime(String str) {
        this.submitTime = str;
    }

    public void setSubmitterID(String str) {
        this.submitterID = str;
    }
}
