package com.bumptech.glide.p133n;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: Util.java */
/* renamed from: com.bumptech.glide.n.c */
/* loaded from: classes.dex */
final class C1803c {

    /* renamed from: a */
    static final Charset f5151a = Charset.forName(C5758c.f20751b);

    /* renamed from: b */
    static final Charset f5152b = Charset.forName("UTF-8");

    private C1803c() {
    }

    /* renamed from: a */
    static String m4631a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            reader.close();
        }
    }

    /* renamed from: a */
    static void m4633a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m4633a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    /* renamed from: a */
    static void m4632a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
