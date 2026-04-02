package ui.view.marq;

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
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import util.g1;

/* JADX INFO: loaded from: classes2.dex */
public class MarqueeView<T> extends ViewFlipper {
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @AnimRes
    private int f14728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @AnimRes
    private int f14729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<T> f14731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f14732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f14733n;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f14735c;

        a(String str, int i2, int i3) {
            this.a = str;
            this.f14734b = i2;
            this.f14735c = i3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 16) {
                MarqueeView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                MarqueeView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            MarqueeView.this.b(this.a, this.f14734b, this.f14735c);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14737b;

        b(int i2, int i3) {
            this.a = i2;
            this.f14737b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView.this.c(this.a, this.f14737b);
        }
    }

    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MarqueeView.c(MarqueeView.this);
            if (MarqueeView.this.f14730k >= MarqueeView.this.f14731l.size()) {
                MarqueeView.this.f14730k = 0;
            }
            MarqueeView marqueeView = MarqueeView.this;
            View viewA = marqueeView.a(marqueeView.f14731l.get(MarqueeView.this.f14730k));
            if (viewA.getParent() == null) {
                MarqueeView.this.addView(viewA);
            }
            MarqueeView.this.f14733n = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (MarqueeView.this.f14733n) {
                animation.cancel();
            }
            MarqueeView.this.f14733n = true;
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MarqueeView.this.f14732m != null) {
                MarqueeView.this.f14732m.onItemClick(MarqueeView.this.getPosition(), view);
            }
        }
    }

    public interface e {
        void onItemClick(int i2, View view);
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    static /* synthetic */ int c(MarqueeView marqueeView) {
        int i2 = marqueeView.f14730k;
        marqueeView.f14730k = i2 + 1;
        return i2;
    }

    public List<T> getMessages() {
        return this.f14731l;
    }

    public int getPosition() {
        return ((Integer) getCurrentView().getTag()).intValue();
    }

    public void setMessages(List<T> list) {
        this.f14731l = list;
    }

    public void setOnItemClickListener(e eVar) {
        this.f14732m = eVar;
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.f14721b = false;
        this.f14722c = 1000;
        this.f14723d = 14;
        this.f14724e = ViewCompat.MEASURED_STATE_MASK;
        this.f14725f = false;
        this.f14726g = 19;
        this.f14727h = 0;
        this.f14728i = R.anim.anim_bottom_in;
        this.f14729j = R.anim.anim_top_out;
        this.f14731l = new ArrayList();
        this.f14733n = false;
        a(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, @AnimRes int i2, @AnimRes int i3) {
        int length = str.length();
        int iB = (int) g1.b(getContext(), getWidth());
        if (iB == 0) {
            throw new RuntimeException("Please set the width of MarqueeView !");
        }
        int i4 = iB / this.f14723d;
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
        if (this.f14731l == null) {
            this.f14731l = new ArrayList();
        }
        this.f14731l.clear();
        this.f14731l.addAll(arrayList);
        a(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@AnimRes int i2, @AnimRes int i3) {
        stopFlipping();
        removeAllViews();
        clearAnimation();
        List<T> list = this.f14731l;
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("The messages cannot be empty!");
        }
        this.f14730k = 0;
        addView(a(this.f14731l.get(this.f14730k)));
        if (this.f14731l.size() > 1) {
            b(i2, i3);
            startFlipping();
        }
        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new c());
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MarqueeViewStyle, i2, 0);
        this.a = typedArrayObtainStyledAttributes.getInteger(4, this.a);
        this.f14721b = typedArrayObtainStyledAttributes.hasValue(0);
        this.f14722c = typedArrayObtainStyledAttributes.getInteger(0, this.f14722c);
        this.f14725f = typedArrayObtainStyledAttributes.getBoolean(5, false);
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            this.f14723d = (int) typedArrayObtainStyledAttributes.getDimension(7, this.f14723d);
            this.f14723d = g1.c(context, this.f14723d);
        }
        this.f14724e = typedArrayObtainStyledAttributes.getColor(6, this.f14724e);
        int i3 = typedArrayObtainStyledAttributes.getInt(3, 0);
        if (i3 == 0) {
            this.f14726g = 19;
        } else if (i3 == 1) {
            this.f14726g = 17;
        } else if (i3 == 2) {
            this.f14726g = 21;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f14727h = typedArrayObtainStyledAttributes.getInt(1, this.f14727h);
            int i4 = this.f14727h;
            if (i4 == 0) {
                this.f14728i = R.anim.anim_bottom_in;
                this.f14729j = R.anim.anim_top_out;
            } else if (i4 == 1) {
                this.f14728i = R.anim.anim_top_in;
                this.f14729j = R.anim.anim_bottom_out;
            } else if (i4 == 2) {
                this.f14728i = R.anim.anim_right_in;
                this.f14729j = R.anim.anim_left_out;
            } else if (i4 == 3) {
                this.f14728i = R.anim.anim_left_in;
                this.f14729j = R.anim.anim_right_out;
            }
        } else {
            this.f14728i = R.anim.anim_bottom_in;
            this.f14729j = R.anim.anim_top_out;
        }
        typedArrayObtainStyledAttributes.recycle();
        setFlipInterval(this.a);
    }

    public static <T> boolean b(List<T> list) {
        return list == null || list.size() == 0;
    }

    private CharSequence b(T t2) {
        if (t2 instanceof CharSequence) {
            return (CharSequence) t2;
        }
        return t2 instanceof ui.view.marq.a ? ((ui.view.marq.a) t2).a() : "";
    }

    private void b(@AnimRes int i2, @AnimRes int i3) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i2);
        if (this.f14721b) {
            animationLoadAnimation.setDuration(this.f14722c);
        }
        setInAnimation(animationLoadAnimation);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), i3);
        if (this.f14721b) {
            animationLoadAnimation2.setDuration(this.f14722c);
        }
        setOutAnimation(animationLoadAnimation2);
    }

    public void a(String str) {
        a(str, this.f14728i, this.f14729j);
    }

    public void a(String str, @AnimRes int i2, @AnimRes int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new a(str, i2, i3));
    }

    public void a(List<T> list) {
        a(list, this.f14728i, this.f14729j);
    }

    public void a(List<T> list, @AnimRes int i2, @AnimRes int i3) {
        if (b((List) list)) {
            return;
        }
        setMessages(list);
        a(i2, i3);
    }

    private void a(@AnimRes int i2, @AnimRes int i3) {
        post(new b(i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(T t2) {
        TextView textView;
        TextView textView2;
        View childAt = getChildAt((getDisplayedChild() + 1) % 3);
        if (childAt == null) {
            childAt = LayoutInflater.from(getContext()).inflate(R.layout.marquee_view, (ViewGroup) this, false);
            textView = (TextView) childAt.findViewById(R.id.tv_marqee);
            textView2 = (TextView) childAt.findViewById(R.id.tv_marqee_sec);
            childAt.setOnClickListener(new d());
        } else {
            textView = (TextView) childAt.findViewById(R.id.tv_marqee);
            textView2 = (TextView) childAt.findViewById(R.id.tv_marqee_sec);
        }
        if (t2 instanceof TowContentBean) {
            TowContentBean towContentBean = (TowContentBean) t2;
            textView.setText(towContentBean.getContentOne());
            if (!TextUtils.isEmpty(towContentBean.getContentTwo())) {
                textView2.setText(towContentBean.getContentTwo());
            }
        }
        childAt.setTag(Integer.valueOf(this.f14730k));
        return childAt;
    }
}
