package p388ui.view.drag.p393e;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

/* compiled from: ScrollRunner.java */
/* renamed from: ui.view.drag.e.c */
/* loaded from: classes2.dex */
public class RunnableC7217c implements Runnable {

    /* renamed from: a */
    private Scroller f24845a;

    /* renamed from: b */
    private InterfaceC7215a f24846b;

    /* renamed from: c */
    private int f24847c;

    /* renamed from: d */
    private int f24848d;

    /* renamed from: e */
    private int f24849e;

    public RunnableC7217c(InterfaceC7215a interfaceC7215a) {
        this(interfaceC7215a, new LinearInterpolator());
    }

    /* renamed from: a */
    public void m25953a(InterfaceC7215a interfaceC7215a) {
        this.f24846b = interfaceC7215a;
    }

    /* renamed from: b */
    public void m25954b() {
        if (this.f24845a.isFinished()) {
            return;
        }
        this.f24846b.removeCallbacks(this);
        this.f24845a.forceFinished(true);
    }

    /* renamed from: c */
    public int m25955c() {
        return this.f24845a.getCurrX();
    }

    /* renamed from: d */
    public int m25956d() {
        return this.f24845a.getCurrY();
    }

    /* renamed from: e */
    public boolean m25957e() {
        return !this.f24845a.isFinished();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f24845a.computeScrollOffset()) {
            this.f24846b.removeCallbacks(this);
            this.f24846b.mo25919a();
            return;
        }
        int currX = this.f24845a.getCurrX();
        int currY = this.f24845a.getCurrY();
        this.f24846b.mo25920a(this.f24848d, this.f24849e, currX, currY);
        this.f24848d = currX;
        this.f24849e = currY;
        if (currX != this.f24845a.getFinalX() || currY != this.f24845a.getFinalY()) {
            this.f24846b.post(this);
        } else {
            this.f24846b.removeCallbacks(this);
            this.f24846b.mo25919a();
        }
    }

    public RunnableC7217c(InterfaceC7215a interfaceC7215a, Interpolator interpolator) {
        this.f24847c = 250;
        this.f24846b = interfaceC7215a;
        this.f24845a = new Scroller(interfaceC7215a.getContext(), interpolator);
    }

    /* renamed from: a */
    public void m25949a(int i2, int i3) {
        m25950a(i2, i3, this.f24847c);
    }

    /* renamed from: a */
    public void m25950a(int i2, int i3, int i4) {
        m25952a(0, 0, i2, i3, i4);
    }

    /* renamed from: a */
    public void m25951a(int i2, int i3, int i4, int i5) {
        m25952a(i2, i3, i4, i5, this.f24847c);
    }

    /* renamed from: a */
    public void m25952a(int i2, int i3, int i4, int i5, int i6) {
        this.f24847c = i6;
        this.f24845a.startScroll(i2, i3, i4, i5, i6);
        this.f24846b.removeCallbacks(this);
        this.f24846b.post(this);
        this.f24848d = i2;
        this.f24849e = i3;
    }

    /* renamed from: a */
    public void m25948a() {
        if (this.f24845a.isFinished()) {
            return;
        }
        this.f24845a.abortAnimation();
    }
}
