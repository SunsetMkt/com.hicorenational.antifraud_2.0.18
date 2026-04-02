package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.f;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d extends f.a {
    private static final String r = "anet.ParcelableInputStreamImpl";
    private static final ByteArray s = ByteArray.create(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1738m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f1734i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinkedList<ByteArray> f1735j = new LinkedList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1739n = 10000;
    private String o = "";
    final ReentrantLock p = new ReentrantLock();
    final Condition q = this.p.newCondition();

    private void b() {
        this.p.lock();
        try {
            this.f1735j.set(this.f1736k, s).recycle();
        } finally {
            this.p.unlock();
        }
    }

    public void a(ByteArray byteArray) {
        if (this.f1734i.get()) {
            return;
        }
        this.p.lock();
        try {
            this.f1735j.add(byteArray);
            this.q.signal();
        } finally {
            this.p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public int available() throws RemoteException {
        if (this.f1734i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.p.lock();
        try {
            int dataLength = 0;
            if (this.f1736k == this.f1735j.size()) {
                return 0;
            }
            ListIterator<ByteArray> listIterator = this.f1735j.listIterator(this.f1736k);
            while (listIterator.hasNext()) {
                dataLength += listIterator.next().getDataLength();
            }
            return dataLength - this.f1737l;
        } finally {
            this.p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public void close() throws RemoteException {
        if (this.f1734i.compareAndSet(false, true)) {
            this.p.lock();
            try {
                for (ByteArray byteArray : this.f1735j) {
                    if (byteArray != s) {
                        byteArray.recycle();
                    }
                }
                this.f1735j.clear();
                this.f1735j = null;
                this.f1736k = -1;
                this.f1737l = -1;
                this.f1738m = 0;
            } finally {
                this.p.unlock();
            }
        }
    }

    @Override // anetwork.channel.aidl.f
    public int length() throws RemoteException {
        return this.f1738m;
    }

    @Override // anetwork.channel.aidl.f
    public int read(byte[] bArr) throws RemoteException {
        return a(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.f
    public int readByte() throws RemoteException {
        byte b2;
        if (this.f1734i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.p.lock();
        while (true) {
            try {
                try {
                    if (this.f1736k == this.f1735j.size() && !this.q.await(this.f1739n, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                    ByteArray byteArray = this.f1735j.get(this.f1736k);
                    if (byteArray == s) {
                        b2 = -1;
                        break;
                    }
                    if (this.f1737l < byteArray.getDataLength()) {
                        b2 = byteArray.getBuffer()[this.f1737l];
                        this.f1737l++;
                        break;
                    }
                    b();
                    this.f1736k++;
                    this.f1737l = 0;
                } catch (InterruptedException unused) {
                    close();
                    throw new RuntimeException("await interrupt");
                }
            } finally {
                this.p.unlock();
            }
        }
        return b2;
    }

    public void a() {
        a(s);
    }

    @Override // anetwork.channel.aidl.f
    public int a(byte[] bArr, int i2, int i3) throws RemoteException {
        int i4;
        if (this.f1734i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        if (bArr != null) {
            if (i2 >= 0 && i3 >= 0 && (i4 = i3 + i2) <= bArr.length) {
                this.p.lock();
                int i5 = i2;
                while (i5 < i4) {
                    try {
                        try {
                            if (this.f1736k == this.f1735j.size() && !this.q.await(this.f1739n, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            ByteArray byteArray = this.f1735j.get(this.f1736k);
                            if (byteArray == s) {
                                break;
                            }
                            int dataLength = byteArray.getDataLength() - this.f1737l;
                            int i6 = i4 - i5;
                            if (dataLength < i6) {
                                System.arraycopy(byteArray.getBuffer(), this.f1737l, bArr, i5, dataLength);
                                i5 += dataLength;
                                b();
                                this.f1736k++;
                                this.f1737l = 0;
                            } else {
                                System.arraycopy(byteArray.getBuffer(), this.f1737l, bArr, i5, i6);
                                this.f1737l += i6;
                                i5 += i6;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.p.unlock();
                        throw th;
                    }
                }
                this.p.unlock();
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

    @Override // anetwork.channel.aidl.f
    public long a(int i2) throws RemoteException {
        ByteArray byteArray;
        this.p.lock();
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f1736k != this.f1735j.size() && (byteArray = this.f1735j.get(this.f1736k)) != s) {
                    int dataLength = byteArray.getDataLength();
                    int i4 = i2 - i3;
                    if (dataLength - this.f1737l < i4) {
                        i3 += dataLength - this.f1737l;
                        b();
                        this.f1736k++;
                        this.f1737l = 0;
                    } else {
                        this.f1737l += i4;
                        i3 = i2;
                    }
                }
            } catch (Throwable th) {
                this.p.unlock();
                throw th;
            }
        }
        this.p.unlock();
        return i3;
    }

    public void a(anetwork.channel.entity.k kVar, int i2) {
        this.f1738m = i2;
        this.o = kVar.f1794i;
        this.f1739n = kVar.f1793h;
    }
}
