package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4077af;
import com.xiaomi.push.service.C4372ax;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.db */
/* loaded from: classes2.dex */
public class C4154db {

    /* renamed from: a */
    private static volatile C4154db f14847a;

    /* renamed from: a */
    private Context f14848a;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<b> f14849a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.xiaomi.push.db$a */
    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.C4154db.b, com.xiaomi.push.C4077af.b
        /* renamed from: b */
        public void mo13724b() {
            C4154db.this.m14266b();
        }
    }

    /* renamed from: com.xiaomi.push.db$b */
    class b extends C4077af.b {

        /* renamed from: a */
        long f14861a = System.currentTimeMillis();

        b() {
        }

        /* renamed from: a */
        public boolean mo14271a() {
            return true;
        }

        @Override // com.xiaomi.push.C4077af.b
        /* renamed from: b */
        public void mo13724b() {
        }

        /* renamed from: b */
        final boolean m14272b() {
            return System.currentTimeMillis() - this.f14861a > 172800000;
        }
    }

    private C4154db(Context context) {
        this.f14848a = context;
        this.f14849a.add(new a());
        m14267b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14266b() {
        try {
            File file = new File(this.f14848a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: c */
    private void m14268c() {
        while (!this.f14849a.isEmpty()) {
            b peek = this.f14849a.peek();
            if (peek != null) {
                if (!peek.m14272b() && this.f14849a.size() <= 6) {
                    return;
                }
                AbstractC4022b.m13359c("remove Expired task");
                this.f14849a.remove(peek);
            }
        }
    }

    /* renamed from: a */
    public static C4154db m14261a(Context context) {
        if (f14847a == null) {
            synchronized (C4154db.class) {
                if (f14847a == null) {
                    f14847a = new C4154db(context);
                }
            }
        }
        f14847a.f14848a = context;
        return f14847a;
    }

    /* renamed from: b */
    private void m14267b(long j2) {
        if (this.f14849a.isEmpty()) {
            return;
        }
        C4231fy.m14906a(new C4077af.b() { // from class: com.xiaomi.push.db.2

            /* renamed from: a */
            C4077af.b f14858a;

            @Override // com.xiaomi.push.C4077af.b
            /* renamed from: b */
            public void mo13724b() {
                b bVar = (b) C4154db.this.f14849a.peek();
                if (bVar == null || !bVar.mo14271a()) {
                    return;
                }
                if (C4154db.this.f14849a.remove(bVar)) {
                    this.f14858a = bVar;
                }
                C4077af.b bVar2 = this.f14858a;
                if (bVar2 != null) {
                    bVar2.mo13724b();
                }
            }

            @Override // com.xiaomi.push.C4077af.b
            /* renamed from: c */
            public void mo13725c() {
                C4077af.b bVar = this.f14858a;
                if (bVar != null) {
                    bVar.mo13725c();
                }
            }
        }, j2);
    }

    /* renamed from: com.xiaomi.push.db$c */
    class c extends b {

        /* renamed from: a */
        int f14863a;

        /* renamed from: a */
        File f14865a;

        /* renamed from: a */
        String f14866a;

        /* renamed from: a */
        boolean f14867a;

        /* renamed from: b */
        String f14868b;

        /* renamed from: b */
        boolean f14869b;

        c(String str, String str2, File file, boolean z) {
            super();
            this.f14866a = str;
            this.f14868b = str2;
            this.f14865a = file;
            this.f14869b = z;
        }

        /* renamed from: c */
        private boolean m14273c() {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = C4154db.this.f14848a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt(Constants.KEY_TIMES);
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (i2 > 10) {
                    return false;
                }
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put(Constants.KEY_TIMES, i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                AbstractC4022b.m13359c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.C4154db.b
        /* renamed from: a */
        public boolean mo14271a() {
            return C4092au.m13803d(C4154db.this.f14848a) || (this.f14869b && C4092au.m13799a(C4154db.this.f14848a));
        }

        @Override // com.xiaomi.push.C4154db.b, com.xiaomi.push.C4077af.b
        /* renamed from: b */
        public void mo13724b() {
            try {
                if (m14273c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", C4372ax.m16018a());
                    hashMap.put("token", this.f14868b);
                    hashMap.put("net", C4092au.m13789a(C4154db.this.f14848a));
                    C4092au.m13793a(this.f14866a, hashMap, this.f14865a, "file");
                }
                this.f14867a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.C4077af.b
        /* renamed from: c */
        public void mo13725c() {
            if (!this.f14867a) {
                this.f14863a++;
                if (this.f14863a < 3) {
                    C4154db.this.f14849a.add(this);
                }
            }
            if (this.f14867a || this.f14863a >= 3) {
                this.f14865a.delete();
            }
            C4154db.this.m14263a((1 << this.f14863a) * 1000);
        }
    }

    /* renamed from: a */
    public void m14270a(final String str, final String str2, final Date date, final Date date2, final int i2, final boolean z) {
        this.f14849a.add(new b() { // from class: com.xiaomi.push.db.1

            /* renamed from: a */
            File f14852a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.C4154db.b, com.xiaomi.push.C4077af.b
            /* renamed from: b */
            public void mo13724b() {
                try {
                    File file = new File(C4154db.this.f14848a.getFilesDir() + "/.logcache");
                    if (C4407v.m16354a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            C4153da c4153da = new C4153da();
                            c4153da.m14259a(i2);
                            this.f14852a = c4153da.m14258a(C4154db.this.f14848a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.C4077af.b
            /* renamed from: c */
            public void mo13725c() {
                File file = this.f14852a;
                if (file != null && file.exists()) {
                    C4154db.this.f14849a.add(C4154db.this.new c(str, str2, this.f14852a, z));
                }
                C4154db.this.m14263a(0L);
            }
        });
        m14267b(0L);
    }

    /* renamed from: a */
    public void m14269a() {
        m14268c();
        m14263a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14263a(long j2) {
        b peek = this.f14849a.peek();
        if (peek == null || !peek.mo14271a()) {
            return;
        }
        m14267b(j2);
    }
}
