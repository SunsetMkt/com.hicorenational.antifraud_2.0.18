package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.p165f.C2172b;
import com.hihonor.honorid.p165f.C2173c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class UserAccountInfo implements Parcelable {
    public static final Parcelable.Creator<UserAccountInfo> CREATOR = new C2160a();

    /* renamed from: j */
    public static final String f6578j = "userAccount";

    /* renamed from: k */
    public static final String f6579k = "accountType";

    /* renamed from: l */
    public static final String f6580l = "accountState";

    /* renamed from: m */
    public static final String f6581m = "accountValidStatus";

    /* renamed from: n */
    public static final String f6582n = "updateTime";

    /* renamed from: o */
    public static final String f6583o = "userAcctInfo";

    /* renamed from: p */
    public static final String f6584p = "userAcctInfoList";

    /* renamed from: q */
    public static final String f6585q = "memberRight";

    /* renamed from: r */
    public static final String f6586r = "memberRightList";

    /* renamed from: s */
    public static final String f6587s = "userEMail";

    /* renamed from: t */
    public static final String f6588t = "mobilePhone";

    /* renamed from: u */
    public static final String f6589u = "emailState";

    /* renamed from: v */
    public static final String f6590v = "mobilePhoneState";

    /* renamed from: w */
    public static final String f6591w = "age";

    /* renamed from: a */
    private String f6592a;

    /* renamed from: b */
    private String f6593b;

    /* renamed from: c */
    private String f6594c;

    /* renamed from: d */
    private String f6595d;

    /* renamed from: e */
    private String f6596e;

    /* renamed from: f */
    private String f6597f;

    /* renamed from: g */
    private String f6598g;

    /* renamed from: h */
    private String f6599h;

    /* renamed from: i */
    private String f6600i;

    /* renamed from: com.hihonor.honorid.core.data.UserAccountInfo$a */
    class C2160a implements Parcelable.Creator<UserAccountInfo> {
        C2160a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountInfo createFromParcel(Parcel parcel) {
            UserAccountInfo userAccountInfo = new UserAccountInfo();
            userAccountInfo.f6592a = parcel.readString();
            userAccountInfo.f6593b = parcel.readString();
            userAccountInfo.f6594c = parcel.readString();
            userAccountInfo.f6595d = parcel.readString();
            userAccountInfo.f6596e = parcel.readString();
            userAccountInfo.f6597f = parcel.readString();
            userAccountInfo.f6598g = parcel.readString();
            userAccountInfo.f6599h = parcel.readString();
            userAccountInfo.f6600i = parcel.readString();
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
        parcel.writeString(this.f6592a);
        parcel.writeString(this.f6593b);
        parcel.writeString(this.f6594c);
        parcel.writeString(this.f6595d);
        parcel.writeString(this.f6596e);
        parcel.writeString(this.f6597f);
        parcel.writeString(this.f6598g);
        parcel.writeString(this.f6599h);
        parcel.writeString(this.f6600i);
    }

    /* renamed from: d */
    private void m6220d(String str) {
        this.f6595d = str;
    }

    /* renamed from: e */
    private void m6222e(String str) {
        this.f6598g = str;
    }

    /* renamed from: f */
    private void m6224f(String str) {
        this.f6600i = str;
    }

    /* renamed from: g */
    private void m6226g(String str) {
        this.f6596e = str;
    }

    /* renamed from: h */
    private void m6228h(String str) {
        this.f6597f = str;
    }

    /* renamed from: i */
    private void m6230i(String str) {
        this.f6599h = str;
    }

    /* renamed from: a */
    public String m6231a() {
        return this.f6594c;
    }

    /* renamed from: b */
    public String m6234b() {
        return this.f6592a;
    }

    /* renamed from: c */
    public String m6236c() {
        return this.f6593b;
    }

    /* renamed from: a */
    public static void m6215a(XmlPullParser xmlPullParser, UserAccountInfo userAccountInfo, String str) {
        if (xmlPullParser == null || userAccountInfo == null || str == null) {
            return;
        }
        if (f6580l.equals(str)) {
            userAccountInfo.m6232a(xmlPullParser.nextText());
            return;
        }
        if ("accountType".equals(str)) {
            userAccountInfo.m6235b(xmlPullParser.nextText());
            return;
        }
        if (f6581m.equals(str)) {
            userAccountInfo.m6220d(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userAccountInfo.m6226g(xmlPullParser.nextText());
            return;
        }
        if ("userAccount".equals(str)) {
            userAccountInfo.m6237c(xmlPullParser.nextText());
            return;
        }
        if (f6587s.equals(str)) {
            userAccountInfo.m6228h(xmlPullParser.nextText());
            return;
        }
        if (f6588t.equals(str)) {
            userAccountInfo.m6222e(xmlPullParser.nextText());
        } else if (f6589u.equals(str)) {
            userAccountInfo.m6230i(xmlPullParser.nextText());
        } else if (f6590v.equals(str)) {
            userAccountInfo.m6224f(xmlPullParser.nextText());
        }
    }

    /* renamed from: b */
    public void m6235b(String str) {
        this.f6592a = str;
    }

    /* renamed from: c */
    public void m6237c(String str) {
        this.f6593b = str;
    }

    /* renamed from: a */
    public boolean m6233a(Object obj) {
        if (obj != null && (obj instanceof UserAccountInfo)) {
            return this == obj || C2172b.m6329a(this.f6598g, ((UserAccountInfo) obj).f6598g);
        }
        return false;
    }

    /* renamed from: a */
    public void m6232a(String str) {
        this.f6594c = str;
    }

    /* renamed from: a */
    public static void m6216a(XmlSerializer xmlSerializer, UserAccountInfo userAccountInfo) {
        if (xmlSerializer == null || userAccountInfo == null) {
            return;
        }
        C2173c.m6330a(xmlSerializer, "accountType", userAccountInfo.m6234b());
        C2173c.m6330a(xmlSerializer, "userAccount", userAccountInfo.m6236c());
    }
}
