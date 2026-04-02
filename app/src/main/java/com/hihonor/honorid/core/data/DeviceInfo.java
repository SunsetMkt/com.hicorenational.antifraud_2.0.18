package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.d.a.d;
import com.hihonor.honorid.f.b;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4114h = "deviceType";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4115i = "deviceID";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4116j = "uuid";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4117k = "terminalType";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4118l = "deviceAliasName";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4119m = "loginTime";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4120n = "logoutTime";
    public static final String o = "frequentlyUsed";
    public static final String p = "deviceInfo";
    public static final String q = "deviceIDList";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4126g = "";

    class a implements Parcelable.Creator<DeviceInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f4121b = parcel.readString();
            deviceInfo.f4123d = parcel.readString();
            deviceInfo.a = parcel.readString();
            deviceInfo.f4122c = parcel.readString();
            deviceInfo.f4124e = parcel.readString();
            deviceInfo.f4125f = parcel.readString();
            deviceInfo.f4126g = parcel.readString();
            return deviceInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i2) {
            return new DeviceInfo[i2];
        }
    }

    public DeviceInfo(String str, String str2, String str3) {
        this.a = str;
        this.f4121b = str2;
        this.f4122c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean h() {
        return TextUtils.isEmpty(this.f4125f) && !TextUtils.isEmpty(this.f4124e);
    }

    public String toString() {
        return "{'mDeviceAliasName':" + d.a(this.f4123d) + ",'mDeviceId':" + d.a(this.f4121b) + ",'mTerminalType':" + this.f4122c + ",'mDeviceType':" + this.a + ",'mLoginTime':" + this.f4124e + ",'mLogoutTime':" + this.f4125f + ",'mFrequentlyUsed':" + this.f4126g + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4121b);
        parcel.writeString(this.f4123d);
        parcel.writeString(this.a);
        parcel.writeString(this.f4122c);
        parcel.writeString(this.f4124e);
        parcel.writeString(this.f4125f);
        parcel.writeString(this.f4126g);
    }

    public String a() {
        return this.f4123d;
    }

    public String b() {
        return this.f4121b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f4122c;
    }

    public String e() {
        return this.f4126g;
    }

    public String f() {
        return this.f4124e;
    }

    public String g() {
        return this.f4125f;
    }

    public static void a(XmlPullParser xmlPullParser, DeviceInfo deviceInfo, String str) {
        if (xmlPullParser == null || deviceInfo == null || str == null) {
            return;
        }
        if (f4115i.equals(str)) {
            deviceInfo.b(xmlPullParser.nextText());
            return;
        }
        if ("deviceType".equals(str)) {
            deviceInfo.c(xmlPullParser.nextText());
            return;
        }
        if ("terminalType".equals(str)) {
            deviceInfo.d(xmlPullParser.nextText());
            return;
        }
        if (f4118l.equals(str)) {
            deviceInfo.a(xmlPullParser.nextText());
            return;
        }
        if (f4119m.equals(str)) {
            deviceInfo.f(xmlPullParser.nextText());
        } else if (f4120n.equals(str)) {
            deviceInfo.g(xmlPullParser.nextText());
        } else if (o.equals(str)) {
            deviceInfo.e(xmlPullParser.nextText());
        }
    }

    public void b(String str) {
        this.f4121b = str;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.f4122c = str;
    }

    public void e(String str) {
        this.f4126g = str;
    }

    public void f(String str) {
        this.f4124e = str;
    }

    public void g(String str) {
        this.f4125f = str;
    }

    public DeviceInfo() {
    }

    public boolean a(Object obj) {
        if (obj != null && (obj instanceof DeviceInfo)) {
            if (obj == this) {
                return true;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            if (b.a(this.f4123d, deviceInfo.f4123d) && b.a(this.f4121b, deviceInfo.f4121b) && b.a(this.f4122c, deviceInfo.f4122c) && b.a(this.a, deviceInfo.a)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        this.f4123d = str;
    }
}
