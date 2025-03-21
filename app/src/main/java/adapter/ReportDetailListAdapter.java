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
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import network.HistoryDetailInfo;

/* loaded from: classes.dex */
public class ReportDetailListAdapter extends RecyclerView.Adapter<ItemHolder> {

    /* renamed from: a */
    private final Context f284a;

    /* renamed from: b */
    public int f285b;

    /* renamed from: c */
    public int f286c;

    /* renamed from: d */
    private List<List<DetailBean>> f287d;

    public class ItemHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        TextView f288a;

        /* renamed from: b */
        TextView f289b;

        /* renamed from: c */
        TextView f290c;

        public ItemHolder(View view) {
            super(view);
            this.f288a = (TextView) view.findViewById(C2113R.id.tv_content);
            this.f289b = (TextView) view.findViewById(C2113R.id.item_time);
            this.f290c = (TextView) view.findViewById(C2113R.id.tv_desc);
            this.f289b.setVisibility(8);
            this.f290c.setVisibility(8);
        }
    }

    public ReportDetailListAdapter(Context context, List<List<DetailBean>> list, int i2, int i3) {
        this.f284a = context;
        this.f287d = list;
        this.f286c = i2;
        this.f285b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ItemHolder itemHolder, int i2) {
        DetailBean detailBean = this.f287d.get(this.f286c).get(i2);
        if (this.f285b == 1) {
            itemHolder.f288a.setText(detailBean.getNumber());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f289b.setVisibility(0);
                itemHolder.f289b.setText(detailBean.getOccurTime());
            }
        }
        if (this.f285b == 2) {
            itemHolder.f289b.setVisibility(0);
            itemHolder.f290c.setVisibility(0);
            itemHolder.f288a.setText(detailBean.getNumber());
            itemHolder.f290c.setText(detailBean.getContent());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f289b.setVisibility(0);
                itemHolder.f289b.setText(detailBean.getOccurTime());
            }
        }
        if (detailBean.getType() == 3) {
            itemHolder.f288a.setText(detailBean.getFileName());
            if (detailBean.getOs() > 0) {
                itemHolder.f288a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(ios)</font>"));
            } else {
                itemHolder.f288a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(Android)</font>"));
            }
            String version = detailBean.getVersion();
            if (!TextUtils.isEmpty(version)) {
                itemHolder.f289b.setVisibility(0);
                itemHolder.f289b.setText("版本：" + version);
            }
            String downloadUrl = detailBean.getDownloadUrl();
            HistoryDetailInfo.AppInnerPicture appAuthorInfo = detailBean.getAppAuthorInfo();
            HistoryDetailInfo.AppInnerPicture downloadQRCode = detailBean.getDownloadQRCode();
            if (!TextUtils.isEmpty(downloadUrl)) {
                String str = "下载链接：" + downloadUrl;
                itemHolder.f290c.setVisibility(0);
                if (appAuthorInfo != null && !TextUtils.isEmpty(appAuthorInfo.name)) {
                    str = str + "\r\n下载二维码：" + appAuthorInfo.name;
                }
                if (downloadQRCode != null && !TextUtils.isEmpty(downloadQRCode.name)) {
                    str = str + "\r\n应用开发者信息：" + downloadQRCode.name;
                }
                itemHolder.f290c.setText(str);
            }
        }
        if (detailBean.getType() == 4) {
            itemHolder.f288a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 5) {
            itemHolder.f288a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 6) {
            itemHolder.f288a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 7) {
            itemHolder.f288a.setText(detailBean.getFileName());
            itemHolder.f289b.setText(detailBean.getOccurTime());
        }
        if (detailBean.getType() == 8) {
            itemHolder.f288a.setText(detailBean.getAccountType() + "账号：" + detailBean.getAccount());
        }
        if (detailBean.getType() == 9) {
            itemHolder.f288a.setText(detailBean.getAccountType() + "账户：" + detailBean.getAccount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f287d.get(this.f286c).size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ItemHolder(LayoutInflater.from(this.f284a).inflate(C2113R.layout.report_group_sub_item, viewGroup, false));
    }
}
