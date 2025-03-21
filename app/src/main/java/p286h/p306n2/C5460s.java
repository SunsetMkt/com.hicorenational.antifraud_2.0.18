package p286h.p306n2;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ReadWrite.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m23546d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.n2.s */
/* loaded from: classes2.dex */
final class C5460s implements InterfaceC5699m<String> {

    /* renamed from: a */
    private final BufferedReader f20341a;

    /* compiled from: ReadWrite.kt */
    /* renamed from: h.n2.s$a */
    public static final class a implements Iterator<String>, InterfaceC5569a {

        /* renamed from: a */
        private String f20342a;

        /* renamed from: b */
        private boolean f20343b;

        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20342a == null && !this.f20343b) {
                this.f20342a = C5460s.this.f20341a.readLine();
                if (this.f20342a == null) {
                    this.f20343b = true;
                }
            }
            return this.f20342a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @InterfaceC5816d
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f20342a;
            this.f20342a = null;
            if (str == null) {
                C5544i0.m22545f();
            }
            return str;
        }
    }

    public C5460s(@InterfaceC5816d BufferedReader bufferedReader) {
        C5544i0.m22546f(bufferedReader, "reader");
        this.f20341a = bufferedReader;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<String> iterator() {
        return new a();
    }
}
