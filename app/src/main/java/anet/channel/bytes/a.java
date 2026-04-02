package anet.channel.bytes;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";
    private final TreeSet<ByteArray> a = new TreeSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteArray f1396b = ByteArray.create(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f1397c = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1398d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: anet.channel.bytes.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    public static class C0008a {
        public static a a = new a();

        C0008a() {
        }
    }

    public synchronized void a(ByteArray byteArray) {
        if (byteArray != null) {
            if (byteArray.bufferLength < 524288) {
                this.f1398d += (long) byteArray.bufferLength;
                this.a.add(byteArray);
                while (this.f1398d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f1398d -= (long) (this.f1397c.nextBoolean() ? this.a.pollFirst() : this.a.pollLast()).bufferLength;
                }
            }
        }
    }

    public synchronized ByteArray a(int i2) {
        if (i2 >= 524288) {
            return ByteArray.create(i2);
        }
        this.f1396b.bufferLength = i2;
        ByteArray byteArrayCeiling = this.a.ceiling(this.f1396b);
        if (byteArrayCeiling == null) {
            byteArrayCeiling = ByteArray.create(i2);
        } else {
            Arrays.fill(byteArrayCeiling.buffer, (byte) 0);
            byteArrayCeiling.dataLength = 0;
            this.a.remove(byteArrayCeiling);
            this.f1398d -= (long) byteArrayCeiling.bufferLength;
        }
        return byteArrayCeiling;
    }

    public ByteArray a(byte[] bArr, int i2) {
        ByteArray byteArrayA = a(i2);
        System.arraycopy(bArr, 0, byteArrayA.buffer, 0, i2);
        byteArrayA.dataLength = i2;
        return byteArrayA;
    }
}
