package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.p162d.p163a.C2167d;
import com.hihonor.honorid.p165f.C2172b;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new C2155a();

    /* renamed from: h */
    public static final String f6509h = "deviceType";

    /* renamed from: i */
    public static final String f6510i = "deviceID";

    /* renamed from: j */
    public static final String f6511j = "uuid";

    /* renamed from: k */
    public static final String f6512k = "terminalType";

    /* renamed from: l */
    public static final String f6513l = "deviceAliasName";

    /* renamed from: m */
    public static final String f6514m = "loginTime";

    /* renamed from: n */
    public static final String f6515n = "logoutTime";

    /* renamed from: o */
    public static final String f6516o = "frequentlyUsed";

    /* renamed from: p */
    public static final String f6517p = "deviceInfo";

    /* renamed from: q */
    public static final String f6518q = "deviceIDList";

    /* renamed from: a */
    private String f6519a;

    /* renamed from: b */
    private String f6520b;

    /* renamed from: c */
    private String f6521c;

    /* renamed from: d */
    private String f6522d;

    /* renamed from: e */
    private String f6523e;

    /* renamed from: f */
    private String f6524f;

    /* renamed from: g */
    private String f6525g = "";

    /* renamed from: com.hihonor.honorid.core.data.DeviceInfo$a */
    class C2155a implements Parcelable.Creator<DeviceInfo> {
        C2155a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f6520b = parcel.readString();
            deviceInfo.f6522d = parcel.readString();
            deviceInfo.f6519a = parcel.readString();
            deviceInfo.f6521c = parcel.readString();
            deviceInfo.f6523e = parcel.readString();
            deviceInfo.f6524f = parcel.readString();
            deviceInfo.f6525g = parcel.readString();
            return deviceInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i2) {
            return new DeviceInfo[i2];
        }
    }

    public DeviceInfo(String str, String str2, String str3) {
        this.f6519a = str;
        this.f6520b = str2;
        this.f6521c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: h */
    public boolean m6129h() {
        return TextUtils.isEmpty(this.f6524f) && !TextUtils.isEmpty(this.f6523e);
    }

    public String toString() {
        return "{'mDeviceAliasName':" + C2167d.m6309a(this.f6522d) + ",'mDeviceId':" + C2167d.m6309a(this.f6520b) + ",'mTerminalType':" + this.f6521c + ",'mDeviceType':" + this.f6519a + ",'mLoginTime':" + this.f6523e + ",'mLogoutTime':" + this.f6524f + ",'mFrequentlyUsed':" + this.f6525g + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6520b);
        parcel.writeString(this.f6522d);
        parcel.writeString(this.f6519a);
        parcel.writeString(this.f6521c);
        parcel.writeString(this.f6523e);
        parcel.writeString(this.f6524f);
        parcel.writeString(this.f6525g);
    }

    /* renamed from: a */
    public String m6114a() {
        return this.f6522d;
    }

    /* renamed from: b */
    public String m6117b() {
        return this.f6520b;
    }

    /* renamed from: c */
    public String m6119c() {
        return this.f6519a;
    }

    /* renamed from: d */
    public String m6121d() {
        return this.f6521c;
    }

    /* renamed from: e */
    public String m6123e() {
        return this.f6525g;
    }

    /* renamed from: f */
    public String m6125f() {
        return this.f6523e;
    }

    /* renamed from: g */
    public String m6127g() {
        return this.f6524f;
    }

    /* renamed from: a */
    public static void m6107a(XmlPullParser xmlPullParser, DeviceInfo deviceInfo, String str) {
        if (xmlPullParser == null || deviceInfo == null || str == null) {
            return;
        }
        if (f6510i.equals(str)) {
            deviceInfo.m6118b(xmlPullParser.nextText());
            return;
        }
        if ("deviceType".equals(str)) {
            deviceInfo.m6120c(xmlPullParser.nextText());
            return;
        }
        if ("terminalType".equals(str)) {
            deviceInfo.m6122d(xmlPullParser.nextText());
            return;
        }
        if (f6513l.equals(str)) {
            deviceInfo.m6115a(xmlPullParser.nextText());
            return;
        }
        if (f6514m.equals(str)) {
            deviceInfo.m6126f(xmlPullParser.nextText());
        } else if (f6515n.equals(str)) {
            deviceInfo.m6128g(xmlPullParser.nextText());
        } else if (f6516o.equals(str)) {
            deviceInfo.m6124e(xmlPullParser.nextText());
        }
    }

    /* renamed from: b */
    public void m6118b(String str) {
        this.f6520b = str;
    }

    /* renamed from: c */
    public void m6120c(String str) {
        this.f6519a = str;
    }

    /* renamed from: d */
    public void m6122d(String str) {
        this.f6521c = str;
    }

    /* renamed from: e */
    public void m6124e(String str) {
        this.f6525g = str;
    }

    /* renamed from: f */
    public void m6126f(String str) {
        this.f6523e = str;
    }

    /* renamed from: g */
    public void m6128g(String str) {
        this.f6524f = str;
    }

    public DeviceInfo() {
    }

    /* renamed from: a */
    public boolean m6116a(Object obj) {
        if (obj != null && (obj instanceof DeviceInfo)) {
            if (obj == this) {
                return true;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            if (C2172b.m6329a(this.f6522d, deviceInfo.f6522d) && C2172b.m6329a(this.f6520b, deviceInfo.f6520b) && C2172b.m6329a(this.f6521c, deviceInfo.f6521c) && C2172b.m6329a(this.f6519a, deviceInfo.f6519a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m6115a(String str) {
        this.f6522d = str;
    }
}
