package p388ui.callview;

import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.basemvp.BaseView;

/* compiled from: DeliveryView.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, m23546d2 = {"Lui/callview/DeliveryView;", "Lui/basemvp/BaseView;", "onItemDelet", "", "itemPos", "", "onItemEdit", "onSuccessList", "list", "", "Lbean/DeliveryBean;", "onSuccessPlatList", "Lbean/DeliveryPlatBean;", "onSuccessSave", "bean", "onSuccessSaveFail", "msg", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface DeliveryView extends BaseView {

    /* compiled from: DeliveryView.kt */
    /* renamed from: ui.callview.DeliveryView$a */
    public static final class C6815a {
        /* renamed from: a */
        public static void m25459a(DeliveryView deliveryView, int i2) {
        }

        /* renamed from: a */
        public static void m25460a(DeliveryView deliveryView, @InterfaceC5816d DeliveryBean deliveryBean) {
            C5544i0.m22546f(deliveryBean, "bean");
        }

        /* renamed from: a */
        public static void m25461a(DeliveryView deliveryView, @InterfaceC5816d String str) {
            C5544i0.m22546f(str, "msg");
        }

        /* renamed from: a */
        public static void m25462a(DeliveryView deliveryView, @InterfaceC5816d List<? extends DeliveryBean> list) {
            C5544i0.m22546f(list, "list");
        }

        /* renamed from: b */
        public static void m25463b(DeliveryView deliveryView, int i2) {
        }

        /* renamed from: b */
        public static void m25464b(DeliveryView deliveryView, @InterfaceC5816d List<? extends DeliveryPlatBean> list) {
            C5544i0.m22546f(list, "list");
        }
    }

    void onItemDelet(int i2);

    void onItemEdit(int i2);

    void onSuccessList(@InterfaceC5816d List<? extends DeliveryBean> list);

    void onSuccessPlatList(@InterfaceC5816d List<? extends DeliveryPlatBean> list);

    void onSuccessSave(@InterfaceC5816d DeliveryBean deliveryBean);

    void onSuccessSaveFail(@InterfaceC5816d String str);
}
