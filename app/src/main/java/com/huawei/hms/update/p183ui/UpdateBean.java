package com.huawei.hms.update.p183ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a */
    private boolean f7910a;

    /* renamed from: b */
    private boolean f7911b;

    /* renamed from: c */
    private String f7912c;

    /* renamed from: d */
    private int f7913d;

    /* renamed from: e */
    private String f7914e;

    /* renamed from: f */
    private String f7915f;

    /* renamed from: g */
    private ArrayList f7916g;

    /* renamed from: h */
    private boolean f7917h = true;

    /* renamed from: a */
    private static <T> T m7728a(T t) {
        return t;
    }

    public String getClientAppId() {
        return (String) m7728a(this.f7914e);
    }

    public String getClientAppName() {
        return (String) m7728a(this.f7915f);
    }

    public String getClientPackageName() {
        return (String) m7728a(this.f7912c);
    }

    public int getClientVersionCode() {
        return ((Integer) m7728a(Integer.valueOf(this.f7913d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f7911b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) m7728a(this.f7916g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) m7728a(Boolean.valueOf(this.f7910a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) m7728a(Boolean.valueOf(this.f7917h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f7914e = str;
    }

    public void setClientAppName(String str) {
        this.f7915f = str;
    }

    public void setClientPackageName(String str) {
        this.f7912c = str;
    }

    public void setClientVersionCode(int i2) {
        this.f7913d = i2;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.f7910a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.f7917h = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.f7911b = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f7916g = arrayList;
    }
}
