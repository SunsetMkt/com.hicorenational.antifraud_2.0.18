package ui.view.drag.e;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

/* JADX INFO: compiled from: ScrollRunner.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    private Scroller a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f14708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14711e;

    public c(a aVar) {
        this(aVar, new LinearInterpolator());
    }

    public void a(a aVar) {
        this.f14708b = aVar;
    }

    public void b() {
        if (this.a.isFinished()) {
            return;
        }
        this.f14708b.removeCallbacks(this);
        this.a.forceFinished(true);
    }

    public int c() {
        return this.a.getCurrX();
    }

    public int d() {
        return this.a.getCurrY();
    }

    public boolean e() {
        return !this.a.isFinished();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.a.computeScrollOffset()) {
            this.f14708b.removeCallbacks(this);
            this.f14708b.a();
            return;
        }
        int currX = this.a.getCurrX();
        int currY = this.a.getCurrY();
        this.f14708b.a(this.f14710d, this.f14711e, currX, currY);
        this.f14710d = currX;
        this.f14711e = currY;
        if (currX != this.a.getFinalX() || currY != this.a.getFinalY()) {
            this.f14708b.post(this);
        } else {
            this.f14708b.removeCallbacks(this);
            this.f14708b.a();
        }
    }

    public c(a aVar, Interpolator interpolator) {
        this.f14709c = 250;
        this.f14708b = aVar;
        this.a = new Scroller(aVar.getContext(), interpolator);
    }

    public void a(int i2, int i3) {
        a(i2, i3, this.f14709c);
    }

    public void a(int i2, int i3, int i4) {
        a(0, 0, i2, i3, i4);
    }

    public void a(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, this.f14709c);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        this.f14709c = i6;
        this.a.startScroll(i2, i3, i4, i5, i6);
        this.f14708b.removeCallbacks(this);
        this.f14708b.post(this);
        this.f14710d = i2;
        this.f14711e = i3;
    }

    public void a() {
        if (this.a.isFinished()) {
            return;
        }
        this.a.abortAnimation();
    }
}
