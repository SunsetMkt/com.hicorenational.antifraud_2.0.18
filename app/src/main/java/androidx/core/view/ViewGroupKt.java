package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.hihonor.honorid.core.data.ChildrenInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ViewGroup.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0086\b\u001a5\u0010\u001f\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010 \u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010\"\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0086\b\u001a5\u0010$\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010%\u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, m23546d2 = {ChildrenInfo.f6500o, "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d View view) {
        C5544i0.m22546f(viewGroup, "$receiver");
        C5544i0.m22546f(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d InterfaceC5506l<? super View, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(viewGroup, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            C5544i0.m22521a((Object) childAt, "getChildAt(index)");
            interfaceC5506l.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super View, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(viewGroup, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Integer valueOf = Integer.valueOf(i2);
            View childAt = viewGroup.getChildAt(i2);
            C5544i0.m22521a((Object) childAt, "getChildAt(index)");
            interfaceC5510p.invoke(valueOf, childAt);
        }
    }

    @InterfaceC5816d
    public static final View get(@InterfaceC5816d ViewGroup viewGroup, int i2) {
        C5544i0.m22546f(viewGroup, "$receiver");
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    @InterfaceC5816d
    public static final InterfaceC5699m<View> getChildren(@InterfaceC5816d final ViewGroup viewGroup) {
        C5544i0.m22546f(viewGroup, "$receiver");
        return new InterfaceC5699m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // p286h.p321x2.InterfaceC5699m
            @InterfaceC5816d
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final int getSize(@InterfaceC5816d ViewGroup viewGroup) {
        C5544i0.m22546f(viewGroup, "$receiver");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@InterfaceC5816d ViewGroup viewGroup) {
        C5544i0.m22546f(viewGroup, "$receiver");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@InterfaceC5816d ViewGroup viewGroup) {
        C5544i0.m22546f(viewGroup, "$receiver");
        return viewGroup.getChildCount() != 0;
    }

    @InterfaceC5816d
    public static final Iterator<View> iterator(@InterfaceC5816d ViewGroup viewGroup) {
        C5544i0.m22546f(viewGroup, "$receiver");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d View view) {
        C5544i0.m22546f(viewGroup, "$receiver");
        C5544i0.m22546f(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d View view) {
        C5544i0.m22546f(viewGroup, "$receiver");
        C5544i0.m22546f(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(@InterfaceC5816d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        C5544i0.m22546f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(@InterfaceC5816d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        C5544i0.m22546f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* bridge */ /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        C5544i0.m22546f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@InterfaceC5816d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        C5544i0.m22546f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    @RequiresApi(17)
    public static /* bridge */ /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        C5544i0.m22546f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
