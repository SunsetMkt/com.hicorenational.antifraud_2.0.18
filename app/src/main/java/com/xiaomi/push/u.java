package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u implements Runnable {
    private Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f1105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f1106a;

    public static void a(Context context, File file, final Runnable runnable) {
        new u(context, file) { // from class: com.xiaomi.push.u.1
            @Override // com.xiaomi.push.u
            protected void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        t tVarA = null;
        try {
            try {
                if (this.f1105a == null) {
                    this.f1105a = new File(this.a.getFilesDir(), "default_locker");
                }
                tVarA = t.a(this.a, this.f1105a);
                if (this.f1106a != null) {
                    this.f1106a.run();
                }
                a(this.a);
                if (tVarA == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (tVarA == null) {
                    return;
                }
            }
            tVarA.a();
        } catch (Throwable th) {
            if (tVarA != null) {
                tVarA.a();
            }
            throw th;
        }
    }

    private u(Context context, File file) {
        this.a = context;
        this.f1105a = file;
    }
}
