package adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;

/* JADX INFO: loaded from: classes.dex */
public class ReportDetailListAdapter extends RecyclerView.Adapter<ItemHolder> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<List<DetailBean>> f1171d;

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f1172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f1173c;

        public ItemHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_content);
            this.f1172b = (TextView) view.findViewById(R.id.item_time);
            this.f1173c = (TextView) view.findViewById(R.id.tv_desc);
            this.f1172b.setVisibility(8);
            this.f1173c.setVisibility(8);
        }
    }

    public ReportDetailListAdapter(Context context, List<List<DetailBean>> list, int i2, int i3) {
        this.a = context;
        this.f1171d = list;
        this.f1170c = i2;
        this.f1169b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ItemHolder itemHolder, int i2) {
        DetailBean detailBean = this.f1171d.get(this.f1170c).get(i2);
        if (this.f1169b == 1) {
            itemHolder.a.setText(detailBean.getNumber());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f1172b.setVisibility(0);
                itemHolder.f1172b.setText(detailBean.getOccurTime());
            }
        }
        if (this.f1169b == 2) {
            itemHolder.f1172b.setVisibility(0);
            itemHolder.f1173c.setVisibility(0);
            itemHolder.a.setText(detailBean.getNumber());
            itemHolder.f1173c.setText(detailBean.getContent());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f1172b.setVisibility(0);
                itemHolder.f1172b.setText(detailBean.getOccurTime());
            }
        }
        if (detailBean.getType() == 3) {
            itemHolder.a.setText(detailBean.getFileName());
            if (detailBean.getOs() > 0) {
                itemHolder.a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(ios)</font>"));
            } else {
                itemHolder.a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(Android)</font>"));
            }
            String version = detailBean.getVersion();
            if (!TextUtils.isEmpty(version)) {
                itemHolder.f1172b.setVisibility(0);
                itemHolder.f1172b.setText("\u7248\u672c\uff1a" + version);
            }
            String downloadUrl = detailBean.getDownloadUrl();
            HistoryDetailInfo.AppInnerPicture appAuthorInfo = detailBean.getAppAuthorInfo();
            HistoryDetailInfo.AppInnerPicture downloadQRCode = detailBean.getDownloadQRCode();
            if (!TextUtils.isEmpty(downloadUrl)) {
                String str = "\u4e0b\u8f7d\u94fe\u63a5\uff1a" + downloadUrl;
                itemHolder.f1173c.setVisibility(0);
                if (appAuthorInfo != null && !TextUtils.isEmpty(appAuthorInfo.name)) {
                    str = str + "\r\n\u4e0b\u8f7d\u4e8c\u7ef4\u7801\uff1a" + appAuthorInfo.name;
                }
                if (downloadQRCode != null && !TextUtils.isEmpty(downloadQRCode.name)) {
                    str = str + "\r\n\u5e94\u7528\u5f00\u53d1\u8005\u4fe1\u606f\uff1a" + downloadQRCode.name;
                }
                itemHolder.f1173c.setText(str);
            }
        }
        if (detailBean.getType() == 4) {
            itemHolder.a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 5) {
            itemHolder.a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 6) {
            itemHolder.a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 7) {
            itemHolder.a.setText(detailBean.getFileName());
            itemHolder.f1172b.setText(detailBean.getOccurTime());
        }
        if (detailBean.getType() == 8) {
            itemHolder.a.setText(detailBean.getAccountType() + "\u8d26\u53f7\uff1a" + detailBean.getAccount());
        }
        if (detailBean.getType() == 9) {
            itemHolder.a.setText(detailBean.getAccountType() + "\u8d26\u6237\uff1a" + detailBean.getAccount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1171d.get(this.f1170c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ItemHolder(LayoutInflater.from(this.a).inflate(R.layout.report_group_sub_item, viewGroup, false));
    }
}
