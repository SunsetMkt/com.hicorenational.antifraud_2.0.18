package d.c.a.a;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import l.a.a.a.j.e;
import l.a.a.c.a.c;
import l.a.a.c.a.c.a;

/* JADX INFO: compiled from: HonorApi.java */
/* JADX INFO: loaded from: classes.dex */
public class b<TOption extends c.a> {
    private TOption a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f10061c;

    public b(Activity activity, c<TOption> cVar, TOption toption) {
        this.f10060b = activity.getApplicationContext();
        this.f10061c = new WeakReference<>(activity);
        a(activity, cVar, toption);
    }

    private void a(Context context, c<TOption> cVar, TOption toption) {
        this.f10060b = context.getApplicationContext();
        this.a = toption;
        a(context);
    }

    protected TOption e() {
        return this.a;
    }

    public Activity f() {
        WeakReference<Activity> weakReference = this.f10061c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Context g() {
        return this.f10060b;
    }

    private void a(Context context) {
        e.a(context);
        com.hihonor.honorid.a.c().a(context);
    }

    public b(Context context, c<TOption> cVar, TOption toption) {
        a(context, cVar, toption);
    }
}
