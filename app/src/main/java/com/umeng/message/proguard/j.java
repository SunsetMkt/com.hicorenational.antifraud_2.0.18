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

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final j f11365b = new j();

    /* renamed from: a, reason: collision with root package name */
    private final Vector<String> f11366a = new Vector<>();

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final UMessage f11367a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f11368b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private final int f11369c;

        public a(UMessage uMessage) {
            this.f11367a = uMessage;
            if (uMessage.isLargeIconFromInternet()) {
                this.f11368b.add(uMessage.getLargeIconUrl());
            }
            if (uMessage.isSoundFromInternet()) {
                this.f11368b.add(uMessage.getSoundUri());
            }
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                this.f11368b.add(uMessage.getBarImageUrl());
            }
            if (uMessage.hasBackgroundImage()) {
                this.f11368b.add(uMessage.getBackgroundImageUrl());
            }
            if (!TextUtils.isEmpty(uMessage.getBigImage())) {
                this.f11368b.add(uMessage.getBigImage());
            }
            this.f11369c = 3;
        }

        private static boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Application a2 = x.a();
                File file = new File(f.g(a2), UMUtils.MD5(str));
                File file2 = new File(f.g(a2), UMUtils.MD5(str) + ".tmp");
                if (file.exists()) {
                    f.a((Closeable) null);
                    f.a((Closeable) null);
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
                            f.a(openStream);
                            f.a(fileOutputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = openStream;
                    e = e;
                    try {
                        UPLog.e("DownloadResource", e);
                        f.a(inputStream);
                        f.a(fileOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        f.a(inputStream);
                        f.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = openStream;
                    th = th;
                    f.a(inputStream);
                    f.a(fileOutputStream);
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
                j.a(f.g(x.a()));
                int i2 = 0;
                boolean z = true;
                do {
                    i2++;
                    Iterator<String> it = this.f11368b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        boolean a2 = a(next);
                        if (!a2) {
                            UPLog.d("DownloadResource", "download fail:", next);
                        }
                        z &= a2;
                    }
                    if (z) {
                        break;
                    }
                } while (i2 < this.f11369c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            j.a().f11366a.remove(this.f11367a.getMsgId());
            Application a3 = x.a();
            UPushMessageHandler messageHandler = PushAgent.getInstance(a3).getMessageHandler();
            if (messageHandler != null) {
                messageHandler.handleMessage(a3, this.f11367a);
            }
        }
    }

    public static j a() {
        return f11365b;
    }

    public final boolean a(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("body")) != null && stringExtra.length() != 0) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                if (this.f11366a.contains(uMessage.getMsgId())) {
                    return true;
                }
                this.f11366a.add(uMessage.getMsgId());
                b.c(new a(uMessage));
                return true;
            } catch (Throwable th) {
                UPLog.e("DownloadResource", th);
            }
        }
        return false;
    }

    static /* synthetic */ void a(File file) {
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
                    az.a(file.getPath(), new FileFilter() { // from class: com.umeng.message.proguard.j.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file3) {
                            return System.currentTimeMillis() - file3.lastModified() > 86400000;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            UPLog.e("DownloadResource", th);
        }
    }
}
