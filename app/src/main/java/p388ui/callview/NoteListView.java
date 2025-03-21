package p388ui.callview;

import bean.NoteListBean;
import java.util.List;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.basemvp.BaseView;

/* compiled from: NoteListView.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, m23546d2 = {"Lui/callview/NoteListView;", "Lui/basemvp/BaseView;", "onSuccessRequest", "", "beans", "", "Lbean/NoteListBean;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface NoteListView extends BaseView {
    void onSuccessRequest(@InterfaceC5816d List<? extends NoteListBean> list);
}
