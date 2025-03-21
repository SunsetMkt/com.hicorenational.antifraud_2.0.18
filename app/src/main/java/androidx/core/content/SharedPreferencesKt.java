package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SharedPreferences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, m23546d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@InterfaceC5816d SharedPreferences sharedPreferences, boolean z, @InterfaceC5816d InterfaceC5506l<? super SharedPreferences.Editor, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(sharedPreferences, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        C5544i0.m22521a((Object) edit, "editor");
        interfaceC5506l.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static /* bridge */ /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        C5544i0.m22546f(sharedPreferences, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        C5544i0.m22521a((Object) edit, "editor");
        interfaceC5506l.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
