package p388ui.callview;

import bean.CallBean;
import bean.CriminalPhoneNumBean;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.basemvp.BaseView;

/* compiled from: CriminalPhoneView.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, m23546d2 = {"Lui/callview/CriminalPhoneView;", "Lui/basemvp/BaseView;", "onSuccess", "", "CNATelList", "", "", "onSuccessList", "callBeans", "Lbean/CallBean;", "onSuccessPhoneNum", "bean", "Lbean/CriminalPhoneNumBean;", "onSuccessRemove", "onSuccessSave", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface CriminalPhoneView extends BaseView {

    /* compiled from: CriminalPhoneView.kt */
    /* renamed from: ui.callview.CriminalPhoneView$a */
    public static final class C6814a {
        /* renamed from: a */
        public static void m25454a(CriminalPhoneView criminalPhoneView) {
        }

        /* renamed from: a */
        public static void m25455a(CriminalPhoneView criminalPhoneView, @InterfaceC5816d CallBean callBean) {
            C5544i0.m22546f(callBean, "callBeans");
        }

        /* renamed from: a */
        public static void m25456a(CriminalPhoneView criminalPhoneView, @InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean) {
            C5544i0.m22546f(criminalPhoneNumBean, "bean");
        }

        /* renamed from: a */
        public static void m25457a(CriminalPhoneView criminalPhoneView, @InterfaceC5816d List<String> list) {
            C5544i0.m22546f(list, "CNATelList");
        }

        /* renamed from: b */
        public static void m25458b(CriminalPhoneView criminalPhoneView, @InterfaceC5816d List<? extends CallBean> list) {
            C5544i0.m22546f(list, "callBeans");
        }
    }

    void onSuccess(@InterfaceC5816d List<String> list);

    void onSuccessList(@InterfaceC5816d List<? extends CallBean> list);

    void onSuccessPhoneNum(@InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean);

    void onSuccessRemove();

    void onSuccessSave(@InterfaceC5816d CallBean callBean);
}
