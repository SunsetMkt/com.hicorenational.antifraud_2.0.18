package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UpdateBean implements Serializable {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f4971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4972h = true;

    private static <T> T a(T t) {
        return t;
    }

    public String getClientAppId() {
        return (String) a(this.f4969e);
    }

    public String getClientAppName() {
        return (String) a(this.f4970f);
    }

    public String getClientPackageName() {
        return (String) a(this.f4967c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f4968d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f4966b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f4971g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f4972h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f4969e = str;
    }

    public void setClientAppName(String str) {
        this.f4970f = str;
    }

    public void setClientPackageName(String str) {
        this.f4967c = str;
    }

    public void setClientVersionCode(int i2) {
        this.f4968d = i2;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.f4972h = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.f4966b = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f4971g = arrayList;
    }
}
