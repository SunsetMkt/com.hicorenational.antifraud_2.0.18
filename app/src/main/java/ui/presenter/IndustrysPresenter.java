package ui.presenter;

import android.app.Activity;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import ui.callview.IndustryAddView;
import ui.model.ModelPresent;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class IndustrysPresenter extends ModelPresent<IndustryAddView> {
    public IndustrysPresenter(Activity activity, IndustryAddView industryAddView) {
        super(activity, industryAddView);
    }

    private void timeStampHttp(HashMap<String, String> map) {
        updateUserHttp(map);
    }

    private void updateUserHttp(HashMap<String, String> map) {
    }

    public void getIndustry() {
    }

    public void updateUserIndustry(String str) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        f1.a("\u63d0\u4ea4\u4e2d...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("profession", str + "");
        timeStampHttp(map);
    }
}
