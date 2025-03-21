package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SocialCriminalBean extends BaseBean {
    private String account;
    private String accountTypeName;

    /* renamed from: id */
    private String f1624id;
    private long suspectInfoID;

    public String getAccount() {
        return this.account;
    }

    public String getAccountTypeName() {
        return this.accountTypeName;
    }

    public String getId() {
        return this.f1624id;
    }

    public long getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountTypeName(String str) {
        this.accountTypeName = str;
    }

    public void setId(String str) {
        this.f1624id = str;
    }

    public void setSuspectInfoID(long j2) {
        this.suspectInfoID = j2;
    }
}
