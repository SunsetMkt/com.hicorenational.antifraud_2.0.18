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

    /* renamed from: a, reason: collision with root package name */
    private final File f11765a;

    /* renamed from: b, reason: collision with root package name */
    private final File f11766b;

    public AtomicFile(File file) {
        this.f11765a = file;
        this.f11766b = new File(file.getPath() + ".bak");
    }

    private static void a(File file, File file2) throws IOException {
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
        this.f11765a.delete();
        this.f11766b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f11765a.delete();
                this.f11766b.renameTo(this.f11765a);
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
                this.f11766b.delete();
            } catch (IOException e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    public File getBaseFile() {
        return this.f11765a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f11766b.exists()) {
            this.f11765a.delete();
            this.f11766b.renameTo(this.f11765a);
        }
        return new FileInputStream(this.f11765a);
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
        if (this.f11765a.exists()) {
            if (this.f11766b.exists()) {
                this.f11765a.delete();
            } else if (this.f11765a.renameTo(this.f11766b)) {
                a(this.f11766b, this.f11765a);
            } else {
                String str = "Couldn't rename file " + this.f11765a + " to backup file " + this.f11766b;
            }
        }
        try {
            return new FileOutputStream(this.f11765a, z);
        } catch (FileNotFoundException e2) {
            if (!this.f11765a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
            try {
                return new FileOutputStream(this.f11765a, z);
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
