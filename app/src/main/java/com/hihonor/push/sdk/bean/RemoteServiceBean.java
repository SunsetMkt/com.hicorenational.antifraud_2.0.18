package com.hihonor.push.sdk.bean;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes.dex */
public class RemoteServiceBean {
    private String packageAction;
    private String packageName;
    private String packageServiceName;
    private String packageSignature;

    public boolean checkServiceInfo() {
        return ((TextUtils.isEmpty(this.packageServiceName) && TextUtils.isEmpty(this.packageAction)) || TextUtils.isEmpty(this.packageName)) ? false : true;
    }

    public String getPackageAction() {
        return this.packageAction;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageServiceName() {
        return this.packageServiceName;
    }

    public String getPackageSignature() {
        return this.packageSignature;
    }

    public void setPackageAction(String str) {
        this.packageAction = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageServiceName(String str) {
        this.packageServiceName = str;
    }

    public void setPackageSignature(String str) {
        this.packageSignature = str;
    }

    public String toString() {
        return this.packageName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.packageAction + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.packageServiceName;
    }
}
