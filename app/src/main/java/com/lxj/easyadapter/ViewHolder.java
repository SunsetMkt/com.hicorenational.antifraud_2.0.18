package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.C3397d;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ViewHolder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m23546d2 = {"Lcom/lxj/easyadapter/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "getConvertView", "()Landroid/view/View;", "mViews", "Landroid/util/SparseArray;", "getView", ExifInterface.GPS_DIRECTION_TRUE, "viewId", "", "(I)Landroid/view/View;", "setImageResource", "resId", "setText", "text", "", "Companion", "easy-adapter_release"}, m23547k = 1, m23548mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: c */
    public static final C2754a f8493c = new C2754a(null);

    /* renamed from: a */
    private final SparseArray<View> f8494a;

    /* renamed from: b */
    @InterfaceC5816d
    private final View f8495b;

    /* compiled from: ViewHolder.kt */
    /* renamed from: com.lxj.easyadapter.ViewHolder$a */
    public static final class C2754a {
        private C2754a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final ViewHolder m8235a(@InterfaceC5816d View view) {
            C5544i0.m22546f(view, "itemView");
            return new ViewHolder(view);
        }

        public /* synthetic */ C2754a(C5586v c5586v) {
            this();
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final ViewHolder m8234a(@InterfaceC5816d Context context, @InterfaceC5816d ViewGroup viewGroup, int i2) {
            C5544i0.m22546f(context, C3397d.f11892R);
            C5544i0.m22546f(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(i2, viewGroup, false);
            C5544i0.m22521a((Object) inflate, "itemView");
            return new ViewHolder(inflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(@InterfaceC5816d View view) {
        super(view);
        C5544i0.m22546f(view, "convertView");
        this.f8495b = view;
        this.f8494a = new SparseArray<>();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final View m8230a() {
        return this.f8495b;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final <T extends View> T m8231a(int i2) {
        T t = (T) this.f8494a.get(i2);
        if (t == null) {
            t = (T) this.f8495b.findViewById(i2);
            this.f8494a.put(i2, t);
        }
        if (t != null) {
            return t;
        }
        throw new C5226e1("null cannot be cast to non-null type T");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final ViewHolder m8233a(int i2, @InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "text");
        ((TextView) m8231a(i2)).setText(charSequence);
        return this;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final ViewHolder m8232a(int i2, int i3) {
        ((ImageView) m8231a(i2)).setImageResource(i3);
        return this;
    }
}
