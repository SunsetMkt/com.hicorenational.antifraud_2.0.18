package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
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

/* compiled from: Menu.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, m23546d2 = {ChildrenInfo.f6500o, "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(@InterfaceC5816d Menu menu, @InterfaceC5816d MenuItem menuItem) {
        C5544i0.m22546f(menu, "$receiver");
        C5544i0.m22546f(menuItem, "item");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (C5544i0.m22531a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@InterfaceC5816d Menu menu, @InterfaceC5816d InterfaceC5506l<? super MenuItem, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(menu, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            C5544i0.m22521a((Object) item, "getItem(index)");
            interfaceC5506l.invoke(item);
        }
    }

    public static final void forEachIndexed(@InterfaceC5816d Menu menu, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super MenuItem, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(menu, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            Integer valueOf = Integer.valueOf(i2);
            MenuItem item = menu.getItem(i2);
            C5544i0.m22521a((Object) item, "getItem(index)");
            interfaceC5510p.invoke(valueOf, item);
        }
    }

    @InterfaceC5816d
    public static final MenuItem get(@InterfaceC5816d Menu menu, int i2) {
        C5544i0.m22546f(menu, "$receiver");
        MenuItem item = menu.getItem(i2);
        C5544i0.m22521a((Object) item, "getItem(index)");
        return item;
    }

    @InterfaceC5816d
    public static final InterfaceC5699m<MenuItem> getChildren(@InterfaceC5816d final Menu menu) {
        C5544i0.m22546f(menu, "$receiver");
        return new InterfaceC5699m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // p286h.p321x2.InterfaceC5699m
            @InterfaceC5816d
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@InterfaceC5816d Menu menu) {
        C5544i0.m22546f(menu, "$receiver");
        return menu.size();
    }

    public static final boolean isEmpty(@InterfaceC5816d Menu menu) {
        C5544i0.m22546f(menu, "$receiver");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@InterfaceC5816d Menu menu) {
        C5544i0.m22546f(menu, "$receiver");
        return menu.size() != 0;
    }

    @InterfaceC5816d
    public static final Iterator<MenuItem> iterator(@InterfaceC5816d Menu menu) {
        C5544i0.m22546f(menu, "$receiver");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@InterfaceC5816d Menu menu, @InterfaceC5816d MenuItem menuItem) {
        C5544i0.m22546f(menu, "$receiver");
        C5544i0.m22546f(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
