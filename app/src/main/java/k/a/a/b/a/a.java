package k.a.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hihonor.honorid.d.a.b;

/* compiled from: AccountInfoPreferences.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f17061c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f17062a;

    /* renamed from: b, reason: collision with root package name */
    private Context f17063b;

    public a(Context context) {
        this.f17062a = context.getSharedPreferences("HonorAccount", 0);
        this.f17063b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f17061c == null) {
                f17061c = new a(context);
            }
            aVar = f17061c;
        }
        return aVar;
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f17062a.edit();
        if (edit != null) {
            edit.putString(str, b.b(this.f17063b, str2)).commit();
        }
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f17062a;
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(str, str2);
        }
        if (str.equals("rkey")) {
            return str2;
        }
        String a2 = b.a(this.f17063b, str2);
        return !TextUtils.isEmpty(a2) ? a2 : str2;
    }

    public void a(String str) {
        SharedPreferences.Editor edit = this.f17062a.edit();
        if (edit != null) {
            edit.remove(str).commit();
        }
    }
}
