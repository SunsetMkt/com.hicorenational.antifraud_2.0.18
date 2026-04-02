package com.hihonor.honorid.core.helper.handler;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ErrorStatus implements Parcelable {
    public static final int A = 38;
    public static final int B = 39;
    public static final int C = 40;
    public static final Parcelable.Creator<ErrorStatus> CREATOR = new a();
    public static final int D = 41;
    public static final int E = 42;
    public static final int F = 43;
    public static final int G = 44;
    public static final int H = 45;
    public static final int I = 46;
    public static final int J = 47;
    public static final int K = 48;
    public static final int L = 49;
    public static final int M = 50;
    public static final int N = 51;
    public static final int O = 53;
    public static final int b0 = 54;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4200c = 5;
    public static final int c0 = 55;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4201d = 6;
    public static final int d0 = 56;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4202e = 12;
    public static final int e0 = 57;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4203f = 13;
    public static final int f0 = 58;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4204g = 15;
    public static final int g0 = 59;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4205h = 17;
    public static final int h0 = 60;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4206i = 19;
    public static final int i0 = 65;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4207j = 20;
    public static final int j0 = 66;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f4208k = 21;
    public static final int k0 = 67;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f4209l = 22;
    public static final int l0 = 67;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4210m = 23;
    public static final int m0 = 68;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4211n = 24;
    public static final int n0 = 69;
    public static final int o = 25;
    public static final int o0 = 70;
    public static final int p = 26;
    public static final int p0 = 3004;
    public static final int q = 27;
    public static final int q0 = 3003;
    public static final int r = 28;
    public static final int r0 = 3002;
    public static final int s = 29;
    public static final int s0 = 1002;
    public static final int t = 30;
    public static final String t0 = "0";
    public static final int u = 31;
    public static final String u0 = "1";
    public static final int v = 32;
    public static final int w = 33;
    public static final int x = 34;
    public static final int y = 35;
    public static final int z = 37;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4212b;

    class a implements Parcelable.Creator<ErrorStatus> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ErrorStatus createFromParcel(Parcel parcel) {
            ErrorStatus errorStatus = new ErrorStatus();
            errorStatus.a = parcel.readInt();
            errorStatus.f4212b = parcel.readString();
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

    public String b() {
        return this.f4212b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[ErrorCode]:" + this.a + "[DES]:" + this.f4212b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeString(this.f4212b);
    }

    public ErrorStatus(int i2, String str) {
        this.a = i2;
        this.f4212b = str;
    }

    public int a() {
        return this.a;
    }
}
