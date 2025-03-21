package com.hihonor.honorid.core.helper.handler;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ErrorStatus implements Parcelable {

    /* renamed from: A */
    public static final int f6654A = 38;

    /* renamed from: B */
    public static final int f6655B = 39;

    /* renamed from: C */
    public static final int f6656C = 40;
    public static final Parcelable.Creator<ErrorStatus> CREATOR = new C2163a();

    /* renamed from: D */
    public static final int f6657D = 41;

    /* renamed from: E */
    public static final int f6658E = 42;

    /* renamed from: F */
    public static final int f6659F = 43;

    /* renamed from: G */
    public static final int f6660G = 44;

    /* renamed from: H */
    public static final int f6661H = 45;

    /* renamed from: I */
    public static final int f6662I = 46;

    /* renamed from: J */
    public static final int f6663J = 47;

    /* renamed from: K */
    public static final int f6664K = 48;

    /* renamed from: L */
    public static final int f6665L = 49;

    /* renamed from: M */
    public static final int f6666M = 50;

    /* renamed from: N */
    public static final int f6667N = 51;

    /* renamed from: O */
    public static final int f6668O = 53;

    /* renamed from: b0 */
    public static final int f6669b0 = 54;

    /* renamed from: c */
    public static final int f6670c = 5;

    /* renamed from: c0 */
    public static final int f6671c0 = 55;

    /* renamed from: d */
    public static final int f6672d = 6;

    /* renamed from: d0 */
    public static final int f6673d0 = 56;

    /* renamed from: e */
    public static final int f6674e = 12;

    /* renamed from: e0 */
    public static final int f6675e0 = 57;

    /* renamed from: f */
    public static final int f6676f = 13;

    /* renamed from: f0 */
    public static final int f6677f0 = 58;

    /* renamed from: g */
    public static final int f6678g = 15;

    /* renamed from: g0 */
    public static final int f6679g0 = 59;

    /* renamed from: h */
    public static final int f6680h = 17;

    /* renamed from: h0 */
    public static final int f6681h0 = 60;

    /* renamed from: i */
    public static final int f6682i = 19;

    /* renamed from: i0 */
    public static final int f6683i0 = 65;

    /* renamed from: j */
    public static final int f6684j = 20;

    /* renamed from: j0 */
    public static final int f6685j0 = 66;

    /* renamed from: k */
    public static final int f6686k = 21;

    /* renamed from: k0 */
    public static final int f6687k0 = 67;

    /* renamed from: l */
    public static final int f6688l = 22;

    /* renamed from: l0 */
    public static final int f6689l0 = 67;

    /* renamed from: m */
    public static final int f6690m = 23;

    /* renamed from: m0 */
    public static final int f6691m0 = 68;

    /* renamed from: n */
    public static final int f6692n = 24;

    /* renamed from: n0 */
    public static final int f6693n0 = 69;

    /* renamed from: o */
    public static final int f6694o = 25;

    /* renamed from: o0 */
    public static final int f6695o0 = 70;

    /* renamed from: p */
    public static final int f6696p = 26;

    /* renamed from: p0 */
    public static final int f6697p0 = 3004;

    /* renamed from: q */
    public static final int f6698q = 27;

    /* renamed from: q0 */
    public static final int f6699q0 = 3003;

    /* renamed from: r */
    public static final int f6700r = 28;

    /* renamed from: r0 */
    public static final int f6701r0 = 3002;

    /* renamed from: s */
    public static final int f6702s = 29;

    /* renamed from: s0 */
    public static final int f6703s0 = 1002;

    /* renamed from: t */
    public static final int f6704t = 30;

    /* renamed from: t0 */
    public static final String f6705t0 = "0";

    /* renamed from: u */
    public static final int f6706u = 31;

    /* renamed from: u0 */
    public static final String f6707u0 = "1";

    /* renamed from: v */
    public static final int f6708v = 32;

    /* renamed from: w */
    public static final int f6709w = 33;

    /* renamed from: x */
    public static final int f6710x = 34;

    /* renamed from: y */
    public static final int f6711y = 35;

    /* renamed from: z */
    public static final int f6712z = 37;

    /* renamed from: a */
    private int f6713a;

    /* renamed from: b */
    private String f6714b;

    /* renamed from: com.hihonor.honorid.core.helper.handler.ErrorStatus$a */
    class C2163a implements Parcelable.Creator<ErrorStatus> {
        C2163a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ErrorStatus createFromParcel(Parcel parcel) {
            ErrorStatus errorStatus = new ErrorStatus();
            errorStatus.f6713a = parcel.readInt();
            errorStatus.f6714b = parcel.readString();
            return errorStatus;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ErrorStatus[] newArray(int i2) {
            return new ErrorStatus[i2];
        }
    }

    public ErrorStatus() {
    }

    /* renamed from: b */
    public String m6298b() {
        return this.f6714b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[ErrorCode]:" + this.f6713a + "[DES]:" + this.f6714b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6713a);
        parcel.writeString(this.f6714b);
    }

    public ErrorStatus(int i2, String str) {
        this.f6713a = i2;
        this.f6714b = str;
    }

    /* renamed from: a */
    public int m6297a() {
        return this.f6713a;
    }
}
