package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal.SegmentedByteStringKt;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5282n;
import p286h.p289g2.C5291q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SegmentedByteString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\r\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001d\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0001H\u0010¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aH\u0016J\r\u0010#\u001a\u00020\u0004H\u0010¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0010¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aH\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u0001H\u0016J\b\u00105\u001a\u00020\u0001H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0001H\u0002J\b\u00108\u001a\u00020\u0010H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J%\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0010¢\u0006\u0002\b?J\b\u0010@\u001a\u00020AH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, m23546d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "digest", "algorithm", "digest$okio", "equals", "", DispatchConstants.OTHER, "", "getSize", "", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "offset", "otherOffset", "byteCount", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {

    @InterfaceC5816d
    private final transient int[] directory;

    @InterfaceC5816d
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@InterfaceC5816d byte[][] bArr, @InterfaceC5816d int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        C5544i0.m22546f(bArr, "segments");
        C5544i0.m22546f(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        C5544i0.m22521a((Object) asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteString digest$okio(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory$okio()[length + i2];
            int i5 = getDirectory$okio()[i2];
            messageDigest.update(getSegments$okio()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] digest = messageDigest.digest();
        C5544i0.m22521a((Object) digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @InterfaceC5816d
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @InterfaceC5816d
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory$okio()[length + i2];
            int i6 = getDirectory$okio()[i2];
            byte[] bArr = getSegments$okio()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        setHashCode$okio(i3);
        return i3;
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteString hmac$okio(@InterfaceC5816d String str, @InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(str, "algorithm");
        C5544i0.m22546f(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = getDirectory$okio()[length + i2];
                int i5 = getDirectory$okio()[i2];
                mac.update(getSegments$okio()[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            byte[] doFinal = mac.doFinal();
            C5544i0.m22521a((Object) doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        return toByteString().indexOf(bArr, i2);
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i2) {
        Util.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i2, 1L);
        int segment = SegmentedByteStringKt.segment(this, i2);
        return getSegments$okio()[segment][(i2 - (segment == 0 ? 0 : getDirectory$okio()[segment - 1])) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        return toByteString().lastIndexOf(bArr, i2);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, @InterfaceC5816d ByteString byteString, int i3, int i4) {
        C5544i0.m22546f(byteString, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = SegmentedByteStringKt.segment(this, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i7 = getDirectory$okio()[segment] - i6;
            int i8 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!byteString.rangeEquals(i3, getSegments$okio()[segment], i8 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public String string(@InterfaceC5816d Charset charset) {
        C5544i0.m22546f(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteString substring(int i2, int i3) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
        if (!(i3 <= size())) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + size() + ')').toString());
        }
        int i4 = i3 - i2;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        if (i2 == 0 && i3 == size()) {
            return this;
        }
        if (i2 == i3) {
            return ByteString.EMPTY;
        }
        int segment = SegmentedByteStringKt.segment(this, i2);
        int segment2 = SegmentedByteStringKt.segment(this, i3 - 1);
        byte[][] bArr = (byte[][]) C5282n.m20058a(getSegments$okio(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i5 = segment;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(getDirectory$okio()[i5] - i2, i4);
                int i7 = i6 + 1;
                iArr[i6 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i5];
                if (i5 == segment2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = segment != 0 ? getDirectory$okio()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i2 - i8);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory$okio()[length + i2];
            int i6 = getDirectory$okio()[i2];
            int i7 = i6 - i3;
            C5291q.m20196a(getSegments$okio()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @InterfaceC5816d
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@InterfaceC5816d OutputStream outputStream) throws IOException {
        C5544i0.m22546f(outputStream, "out");
        int length = getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory$okio()[length + i2];
            int i5 = getDirectory$okio()[i2];
            outputStream.write(getSegments$okio()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@InterfaceC5816d Buffer buffer, int i2, int i3) {
        C5544i0.m22546f(buffer, "buffer");
        int i4 = i3 + i2;
        int segment = SegmentedByteStringKt.segment(this, i2);
        while (i2 < i4) {
            int i5 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i6 = getDirectory$okio()[segment] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i2;
            int i8 = i7 + (i2 - i5);
            Segment segment2 = new Segment(getSegments$okio()[segment], i8, i8 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2.prev;
                buffer.head = segment2.next;
            } else {
                if (segment3 == null) {
                    C5544i0.m22545f();
                }
                Segment segment4 = segment3.prev;
                if (segment4 == null) {
                    C5544i0.m22545f();
                }
                segment4.push(segment2);
            }
            i2 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + size());
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, @InterfaceC5816d byte[] bArr, int i3, int i4) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = SegmentedByteStringKt.segment(this, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i7 = getDirectory$okio()[segment] - i6;
            int i8 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!Util.arrayRangeEquals(getSegments$okio()[segment], i8 + (i2 - i6), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }
}
