package p388ui.view.marq;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.AnimRes;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import bean.TowContentBean;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import util.C7264c1;

/* loaded from: classes2.dex */
public class MarqueeView<T> extends ViewFlipper {

    /* renamed from: o */
    private static final int f24896o = 0;

    /* renamed from: p */
    private static final int f24897p = 1;

    /* renamed from: q */
    private static final int f24898q = 2;

    /* renamed from: r */
    private static final int f24899r = 0;

    /* renamed from: s */
    private static final int f24900s = 1;

    /* renamed from: t */
    private static final int f24901t = 2;

    /* renamed from: u */
    private static final int f24902u = 3;

    /* renamed from: a */
    private int f24903a;

    /* renamed from: b */
    private boolean f24904b;

    /* renamed from: c */
    private int f24905c;

    /* renamed from: d */
    private int f24906d;

    /* renamed from: e */
    private int f24907e;

    /* renamed from: f */
    private boolean f24908f;

    /* renamed from: g */
    private int f24909g;

    /* renamed from: h */
    private int f24910h;

    /* renamed from: i */
    @AnimRes
    private int f24911i;

    /* renamed from: j */
    @AnimRes
    private int f24912j;

    /* renamed from: k */
    private int f24913k;

    /* renamed from: l */
    private List<T> f24914l;

    /* renamed from: m */
    private InterfaceC7233e f24915m;

    /* renamed from: n */
    private boolean f24916n;

    /* renamed from: ui.view.marq.MarqueeView$a */
    class ViewTreeObserverOnGlobalLayoutListenerC7229a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ String f24917a;

        /* renamed from: b */
        final /* synthetic */ int f24918b;

        /* renamed from: c */
        final /* synthetic */ int f24919c;

        ViewTreeObserverOnGlobalLayoutListenerC7229a(String str, int i2, int i3) {
            this.f24917a = str;
            this.f24918b = i2;
            this.f24919c = i3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 16) {
                MarqueeView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                MarqueeView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            MarqueeView.this.m25991b(this.f24917a, this.f24918b, this.f24919c);
        }
    }

    /* renamed from: ui.view.marq.MarqueeView$b */
    class RunnableC7230b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f24921a;

        /* renamed from: b */
        final /* synthetic */ int f24922b;

        RunnableC7230b(int i2, int i3) {
            this.f24921a = i2;
            this.f24922b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView.this.m25994c(this.f24921a, this.f24922b);
        }
    }

    /* renamed from: ui.view.marq.MarqueeView$c */
    class AnimationAnimationListenerC7231c implements Animation.AnimationListener {
        AnimationAnimationListenerC7231c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MarqueeView.m25993c(MarqueeView.this);
            if (MarqueeView.this.f24913k >= MarqueeView.this.f24914l.size()) {
                MarqueeView.this.f24913k = 0;
            }
            MarqueeView marqueeView = MarqueeView.this;
            View m25980a = marqueeView.m25980a((MarqueeView) marqueeView.f24914l.get(MarqueeView.this.f24913k));
            if (m25980a.getParent() == null) {
                MarqueeView.this.addView(m25980a);
            }
            MarqueeView.this.f24916n = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (MarqueeView.this.f24916n) {
                animation.cancel();
            }
            MarqueeView.this.f24916n = true;
        }
    }

    /* renamed from: ui.view.marq.MarqueeView$d */
    class ViewOnClickListenerC7232d implements View.OnClickListener {
        ViewOnClickListenerC7232d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MarqueeView.this.f24915m != null) {
                MarqueeView.this.f24915m.onItemClick(MarqueeView.this.getPosition(), view);
            }
        }
    }

    /* renamed from: ui.view.marq.MarqueeView$e */
    public interface InterfaceC7233e {
        void onItemClick(int i2, View view);
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    static /* synthetic */ int m25993c(MarqueeView marqueeView) {
        int i2 = marqueeView.f24913k;
        marqueeView.f24913k = i2 + 1;
        return i2;
    }

    public List<T> getMessages() {
        return this.f24914l;
    }

    public int getPosition() {
        return ((Integer) getCurrentView().getTag()).intValue();
    }

    public void setMessages(List<T> list) {
        this.f24914l = list;
    }

    public void setOnItemClickListener(InterfaceC7233e interfaceC7233e) {
        this.f24915m = interfaceC7233e;
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24903a = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.f24904b = false;
        this.f24905c = 1000;
        this.f24906d = 14;
        this.f24907e = ViewCompat.MEASURED_STATE_MASK;
        this.f24908f = false;
        this.f24909g = 19;
        this.f24910h = 0;
        this.f24911i = C2113R.anim.anim_bottom_in;
        this.f24912j = C2113R.anim.anim_top_out;
        this.f24914l = new ArrayList();
        this.f24916n = false;
        m25983a(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m25991b(String str, @AnimRes int i2, @AnimRes int i3) {
        int length = str.length();
        int m26291b = (int) C7264c1.m26291b(getContext(), getWidth());
        if (m26291b == 0) {
            throw new RuntimeException("Please set the width of MarqueeView !");
        }
        int i4 = m26291b / this.f24906d;
        ArrayList arrayList = new ArrayList();
        if (length <= i4) {
            arrayList.add(str);
        } else {
            int i5 = 0;
            int i6 = (length / i4) + (length % i4 != 0 ? 1 : 0);
            while (i5 < i6) {
                int i7 = i5 * i4;
                i5++;
                int i8 = i5 * i4;
                if (i8 >= length) {
                    i8 = length;
                }
                arrayList.add(str.substring(i7, i8));
            }
        }
        if (this.f24914l == null) {
            this.f24914l = new ArrayList();
        }
        this.f24914l.clear();
        this.f24914l.addAll(arrayList);
        m25982a(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m25994c(@AnimRes int i2, @AnimRes int i3) {
        stopFlipping();
        removeAllViews();
        clearAnimation();
        List<T> list = this.f24914l;
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("The messages cannot be empty!");
        }
        this.f24913k = 0;
        addView(m25980a((MarqueeView<T>) this.f24914l.get(this.f24913k)));
        if (this.f24914l.size() > 1) {
            m25990b(i2, i3);
            startFlipping();
        }
        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new AnimationAnimationListenerC7231c());
        }
    }

    /* renamed from: a */
    private void m25983a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2113R.styleable.MarqueeViewStyle, i2, 0);
        this.f24903a = obtainStyledAttributes.getInteger(4, this.f24903a);
        this.f24904b = obtainStyledAttributes.hasValue(0);
        this.f24905c = obtainStyledAttributes.getInteger(0, this.f24905c);
        this.f24908f = obtainStyledAttributes.getBoolean(5, false);
        if (obtainStyledAttributes.hasValue(7)) {
            this.f24906d = (int) obtainStyledAttributes.getDimension(7, this.f24906d);
            this.f24906d = C7264c1.m26295c(context, this.f24906d);
        }
        this.f24907e = obtainStyledAttributes.getColor(6, this.f24907e);
        int i3 = obtainStyledAttributes.getInt(3, 0);
        if (i3 == 0) {
            this.f24909g = 19;
        } else if (i3 == 1) {
            this.f24909g = 17;
        } else if (i3 == 2) {
            this.f24909g = 21;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f24910h = obtainStyledAttributes.getInt(1, this.f24910h);
            int i4 = this.f24910h;
            if (i4 == 0) {
                this.f24911i = C2113R.anim.anim_bottom_in;
                this.f24912j = C2113R.anim.anim_top_out;
            } else if (i4 == 1) {
                this.f24911i = C2113R.anim.anim_top_in;
                this.f24912j = C2113R.anim.anim_bottom_out;
            } else if (i4 == 2) {
                this.f24911i = C2113R.anim.anim_right_in;
                this.f24912j = C2113R.anim.anim_left_out;
            } else if (i4 == 3) {
                this.f24911i = C2113R.anim.anim_left_in;
                this.f24912j = C2113R.anim.anim_right_out;
            }
        } else {
            this.f24911i = C2113R.anim.anim_bottom_in;
            this.f24912j = C2113R.anim.anim_top_out;
        }
        obtainStyledAttributes.recycle();
        setFlipInterval(this.f24903a);
    }

    /* renamed from: b */
    public static <T> boolean m25992b(List<T> list) {
        return list == null || list.size() == 0;
    }

    /* renamed from: b */
    private CharSequence m25989b(T t) {
        if (t instanceof CharSequence) {
            return (CharSequence) t;
        }
        return t instanceof InterfaceC7234a ? ((InterfaceC7234a) t).m26001a() : "";
    }

    /* renamed from: b */
    private void m25990b(@AnimRes int i2, @AnimRes int i3) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i2);
        if (this.f24904b) {
            loadAnimation.setDuration(this.f24905c);
        }
        setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i3);
        if (this.f24904b) {
            loadAnimation2.setDuration(this.f24905c);
        }
        setOutAnimation(loadAnimation2);
    }

    /* renamed from: a */
    public void m25997a(String str) {
        m25998a(str, this.f24911i, this.f24912j);
    }

    /* renamed from: a */
    public void m25998a(String str, @AnimRes int i2, @AnimRes int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC7229a(str, i2, i3));
    }

    /* renamed from: a */
    public void m25999a(List<T> list) {
        m26000a(list, this.f24911i, this.f24912j);
    }

    /* renamed from: a */
    public void m26000a(List<T> list, @AnimRes int i2, @AnimRes int i3) {
        if (m25992b((List) list)) {
            return;
        }
        setMessages(list);
        m25982a(i2, i3);
    }

    /* renamed from: a */
    private void m25982a(@AnimRes int i2, @AnimRes int i3) {
        post(new RunnableC7230b(i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public View m25980a(T t) {
        TextView textView;
        TextView textView2;
        View childAt = getChildAt((getDisplayedChild() + 1) % 3);
        if (childAt == null) {
            childAt = LayoutInflater.from(getContext()).inflate(C2113R.layout.marquee_view, (ViewGroup) this, false);
            textView = (TextView) childAt.findViewById(C2113R.id.tv_marqee);
            textView2 = (TextView) childAt.findViewById(C2113R.id.tv_marqee_sec);
            childAt.setOnClickListener(new ViewOnClickListenerC7232d());
        } else {
            textView = (TextView) childAt.findViewById(C2113R.id.tv_marqee);
            textView2 = (TextView) childAt.findViewById(C2113R.id.tv_marqee_sec);
        }
        if (t instanceof TowContentBean) {
            TowContentBean towContentBean = (TowContentBean) t;
            textView.setText(towContentBean.getContentOne());
            if (!TextUtils.isEmpty(towContentBean.getContentTwo())) {
                textView2.setText(towContentBean.getContentTwo());
            }
        }
        childAt.setTag(Integer.valueOf(this.f24913k));
        return childAt;
    }
}
