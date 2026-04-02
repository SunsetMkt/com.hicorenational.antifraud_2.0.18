package bean.aimedia;

import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class StsCredentialsRoot extends BaseBean {
    private int code;
    private StsCredentials data;
    private String msg;

    public Integer getcode() {
        return Integer.valueOf(this.code);
    }

    public StsCredentials getdata() {
        return this.data;
    }

    public String getmsg() {
        return this.msg;
    }

    public void setcode(Integer num) {
        this.code = num.intValue();
    }

    public void setdata(StsCredentials stsCredentials) {
        this.data = stsCredentials;
    }

    public void setmsg(String str) {
        this.msg = str;
    }
}
