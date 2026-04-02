package com.xiaomi.push;

import com.xiaomi.push.af;

/* JADX INFO: loaded from: classes2.dex */
public class fy {
    private static af a = new af(true, 20);

    public static void a(final Runnable runnable) {
        a.a(new af.b() { // from class: com.xiaomi.push.fy.1
            @Override // com.xiaomi.push.af.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(af.b bVar) {
        a.a(bVar);
    }

    public static void a(af.b bVar, long j2) {
        a.a(bVar, j2);
    }
}
