package p031c.p075c.p076a.p077a;

import android.app.Activity;
import android.content.Context;
import com.hihonor.honorid.C2151a;
import java.lang.ref.WeakReference;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p367c.p368a.C5868c;
import p358k.p359a.p360a.p367c.p368a.C5868c.a;

/* compiled from: HonorApi.java */
/* renamed from: c.c.a.a.b */
/* loaded from: classes.dex */
public class C1183b<TOption extends C5868c.a> {

    /* renamed from: a */
    private TOption f2470a;

    /* renamed from: b */
    private Context f2471b;

    /* renamed from: c */
    private WeakReference<Activity> f2472c;

    public C1183b(Activity activity, C5868c<TOption> c5868c, TOption toption) {
        this.f2471b = activity.getApplicationContext();
        this.f2472c = new WeakReference<>(activity);
        m2258a(activity, c5868c, toption);
    }

    /* renamed from: a */
    private void m2258a(Context context, C5868c<TOption> c5868c, TOption toption) {
        this.f2471b = context.getApplicationContext();
        this.f2470a = toption;
        m2257a(context);
    }

    /* renamed from: e */
    protected TOption m2259e() {
        return this.f2470a;
    }

    /* renamed from: f */
    public Activity m2260f() {
        WeakReference<Activity> weakReference = this.f2472c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: g */
    public Context m2261g() {
        return this.f2471b;
    }

    /* renamed from: a */
    private void m2257a(Context context) {
        C5863e.m24690a(context);
        C2151a.m6093c().m6095a(context);
    }

    public C1183b(Context context, C5868c<TOption> c5868c, TOption toption) {
        m2258a(context, c5868c, toption);
    }
}
