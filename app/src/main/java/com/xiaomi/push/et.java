package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: classes2.dex */
class et {

    /* renamed from: a, reason: collision with other field name */
    private ey f468a;

    /* renamed from: a, reason: collision with other field name */
    private InputStream f469a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f472a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f473a;

    /* renamed from: a, reason: collision with other field name */
    private ByteBuffer f470a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f12788b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f471a = new Adler32();

    /* renamed from: a, reason: collision with root package name */
    private ew f12787a = new ew();

    et(InputStream inputStream, ey eyVar) {
        this.f469a = new BufferedInputStream(inputStream);
        this.f468a = eyVar;
    }

    private void c() {
        boolean z = false;
        this.f472a = false;
        er m401a = m401a();
        if ("CONN".equals(m401a.m390a())) {
            dp.f a2 = dp.f.a(m401a.m394a());
            if (a2.m332a()) {
                this.f468a.a(a2.m331a());
                z = true;
            }
            if (a2.c()) {
                dp.b m330a = a2.m330a();
                er erVar = new er();
                erVar.a("SYNC", "CONF");
                erVar.a(m330a.m374a(), (String) null);
                this.f468a.a(erVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] CONN: host = " + a2.m333b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f473a = this.f468a.m408a();
        while (!this.f472a) {
            er m401a2 = m401a();
            long currentTimeMillis = System.currentTimeMillis();
            this.f468a.c();
            short m392a = m401a2.m392a();
            if (m392a == 1) {
                this.f468a.a(m401a2);
            } else if (m392a != 2) {
                if (m392a != 3) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] unknow blob type " + ((int) m401a2.m392a()));
                } else {
                    try {
                        this.f468a.b(this.f12787a.a(m401a2.m394a(), this.f468a));
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m401a2.a() + "; Id=" + m401a2.e() + " failure:" + e2.getMessage());
                    }
                }
            } else if ("SECMSG".equals(m401a2.m390a()) && ((m401a2.a() == 2 || m401a2.a() == 3) && TextUtils.isEmpty(m401a2.m397b()))) {
                try {
                    fo a3 = this.f12787a.a(m401a2.m395a(com.xiaomi.push.service.am.a().a(Integer.valueOf(m401a2.a()).toString(), m401a2.g()).f13351h), this.f468a);
                    a3.f529a = currentTimeMillis;
                    this.f468a.b(a3);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m401a2.a() + "; Id=" + m401a2.e() + " failure:" + e3.getMessage());
                }
            } else {
                this.f468a.a(m401a2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    void m402a() {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f472a) {
                throw e2;
            }
        }
    }

    void b() {
        this.f472a = true;
    }

    private ByteBuffer a() {
        this.f470a.clear();
        a(this.f470a, 8);
        short s = this.f470a.getShort(0);
        short s2 = this.f470a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.f470a.getInt(4);
            int position = this.f470a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.f470a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(i2 + 2048);
                    allocate.put(this.f470a.array(), 0, this.f470a.arrayOffset() + this.f470a.position());
                    this.f470a = allocate;
                } else if (this.f470a.capacity() > 4096 && i2 < 2048) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                    allocate2.put(this.f470a.array(), 0, this.f470a.arrayOffset() + this.f470a.position());
                    this.f470a = allocate2;
                }
                a(this.f470a, i2);
                this.f12788b.clear();
                a(this.f12788b, 4);
                this.f12788b.position(0);
                int i3 = this.f12788b.getInt();
                this.f471a.reset();
                this.f471a.update(this.f470a.array(), 0, this.f470a.position());
                if (i3 == ((int) this.f471a.getValue())) {
                    byte[] bArr = this.f473a;
                    if (bArr != null) {
                        com.xiaomi.push.service.ar.a(bArr, this.f470a.array(), true, position, i2);
                    }
                    return this.f470a;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("CRC = " + ((int) this.f471a.getValue()) + " and " + i3);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* renamed from: a, reason: collision with other method in class */
    er m401a() {
        int i2;
        er a2;
        try {
            ByteBuffer a3 = a();
            i2 = a3.position();
            try {
                a3.flip();
                a3.position(8);
                if (i2 == 8) {
                    a2 = new ex();
                } else {
                    a2 = er.a(a3.slice());
                }
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + a2.m390a() + ";chid=" + a2.a() + ";len=" + i2 + "}");
                return a2;
            } catch (IOException e2) {
                e = e2;
                if (i2 == 0) {
                    i2 = this.f470a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f470a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(ab.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i2 = 0;
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position();
        do {
            int read = this.f469a.read(byteBuffer.array(), position, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            position += read;
        } while (i2 > 0);
        byteBuffer.position(position);
    }
}
