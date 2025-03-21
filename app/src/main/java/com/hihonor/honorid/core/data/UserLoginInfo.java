package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class UserLoginInfo implements Parcelable {
    public static final Parcelable.Creator<UserLoginInfo> CREATOR = new C2162a();

    /* renamed from: i */
    public static final String f6638i = "userID";

    /* renamed from: j */
    public static final String f6639j = "registerTime";

    /* renamed from: k */
    public static final String f6640k = "unRegisterTime";

    /* renamed from: l */
    public static final String f6641l = "lastLoginTime";

    /* renamed from: m */
    public static final String f6642m = "registerClientType";

    /* renamed from: n */
    public static final String f6643n = "registerClientIP";

    /* renamed from: o */
    public static final String f6644o = "registerFrom";

    /* renamed from: p */
    public static final String f6645p = "lastLoginIP";

    /* renamed from: a */
    private String f6646a;

    /* renamed from: b */
    private String f6647b;

    /* renamed from: c */
    private String f6648c;

    /* renamed from: d */
    private String f6649d;

    /* renamed from: e */
    private String f6650e;

    /* renamed from: f */
    private String f6651f;

    /* renamed from: g */
    private String f6652g;

    /* renamed from: h */
    private String f6653h;

    /* renamed from: com.hihonor.honorid.core.data.UserLoginInfo$a */
    class C2162a implements Parcelable.Creator<UserLoginInfo> {
        C2162a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserLoginInfo createFromParcel(Parcel parcel) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.f6653h = parcel.readString();
            userLoginInfo.f6649d = parcel.readString();
            userLoginInfo.f6651f = parcel.readString();
            userLoginInfo.f6650e = parcel.readString();
            userLoginInfo.f6652g = parcel.readString();
            userLoginInfo.f6647b = parcel.readString();
            userLoginInfo.f6648c = parcel.readString();
            userLoginInfo.f6646a = parcel.readString();
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
        parcel.writeString(this.f6653h);
        parcel.writeString(this.f6649d);
        parcel.writeString(this.f6651f);
        parcel.writeString(this.f6650e);
        parcel.writeString(this.f6652g);
        parcel.writeString(this.f6647b);
        parcel.writeString(this.f6648c);
        parcel.writeString(this.f6646a);
    }

    /* renamed from: a */
    public static void m6280a(XmlPullParser xmlPullParser, UserLoginInfo userLoginInfo, String str) {
        if (xmlPullParser == null || userLoginInfo == null || str == null) {
            return;
        }
        if (f6638i.equals(str)) {
            userLoginInfo.m6294h(xmlPullParser.nextText());
            return;
        }
        if (f6639j.equals(str)) {
            userLoginInfo.m6290f(xmlPullParser.nextText());
            return;
        }
        if (f6640k.equals(str)) {
            userLoginInfo.m6292g(xmlPullParser.nextText());
            return;
        }
        if (f6641l.equals(str)) {
            userLoginInfo.m6282b(xmlPullParser.nextText());
            return;
        }
        if (f6642m.equals(str)) {
            userLoginInfo.m6286d(xmlPullParser.nextText());
            return;
        }
        if (f6645p.equals(str)) {
            userLoginInfo.m6279a(xmlPullParser.nextText());
        } else if (f6643n.equals(str)) {
            userLoginInfo.m6284c(xmlPullParser.nextText());
        } else if (f6644o.equals(str)) {
            userLoginInfo.m6288e(xmlPullParser.nextText());
        }
    }

    /* renamed from: b */
    private void m6282b(String str) {
        this.f6649d = str;
    }

    /* renamed from: c */
    private void m6284c(String str) {
        this.f6651f = str;
    }

    /* renamed from: d */
    private void m6286d(String str) {
        this.f6650e = str;
    }

    /* renamed from: e */
    private void m6288e(String str) {
        this.f6652g = str;
    }

    /* renamed from: f */
    private void m6290f(String str) {
        this.f6647b = str;
    }

    /* renamed from: g */
    private void m6292g(String str) {
        this.f6648c = str;
    }

    /* renamed from: h */
    private void m6294h(String str) {
        this.f6646a = str;
    }

    /* renamed from: a */
    private void m6279a(String str) {
        this.f6653h = str;
    }
}
