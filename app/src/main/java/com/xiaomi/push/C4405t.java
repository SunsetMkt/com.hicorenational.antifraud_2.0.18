package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.push.t */
/* loaded from: classes2.dex */
public final class C4405t {

    /* renamed from: a */
    private static final Set<String> f16823a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a */
    private Context f16824a;

    /* renamed from: a */
    private RandomAccessFile f16825a;

    /* renamed from: a */
    private String f16826a;

    /* renamed from: a */
    private FileLock f16827a;

    private C4405t(Context context) {
        this.f16824a = context;
    }

    /* renamed from: a */
    public static C4405t m16349a(Context context, File file) {
        AbstractC4022b.m13359c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (!f16823a.add(str)) {
            throw new IOException("abtain lock failure");
        }
        C4405t c4405t = new C4405t(context);
        c4405t.f16826a = str;
        try {
            c4405t.f16825a = new RandomAccessFile(file2, "rw");
            c4405t.f16827a = c4405t.f16825a.getChannel().lock();
            AbstractC4022b.m13359c("Locked: " + str + " :" + c4405t.f16827a);
            return c4405t;
        } finally {
            if (c4405t.f16827a == null) {
                RandomAccessFile randomAccessFile = c4405t.f16825a;
                if (randomAccessFile != null) {
                    C4408w.m16356a(randomAccessFile);
                }
                f16823a.remove(c4405t.f16826a);
            }
        }
    }

    /* renamed from: a */
    public void m16350a() {
        AbstractC4022b.m13359c("unLock: " + this.f16827a);
        FileLock fileLock = this.f16827a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f16827a.release();
            } catch (IOException unused) {
            }
            this.f16827a = null;
        }
        RandomAccessFile randomAccessFile = this.f16825a;
        if (randomAccessFile != null) {
            C4408w.m16356a(randomAccessFile);
        }
        f16823a.remove(this.f16826a);
    }
}
