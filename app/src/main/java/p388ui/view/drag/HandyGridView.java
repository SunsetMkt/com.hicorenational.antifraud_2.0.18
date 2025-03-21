package p388ui.view.drag;

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
import p388ui.view.drag.p392d.InterfaceC7213a;
import p388ui.view.drag.p392d.InterfaceC7214b;
import p388ui.view.drag.p393e.InterfaceC7215a;
import p388ui.view.drag.p393e.InterfaceC7216b;
import p388ui.view.drag.p393e.RunnableC7217c;

/* loaded from: classes2.dex */
public class HandyGridView extends GridView implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, InterfaceC7215a {

    /* renamed from: A */
    private AdapterView.OnItemClickListener f24788A;

    /* renamed from: B */
    private boolean f24789B;

    /* renamed from: C */
    private boolean f24790C;

    /* renamed from: D */
    private boolean f24791D;

    /* renamed from: E */
    private EnumC7209b f24792E;

    /* renamed from: F */
    private Drawable f24793F;

    /* renamed from: G */
    private Drawable f24794G;

    /* renamed from: H */
    private InterfaceC7213a f24795H;

    /* renamed from: I */
    private boolean f24796I;

    /* renamed from: J */
    private InterfaceC7214b f24797J;

    /* renamed from: a */
    private int f24798a;

    /* renamed from: b */
    private int f24799b;

    /* renamed from: c */
    private int f24800c;

    /* renamed from: d */
    private int f24801d;

    /* renamed from: e */
    private float f24802e;

    /* renamed from: f */
    private float f24803f;

    /* renamed from: g */
    private C7211b f24804g;

    /* renamed from: h */
    private int f24805h;

    /* renamed from: i */
    private AdapterView.OnItemLongClickListener f24806i;

    /* renamed from: j */
    private AbsListView.OnScrollListener f24807j;

    /* renamed from: k */
    private RunnableC7217c f24808k;

    /* renamed from: l */
    private int f24809l;

    /* renamed from: m */
    private boolean f24810m;

    /* renamed from: n */
    private Rect f24811n;

    /* renamed from: o */
    private MotionEvent f24812o;

    /* renamed from: p */
    private ListAdapter f24813p;

    /* renamed from: q */
    private InterfaceC7216b f24814q;

    /* renamed from: r */
    private View f24815r;

    /* renamed from: s */
    private int f24816s;

    /* renamed from: t */
    private Rect f24817t;

    /* renamed from: u */
    private int f24818u;

    /* renamed from: v */
    private int f24819v;

    /* renamed from: w */
    private int f24820w;

    /* renamed from: x */
    private int f24821x;

    /* renamed from: y */
    private int f24822y;

    /* renamed from: z */
    private int f24823z;

    /* renamed from: ui.view.drag.HandyGridView$a */
    class C7208a implements AbsListView.OnScrollListener {
        C7208a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i3 != 0) {
                HandyGridView.this.f24801d = i2;
                HandyGridView.this.m25901b(i2);
                if (HandyGridView.this.f24807j != null) {
                    HandyGridView.this.f24807j.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (HandyGridView.this.f24807j != null) {
                HandyGridView.this.f24807j.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* renamed from: ui.view.drag.HandyGridView$b */
    public enum EnumC7209b {
        TOUCH,
        LONG_PRESS,
        NONE;

        public static EnumC7209b get(int i2) {
            int i3 = 0;
            for (EnumC7209b enumC7209b : values()) {
                if (i3 == i2) {
                    return enumC7209b;
                }
                i3++;
            }
            return null;
        }

        public static int indexOf(EnumC7209b enumC7209b) {
            int i2 = -1;
            for (EnumC7209b enumC7209b2 : values()) {
                i2++;
                if (enumC7209b == enumC7209b2) {
                    break;
                }
            }
            return i2;
        }

        @Override // java.lang.Enum
        public String toString() {
            char c2;
            String name = name();
            int hashCode = name.hashCode();
            if (hashCode == 2402104) {
                if (name.equals("NONE")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 80013087) {
                if (hashCode == 1074528416 && name.equals("LONG_PRESS")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (name.equals("TOUCH")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            return c2 != 0 ? c2 != 1 ? c2 != 2 ? super.toString() : "普通模式" : "长按拖拽模式" : "编辑模式";
        }
    }

    public HandyGridView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m25898a(String str) {
    }

    /* renamed from: e */
    private void m25909e(int i2) {
        this.f24804g.m25941b(i2);
    }

    private int getMotionPosition() {
        return pointToPosition((int) (this.f24812o.getRawX() - this.f24811n.left), (int) (this.f24812o.getRawY() - this.f24811n.top));
    }

    /* renamed from: h */
    private void m25910h() {
        this.f24804g.m25937a();
    }

    /* renamed from: i */
    private void m25911i() {
        if (this.f24797J == null || m25908d(this.f24823z)) {
            return;
        }
        this.f24797J.m25945b(this.f24815r, this.f24823z);
    }

    /* renamed from: j */
    private void m25912j() {
        if (this.f24797J == null || m25908d(this.f24823z)) {
            return;
        }
        this.f24797J.m25944a(this.f24815r, this.f24823z);
    }

    /* renamed from: k */
    private boolean m25913k() {
        Rect rect = this.f24811n;
        Rect rect2 = this.f24817t;
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* renamed from: l */
    private void m25914l() {
        this.f24815r.getGlobalVisibleRect(this.f24817t);
        int[] iArr = new int[2];
        this.f24815r.getLocationOnScreen(iArr);
        Rect rect = this.f24817t;
        rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.f24817t.height());
    }

    /* renamed from: m */
    private void m25915m() {
        if (this.f24811n == null) {
            this.f24811n = new Rect();
            getGlobalVisibleRect(this.f24811n);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Rect rect = this.f24811n;
            rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.f24811n.height());
        }
    }

    /* renamed from: n */
    private void m25916n() {
        int childCount = getChildCount();
        m25910h();
        for (int i2 = 0; i2 < childCount; i2++) {
            m25894a(i2, super.getChildAt(i2));
        }
    }

    /* renamed from: o */
    private void m25917o() {
        int[] m25922a = m25922a(this.f24823z);
        int left = m25922a[0] - this.f24815r.getLeft();
        int top = m25922a[1] - this.f24815r.getTop();
        this.f24815r.offsetLeftAndRight(left);
        this.f24815r.offsetTopAndBottom(top);
        m25912j();
        if (this.f24815r.isPressed()) {
            this.f24815r.setPressed(false);
        }
    }

    @TargetApi(19)
    /* renamed from: p */
    private void m25918p() {
        int totalScrollY;
        int listPaddingBottom;
        m25914l();
        m25915m();
        if (!m25913k()) {
            this.f24808k.m25954b();
            return;
        }
        Rect rect = this.f24817t;
        int i2 = rect.top;
        Rect rect2 = this.f24811n;
        if (i2 <= rect2.top) {
            if (!m25923b() || this.f24808k.m25957e()) {
                return;
            }
            int listPaddingTop = this.f24810m ? this.f24798a : this.f24798a - getListPaddingTop();
            this.f24808k.m25950a(0, listPaddingTop, (Math.abs(listPaddingTop) * 1000) / this.f24809l);
            return;
        }
        if (rect.bottom < rect2.bottom) {
            this.f24808k.m25954b();
            return;
        }
        if (!m25924c() || this.f24808k.m25957e()) {
            return;
        }
        if (this.f24810m) {
            totalScrollY = getTotalScrollY();
            listPaddingBottom = this.f24798a;
        } else {
            totalScrollY = getTotalScrollY() + this.f24798a;
            listPaddingBottom = getListPaddingBottom();
        }
        int i3 = totalScrollY + listPaddingBottom;
        this.f24808k.m25950a(0, i3, (Math.abs(i3) * 1000) / this.f24809l);
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    /* renamed from: a */
    public void mo25919a() {
    }

    @Override // android.view.ViewGroup
    protected void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.attachViewToParent(view, i2, layoutParams);
        m25894a(i2, view);
    }

    /* renamed from: c */
    public boolean m25924c() {
        return getTotalScrollY() > (-(this.f24810m ? -this.f24798a : getListPaddingBottom()));
    }

    /* renamed from: d */
    public boolean m25925d() {
        return this.f24792E == EnumC7209b.LONG_PRESS;
    }

    @Override // android.view.ViewGroup
    protected void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
        m25910h();
    }

    @Override // android.view.ViewGroup
    protected void detachViewsFromParent(int i2, int i3) {
        super.detachViewsFromParent(i2, i3);
        if (i2 == 0) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                m25909e(0);
            }
            return;
        }
        int m25940b = this.f24804g.m25940b() - 1;
        for (int i5 = m25940b; i5 > m25940b - i3; i5--) {
            m25909e(i5);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.f24796I) {
            m25896a(canvas);
        }
        super.dispatchDraw(canvas);
        if (this.f24796I) {
            m25896a(canvas);
        }
    }

    /* renamed from: f */
    public boolean m25927f() {
        return this.f24790C;
    }

    /* renamed from: g */
    public boolean m25928g() {
        if ((m25923b() || m25924c()) && this.f24791D) {
            this.f24792E = EnumC7209b.LONG_PRESS;
        }
        return this.f24792E == EnumC7209b.TOUCH;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i2) {
        int childCount = getChildCount();
        if (this.f24815r != null) {
            int i3 = this.f24823z - this.f24801d;
            if (i3 != 0) {
                int i4 = childCount - 1;
                if (i3 == i4 && childCount % this.f24820w != 1) {
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
        if (this.f24815r == null) {
            return i3;
        }
        this.f24816s = this.f24823z - this.f24801d;
        int i4 = this.f24816s;
        return i3 == i4 ? i2 - 1 : i3 == i2 + (-1) ? i4 : i3;
    }

    public int getDragPosition() {
        return this.f24823z;
    }

    public EnumC7209b getMode() {
        return this.f24792E;
    }

    public int getTotalScrollY() {
        if (this.f24813p == null) {
            return 0;
        }
        int count = ((r0.getCount() - 1) / this.f24820w) + 1;
        return ((this.f24819v * count) + ((count - 1) * this.f24822y)) - getHeight();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.f24815r == null) {
            m25916n();
            return;
        }
        m25916n();
        View childAt = super.getChildAt(this.f24823z - this.f24801d);
        m25912j();
        this.f24815r = childAt;
        m25911i();
        m25893a(0, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AdapterView.OnItemClickListener onItemClickListener = this.f24788A;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i2, j2);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean z;
        if (!m25925d() || m25908d(i2)) {
            z = false;
        } else {
            m25897a(view, i2);
            z = true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f24806i;
        if (onItemLongClickListener != null) {
            boolean onItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i2, j2);
            if (!z) {
                return onItemLongClick;
            }
        }
        return z;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f24811n = null;
        m25915m();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return m25899a(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        m25894a(indexOfChild(view), view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        m25900a(view);
    }

    @Override // android.widget.AbsListView
    public int pointToPosition(int i2, int i3) {
        int i4;
        int i5 = this.f24818u;
        int i6 = this.f24821x;
        if (i5 + i6 > 0) {
            int i7 = this.f24819v;
            int i8 = this.f24822y;
            if (i7 + i8 != 0) {
                int i9 = this.f24800c;
                int i10 = (i2 - i9) / (i5 + i6);
                int i11 = this.f24799b;
                int i12 = (i3 - i11) / (i7 + i8);
                int i13 = i11 + ((i12 + 1) * (i8 + i7)) + i7;
                if (i2 <= i9 + ((i10 + 1) * (i5 + i6)) && i3 <= i13 && i10 < (i4 = this.f24820w)) {
                    int i14 = this.f24801d + (i12 * i4) + i10;
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
        C7212c.m25942a(this, "trackMotionScroll", objArr, new Class[]{cls, cls});
    }

    public void setAutoOptimize(boolean z) {
        this.f24791D = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f24810m = z;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.f24821x = i2;
    }

    public void setMode(EnumC7209b enumC7209b) {
        this.f24792E = enumC7209b;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        super.setNumColumns(i2);
        this.f24820w = i2;
    }

    public void setOnItemCapturedListener(InterfaceC7214b interfaceC7214b) {
        this.f24797J = interfaceC7214b;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f24788A = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f24806i = onItemLongClickListener;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f24807j = onScrollListener;
    }

    public void setScrollSpeed(int i2) {
        this.f24809l = i2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        if (this.f24790C) {
            super.setSelector(drawable);
            return;
        }
        this.f24793F = drawable;
        if (this.f24794G == null) {
            this.f24794G = new ColorDrawable();
        }
        super.setSelector(this.f24794G);
    }

    public void setSelectorEnabled(boolean z) {
        Drawable drawable;
        if (z != this.f24790C) {
            this.f24790C = z;
            if (this.f24790C && (drawable = this.f24793F) != null) {
                setSelector(drawable);
            }
            if (this.f24790C) {
                return;
            }
            setSelector(getSelector());
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.f24822y = i2;
    }

    public HandyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24801d = -1;
        this.f24809l = 750;
        this.f24810m = false;
        this.f24816s = -1;
        this.f24817t = new Rect();
        this.f24823z = -1;
        this.f24789B = false;
        this.f24790C = false;
        this.f24791D = true;
        this.f24792E = EnumC7209b.TOUCH;
        this.f24796I = false;
        m25895a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m25901b(int i2) {
        View childAt = getChildAt(0);
        this.f24800c = getListPaddingLeft();
        this.f24799b = childAt.getTop();
        this.f24818u = childAt.getWidth();
        this.f24819v = childAt.getHeight();
        this.f24798a = this.f24799b - ((i2 / this.f24820w) * (this.f24822y + this.f24819v));
    }

    /* renamed from: d */
    private boolean m25908d(int i2) {
        if (i2 != -1) {
            ListAdapter listAdapter = this.f24813p;
            if (listAdapter instanceof InterfaceC7216b) {
                this.f24814q = (InterfaceC7216b) listAdapter;
                if (this.f24814q.m25947a(i2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public boolean m25926e() {
        return this.f24792E == EnumC7209b.NONE;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.f24813p = listAdapter;
        if (listAdapter instanceof InterfaceC7216b) {
            this.f24814q = (InterfaceC7216b) listAdapter;
        } else {
            m25898a("Your adapter should implements OnItemMovedListener for listening  item's swap action.");
        }
        super.setAdapter(this.f24813p);
    }

    /* renamed from: a */
    private void m25895a(Context context) {
        this.f24808k = new RunnableC7217c(this, new AccelerateDecelerateInterpolator());
        setChildrenDrawingOrderEnabled(true);
        super.setOnItemLongClickListener(this);
        super.setOnItemClickListener(this);
        setOverScrollMode(2);
        this.f24805h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f24804g = new C7211b(this);
        super.setOnScrollListener(new C7208a());
    }

    /* renamed from: c */
    private void m25907c(int i2, int i3) {
        C7210a m25936a = this.f24804g.m25936a(i2 - getFirstVisiblePosition());
        View view = m25936a.f24836b;
        if (m25936a == null || view == null) {
            return;
        }
        m25936a.m25932a(i2, i3);
        m25903b(i3, view);
        m25902b(i2, i3);
        detachViewFromParent(view);
        super.attachViewToParent(view, i3 - getFirstVisiblePosition(), view.getLayoutParams());
    }

    /* renamed from: b */
    public boolean m25923b() {
        return this.f24798a < (this.f24810m ? 0 : getListPaddingTop());
    }

    /* renamed from: b */
    private void m25904b(MotionEvent motionEvent) {
        int dragPosition;
        if (motionEvent == null || this.f24815r == null || m25908d(this.f24823z)) {
            return;
        }
        m25915m();
        m25914l();
        int pointToPosition = pointToPosition((int) (motionEvent.getRawX() - this.f24811n.left), (int) (motionEvent.getRawY() - this.f24811n.top));
        boolean m25913k = m25913k();
        if (pointToPosition == -1 || !m25913k) {
            pointToPosition = -1;
        }
        if (m25908d(pointToPosition)) {
            pointToPosition = -1;
        }
        if (pointToPosition == -1 || pointToPosition == (dragPosition = getDragPosition())) {
            return;
        }
        m25914l();
        if (pointToPosition >= dragPosition) {
            while (true) {
                dragPosition++;
                if (dragPosition > pointToPosition) {
                    break;
                } else {
                    m25907c(dragPosition, dragPosition - 1);
                }
            }
        } else {
            for (int i2 = dragPosition - 1; i2 >= pointToPosition; i2--) {
                m25907c(i2, i2 + 1);
            }
        }
        m25903b(pointToPosition, this.f24815r);
        this.f24823z = pointToPosition;
    }

    /* renamed from: c */
    private int m25906c(int i2) {
        return i2 - this.f24801d;
    }

    /* renamed from: a */
    public void m25921a(InterfaceC7213a interfaceC7213a, boolean z) {
        this.f24795H = interfaceC7213a;
        this.f24796I = z;
    }

    /* renamed from: a */
    private void m25894a(int i2, View view) {
        if (i2 < 0) {
            i2 = this.f24804g.m25940b();
        }
        this.f24804g.m25938a(i2, view);
    }

    /* renamed from: a */
    private boolean m25900a(View view) {
        int m25940b = this.f24804g.m25940b();
        for (int i2 = 0; i2 < m25940b; i2++) {
            C7210a m25936a = this.f24804g.m25936a(i2);
            if (m25936a.f24836b == view) {
                return this.f24804g.m25939a(m25936a);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r0 != 3) goto L31;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m25899a(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r6.f24812o = r7
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L67
            if (r0 == r3) goto L55
            r4 = 2
            if (r0 == r4) goto L15
            r4 = 3
            if (r0 == r4) goto L55
            goto L89
        L15:
            float r0 = r7.getRawX()
            float r1 = r6.f24802e
            float r0 = r0 - r1
            int r0 = (int) r0
            float r1 = r7.getRawY()
            float r4 = r6.f24803f
            float r1 = r1 - r4
            int r1 = (int) r1
            android.view.View r4 = r6.f24815r
            if (r4 == 0) goto L89
            boolean r5 = r6.f24789B
            if (r5 != 0) goto L3a
            boolean r4 = r4.isPressed()
            if (r4 == 0) goto L38
            android.view.View r4 = r6.f24815r
            r4.setPressed(r2)
        L38:
            r6.f24789B = r3
        L3a:
            boolean r2 = r6.f24789B
            if (r2 == 0) goto L47
            r6.m25893a(r0, r1)
            r6.m25904b(r7)
            r6.m25918p()
        L47:
            float r0 = r7.getRawX()
            r6.f24802e = r0
            float r0 = r7.getRawY()
            r6.f24803f = r0
            r2 = 1
            goto L89
        L55:
            android.view.View r0 = r6.f24815r
            if (r0 == 0) goto L62
            r6.m25917o()
            ui.view.drag.e.c r0 = r6.f24808k
            r0.m25954b()
            r2 = 1
        L62:
            r6.f24815r = r1
            r6.f24812o = r1
            goto L89
        L67:
            float r0 = r7.getRawX()
            r6.f24802e = r0
            float r0 = r7.getRawY()
            r6.f24803f = r0
            r6.f24789B = r2
            boolean r0 = r6.m25928g()
            if (r0 == 0) goto L89
            r0 = -1
            r6.m25897a(r1, r0)
            r6.invalidate()
            android.view.View r0 = r6.f24815r
            if (r0 == 0) goto L89
            r0.setPressed(r3)
        L89:
            boolean r0 = r6.m25928g()
            if (r0 == 0) goto L90
            r2 = 1
        L90:
            if (r2 == 0) goto L93
            goto L97
        L93:
            boolean r2 = super.onTouchEvent(r7)
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.view.drag.HandyGridView.m25899a(android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    private void m25902b(int i2, int i3) {
        InterfaceC7216b interfaceC7216b = this.f24814q;
        if (interfaceC7216b != null) {
            interfaceC7216b.m25946a(i2, i3);
        }
    }

    /* renamed from: b */
    private void m25903b(int i2, View view) {
        m25900a(view);
        m25894a(m25906c(i2), view);
    }

    /* renamed from: a */
    private void m25897a(View view, int i2) {
        m25915m();
        if (view == null && i2 == -1) {
            int motionPosition = getMotionPosition();
            if (motionPosition != -1) {
                m25897a(getChildAt(motionPosition - this.f24801d), motionPosition);
                return;
            }
            return;
        }
        this.f24823z = i2;
        this.f24815r = view;
        m25914l();
        this.f24816s = this.f24823z - this.f24801d;
        m25911i();
        m25893a(0, 0);
    }

    /* renamed from: a */
    private void m25896a(Canvas canvas) {
        if (this.f24795H != null) {
            canvas.save();
            this.f24795H.m25943a(canvas, getWidth(), getHeight());
            canvas.restore();
        }
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    /* renamed from: a */
    public void mo25920a(int i2, int i3, int i4, int i5) {
        int i6 = i5 - i3;
        this.f24815r.offsetTopAndBottom(i6);
        scrollListBy(i6);
        m25904b(this.f24812o);
    }

    /* renamed from: a */
    public int[] m25922a(int i2) {
        int i3 = this.f24820w;
        return new int[]{this.f24800c + ((i2 % i3) * (this.f24818u + this.f24821x)), this.f24798a + ((i2 / i3) * (this.f24819v + this.f24822y))};
    }

    /* renamed from: a */
    private void m25893a(int i2, int i3) {
        MotionEvent motionEvent = this.f24812o;
        if (motionEvent == null) {
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = this.f24812o.getRawY();
        m25915m();
        int left = ((int) ((rawX - this.f24811n.left) - (this.f24815r.getLeft() + (this.f24818u / 2)))) + i2;
        int top = ((int) ((rawY - this.f24811n.top) - (this.f24815r.getTop() + (this.f24819v / 2)))) + i3;
        if (m25908d(this.f24823z)) {
            return;
        }
        this.f24815r.offsetLeftAndRight(left);
        this.f24815r.offsetTopAndBottom(top);
    }
}
