package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.ae;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class dn extends ae.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f12647a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f331a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.ah f332a;

    public dn(Context context) {
        this.f12647a = context;
        this.f331a = context.getSharedPreferences("mipush_extra", 0);
        this.f332a = com.xiaomi.push.service.ah.a(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m274a() {
        if (au.d(this.f12647a)) {
            return false;
        }
        if ((au.f(this.f12647a) || au.e(this.f12647a)) && !c()) {
            return true;
        }
        return (au.g(this.f12647a) && !b()) || au.h(this.f12647a);
    }

    private boolean b() {
        if (!this.f332a.a(gk.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f331a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f332a.a(gk.Upload3GFrequency.a(), 432000)));
    }

    private boolean c() {
        if (!this.f332a.a(gk.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f331a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f332a.a(gk.Upload4GFrequency.a(), 259200)));
    }

    @Override // com.xiaomi.push.ae.a
    /* renamed from: a */
    public String mo183a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f12647a.getFilesDir(), "push_cdata.data");
        if (!au.c(this.f12647a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m274a() && file.exists()) {
            List<gn> a2 = a(file);
            if (!z.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                gy gyVar = new gy();
                gyVar.a(a2);
                byte[] a3 = w.a(hp.a(gyVar));
                he heVar = new he("-1", false);
                heVar.c(gp.DataCollection.f597a);
                heVar.a(a3);
                df m269a = dg.a().m269a();
                if (m269a != null) {
                    m269a.a(heVar, gf.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }

    private void a() {
        SharedPreferences.Editor edit = this.f331a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private List<gn> a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        df m269a = dg.a().m269a();
        String a2 = m269a == null ? "" : m269a.a();
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dj.f12642a) {
            try {
                File file2 = new File(this.f12647a.getFilesDir(), "push_cdata.lock");
                w.m765a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        while (fileInputStream2.read(bArr) == 4) {
                            try {
                                int a3 = y.a(bArr);
                                byte[] bArr2 = new byte[a3];
                                if (fileInputStream2.read(bArr2) != a3) {
                                    break;
                                }
                                byte[] a4 = di.a(a2, bArr2);
                                if (a4 != null && a4.length != 0) {
                                    gn gnVar = new gn();
                                    hp.a(gnVar, a4);
                                    arrayList.add(gnVar);
                                    a(gnVar);
                                }
                            } catch (Exception unused) {
                                fileInputStream = fileInputStream2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                w.a((Closeable) fileInputStream);
                                w.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                w.a((Closeable) fileInputStream);
                                w.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        w.a((Closeable) fileInputStream2);
                    } catch (Exception unused5) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused6) {
                    fileLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                }
            } catch (Exception unused7) {
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                randomAccessFile = null;
            }
            w.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a(gn gnVar) {
        if (gnVar.f588a != gh.AppInstallList || gnVar.f589a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f331a.edit();
        edit.putLong("dc_job_result_time_4", gnVar.f587a);
        edit.putString("dc_job_result_4", bb.a(gnVar.f589a));
        edit.commit();
    }
}
