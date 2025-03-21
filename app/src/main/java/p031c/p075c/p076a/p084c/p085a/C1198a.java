package p031c.p075c.p076a.p084c.p085a;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.List;
import p031c.p075c.p076a.p084c.p085a.p086b.C1200b;
import p031c.p075c.p076a.p084c.p085a.p087c.C1202b;
import p031c.p075c.p076a.p084c.p085a.p087c.InterfaceC1201a;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p358k.p359a.p360a.p361a.C5847a;
import p358k.p359a.p360a.p361a.C5848b;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: HonorIdSignInManager.java */
/* renamed from: c.c.a.c.a.a */
/* loaded from: classes.dex */
public final class C1198a {
    /* renamed from: a */
    private static Intent m2283a(Activity activity, SignInOptions signInOptions) {
        return m2292b(activity, signInOptions).mo2311c();
    }

    /* renamed from: b */
    public static boolean m2293b(Context context) {
        return C1200b.m2305b(context);
    }

    /* renamed from: a */
    public static void m2287a(Activity activity, int i2, SignInOptions signInOptions) {
        if (activity == null || signInOptions == null) {
            throw new NullPointerException("SignInOptions should not be null or activity is null");
        }
        if (!C5848b.m24626b(signInOptions.m6030f())) {
            throw new NullPointerException("ScopeList should not be null");
        }
        Intent m2283a = m2283a(activity, signInOptions);
        if (m2283a == null) {
            C5863e.m24691a("HonorIdSignInManager", "addAuthScopes signInIntent is null", true);
        } else {
            activity.startActivityForResult(m2283a, i2);
        }
    }

    /* renamed from: b */
    public static InterfaceC1201a m2292b(Activity activity, SignInOptions signInOptions) {
        C5847a.m24623a(activity, "Null activity is not permitted.");
        return new C1202b(activity, signInOptions);
    }

    /* renamed from: a */
    public static boolean m2291a(Context context, SignInAccountInfo signInAccountInfo, List<Scope> list) {
        C5847a.m24623a(context, "Null context is not permitted.");
        if (signInAccountInfo == null || C5848b.m24625a(list)) {
            return false;
        }
        return C1200b.m2302a(context, signInAccountInfo, list);
    }

    /* renamed from: a */
    public static InterfaceC1201a m2284a(Context context, SignInOptions signInOptions) {
        C5847a.m24623a(context, "Null context is not permitted.");
        return new C1202b(context, signInOptions);
    }

    /* renamed from: a */
    public static boolean m2289a() {
        return C1200b.m2300a();
    }

    /* renamed from: a */
    public static boolean m2290a(Context context) {
        return C1200b.m2301a(context);
    }

    /* renamed from: a */
    public static AbstractC1213j<SignInAccountInfo> m2286a(Intent intent) {
        return m2285a(-2, intent);
    }

    /* renamed from: a */
    public static AbstractC1213j<SignInAccountInfo> m2285a(int i2, Intent intent) {
        return C1200b.m2296a(i2, intent);
    }

    /* renamed from: a */
    public static void m2288a(Fragment fragment, int i2, SignInOptions signInOptions) {
        if (fragment != null && signInOptions != null) {
            if (C5848b.m24626b(signInOptions.m6030f())) {
                fragment.startActivityForResult(m2283a(fragment.getActivity(), signInOptions), i2);
                return;
            }
            throw new NullPointerException("ScopeList should not be null");
        }
        throw new NullPointerException("SignInOptions should not be null or fragment is null");
    }
}
