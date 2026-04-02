package ui.view.drag;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class HandyGridView extends GridView implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, ui.view.drag.e.a {
    private AdapterView.OnItemClickListener A;
    private boolean B;
    private boolean C;
    private boolean D;
    private b E;
    private Drawable F;
    private Drawable G;
    private ui.view.drag.d.a H;
    private boolean I;
    private ui.view.drag.d.b J;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ui.view.drag.b f14684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AdapterView.OnItemLongClickListener f14686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AbsListView.OnScrollListener f14687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ui.view.drag.e.c f14688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Rect f14691n;
    private MotionEvent o;
    private ListAdapter p;
    private ui.view.drag.e.b q;
    private View r;
    private int s;
    private Rect t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i3 != 0) {
                HandyGridView.this.f14681d = i2;
                HandyGridView.this.b(i2);
                if (HandyGridView.this.f14687j != null) {
                    HandyGridView.this.f14687j.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (HandyGridView.this.f14687j != null) {
                HandyGridView.this.f14687j.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public enum b {
        TOUCH,
        LONG_PRESS,
        NONE;

        public static b get(int i2) {
            int i3 = 0;
            for (b bVar : values()) {
                if (i3 == i2) {
                    return bVar;
                }
                i3++;
            }
            return null;
        }

        public static int indexOf(b bVar) {
            int i2 = -1;
            for (b bVar2 : values()) {
                i2++;
                if (bVar == bVar2) {
                    break;
                }
            }
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
        @Override // java.lang.Enum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            byte b2;
            String strName = name();
            int iHashCode = strName.hashCode();
            if (iHashCode != 2402104) {
                if (iHashCode != 80013087) {
                    b2 = (iHashCode == 1074528416 && strName.equals("LONG_PRESS")) ? (byte) 1 : (byte) -1;
                } else if (strName.equals("TOUCH")) {
                    b2 = 0;
                }
            } else if (strName.equals("NONE")) {
                b2 = 2;
            }
            return b2 != 0 ? b2 != 1 ? b2 != 2 ? super.toString() : "\u666e\u901a\u6a21\u5f0f" : "\u957f\u6309\u62d6\u62fd\u6a21\u5f0f" : "\u7f16\u8f91\u6a21\u5f0f";
        }
    }

    public HandyGridView(Context context) {
        this(context, null);
    }

    private void a(String str) {
    }

    private void e(int i2) {
        this.f14684g.b(i2);
    }

    private int getMotionPosition() {
        return pointToPosition((int) (this.o.getRawX() - this.f14691n.left), (int) (this.o.getRawY() - this.f14691n.top));
    }

    private void h() {
        this.f14684g.a();
    }

    private void i() {
        if (this.J == null || d(this.z)) {
            return;
        }
        this.J.b(this.r, this.z);
    }

    private void j() {
        if (this.J == null || d(this.z)) {
            return;
        }
        this.J.a(this.r, this.z);
    }

    private boolean k() {
        Rect rect = this.f14691n;
        Rect rect2 = this.t;
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void l() {
        this.r.getGlobalVisibleRect(this.t);
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        Rect rect = this.t;
        rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.t.height());
    }

    private void m() {
        if (this.f14691n == null) {
            this.f14691n = new Rect();
            getGlobalVisibleRect(this.f14691n);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Rect rect = this.f14691n;
            rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.f14691n.height());
        }
    }

    private void n() {
        int childCount = getChildCount();
        h();
        for (int i2 = 0; i2 < childCount; i2++) {
            a(i2, super.getChildAt(i2));
        }
    }

    private void o() {
        int[] iArrA = a(this.z);
        int left = iArrA[0] - this.r.getLeft();
        int top = iArrA[1] - this.r.getTop();
        this.r.offsetLeftAndRight(left);
        this.r.offsetTopAndBottom(top);
        j();
        if (this.r.isPressed()) {
            this.r.setPressed(false);
        }
    }

    @TargetApi(19)
    private void p() {
        int totalScrollY;
        int listPaddingBottom;
        l();
        m();
        if (!k()) {
            this.f14688k.b();
            return;
        }
        Rect rect = this.t;
        int i2 = rect.top;
        Rect rect2 = this.f14691n;
        if (i2 <= rect2.top) {
            if (!b() || this.f14688k.e()) {
                return;
            }
            int listPaddingTop = this.f14690m ? this.a : this.a - getListPaddingTop();
            this.f14688k.a(0, listPaddingTop, (Math.abs(listPaddingTop) * 1000) / this.f14689l);
            return;
        }
        if (rect.bottom < rect2.bottom) {
            this.f14688k.b();
            return;
        }
        if (!c() || this.f14688k.e()) {
            return;
        }
        if (this.f14690m) {
            totalScrollY = getTotalScrollY();
            listPaddingBottom = this.a;
        } else {
            totalScrollY = getTotalScrollY() + this.a;
            listPaddingBottom = getListPaddingBottom();
        }
        int i3 = totalScrollY + listPaddingBottom;
        this.f14688k.a(0, i3, (Math.abs(i3) * 1000) / this.f14689l);
    }

    @Override // ui.view.drag.e.a
    public void a() {
    }

    @Override // android.view.ViewGroup
    protected void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.attachViewToParent(view, i2, layoutParams);
        a(i2, view);
    }

    public boolean c() {
        return getTotalScrollY() > (-(this.f14690m ? -this.a : getListPaddingBottom()));
    }

    public boolean d() {
        return this.E == b.LONG_PRESS;
    }

    @Override // android.view.ViewGroup
    protected void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
        h();
    }

    @Override // android.view.ViewGroup
    protected void detachViewsFromParent(int i2, int i3) {
        super.detachViewsFromParent(i2, i3);
        if (i2 == 0) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                e(0);
            }
            return;
        }
        int iB = this.f14684g.b() - 1;
        for (int i5 = iB; i5 > iB - i3; i5--) {
            e(i5);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.I) {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (this.I) {
            a(canvas);
        }
    }

    public boolean f() {
        return this.C;
    }

    public boolean g() {
        if ((b() || c()) && this.D) {
            this.E = b.LONG_PRESS;
        }
        return this.E == b.TOUCH;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i2) {
        int childCount = getChildCount();
        if (this.r != null) {
            int i3 = this.z - this.f14681d;
            if (i3 != 0) {
                int i4 = childCount - 1;
                if (i3 == i4 && childCount % this.w != 1) {
                    if (i2 == i4) {
                        i2--;
                    } else if (i2 == childCount - 2) {
                        i2 = i4;
                    }
                }
            } else if (i2 == 0) {
                i2 = 1;
            } else if (i2 == 1) {
                i2 = 0;
            }
        }
        if (i2 >= getChildCount()) {
            i2 = getChildCount() - 1;
        }
        return super.getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return super.getChildCount();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.r == null) {
            return i3;
        }
        this.s = this.z - this.f14681d;
        int i4 = this.s;
        return i3 == i4 ? i2 - 1 : i3 == i2 + (-1) ? i4 : i3;
    }

    public int getDragPosition() {
        return this.z;
    }

    public b getMode() {
        return this.E;
    }

    public int getTotalScrollY() {
        if (this.p == null) {
            return 0;
        }
        int count = ((r0.getCount() - 1) / this.w) + 1;
        return ((this.v * count) + ((count - 1) * this.y)) - getHeight();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.r == null) {
            n();
            return;
        }
        n();
        View childAt = super.getChildAt(this.z - this.f14681d);
        j();
        this.r = childAt;
        i();
        a(0, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AdapterView.OnItemClickListener onItemClickListener = this.A;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i2, j2);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean z;
        if (!d() || d(i2)) {
            z = false;
        } else {
            a(view, i2);
            z = true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f14686i;
        if (onItemLongClickListener != null) {
            boolean zOnItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i2, j2);
            if (!z) {
                return zOnItemLongClick;
            }
        }
        return z;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f14691n = null;
        m();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return a(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        a(indexOfChild(view), view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        a(view);
    }

    @Override // android.widget.AbsListView
    public int pointToPosition(int i2, int i3) {
        int i4;
        int i5 = this.u;
        int i6 = this.x;
        if (i5 + i6 > 0) {
            int i7 = this.v;
            int i8 = this.y;
            if (i7 + i8 != 0) {
                int i9 = this.f14680c;
                int i10 = (i2 - i9) / (i5 + i6);
                int i11 = this.f14679b;
                int i12 = (i3 - i11) / (i7 + i8);
                int i13 = i11 + ((i12 + 1) * (i8 + i7)) + i7;
                if (i2 <= i9 + ((i10 + 1) * (i5 + i6)) && i3 <= i13 && i10 < (i4 = this.w)) {
                    int i14 = this.f14681d + (i12 * i4) + i10;
                    if (i14 <= getLastVisiblePosition()) {
                        return i14;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override // android.widget.AbsListView
    @TargetApi(19)
    public void scrollListBy(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.scrollListBy(i2);
            return;
        }
        int i3 = -i2;
        Object[] objArr = {Integer.valueOf(i3), Integer.valueOf(i3)};
        Class cls = Integer.TYPE;
        c.a(this, "trackMotionScroll", objArr, new Class[]{cls, cls});
    }

    public void setAutoOptimize(boolean z) {
        this.D = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f14690m = z;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.x = i2;
    }

    public void setMode(b bVar) {
        this.E = bVar;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        super.setNumColumns(i2);
        this.w = i2;
    }

    public void setOnItemCapturedListener(ui.view.drag.d.b bVar) {
        this.J = bVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f14686i = onItemLongClickListener;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f14687j = onScrollListener;
    }

    public void setScrollSpeed(int i2) {
        this.f14689l = i2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        if (this.C) {
            super.setSelector(drawable);
            return;
        }
        this.F = drawable;
        if (this.G == null) {
            this.G = new ColorDrawable();
        }
        super.setSelector(this.G);
    }

    public void setSelectorEnabled(boolean z) {
        Drawable drawable;
        if (z != this.C) {
            this.C = z;
            if (this.C && (drawable = this.F) != null) {
                setSelector(drawable);
            }
            if (this.C) {
                return;
            }
            setSelector(getSelector());
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.y = i2;
    }

    public HandyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14681d = -1;
        this.f14689l = 750;
        this.f14690m = false;
        this.s = -1;
        this.t = new Rect();
        this.z = -1;
        this.B = false;
        this.C = false;
        this.D = true;
        this.E = b.TOUCH;
        this.I = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        View childAt = getChildAt(0);
        this.f14680c = getListPaddingLeft();
        this.f14679b = childAt.getTop();
        this.u = childAt.getWidth();
        this.v = childAt.getHeight();
        this.a = this.f14679b - ((i2 / this.w) * (this.y + this.v));
    }

    private boolean d(int i2) {
        if (i2 != -1) {
            ListAdapter listAdapter = this.p;
            if (listAdapter instanceof ui.view.drag.e.b) {
                this.q = (ui.view.drag.e.b) listAdapter;
                if (this.q.a(i2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e() {
        return this.E == b.NONE;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.p = listAdapter;
        if (listAdapter instanceof ui.view.drag.e.b) {
            this.q = (ui.view.drag.e.b) listAdapter;
        } else {
            a("Your adapter should implements OnItemMovedListener for listening  item's swap action.");
        }
        super.setAdapter(this.p);
    }

    private void a(Context context) {
        this.f14688k = new ui.view.drag.e.c(this, new AccelerateDecelerateInterpolator());
        setChildrenDrawingOrderEnabled(true);
        super.setOnItemLongClickListener(this);
        super.setOnItemClickListener(this);
        setOverScrollMode(2);
        this.f14685h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f14684g = new ui.view.drag.b(this);
        super.setOnScrollListener(new a());
    }

    private void c(int i2, int i3) {
        ui.view.drag.a aVarA = this.f14684g.a(i2 - getFirstVisiblePosition());
        View view = aVarA.f14700b;
        if (aVarA == null || view == null) {
            return;
        }
        aVarA.a(i2, i3);
        b(i3, view);
        b(i2, i3);
        detachViewFromParent(view);
        super.attachViewToParent(view, i3 - getFirstVisiblePosition(), view.getLayoutParams());
    }

    public boolean b() {
        return this.a < (this.f14690m ? 0 : getListPaddingTop());
    }

    private void b(MotionEvent motionEvent) {
        int dragPosition;
        if (motionEvent == null || this.r == null || d(this.z)) {
            return;
        }
        m();
        l();
        int iPointToPosition = pointToPosition((int) (motionEvent.getRawX() - this.f14691n.left), (int) (motionEvent.getRawY() - this.f14691n.top));
        boolean zK = k();
        if (iPointToPosition == -1 || !zK) {
            iPointToPosition = -1;
        }
        if (d(iPointToPosition)) {
            iPointToPosition = -1;
        }
        if (iPointToPosition == -1 || iPointToPosition == (dragPosition = getDragPosition())) {
            return;
        }
        l();
        if (iPointToPosition >= dragPosition) {
            while (true) {
                dragPosition++;
                if (dragPosition > iPointToPosition) {
                    break;
                } else {
                    c(dragPosition, dragPosition - 1);
                }
            }
        } else {
            for (int i2 = dragPosition - 1; i2 >= iPointToPosition; i2--) {
                c(i2, i2 + 1);
            }
        }
        b(iPointToPosition, this.r);
        this.z = iPointToPosition;
    }

    private int c(int i2) {
        return i2 - this.f14681d;
    }

    public void a(ui.view.drag.d.a aVar, boolean z) {
        this.H = aVar;
        this.I = z;
    }

    private void a(int i2, View view) {
        if (i2 < 0) {
            i2 = this.f14684g.b();
        }
        this.f14684g.a(i2, view);
    }

    private boolean a(View view) {
        int iB = this.f14684g.b();
        for (int i2 = 0; i2 < iB; i2++) {
            ui.view.drag.a aVarA = this.f14684g.a(i2);
            if (aVarA.f14700b == view) {
                return this.f14684g.a(aVarA);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.o = motionEvent;
        boolean z = false;
        if (action == 0) {
            this.f14682e = motionEvent.getRawX();
            this.f14683f = motionEvent.getRawY();
            this.B = false;
            if (g()) {
                a((View) null, -1);
                invalidate();
                View view = this.r;
                if (view != null) {
                    view.setPressed(true);
                }
            }
        } else if (action == 1) {
            if (this.r != null) {
                o();
                this.f14688k.b();
                z = true;
            }
            this.r = null;
            this.o = null;
        } else if (action == 2) {
            int rawX = (int) (motionEvent.getRawX() - this.f14682e);
            int rawY = (int) (motionEvent.getRawY() - this.f14683f);
            View view2 = this.r;
            if (view2 != null) {
                if (!this.B) {
                    if (view2.isPressed()) {
                        this.r.setPressed(false);
                    }
                    this.B = true;
                }
                if (this.B) {
                    a(rawX, rawY);
                    b(motionEvent);
                    p();
                }
                this.f14682e = motionEvent.getRawX();
                this.f14683f = motionEvent.getRawY();
                z = true;
            }
        } else if (action == 3) {
        }
        if (g()) {
            z = true;
        }
        return z ? z : super.onTouchEvent(motionEvent);
    }

    private void b(int i2, int i3) {
        ui.view.drag.e.b bVar = this.q;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
    }

    private void b(int i2, View view) {
        a(view);
        a(c(i2), view);
    }

    private void a(View view, int i2) {
        m();
        if (view == null && i2 == -1) {
            int motionPosition = getMotionPosition();
            if (motionPosition != -1) {
                a(getChildAt(motionPosition - this.f14681d), motionPosition);
                return;
            }
            return;
        }
        this.z = i2;
        this.r = view;
        l();
        this.s = this.z - this.f14681d;
        i();
        a(0, 0);
    }

    private void a(Canvas canvas) {
        if (this.H != null) {
            canvas.save();
            this.H.a(canvas, getWidth(), getHeight());
            canvas.restore();
        }
    }

    @Override // ui.view.drag.e.a
    public void a(int i2, int i3, int i4, int i5) {
        int i6 = i5 - i3;
        this.r.offsetTopAndBottom(i6);
        scrollListBy(i6);
        b(this.o);
    }

    public int[] a(int i2) {
        int i3 = this.w;
        return new int[]{this.f14680c + ((i2 % i3) * (this.u + this.x)), this.a + ((i2 / i3) * (this.v + this.y))};
    }

    private void a(int i2, int i3) {
        MotionEvent motionEvent = this.o;
        if (motionEvent == null) {
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = this.o.getRawY();
        m();
        int left = ((int) ((rawX - this.f14691n.left) - (this.r.getLeft() + (this.u / 2)))) + i2;
        int top = ((int) ((rawY - this.f14691n.top) - (this.r.getTop() + (this.v / 2)))) + i3;
        if (d(this.z)) {
            return;
        }
        this.r.offsetLeftAndRight(left);
        this.r.offsetTopAndBottom(top);
    }
}
