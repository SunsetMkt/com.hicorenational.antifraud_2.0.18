package okio;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.InterfaceC5484h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: HashingSource.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m23546d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "source", "Lokio/Source;", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", SocializeProtocolConstants.PROTOCOL_KEY_MAC, "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* compiled from: HashingSource.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, m23546d2 = {"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource hmacSha1(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
            C5544i0.m22546f(source, "source");
            C5544i0.m22546f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource hmacSha256(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
            C5544i0.m22546f(source, "source");
            C5544i0.m22546f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource hmacSha512(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
            C5544i0.m22546f(source, "source");
            C5544i0.m22546f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource md5(@InterfaceC5816d Source source) {
            C5544i0.m22546f(source, "source");
            return new HashingSource(source, "MD5");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource sha1(@InterfaceC5816d Source source) {
            C5544i0.m22546f(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource sha256(@InterfaceC5816d Source source) {
            C5544i0.m22546f(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final HashingSource sha512(@InterfaceC5816d Source source) {
            C5544i0.m22546f(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        public /* synthetic */ Companion(C5586v c5586v) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@InterfaceC5816d Source source, @InterfaceC5816d String str) {
        super(source);
        C5544i0.m22546f(source, "source");
        C5544i0.m22546f(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource hmacSha1(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource hmacSha256(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource hmacSha512(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource md5(@InterfaceC5816d Source source) {
        return Companion.md5(source);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource sha1(@InterfaceC5816d Source source) {
        return Companion.sha1(source);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource sha256(@InterfaceC5816d Source source) {
        return Companion.sha256(source);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final HashingSource sha512(@InterfaceC5816d Source source) {
        return Companion.sha512(source);
    }

    @InterfaceC5481e(name = "-deprecated_hash")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to val", replaceWith = @InterfaceC5467o0(expression = "hash", imports = {}))
    @InterfaceC5816d
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m26883deprecated_hash() {
        return hash();
    }

    @InterfaceC5481e(name = "hash")
    @InterfaceC5816d
    public final ByteString hash() {
        byte[] doFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            doFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            if (mac == null) {
                C5544i0.m22545f();
            }
            doFinal = mac.doFinal();
        }
        C5544i0.m22521a((Object) doFinal, "result");
        return new ByteString(doFinal);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@InterfaceC5816d Buffer buffer, long j2) throws IOException {
        C5544i0.m22546f(buffer, "sink");
        long read = super.read(buffer, j2);
        if (read != -1) {
            long size = buffer.size() - read;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            if (segment == null) {
                C5544i0.m22545f();
            }
            while (size2 > size) {
                segment = segment.prev;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < buffer.size()) {
                int i2 = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i2, segment.limit - i2);
                } else {
                    Mac mac = this.mac;
                    if (mac == null) {
                        C5544i0.m22545f();
                    }
                    mac.update(segment.data, i2, segment.limit - i2);
                }
                size = (segment.limit - segment.pos) + size2;
                segment = segment.next;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                size2 = size;
            }
        }
        return read;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@InterfaceC5816d Source source, @InterfaceC5816d ByteString byteString, @InterfaceC5816d String str) {
        super(source);
        C5544i0.m22546f(source, "source");
        C5544i0.m22546f(byteString, "key");
        C5544i0.m22546f(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
