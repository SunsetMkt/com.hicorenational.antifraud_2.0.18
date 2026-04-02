package d.c.a.c.a.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import d.c.a.d.j;
import l.a.a.a.j.e;
import l.a.a.c.a.c;

/* JADX INFO: compiled from: HonorIDSignInServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends d.c.a.a.b<SignInOptions> implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10098d = "HonorIDSignInServiceImpl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c<SignInOptions> f10099e = new c<>("SignInAccountInfo.API");

    public b(Activity activity, SignInOptions signInOptions) {
        super(activity, f10099e, signInOptions);
    }

    @Override // d.c.a.c.a.c.a
    public j<SignInAccountInfo> a() {
        e.b(f10098d, "silentSignIn", true);
        return d.c.a.c.a.b.b.d(g(), e());
    }

    @Override // d.c.a.c.b.a.a
    public j<Void> b() {
        e.b(f10098d, "signOut", true);
        return d.c.a.c.a.b.b.c(g(), e());
    }

    @Override // d.c.a.c.b.a.a
    public Intent c() {
        return d.c.a.c.a.b.b.b(g(), e());
    }

    @Override // d.c.a.c.b.a.a
    public j<Void> d() {
        e.b(f10098d, "cancelAuthorization", true);
        return d.c.a.c.a.b.b.a(g(), e());
    }

    public b(Context context, SignInOptions signInOptions) {
        super(context, f10099e, signInOptions);
    }
}
