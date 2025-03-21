package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: com.xiaomi.push.u */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC4406u implements Runnable {

    /* renamed from: a */
    private Context f16828a;

    /* renamed from: a */
    private File f16829a;

    /* renamed from: a */
    private Runnable f16830a;

    /* renamed from: a */
    public static void m16351a(Context context, File file, final Runnable runnable) {
        new AbstractRunnableC4406u(context, file) { // from class: com.xiaomi.push.u.1
            @Override // com.xiaomi.push.AbstractRunnableC4406u
            /* renamed from: a */
            protected void mo16352a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    /* renamed from: a */
    protected abstract void mo16352a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        C4405t c4405t = null;
        try {
            try {
                if (this.f16829a == null) {
                    this.f16829a = new File(this.f16828a.getFilesDir(), "default_locker");
                }
                c4405t = C4405t.m16349a(this.f16828a, this.f16829a);
                if (this.f16830a != null) {
                    this.f16830a.run();
                }
                mo16352a(this.f16828a);
                if (c4405t == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (c4405t == null) {
                    return;
                }
            }
            c4405t.m16350a();
        } catch (Throwable th) {
            if (c4405t != null) {
                c4405t.m16350a();
            }
            throw th;
        }
    }

    private AbstractRunnableC4406u(Context context, File file) {
        this.f16828a = context;
        this.f16829a = file;
    }
}
