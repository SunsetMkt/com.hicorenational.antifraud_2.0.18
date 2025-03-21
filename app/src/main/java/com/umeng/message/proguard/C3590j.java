package com.umeng.message.proguard;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.j */
/* loaded from: classes2.dex */
public final class C3590j {

    /* renamed from: b */
    private static final C3590j f13293b = new C3590j();

    /* renamed from: a */
    private final Vector<String> f13294a = new Vector<>();

    /* renamed from: com.umeng.message.proguard.j$a */
    static class a implements Runnable {

        /* renamed from: a */
        private final UMessage f13295a;

        /* renamed from: b */
        private final ArrayList<String> f13296b = new ArrayList<>();

        /* renamed from: c */
        private final int f13297c;

        public a(UMessage uMessage) {
            this.f13295a = uMessage;
            if (uMessage.isLargeIconFromInternet()) {
                this.f13296b.add(uMessage.getLargeIconUrl());
            }
            if (uMessage.isSoundFromInternet()) {
                this.f13296b.add(uMessage.getSoundUri());
            }
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                this.f13296b.add(uMessage.getBarImageUrl());
            }
            if (uMessage.hasBackgroundImage()) {
                this.f13296b.add(uMessage.getBackgroundImageUrl());
            }
            if (!TextUtils.isEmpty(uMessage.getBigImage())) {
                this.f13296b.add(uMessage.getBigImage());
            }
            this.f13297c = 3;
        }

        /* renamed from: a */
        private static boolean m12418a(String str) {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Application m12460a = C3604x.m12460a();
                File file = new File(C3586f.m12396g(m12460a), UMUtils.MD5(str));
                File file2 = new File(C3586f.m12396g(m12460a), UMUtils.MD5(str) + ".tmp");
                if (file.exists()) {
                    C3586f.m12386a((Closeable) null);
                    C3586f.m12386a((Closeable) null);
                    return true;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                InputStream openStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openStream.read(bArr);
                        if (read <= 0) {
                            file2.renameTo(file);
                            C3586f.m12386a(openStream);
                            C3586f.m12386a(fileOutputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = openStream;
                    e = e;
                    try {
                        UPLog.m12143e("DownloadResource", e);
                        C3586f.m12386a(inputStream);
                        C3586f.m12386a(fileOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        C3586f.m12386a(inputStream);
                        C3586f.m12386a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = openStream;
                    th = th;
                    C3586f.m12386a(inputStream);
                    C3586f.m12386a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                C3590j.m12416a(C3586f.m12396g(C3604x.m12460a()));
                int i2 = 0;
                boolean z = true;
                do {
                    i2++;
                    Iterator<String> it = this.f13296b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        boolean m12418a = m12418a(next);
                        if (!m12418a) {
                            UPLog.m12142d("DownloadResource", "download fail:", next);
                        }
                        z &= m12418a;
                    }
                    if (z) {
                        break;
                    }
                } while (i2 < this.f13297c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            C3590j.m12414a().f13294a.remove(this.f13295a.getMsgId());
            Application m12460a = C3604x.m12460a();
            UPushMessageHandler messageHandler = PushAgent.getInstance(m12460a).getMessageHandler();
            if (messageHandler != null) {
                messageHandler.handleMessage(m12460a, this.f13295a);
            }
        }
    }

    /* renamed from: a */
    public static C3590j m12414a() {
        return f13293b;
    }

    /* renamed from: a */
    public final boolean m12417a(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("body")) != null && stringExtra.length() != 0) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                if (this.f13294a.contains(uMessage.getMsgId())) {
                    return true;
                }
                this.f13294a.add(uMessage.getMsgId());
                C3578b.m12327c(new a(uMessage));
                return true;
            } catch (Throwable th) {
                UPLog.m12143e("DownloadResource", th);
            }
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m12416a(File file) {
        try {
            if (file.exists()) {
                long j2 = 0;
                if (file != null && file.exists()) {
                    if (!file.isDirectory()) {
                        j2 = file.length();
                    } else {
                        LinkedList linkedList = new LinkedList();
                        linkedList.push(file);
                        while (!linkedList.isEmpty()) {
                            File[] listFiles = ((File) linkedList.pop()).listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (file2.isDirectory()) {
                                        linkedList.push(file2);
                                    } else {
                                        j2 += file2.length();
                                    }
                                }
                            }
                        }
                    }
                }
                if (j2 > 1048576) {
                    C3577az.m12320a(file.getPath(), new FileFilter() { // from class: com.umeng.message.proguard.j.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file3) {
                            return System.currentTimeMillis() - file3.lastModified() > 86400000;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e("DownloadResource", th);
        }
    }
}
