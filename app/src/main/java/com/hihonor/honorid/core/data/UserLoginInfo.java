package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class UserLoginInfo implements Parcelable {
    public static final Parcelable.Creator<UserLoginInfo> CREATOR = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4187i = "userID";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4188j = "registerTime";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4189k = "unRegisterTime";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4190l = "lastLoginTime";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4191m = "registerClientType";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4192n = "registerClientIP";
    public static final String o = "registerFrom";
    public static final String p = "lastLoginIP";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4199h;

    class a implements Parcelable.Creator<UserLoginInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserLoginInfo createFromParcel(Parcel parcel) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.f4199h = parcel.readString();
            userLoginInfo.f4195d = parcel.readString();
            userLoginInfo.f4197f = parcel.readString();
            userLoginInfo.f4196e = parcel.readString();
            userLoginInfo.f4198g = parcel.readString();
            userLoginInfo.f4193b = parcel.readString();
            userLoginInfo.f4194c = parcel.readString();
            userLoginInfo.a = parcel.readString();
            return userLoginInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserLoginInfo[] newArray(int i2) {
            return new UserLoginInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4199h);
        parcel.writeString(this.f4195d);
        parcel.writeString(this.f4197f);
        parcel.writeString(this.f4196e);
        parcel.writeString(this.f4198g);
        parcel.writeString(this.f4193b);
        parcel.writeString(this.f4194c);
        parcel.writeString(this.a);
    }

    public static void a(XmlPullParser xmlPullParser, UserLoginInfo userLoginInfo, String str) {
        if (xmlPullParser == null || userLoginInfo == null || str == null) {
            return;
        }
        if (f4187i.equals(str)) {
            userLoginInfo.h(xmlPullParser.nextText());
            return;
        }
        if (f4188j.equals(str)) {
            userLoginInfo.f(xmlPullParser.nextText());
            return;
        }
        if (f4189k.equals(str)) {
            userLoginInfo.g(xmlPullParser.nextText());
            return;
        }
        if (f4190l.equals(str)) {
            userLoginInfo.b(xmlPullParser.nextText());
            return;
        }
        if (f4191m.equals(str)) {
            userLoginInfo.d(xmlPullParser.nextText());
            return;
        }
        if (p.equals(str)) {
            userLoginInfo.a(xmlPullParser.nextText());
        } else if (f4192n.equals(str)) {
            userLoginInfo.c(xmlPullParser.nextText());
        } else if (o.equals(str)) {
            userLoginInfo.e(xmlPullParser.nextText());
        }
    }

    private void b(String str) {
        this.f4195d = str;
    }

    private void c(String str) {
        this.f4197f = str;
    }

    private void d(String str) {
        this.f4196e = str;
    }

    private void e(String str) {
        this.f4198g = str;
    }

    private void f(String str) {
        this.f4193b = str;
    }

    private void g(String str) {
        this.f4194c = str;
    }

    private void h(String str) {
        this.a = str;
    }

    private void a(String str) {
        this.f4199h = str;
    }
}
