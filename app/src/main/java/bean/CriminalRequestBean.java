package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CriminalRequestBean extends BaseBean {

    /* renamed from: id */
    private String f1592id;
    private List<CallBean> mobiles;
    private List<SocialAccBean> socialAccounts;
    private String suspectInfoID;

    public String getId() {
        return this.f1592id;
    }

    public List<CallBean> getMobiles() {
        return this.mobiles;
    }

    public List<SocialAccBean> getSocialAccounts() {
        return this.socialAccounts;
    }

    public String getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public void setId(String str) {
        this.f1592id = str;
    }

    public void setMobiles(List<CallBean> list) {
        this.mobiles = list;
    }

    public void setSocialAccounts(List<SocialAccBean> list) {
        this.socialAccounts = list;
    }

    public void setSuspectInfoID(String str) {
        this.suspectInfoID = str;
    }
}
