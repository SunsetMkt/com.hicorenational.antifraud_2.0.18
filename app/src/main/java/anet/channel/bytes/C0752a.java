package anet.channel.bytes;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* compiled from: Taobao */
/* renamed from: anet.channel.bytes.a */
/* loaded from: classes.dex */
public class C0752a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* renamed from: a */
    private final TreeSet<ByteArray> f761a = new TreeSet<>();

    /* renamed from: b */
    private final ByteArray f762b = ByteArray.create(0);

    /* renamed from: c */
    private final Random f763c = new Random();

    /* renamed from: d */
    private long f764d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.bytes.a$a */
    public static class a {

        /* renamed from: a */
        public static C0752a f765a = new C0752a();

        a() {
        }
    }

    /* renamed from: a */
    public synchronized void m448a(ByteArray byteArray) {
        if (byteArray != null) {
            if (byteArray.bufferLength < 524288) {
                this.f764d += byteArray.bufferLength;
                this.f761a.add(byteArray);
                while (this.f764d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f764d -= (this.f763c.nextBoolean() ? this.f761a.pollFirst() : this.f761a.pollLast()).bufferLength;
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized ByteArray m446a(int i2) {
        if (i2 >= 524288) {
            return ByteArray.create(i2);
        }
        this.f762b.bufferLength = i2;
        ByteArray ceiling = this.f761a.ceiling(this.f762b);
        if (ceiling == null) {
            ceiling = ByteArray.create(i2);
        } else {
            Arrays.fill(ceiling.buffer, (byte) 0);
            ceiling.dataLength = 0;
            this.f761a.remove(ceiling);
            this.f764d -= ceiling.bufferLength;
        }
        return ceiling;
    }

    /* renamed from: a */
    public ByteArray m447a(byte[] bArr, int i2) {
        ByteArray m446a = m446a(i2);
        System.arraycopy(bArr, 0, m446a.buffer, 0, i2);
        m446a.dataLength = i2;
        return m446a;
    }
}
