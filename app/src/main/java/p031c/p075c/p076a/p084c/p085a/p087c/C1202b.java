package p031c.p075c.p076a.p084c.p085a.p087c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import p031c.p075c.p076a.p077a.C1183b;
import p031c.p075c.p076a.p084c.p085a.p086b.C1200b;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p367c.p368a.C5868c;

/* compiled from: HonorIDSignInServiceImpl.java */
/* renamed from: c.c.a.c.a.c.b */
/* loaded from: classes.dex */
public class C1202b extends C1183b<SignInOptions> implements InterfaceC1201a {

    /* renamed from: d */
    public static final String f2653d = "HonorIDSignInServiceImpl";

    /* renamed from: e */
    public static final C5868c<SignInOptions> f2654e = new C5868c<>("SignInAccountInfo.API");

    public C1202b(Activity activity, SignInOptions signInOptions) {
        super(activity, f2654e, signInOptions);
    }

    @Override // p031c.p075c.p076a.p084c.p085a.p087c.InterfaceC1201a
    /* renamed from: a */
    public AbstractC1213j<SignInAccountInfo> mo2309a() {
        C5863e.m24692b(f2653d, "silentSignIn", true);
        return C1200b.m2308d(m2261g(), m2259e());
    }

    @Override // p031c.p075c.p076a.p084c.p088b.p089a.InterfaceC1203a
    /* renamed from: b */
    public AbstractC1213j<Void> mo2310b() {
        C5863e.m24692b(f2653d, "signOut", true);
        return C1200b.m2306c(m2261g(), m2259e());
    }

    @Override // p031c.p075c.p076a.p084c.p088b.p089a.InterfaceC1203a
    /* renamed from: c */
    public Intent mo2311c() {
        return C1200b.m2303b(m2261g(), m2259e());
    }

    @Override // p031c.p075c.p076a.p084c.p088b.p089a.InterfaceC1203a
    /* renamed from: d */
    public AbstractC1213j<Void> mo2312d() {
        C5863e.m24692b(f2653d, "cancelAuthorization", true);
        return C1200b.m2297a(m2261g(), m2259e());
    }

    public C1202b(Context context, SignInOptions signInOptions) {
        super(context, f2654e, signInOptions);
    }
}
