package p388ui.callview;

import bean.RelationBean;
import bean.RelationPlatBean;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.basemvp.BaseView;

/* compiled from: RelationView.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, m23546d2 = {"Lui/callview/RelationView;", "Lui/basemvp/BaseView;", "onItemDelet", "", "pot", "", "onItemEdit", "onSuccessList", "list", "", "Lbean/RelationBean;", "onSuccessPlatList", "Lbean/RelationPlatBean;", "onSuccessSave", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface RelationView extends BaseView {

    /* compiled from: RelationView.kt */
    /* renamed from: ui.callview.RelationView$a */
    public static final class C6817a {
        /* renamed from: a */
        public static void m25470a(RelationView relationView) {
        }

        /* renamed from: a */
        public static void m25471a(RelationView relationView, int i2) {
        }

        /* renamed from: a */
        public static void m25472a(RelationView relationView, @InterfaceC5816d List<? extends RelationBean> list) {
            C5544i0.m22546f(list, "list");
        }

        /* renamed from: b */
        public static void m25473b(RelationView relationView) {
        }

        /* renamed from: b */
        public static void m25474b(RelationView relationView, @InterfaceC5816d List<? extends RelationPlatBean> list) {
            C5544i0.m22546f(list, "list");
        }
    }

    void onItemDelet(int i2);

    void onItemEdit();

    void onSuccessList(@InterfaceC5816d List<? extends RelationBean> list);

    void onSuccessPlatList(@InterfaceC5816d List<? extends RelationPlatBean> list);

    void onSuccessSave();
}
