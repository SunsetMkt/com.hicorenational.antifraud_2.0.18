package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.d */
/* loaded from: classes2.dex */
public class C3277d {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$a */
    public static final class a {
        /* renamed from: a */
        public static final boolean m10549a(int i2, int i3) {
            return i3 == (i2 & i3);
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$b */
    public static final class b {
        /* renamed from: a */
        public static boolean m10550a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        /* renamed from: b */
        public static c m10551b() {
            if (m10550a()) {
                return c.m10552b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$c */
    public static class c {

        /* renamed from: a */
        private File f11270a;

        /* renamed from: b */
        private long f11271b;

        /* renamed from: c */
        private long f11272c;

        /* renamed from: a */
        public File m10553a() {
            return this.f11270a;
        }

        /* renamed from: b */
        public long m10556b() {
            return this.f11271b;
        }

        /* renamed from: c */
        public long m10558c() {
            return this.f11272c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", m10553a().getAbsolutePath(), Long.valueOf(m10558c()), Long.valueOf(m10556b()));
        }

        /* renamed from: a */
        public void m10555a(File file) {
            this.f11270a = file;
        }

        /* renamed from: b */
        public void m10557b(long j2) {
            this.f11272c = j2;
        }

        /* renamed from: b */
        public static c m10552b(File file) {
            c cVar = new c();
            cVar.m10555a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            cVar.m10554a(blockCount * blockSize);
            cVar.m10557b(availableBlocks * blockSize);
            return cVar;
        }

        /* renamed from: a */
        public void m10554a(long j2) {
            this.f11271b = j2;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$d */
    public static final class d {
        @SuppressLint({"SimpleDateFormat"})
        /* renamed from: a */
        public static SimpleDateFormat m10559a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    /* renamed from: a */
    public static boolean m10547a(String str) {
        return str.contains("access_token") || str.contains("pay_token") || str.contains("pfkey") || str.contains("expires_in") || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    /* renamed from: b */
    public static Bundle m10548b(Bundle bundle) {
        if (!m10546a(bundle)) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove("access_token");
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove("expires_in");
        bundle2.remove("openid");
        bundle2.remove("proxy_code");
        bundle2.remove("proxy_expires_in");
        return bundle2;
    }

    /* renamed from: a */
    public static boolean m10546a(Bundle bundle) {
        return bundle.containsKey("access_token") || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey("expires_in") || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }
}
