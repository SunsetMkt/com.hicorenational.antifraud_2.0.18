package adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RiskAppUploadAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {
    private List<AppInfoBean> V;
    private List<UploadStateInfo> W;
    private a X;

    public interface a {
        void onItemClickListener(int i2, List<AppInfoBean> list);
    }

    public RiskAppUploadAdapter(int i2, List<AppInfoBean> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.V = list;
        this.W = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<AppInfoBean> list) {
        this.V = list;
        this.A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(a aVar) {
        this.X = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        String str;
        String str2;
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            baseViewHolder.a(R.id.app_icon, appIcon);
        }
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_level);
        if (appInfoBean.getVirusLevel() == 1) {
            textView.setTextColor(this.x.getResources().getColor(R.color.colorRedRiskFlag));
            textView.setBackgroundResource(R.drawable.shape_red);
            str = "\u9ad8\u5371";
        } else {
            textView.setTextColor(this.x.getResources().getColor(R.color.dark_orange));
            textView.setBackgroundResource(R.drawable.shape_orange);
            str = "\u98ce\u9669";
        }
        if (appInfoBean.isTypeIsApp()) {
            str2 = str + "\u5e94\u7528";
        } else {
            str2 = str + "\u5b89\u88c5\u5305";
        }
        textView.setText(str2);
        baseViewHolder.a(R.id.tv_app_name, (CharSequence) appInfoBean.getName()).a(R.id.tv_app_version, (CharSequence) ("(\u7248\u672c:" + appInfoBean.getVersionCode() + " )")).a(R.id.app_icon, appInfoBean.getAppIcon()).a(R.id.iv_checkbox);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_checkbox);
        UploadStateInfo uploadStateInfo = this.W.get(i2);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        textView.setText("\u4e0a\u4f20\u5931\u8d25");
        if (uploadStateInfo.getUploadState() == 3) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        a(imageView, uploadStateInfo);
    }

    private void a(ImageView imageView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            k.d.a(imageView, Integer.valueOf(R.mipmap.ic_scan_wait));
            return;
        }
        if (uploadState == 1) {
            k.d.a(imageView, Integer.valueOf(R.mipmap.ic_scan_loading));
        } else if (uploadState == 2) {
            k.d.b(imageView, Integer.valueOf(R.mipmap.ic_scan_ok));
        } else {
            if (uploadState != 3) {
                return;
            }
            k.d.b(imageView, Integer.valueOf(R.mipmap.ic_scan_fail));
        }
    }
}
