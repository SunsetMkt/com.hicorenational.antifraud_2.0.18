package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4366ar;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* renamed from: com.xiaomi.push.et */
/* loaded from: classes2.dex */
class C4199et {

    /* renamed from: a */
    private C4204ey f15218a;

    /* renamed from: a */
    private InputStream f15219a;

    /* renamed from: a */
    private volatile boolean f15222a;

    /* renamed from: a */
    private byte[] f15223a;

    /* renamed from: a */
    private ByteBuffer f15220a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f15224b = ByteBuffer.allocate(4);

    /* renamed from: a */
    private Adler32 f15221a = new Adler32();

    /* renamed from: a */
    private C4202ew f15217a = new C4202ew();

    C4199et(InputStream inputStream, C4204ey c4204ey) {
        this.f15219a = new BufferedInputStream(inputStream);
        this.f15218a = c4204ey;
    }

    /* renamed from: c */
    private void m14715c() {
        boolean z = false;
        this.f15222a = false;
        C4197er m14716a = m14716a();
        if ("CONN".equals(m14716a.m14685a())) {
            C4168dp.f m14456a = C4168dp.f.m14456a(m14716a.m14696a());
            if (m14456a.m14461a()) {
                this.f15218a.m14768a(m14456a.m14460a());
                z = true;
            }
            if (m14456a.m14465c()) {
                C4168dp.b m14457a = m14456a.m14457a();
                C4197er c4197er = new C4197er();
                c4197er.m14692a("SYNC", "CONF");
                c4197er.m14694a(m14457a.m14590a(), (String) null);
                this.f15218a.m14740a(c4197er);
            }
            AbstractC4022b.m13347a("[Slim] CONN: host = " + m14456a.m14463b());
        }
        if (!z) {
            AbstractC4022b.m13347a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f15223a = this.f15218a.m14747a();
        while (!this.f15222a) {
            C4197er m14716a2 = m14716a();
            long currentTimeMillis = System.currentTimeMillis();
            this.f15218a.m14779c();
            short m14687a = m14716a2.m14687a();
            if (m14687a == 1) {
                this.f15218a.m14740a(m14716a2);
            } else if (m14687a != 2) {
                if (m14687a != 3) {
                    AbstractC4022b.m13347a("[Slim] unknow blob type " + ((int) m14716a2.m14687a()));
                } else {
                    try {
                        this.f15218a.m14749b(this.f15217a.m14734a(m14716a2.m14696a(), this.f15218a));
                    } catch (Exception e2) {
                        AbstractC4022b.m13347a("[Slim] Parse packet from Blob chid=" + m14716a2.m14683a() + "; Id=" + m14716a2.m14709e() + " failure:" + e2.getMessage());
                    }
                }
            } else if ("SECMSG".equals(m14716a2.m14685a()) && ((m14716a2.m14683a() == 2 || m14716a2.m14683a() == 3) && TextUtils.isEmpty(m14716a2.m14700b()))) {
                try {
                    AbstractC4221fo m14734a = this.f15217a.m14734a(m14716a2.m14697a(C4361am.m15951a().m15954a(Integer.valueOf(m14716a2.m14683a()).toString(), m14716a2.m14711g()).f16564h), this.f15218a);
                    m14734a.f15349a = currentTimeMillis;
                    this.f15218a.m14749b(m14734a);
                } catch (Exception e3) {
                    AbstractC4022b.m13347a("[Slim] Parse packet from Blob chid=" + m14716a2.m14683a() + "; Id=" + m14716a2.m14709e() + " failure:" + e3.getMessage());
                }
            } else {
                this.f15218a.m14740a(m14716a2);
            }
        }
    }

    /* renamed from: a */
    void m14717a() {
        try {
            m14715c();
        } catch (IOException e2) {
            if (!this.f15222a) {
                throw e2;
            }
        }
    }

    /* renamed from: b */
    void m14718b() {
        this.f15222a = true;
    }

    /* renamed from: a */
    private ByteBuffer m14713a() {
        this.f15220a.clear();
        m14714a(this.f15220a, 8);
        short s = this.f15220a.getShort(0);
        short s2 = this.f15220a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.f15220a.getInt(4);
            int position = this.f15220a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.f15220a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(i2 + 2048);
                    allocate.put(this.f15220a.array(), 0, this.f15220a.arrayOffset() + this.f15220a.position());
                    this.f15220a = allocate;
                } else if (this.f15220a.capacity() > 4096 && i2 < 2048) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                    allocate2.put(this.f15220a.array(), 0, this.f15220a.arrayOffset() + this.f15220a.position());
                    this.f15220a = allocate2;
                }
                m14714a(this.f15220a, i2);
                this.f15224b.clear();
                m14714a(this.f15224b, 4);
                this.f15224b.position(0);
                int i3 = this.f15224b.getInt();
                this.f15221a.reset();
                this.f15221a.update(this.f15220a.array(), 0, this.f15220a.position());
                if (i3 == ((int) this.f15221a.getValue())) {
                    byte[] bArr = this.f15223a;
                    if (bArr != null) {
                        C4366ar.m15997a(bArr, this.f15220a.array(), true, position, i2);
                    }
                    return this.f15220a;
                }
                AbstractC4022b.m13347a("CRC = " + ((int) this.f15221a.getValue()) + " and " + i3);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* renamed from: a */
    C4197er m14716a() {
        int i2;
        C4197er m14681a;
        try {
            ByteBuffer m14713a = m14713a();
            i2 = m14713a.position();
            try {
                m14713a.flip();
                m14713a.position(8);
                if (i2 == 8) {
                    m14681a = new C4203ex();
                } else {
                    m14681a = C4197er.m14681a(m14713a.slice());
                }
                AbstractC4022b.m13359c("[Slim] Read {cmd=" + m14681a.m14685a() + ";chid=" + m14681a.m14683a() + ";len=" + i2 + "}");
                return m14681a;
            } catch (IOException e2) {
                e = e2;
                if (i2 == 0) {
                    i2 = this.f15220a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f15220a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(C4073ab.m13691a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                AbstractC4022b.m13347a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i2 = 0;
        }
    }

    /* renamed from: a */
    private void m14714a(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position();
        do {
            int read = this.f15219a.read(byteBuffer.array(), position, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            position += read;
        } while (i2 > 0);
        byteBuffer.position(position);
    }
}
