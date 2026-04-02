package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicFile {
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f8334b;

    public AtomicFile(File file) {
        this.a = file;
        this.f8334b = new File(file.getPath() + ".bak");
    }

    private static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
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
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    String str = "comsum time:" + (System.currentTimeMillis() - jCurrentTimeMillis);
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
                String str2 = i2 + "";
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
        this.a.delete();
        this.f8334b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.a.delete();
                this.f8334b.renameTo(this.a);
            } catch (IOException e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f8334b.delete();
            } catch (IOException e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    public File getBaseFile() {
        return this.a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f8334b.exists()) {
            this.a.delete();
            this.f8334b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream fileInputStreamOpenRead = openRead();
        try {
            byte[] bArr = new byte[fileInputStreamOpenRead.available()];
            int i2 = 0;
            while (true) {
                int i3 = fileInputStreamOpenRead.read(bArr, i2, bArr.length - i2);
                if (i3 <= 0) {
                    return bArr;
                }
                i2 += i3;
                int iAvailable = fileInputStreamOpenRead.available();
                if (iAvailable > bArr.length - i2) {
                    byte[] bArr2 = new byte[iAvailable + i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
            }
        } finally {
            fileInputStreamOpenRead.close();
        }
    }

    public FileOutputStream startWrite(boolean z) throws Throwable {
        if (this.a.exists()) {
            if (this.f8334b.exists()) {
                this.a.delete();
            } else if (this.a.renameTo(this.f8334b)) {
                a(this.f8334b, this.a);
            } else {
                String str = "Couldn't rename file " + this.a + " to backup file " + this.f8334b;
            }
        }
        try {
            return new FileOutputStream(this.a, z);
        } catch (FileNotFoundException e2) {
            if (!this.a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
            try {
                return new FileOutputStream(this.a, z);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
                return null;
            }
        }
    }

    static boolean a(FileOutputStream fileOutputStream) {
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
