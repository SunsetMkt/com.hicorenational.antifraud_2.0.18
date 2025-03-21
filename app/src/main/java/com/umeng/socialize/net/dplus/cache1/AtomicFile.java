package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class AtomicFile {

    /* renamed from: a */
    private final File f13720a;

    /* renamed from: b */
    private final File f13721b;

    public AtomicFile(File file) {
        this.f13720a = file;
        this.f13721b = new File(file.getPath() + ".bak");
    }

    /* renamed from: a */
    private static void m12670a(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    String str = "comsum time:" + (System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
                String str2 = read + "";
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public void delete() {
        this.f13720a.delete();
        this.f13721b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m12671a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f13720a.delete();
                this.f13721b.renameTo(this.f13720a);
            } catch (IOException e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m12671a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f13721b.delete();
            } catch (IOException e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    public File getBaseFile() {
        return this.f13720a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f13721b.exists()) {
            this.f13720a.delete();
            this.f13721b.renameTo(this.f13720a);
        }
        return new FileInputStream(this.f13720a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i2 = 0;
            while (true) {
                int read = openRead.read(bArr, i2, bArr.length - i2);
                if (read <= 0) {
                    return bArr;
                }
                i2 += read;
                int available = openRead.available();
                if (available > bArr.length - i2) {
                    byte[] bArr2 = new byte[available + i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite(boolean z) throws IOException {
        if (this.f13720a.exists()) {
            if (this.f13721b.exists()) {
                this.f13720a.delete();
            } else if (this.f13720a.renameTo(this.f13721b)) {
                m12670a(this.f13721b, this.f13720a);
            } else {
                String str = "Couldn't rename file " + this.f13720a + " to backup file " + this.f13721b;
            }
        }
        try {
            return new FileOutputStream(this.f13720a, z);
        } catch (FileNotFoundException e2) {
            if (!this.f13720a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
            try {
                return new FileOutputStream(this.f13720a, z);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
                return null;
            }
        }
    }

    /* renamed from: a */
    static boolean m12671a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
            return false;
        }
    }
}
