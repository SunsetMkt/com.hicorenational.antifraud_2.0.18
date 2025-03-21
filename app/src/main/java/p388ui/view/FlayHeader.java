package p388ui.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;

/* loaded from: classes2.dex */
public class FlayHeader extends InternalAbstract implements InterfaceC2873g {

    /* renamed from: d */
    private ImageView f24504d;

    /* renamed from: e */
    private View f24505e;

    /* renamed from: ui.view.FlayHeader$a */
    static /* synthetic */ class C7169a {

        /* renamed from: a */
        static final /* synthetic */ int[] f24506a = new int[EnumC2879b.values().length];

        static {
            try {
                f24506a[EnumC2879b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24506a[EnumC2879b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24506a[EnumC2879b.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24506a[EnumC2879b.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FlayHeader(Context context, @LayoutRes int i2) {
        this(context, null, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f24504d, "rotation", 0.0f, 360.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @NonNull
    public EnumC2880c getSpinnerStyle() {
        return EnumC2880c.Scale;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    public void setPrimaryColors(int... iArr) {
        for (int i2 : iArr) {
            this.f24505e.setBackgroundColor(i2);
        }
    }

    public FlayHeader(Context context, AttributeSet attributeSet, @LayoutRes int i2) {
        this(context, attributeSet, 0, i2);
    }

    public FlayHeader(Context context, AttributeSet attributeSet, int i2, @LayoutRes int i3) {
        super(context, attributeSet, i2);
        View inflate = View.inflate(context, i3, this);
        this.f24504d = (ImageView) inflate.findViewById(C2113R.id.header);
        this.f24505e = inflate.findViewById(C2113R.id.primary);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p191d.InterfaceC2886f
    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        int i2 = C7169a.f24506a[enumC2879b2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f24504d.setVisibility(8);
            return;
        }
        if (i2 == 3) {
            this.f24504d.setImageResource(C2113R.drawable.bg_record_time_cut);
        } else {
            if (i2 != 4) {
                return;
            }
            this.f24504d.setVisibility(0);
            this.f24504d.setImageResource(C2113R.drawable.set_loading);
        }
    }
}
