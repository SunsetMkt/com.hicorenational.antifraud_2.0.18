package bean;

import java.util.List;
import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class AIInspectRecordBean extends BaseBean {
    private List<Records> rows;
    private int total;
    private int totalPages;

    public List<Records> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setRows(List<Records> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }

    public void setTotalPages(int i2) {
        this.totalPages = i2;
    }
}
