package anetwork.channel.aidl.p022j;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.InterfaceC0870f;
import anetwork.channel.entity.C0899k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.d */
/* loaded from: classes.dex */
public class BinderC0877d extends InterfaceC0870f.a {

    /* renamed from: r */
    private static final String f1287r = "anet.ParcelableInputStreamImpl";

    /* renamed from: s */
    private static final ByteArray f1288s = ByteArray.create(0);

    /* renamed from: k */
    private int f1291k;

    /* renamed from: l */
    private int f1292l;

    /* renamed from: m */
    private int f1293m;

    /* renamed from: i */
    private final AtomicBoolean f1289i = new AtomicBoolean(false);

    /* renamed from: j */
    private LinkedList<ByteArray> f1290j = new LinkedList<>();

    /* renamed from: n */
    private int f1294n = 10000;

    /* renamed from: o */
    private String f1295o = "";

    /* renamed from: p */
    final ReentrantLock f1296p = new ReentrantLock();

    /* renamed from: q */
    final Condition f1297q = this.f1296p.newCondition();

    /* renamed from: b */
    private void m786b() {
        this.f1296p.lock();
        try {
            this.f1290j.set(this.f1291k, f1288s).recycle();
        } finally {
            this.f1296p.unlock();
        }
    }

    /* renamed from: a */
    public void m788a(ByteArray byteArray) {
        if (this.f1289i.get()) {
            return;
        }
        this.f1296p.lock();
        try {
            this.f1290j.add(byteArray);
            this.f1297q.signal();
        } finally {
            this.f1296p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    public int available() throws RemoteException {
        if (this.f1289i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.f1296p.lock();
        try {
            int i2 = 0;
            if (this.f1291k == this.f1290j.size()) {
                return 0;
            }
            ListIterator<ByteArray> listIterator = this.f1290j.listIterator(this.f1291k);
            while (listIterator.hasNext()) {
                i2 += listIterator.next().getDataLength();
            }
            return i2 - this.f1292l;
        } finally {
            this.f1296p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    public void close() throws RemoteException {
        if (this.f1289i.compareAndSet(false, true)) {
            this.f1296p.lock();
            try {
                Iterator<ByteArray> it = this.f1290j.iterator();
                while (it.hasNext()) {
                    ByteArray next = it.next();
                    if (next != f1288s) {
                        next.recycle();
                    }
                }
                this.f1290j.clear();
                this.f1290j = null;
                this.f1291k = -1;
                this.f1292l = -1;
                this.f1293m = 0;
            } finally {
                this.f1296p.unlock();
            }
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    public int length() throws RemoteException {
        return this.f1293m;
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    public int read(byte[] bArr) throws RemoteException {
        return mo771a(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    public int readByte() throws RemoteException {
        byte b2;
        if (this.f1289i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.f1296p.lock();
        while (true) {
            try {
                try {
                    if (this.f1291k == this.f1290j.size() && !this.f1297q.await(this.f1294n, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                    ByteArray byteArray = this.f1290j.get(this.f1291k);
                    if (byteArray == f1288s) {
                        b2 = -1;
                        break;
                    }
                    if (this.f1292l < byteArray.getDataLength()) {
                        b2 = byteArray.getBuffer()[this.f1292l];
                        this.f1292l++;
                        break;
                    }
                    m786b();
                    this.f1291k++;
                    this.f1292l = 0;
                } catch (InterruptedException unused) {
                    close();
                    throw new RuntimeException("await interrupt");
                }
            } finally {
                this.f1296p.unlock();
            }
        }
        return b2;
    }

    /* renamed from: a */
    public void m787a() {
        m788a(f1288s);
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    /* renamed from: a */
    public int mo771a(byte[] bArr, int i2, int i3) throws RemoteException {
        int i4;
        if (this.f1289i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        if (bArr != null) {
            if (i2 >= 0 && i3 >= 0 && (i4 = i3 + i2) <= bArr.length) {
                this.f1296p.lock();
                int i5 = i2;
                while (i5 < i4) {
                    try {
                        try {
                            if (this.f1291k == this.f1290j.size() && !this.f1297q.await(this.f1294n, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            ByteArray byteArray = this.f1290j.get(this.f1291k);
                            if (byteArray == f1288s) {
                                break;
                            }
                            int dataLength = byteArray.getDataLength() - this.f1292l;
                            int i6 = i4 - i5;
                            if (dataLength < i6) {
                                System.arraycopy(byteArray.getBuffer(), this.f1292l, bArr, i5, dataLength);
                                i5 += dataLength;
                                m786b();
                                this.f1291k++;
                                this.f1292l = 0;
                            } else {
                                System.arraycopy(byteArray.getBuffer(), this.f1292l, bArr, i5, i6);
                                this.f1292l += i6;
                                i5 += i6;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.f1296p.unlock();
                        throw th;
                    }
                }
                this.f1296p.unlock();
                int i7 = i5 - i2;
                if (i7 > 0) {
                    return i7;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    @Override // anetwork.channel.aidl.InterfaceC0870f
    /* renamed from: a */
    public long mo772a(int i2) throws RemoteException {
        ByteArray byteArray;
        this.f1296p.lock();
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f1291k != this.f1290j.size() && (byteArray = this.f1290j.get(this.f1291k)) != f1288s) {
                    int dataLength = byteArray.getDataLength();
                    int i4 = i2 - i3;
                    if (dataLength - this.f1292l < i4) {
                        i3 += dataLength - this.f1292l;
                        m786b();
                        this.f1291k++;
                        this.f1292l = 0;
                    } else {
                        this.f1292l += i4;
                        i3 = i2;
                    }
                }
            } catch (Throwable th) {
                this.f1296p.unlock();
                throw th;
            }
        }
        this.f1296p.unlock();
        return i3;
    }

    /* renamed from: a */
    public void m789a(C0899k c0899k, int i2) {
        this.f1293m = i2;
        this.f1295o = c0899k.f1367i;
        this.f1294n = c0899k.f1366h;
    }
}
