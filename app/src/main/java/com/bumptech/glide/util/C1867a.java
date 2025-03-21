package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
import p286h.C5230f1;

/* compiled from: ByteBufferUtil.java */
/* renamed from: com.bumptech.glide.util.a */
/* loaded from: classes.dex */
public final class C1867a {

    /* renamed from: a */
    private static final int f5466a = 16384;

    /* renamed from: b */
    private static final AtomicReference<byte[]> f5467b = new AtomicReference<>();

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$b */
    static final class b {

        /* renamed from: a */
        final int f5471a;

        /* renamed from: b */
        final int f5472b;

        /* renamed from: c */
        final byte[] f5473c;

        b(@NonNull byte[] bArr, int i2, int i3) {
            this.f5473c = bArr;
            this.f5471a = i2;
            this.f5472b = i3;
        }
    }

    private C1867a() {
    }

    @NonNull
    /* renamed from: a */
    public static ByteBuffer m4951a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th2) {
                fileChannel = channel;
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    @NonNull
    /* renamed from: b */
    public static byte[] m4955b(@NonNull ByteBuffer byteBuffer) {
        b m4950a = m4950a(byteBuffer);
        if (m4950a != null && m4950a.f5471a == 0 && m4950a.f5472b == m4950a.f5473c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    /* renamed from: c */
    public static InputStream m4956c(@NonNull ByteBuffer byteBuffer) {
        return new a(byteBuffer);
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$a */
    private static class a extends InputStream {

        /* renamed from: c */
        private static final int f5468c = -1;

        /* renamed from: a */
        @NonNull
        private final ByteBuffer f5469a;

        /* renamed from: b */
        private int f5470b = -1;

        a(@NonNull ByteBuffer byteBuffer) {
            this.f5469a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5469a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            this.f5470b = this.f5469a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f5469a.hasRemaining()) {
                return this.f5469a.get() & C5230f1.f20085c;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f5470b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f5469a.position(this.f5470b);
        }

        @Override // java.io.InputStream
        public long skip(long j2) throws IOException {
            if (!this.f5469a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j2, available());
            this.f5469a.position((int) (r0.position() + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
            if (!this.f5469a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i3, available());
            this.f5469a.get(bArr, i2, min);
            return min;
        }
    }

    /* renamed from: a */
    public static void m4953a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m4954a(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b m4950a = m4950a(byteBuffer);
        if (m4950a != null) {
            byte[] bArr = m4950a.f5473c;
            int i2 = m4950a.f5471a;
            outputStream.write(bArr, i2, m4950a.f5472b + i2);
            return;
        }
        byte[] andSet = f5467b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        f5467b.set(andSet);
    }

    @NonNull
    /* renamed from: a */
    public static ByteBuffer m4952a(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f5467b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f5467b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @Nullable
    /* renamed from: a */
    private static b m4950a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
