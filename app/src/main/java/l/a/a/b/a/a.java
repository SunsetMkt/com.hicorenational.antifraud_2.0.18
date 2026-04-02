package l.a.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hihonor.honorid.d.a.b;

/* JADX INFO: compiled from: AccountInfoPreferences.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f12692c;
    private SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f12693b;

    public a(Context context) {
        this.a = context.getSharedPreferences("HonorAccount", 0);
        this.f12693b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        if (f12692c == null) {
            f12692c = new a(context);
        }
        return f12692c;
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        if (editorEdit != null) {
            editorEdit.putString(str, b.b(this.f12693b, str2)).commit();
        }
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(str, str2);
        }
        if (str.equals("rkey")) {
            return str2;
        }
        String strA = b.a(this.f12693b, str2);
        return !TextUtils.isEmpty(strA) ? strA : str2;
    }

    public void a(String str) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        if (editorEdit != null) {
            editorEdit.remove(str).commit();
        }
    }
}
