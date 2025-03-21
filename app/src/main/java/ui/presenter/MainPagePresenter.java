package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import interfaces.IVerifyListener;
import network.http.ReportNumHttp;
import ui.Hicore;
import ui.callview.MainCallview;
import ui.model.ModelPresent;
import ui.view.BottomBar;
import util.z1;

/* loaded from: classes2.dex */
public class MainPagePresenter extends ModelPresent<MainCallview> {
    public MainPagePresenter(Activity activity, MainCallview mainCallview) {
        super(activity, mainCallview);
    }

    public /* synthetic */ void a() {
        ReportNumHttp.getInstance().principalHttp(new e0(this));
    }

    public void getH5SchmeData(BottomBar bottomBar) {
        util.d2.a a2 = util.d2.c.a(Hicore.schemeString);
        if (a2.c()) {
            Hicore.schemeString = "";
            return;
        }
        String b2 = a2.b(ConnType.PK_OPEN);
        if (TextUtils.equals("1", b2)) {
            bottomBar.setCurrentItem(1);
        } else if (TextUtils.equals("2", b2)) {
            z1.a(this.mActivity).a(1011, new IVerifyListener() { // from class: ui.presenter.g
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    MainPagePresenter.this.a();
                }
            });
        }
        Hicore.schemeString = "";
    }
}
