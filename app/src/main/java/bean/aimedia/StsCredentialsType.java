package bean.aimedia;

import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class StsCredentialsType extends BaseBean {
    private String accessKeyId;
    private String accessKeySecret;
    private String expiration;
    private String securityToken;

    public String getaccessKeyId() {
        return this.accessKeyId;
    }

    public String getaccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getexpiration() {
        return this.expiration;
    }

    public String getsecurityToken() {
        return this.securityToken;
    }

    public void setaccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setaccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setexpiration(String str) {
        this.expiration = str;
    }

    public void setsecurityToken(String str) {
        this.securityToken = str;
    }
}
