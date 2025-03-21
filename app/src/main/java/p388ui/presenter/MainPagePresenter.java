package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import interfaces.IVerifyListener;
import network.http.ReportNumHttp;
import p388ui.Hicore;
import p388ui.callview.MainCallview;
import p388ui.model.ModelPresent;
import p388ui.view.BottomBar;
import util.C7340z1;
import util.p396d2.C7269a;
import util.p396d2.C7271c;

/* loaded from: classes2.dex */
public class MainPagePresenter extends ModelPresent<MainCallview> {
    public MainPagePresenter(Activity activity, MainCallview mainCallview) {
        super(activity, mainCallview);
    }

    /* renamed from: a */
    public /* synthetic */ void m25637a() {
        ReportNumHttp.getInstance().principalHttp(new C7137e0(this));
    }

    public void getH5SchmeData(BottomBar bottomBar) {
        C7269a m26330a = C7271c.m26330a(Hicore.schemeString);
        if (m26330a.m26325c()) {
            Hicore.schemeString = "";
            return;
        }
        String m26323b = m26330a.m26323b(ConnType.PK_OPEN);
        if (TextUtils.equals("1", m26323b)) {
            bottomBar.setCurrentItem(1);
        } else if (TextUtils.equals("2", m26323b)) {
            C7340z1.m26805a(this.mActivity).m26811a(1011, new IVerifyListener() { // from class: ui.presenter.g
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    MainPagePresenter.this.m25637a();
                }
            });
        }
        Hicore.schemeString = "";
    }
}
