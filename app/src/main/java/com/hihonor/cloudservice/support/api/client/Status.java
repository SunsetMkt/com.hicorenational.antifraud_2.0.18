package com.hihonor.cloudservice.support.api.client;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Status extends AbstractC2135a implements Parcelable {

    /* renamed from: b */
    private PendingIntent f6386b;

    /* renamed from: c */
    private Intent f6387c;

    /* renamed from: d */
    private int f6388d;

    /* renamed from: e */
    private String f6389e;

    /* renamed from: f */
    public static final Status f6377f = new Status(0);

    /* renamed from: g */
    public static final Status f6378g = new Status(1);

    /* renamed from: h */
    @Deprecated
    public static final Status f6379h = new Status(16);

    /* renamed from: i */
    @Deprecated
    public static final Status f6380i = new Status(18);

    /* renamed from: j */
    @Deprecated
    public static final Status f6381j = new Status(8);

    /* renamed from: k */
    @Deprecated
    public static final Status f6382k = new Status(14);

    /* renamed from: l */
    @Deprecated
    public static final Status f6383l = new Status(15);

    /* renamed from: m */
    public static final Status f6384m = new Status(TinkerReport.KEY_LOADED_SUCC_COST_OTHER);

    /* renamed from: n */
    public static final Status f6385n = new Status(500);
    public static final Parcelable.Creator<Status> CREATOR = new C2134a();

    /* renamed from: com.hihonor.cloudservice.support.api.client.Status$a */
    class C2134a implements Parcelable.Creator {
        C2134a() {
        }

        @Override // android.os.Parcelable.Creator
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public Status[] newArray(int i2) {
            return new Status[i2];
        }
    }

    public Status(int i2) {
        this(i2, null);
    }

    /* renamed from: a */
    private static boolean m6010a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // com.hihonor.cloudservice.support.api.client.AbstractC2135a
    /* renamed from: a */
    public Status mo6011a() {
        return this;
    }

    /* renamed from: b */
    public String m6012b() {
        StringBuilder sb = new StringBuilder();
        sb.append(m6013c());
        sb.append(": ");
        sb.append(m6014d() != null ? m6014d() : "");
        return sb.toString();
    }

    /* renamed from: c */
    public int m6013c() {
        return this.f6388d;
    }

    /* renamed from: d */
    public String m6014d() {
        return this.f6389e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public boolean m6015e() {
        return this.f6388d <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f6388d == status.f6388d && m6010a(this.f6389e, status.f6389e) && m6010a(this.f6386b, status.f6386b);
    }

    public int hashCode() {
        Object[] objArr = new Object[3];
        Object[] objArr2 = new Object[0];
        objArr2[0] = Integer.valueOf(this.f6388d);
        objArr2[1] = this.f6389e;
        objArr[2] = this.f6386b;
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return "{statusCode: " + this.f6388d + ", statusMessage: " + this.f6389e + ", pendingIntent: " + this.f6386b + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6388d);
        parcel.writeString(this.f6389e);
        PendingIntent pendingIntent = this.f6386b;
        if (pendingIntent != null) {
            pendingIntent.writeToParcel(parcel, i2);
        }
        PendingIntent.writePendingIntentOrNullToParcel(this.f6386b, parcel);
        if (this.f6387c != null) {
            writeToParcel(parcel, i2);
        }
    }

    public Status(int i2, String str) {
        this.f6388d = i2;
        this.f6389e = str;
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this.f6388d = i2;
        this.f6389e = str;
        this.f6386b = pendingIntent;
    }
}
