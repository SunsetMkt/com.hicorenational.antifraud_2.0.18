package i.n2;

import i.q2.t.i0;
import i.y;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
final class s implements i.x2.m<String> {
    private final BufferedReader a;

    /* JADX INFO: compiled from: ReadWrite.kt */
    public static final class a implements Iterator<String>, i.q2.t.q1.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12190b;

        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null && !this.f12190b) {
                this.a = s.this.a.readLine();
                if (this.a == null) {
                    this.f12190b = true;
                }
            }
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @j.c.a.d
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.a;
            this.a = null;
            if (str == null) {
                i0.f();
            }
            return str;
        }
    }

    public s(@j.c.a.d BufferedReader bufferedReader) {
        i0.f(bufferedReader, "reader");
        this.a = bufferedReader;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<String> iterator() {
        return new a();
    }
}
