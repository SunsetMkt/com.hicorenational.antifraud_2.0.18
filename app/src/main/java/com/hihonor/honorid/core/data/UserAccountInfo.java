package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.f.b;
import com.hihonor.honorid.f.c;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class UserAccountInfo implements Parcelable {
    public static final Parcelable.Creator<UserAccountInfo> CREATOR = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4161j = "userAccount";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4162k = "accountType";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4163l = "accountState";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4164m = "accountValidStatus";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4165n = "updateTime";
    public static final String o = "userAcctInfo";
    public static final String p = "userAcctInfoList";
    public static final String q = "memberRight";
    public static final String r = "memberRightList";
    public static final String s = "userEMail";
    public static final String t = "mobilePhone";
    public static final String u = "emailState";
    public static final String v = "mobilePhoneState";
    public static final String w = "age";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4173i;

    class a implements Parcelable.Creator<UserAccountInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountInfo createFromParcel(Parcel parcel) {
            UserAccountInfo userAccountInfo = new UserAccountInfo();
            userAccountInfo.a = parcel.readString();
            userAccountInfo.f4166b = parcel.readString();
            userAccountInfo.f4167c = parcel.readString();
            userAccountInfo.f4168d = parcel.readString();
            userAccountInfo.f4169e = parcel.readString();
            userAccountInfo.f4170f = parcel.readString();
            userAccountInfo.f4171g = parcel.readString();
            userAccountInfo.f4172h = parcel.readString();
            userAccountInfo.f4173i = parcel.readString();
            return userAccountInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountInfo[] newArray(int i2) {
            return new UserAccountInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4166b);
        parcel.writeString(this.f4167c);
        parcel.writeString(this.f4168d);
        parcel.writeString(this.f4169e);
        parcel.writeString(this.f4170f);
        parcel.writeString(this.f4171g);
        parcel.writeString(this.f4172h);
        parcel.writeString(this.f4173i);
    }

    private void d(String str) {
        this.f4168d = str;
    }

    private void e(String str) {
        this.f4171g = str;
    }

    private void f(String str) {
        this.f4173i = str;
    }

    private void g(String str) {
        this.f4169e = str;
    }

    private void h(String str) {
        this.f4170f = str;
    }

    private void i(String str) {
        this.f4172h = str;
    }

    public String a() {
        return this.f4167c;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f4166b;
    }

    public static void a(XmlPullParser xmlPullParser, UserAccountInfo userAccountInfo, String str) {
        if (xmlPullParser == null || userAccountInfo == null || str == null) {
            return;
        }
        if (f4163l.equals(str)) {
            userAccountInfo.a(xmlPullParser.nextText());
            return;
        }
        if ("accountType".equals(str)) {
            userAccountInfo.b(xmlPullParser.nextText());
            return;
        }
        if (f4164m.equals(str)) {
            userAccountInfo.d(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userAccountInfo.g(xmlPullParser.nextText());
            return;
        }
        if ("userAccount".equals(str)) {
            userAccountInfo.c(xmlPullParser.nextText());
            return;
        }
        if (s.equals(str)) {
            userAccountInfo.h(xmlPullParser.nextText());
            return;
        }
        if (t.equals(str)) {
            userAccountInfo.e(xmlPullParser.nextText());
        } else if (u.equals(str)) {
            userAccountInfo.i(xmlPullParser.nextText());
        } else if (v.equals(str)) {
            userAccountInfo.f(xmlPullParser.nextText());
        }
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.f4166b = str;
    }

    public boolean a(Object obj) {
        if (obj != null && (obj instanceof UserAccountInfo)) {
            return this == obj || b.a(this.f4171g, ((UserAccountInfo) obj).f4171g);
        }
        return false;
    }

    public void a(String str) {
        this.f4167c = str;
    }

    public static void a(XmlSerializer xmlSerializer, UserAccountInfo userAccountInfo) throws IOException {
        if (xmlSerializer == null || userAccountInfo == null) {
            return;
        }
        c.a(xmlSerializer, "accountType", userAccountInfo.b());
        c.a(xmlSerializer, "userAccount", userAccountInfo.c());
    }
}
