package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.service.C4356ah;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.dn */
/* loaded from: classes2.dex */
public class C4166dn extends C4076ae.a {

    /* renamed from: a */
    private Context f14896a;

    /* renamed from: a */
    private SharedPreferences f14897a;

    /* renamed from: a */
    private C4356ah f14898a;

    public C4166dn(Context context) {
        this.f14896a = context;
        this.f14897a = context.getSharedPreferences("mipush_extra", 0);
        this.f14898a = C4356ah.m15923a(context);
    }

    /* renamed from: a */
    private boolean m14309a() {
        if (C4092au.m13803d(this.f14896a)) {
            return false;
        }
        if ((C4092au.m13805f(this.f14896a) || C4092au.m13804e(this.f14896a)) && !m14311c()) {
            return true;
        }
        return (C4092au.m13806g(this.f14896a) && !m14310b()) || C4092au.m13807h(this.f14896a);
    }

    /* renamed from: b */
    private boolean m14310b() {
        if (!this.f14898a.m15935a(EnumC4244gk.Upload3GSwitch.m15014a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f14897a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f14898a.m15927a(EnumC4244gk.Upload3GFrequency.m15014a(), 432000)));
    }

    /* renamed from: c */
    private boolean m14311c() {
        if (!this.f14898a.m15935a(EnumC4244gk.Upload4GSwitch.m15014a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f14897a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f14898a.m15927a(EnumC4244gk.Upload4GFrequency.m15014a(), 259200)));
    }

    @Override // com.xiaomi.push.C4076ae.a
    /* renamed from: a */
    public String mo13391a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f14896a.getFilesDir(), "push_cdata.data");
        if (!C4092au.m13802c(this.f14896a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m14309a() && file.exists()) {
            List<C4247gn> m14306a = m14306a(file);
            if (!C4411z.m16370a(m14306a)) {
                int size = m14306a.size();
                if (size > 4000) {
                    m14306a = m14306a.subList(size - 4000, size);
                }
                C4258gy c4258gy = new C4258gy();
                c4258gy.m15213a(m14306a);
                byte[] m16362a = C4408w.m16362a(C4276hp.m15567a(c4258gy));
                C4265he c4265he = new C4265he("-1", false);
                c4265he.m15318c(EnumC4249gp.DataCollection.f15769a);
                c4265he.m15305a(m16362a);
                InterfaceC4158df m14282a = C4159dg.m14281a().m14282a();
                if (m14282a != null) {
                    m14282a.mo13565a(c4265he, EnumC4239gf.Notification, null);
                }
                m14307a();
            }
            file.delete();
        }
    }

    /* renamed from: a */
    private void m14307a() {
        SharedPreferences.Editor edit = this.f14897a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a */
    private List<C4247gn> m14306a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        InterfaceC4158df m14282a = C4159dg.m14281a().m14282a();
        String mo13564a = m14282a == null ? "" : m14282a.mo13564a();
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(mo13564a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (C4162dj.f14887a) {
            try {
                File file2 = new File(this.f14896a.getFilesDir(), "push_cdata.lock");
                C4408w.m16360a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        while (fileInputStream2.read(bArr) == 4) {
                            try {
                                int m16368a = C4410y.m16368a(bArr);
                                byte[] bArr2 = new byte[m16368a];
                                if (fileInputStream2.read(bArr2) != m16368a) {
                                    break;
                                }
                                byte[] m14287a = C4161di.m14287a(mo13564a, bArr2);
                                if (m14287a != null && m14287a.length != 0) {
                                    C4247gn c4247gn = new C4247gn();
                                    C4276hp.m15566a(c4247gn, m14287a);
                                    arrayList.add(c4247gn);
                                    m14308a(c4247gn);
                                }
                            } catch (Exception unused) {
                                fileInputStream = fileInputStream2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                C4408w.m16356a((Closeable) fileInputStream);
                                C4408w.m16356a(randomAccessFile);
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
                                C4408w.m16356a((Closeable) fileInputStream);
                                C4408w.m16356a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        C4408w.m16356a((Closeable) fileInputStream2);
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
            C4408w.m16356a(randomAccessFile);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m14308a(C4247gn c4247gn) {
        if (c4247gn.f15696a != EnumC4241gh.AppInstallList || c4247gn.f15697a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f14897a.edit();
        edit.putLong("dc_job_result_time_4", c4247gn.f15695a);
        edit.putString("dc_job_result_4", C4100bb.m13879a(c4247gn.f15697a));
        edit.commit();
    }
}
