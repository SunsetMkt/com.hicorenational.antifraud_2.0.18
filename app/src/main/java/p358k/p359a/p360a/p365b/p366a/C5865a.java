package p358k.p359a.p360a.p365b.p366a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hihonor.honorid.p162d.p163a.C2165b;

/* compiled from: AccountInfoPreferences.java */
/* renamed from: k.a.a.b.a.a */
/* loaded from: classes2.dex */
public class C5865a {

    /* renamed from: c */
    private static C5865a f21170c;

    /* renamed from: a */
    private SharedPreferences f21171a;

    /* renamed from: b */
    private Context f21172b;

    public C5865a(Context context) {
        this.f21171a = context.getSharedPreferences("HonorAccount", 0);
        this.f21172b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static synchronized C5865a m24711a(Context context) {
        C5865a c5865a;
        synchronized (C5865a.class) {
            if (f21170c == null) {
                f21170c = new C5865a(context);
            }
            c5865a = f21170c;
        }
        return c5865a;
    }

    /* renamed from: b */
    public void m24714b(String str, String str2) {
        SharedPreferences.Editor edit = this.f21171a.edit();
        if (edit != null) {
            edit.putString(str, C2165b.m6303b(this.f21172b, str2)).commit();
        }
    }

    /* renamed from: a */
    public String m24712a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f21171a;
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(str, str2);
        }
        if (str.equals("rkey")) {
            return str2;
        }
        String m6302a = C2165b.m6302a(this.f21172b, str2);
        return !TextUtils.isEmpty(m6302a) ? m6302a : str2;
    }

    /* renamed from: a */
    public void m24713a(String str) {
        SharedPreferences.Editor edit = this.f21171a.edit();
        if (edit != null) {
            edit.remove(str).commit();
        }
    }
}
