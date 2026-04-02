package bean.aimedia;

import java.util.List;
import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class RootData extends BaseBean {
    private Integer code;
    private List<DataType> data;
    private String msg;

    public Integer getcode() {
        return this.code;
    }

    public List<DataType> getdata() {
        return this.data;
    }

    public String getmsg() {
        return this.msg;
    }

    public void setcode(Integer num) {
        this.code = num;
    }

    public void setdata(List<DataType> list) {
        this.data = list;
    }

    public void setmsg(String str) {
        this.msg = str;
    }
}
