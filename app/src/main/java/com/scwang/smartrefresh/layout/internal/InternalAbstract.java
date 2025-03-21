package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2874h;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;

/* loaded from: classes.dex */
public abstract class InternalAbstract extends RelativeLayout implements InterfaceC2874h {

    /* renamed from: a */
    protected View f9232a;

    /* renamed from: b */
    protected EnumC2880c f9233b;

    /* renamed from: c */
    protected InterfaceC2874h f9234c;

    /* JADX WARN: Multi-variable type inference failed */
    protected InternalAbstract(@NonNull View view) {
        this(view, view instanceof InterfaceC2874h ? (InterfaceC2874h) view : null);
    }

    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return 0;
        }
        return interfaceC2874h.mo8713a(interfaceC2876j, z);
    }

    /* renamed from: b */
    public void mo8719b(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        interfaceC2874h.mo8719b(interfaceC2876j, i2, i3);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof InterfaceC2874h) && getView() == ((InterfaceC2874h) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @NonNull
    public EnumC2880c getSpinnerStyle() {
        int i2;
        EnumC2880c enumC2880c = this.f9233b;
        if (enumC2880c != null) {
            return enumC2880c;
        }
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h != null && interfaceC2874h != this) {
            return interfaceC2874h.getSpinnerStyle();
        }
        View view = this.f9232a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.C2864m) {
                this.f9233b = ((SmartRefreshLayout.C2864m) layoutParams).f9102b;
                EnumC2880c enumC2880c2 = this.f9233b;
                if (enumC2880c2 != null) {
                    return enumC2880c2;
                }
            }
            if (layoutParams != null && ((i2 = layoutParams.height) == 0 || i2 == -1)) {
                EnumC2880c enumC2880c3 = EnumC2880c.Scale;
                this.f9233b = enumC2880c3;
                return enumC2880c3;
            }
        }
        EnumC2880c enumC2880c4 = EnumC2880c.Translate;
        this.f9233b = enumC2880c4;
        return enumC2880c4;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @NonNull
    public View getView() {
        View view = this.f9232a;
        return view == null ? this : view;
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        interfaceC2874h.setPrimaryColors(iArr);
    }

    protected InternalAbstract(@NonNull View view, @Nullable InterfaceC2874h interfaceC2874h) {
        super(view.getContext(), null, 0);
        this.f9232a = view;
        this.f9234c = interfaceC2874h;
    }

    /* renamed from: a */
    public void mo8715a(@NonNull InterfaceC2875i interfaceC2875i, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h != null && interfaceC2874h != this) {
            interfaceC2874h.mo8715a(interfaceC2875i, i2, i3);
            return;
        }
        View view = this.f9232a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.C2864m) {
                interfaceC2875i.mo8691a(this, ((SmartRefreshLayout.C2864m) layoutParams).f9101a);
            }
        }
    }

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* renamed from: a */
    public boolean mo8718a() {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        return (interfaceC2874h == null || interfaceC2874h == this || !interfaceC2874h.mo8718a()) ? false : true;
    }

    /* renamed from: a */
    public void mo8714a(float f2, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        interfaceC2874h.mo8714a(f2, i2, i3);
    }

    /* renamed from: a */
    public void mo8717a(boolean z, float f2, int i2, int i3, int i4) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        interfaceC2874h.mo8717a(z, f2, i2, i3, i4);
    }

    /* renamed from: a */
    public void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        interfaceC2874h.mo8716a(interfaceC2876j, i2, i3);
    }

    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        if (interfaceC2874h == null || interfaceC2874h == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (interfaceC2874h instanceof InterfaceC2873g)) {
            if (enumC2879b.isFooter) {
                enumC2879b = enumC2879b.toHeader();
            }
            if (enumC2879b2.isFooter) {
                enumC2879b2 = enumC2879b2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (this.f9234c instanceof InterfaceC2872f)) {
            if (enumC2879b.isHeader) {
                enumC2879b = enumC2879b.toFooter();
            }
            if (enumC2879b2.isHeader) {
                enumC2879b2 = enumC2879b2.toFooter();
            }
        }
        InterfaceC2874h interfaceC2874h2 = this.f9234c;
        if (interfaceC2874h2 != null) {
            interfaceC2874h2.mo8733a(interfaceC2876j, enumC2879b, enumC2879b2);
        }
    }
}
