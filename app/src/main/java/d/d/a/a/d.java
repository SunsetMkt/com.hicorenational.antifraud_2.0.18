package d.d.a.a;

import d.d.a.a.f.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: compiled from: V1SchemeUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: V1SchemeUtil.java */
    public static class a extends Exception {
        static final long serialVersionUID = -3387516993124229949L;

        public a() {
        }

        public a(String str) {
            super(str);
        }
    }

    public static void a(File file, String str) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        if (file == null || !file.exists() || !file.isFile() || str == null || str.isEmpty()) {
            throw new Exception("param error , file : " + file + " , channel : " + str);
        }
        byte[] bytes = str.getBytes("UTF-8");
        c<ByteBuffer, Long> cVarC = c(file);
        if (cVarC.a().remaining() == 22) {
            System.out.println("file : " + file.getAbsolutePath() + " , has no comment");
            try {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = null;
            }
            try {
                randomAccessFile2.seek(file.length() - 2);
                a(bytes.length + 2 + b.f10110d.length, randomAccessFile2);
                randomAccessFile2.write(bytes);
                a(bytes.length, randomAccessFile2);
                randomAccessFile2.write(b.f10110d);
                randomAccessFile2.close();
                return;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        }
        System.out.println("file : " + file.getAbsolutePath() + " , has comment");
        if (a(file)) {
            try {
                String strD = d(file);
                if (strD != null) {
                    file.delete();
                    throw new a("file : " + file.getAbsolutePath() + " has a channel : " + strD + ", only ignore");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int iA = d.d.a.a.f.b.a(cVarC.a(), 20);
        int length = bytes.length + iA + 2 + b.f10110d.length;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek((cVarC.b().longValue() + 22) - 2);
            a(length, randomAccessFile);
            randomAccessFile.seek(cVarC.b().longValue() + 22 + ((long) iA));
            randomAccessFile.write(bytes);
            a(bytes.length, randomAccessFile);
            randomAccessFile.write(b.f10110d);
            randomAccessFile.close();
        } catch (Throwable th4) {
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0028, code lost:
    
        r1 = r0.getJarEntry(r3.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            JarEntry jarEntry = jarFile.getJarEntry("META-INF/MANIFEST.MF");
            JarEntry jarEntry2 = null;
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (true) {
                if (!enumerationEntries.hasMoreElements()) {
                    break;
                }
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                if (jarEntryNextElement.getName().matches("META-INF/\\w+\\.SF")) {
                    break;
                }
            }
            return (jarEntry == null || jarEntry2 == null) ? false : true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static c<ByteBuffer, Long> c(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            c<ByteBuffer, Long> cVarB = d.d.a.a.f.a.b(randomAccessFile);
            if (d.d.a.a.f.b.a(randomAccessFile, cVarB.b().longValue())) {
                throw new a.c("ZIP64 APK not supported");
            }
            randomAccessFile.close();
            return cVarB;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String d(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[b.f10110d.length];
            long length2 = length - ((long) b.f10110d.length);
            randomAccessFile.seek(length2);
            randomAccessFile.readFully(bArr);
            if (!a(bArr)) {
                throw new Exception("zip v1 magic not found");
            }
            long j2 = length2 - 2;
            randomAccessFile.seek(j2);
            int iA = a(randomAccessFile);
            if (iA <= 0) {
                throw new Exception("zip channel info not found");
            }
            randomAccessFile.seek(j2 - ((long) iA));
            byte[] bArr2 = new byte[iA];
            randomAccessFile.readFully(bArr2);
            String str = new String(bArr2, "UTF-8");
            randomAccessFile.close();
            return str;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static void a(int i2, DataOutput dataOutput) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putShort((short) i2);
        dataOutput.write(byteBufferOrder.array());
    }

    private static short a(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    public static boolean a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[b.f10110d.length];
            randomAccessFile.seek(length - ((long) b.f10110d.length));
            randomAccessFile.readFully(bArr);
            boolean zA = a(bArr);
            randomAccessFile.close();
            return zA;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != b.f10110d.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = b.f10110d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    public static void a(File file, File file2) throws Throwable {
        FileChannel channel;
        FileChannel channel2;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel = null;
        try {
            channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                fileChannel = channel2;
                th = th;
                channel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            channel = null;
        }
        try {
            channel.transferFrom(channel2, 0L, channel2.size());
            if (channel2 != null) {
                channel2.close();
            }
            if (channel != null) {
                channel.close();
            }
        } catch (Throwable th3) {
            fileChannel = channel2;
            th = th3;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }
}
