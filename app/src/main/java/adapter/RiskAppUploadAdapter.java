package adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p357j.C5845d;

/* loaded from: classes.dex */
public class RiskAppUploadAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {

    /* renamed from: V */
    private List<AppInfoBean> f316V;

    /* renamed from: W */
    private List<UploadStateInfo> f317W;

    /* renamed from: X */
    private InterfaceC0072a f318X;

    /* renamed from: adapter.RiskAppUploadAdapter$a */
    public interface InterfaceC0072a {
        void onItemClickListener(int i2, List<AppInfoBean> list);
    }

    public RiskAppUploadAdapter(int i2, List<AppInfoBean> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f316V = list;
        this.f317W = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<AppInfoBean> list) {
        this.f316V = list;
        this.f5546A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(InterfaceC0072a interfaceC0072a) {
        this.f318X = interfaceC0072a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        String str;
        String str2;
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            baseViewHolder.m5202a(C2113R.id.app_icon, appIcon);
        }
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_level);
        if (appInfoBean.getVirusLevel() == 1) {
            textView.setTextColor(this.f5580x.getResources().getColor(C2113R.color.colorRedRiskFlag));
            textView.setBackgroundResource(C2113R.drawable.shape_red);
            str = "高危";
        } else {
            textView.setTextColor(this.f5580x.getResources().getColor(C2113R.color.dark_orange));
            textView.setBackgroundResource(C2113R.drawable.shape_orange);
            str = "风险";
        }
        if (appInfoBean.isTypeIsApp()) {
            str2 = str + "应用";
        } else {
            str2 = str + "安装包";
        }
        textView.setText(str2);
        baseViewHolder.m5211a(C2113R.id.tv_app_name, (CharSequence) appInfoBean.getName()).m5211a(C2113R.id.tv_app_version, (CharSequence) ("(版本:" + appInfoBean.getVersionCode() + " )")).m5202a(C2113R.id.app_icon, appInfoBean.getAppIcon()).m5194a(C2113R.id.iv_checkbox);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((RiskAppUploadAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox);
        UploadStateInfo uploadStateInfo = this.f317W.get(i2);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state);
        textView.setText("上传失败");
        if (uploadStateInfo.getUploadState() == 3) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        m280a(imageView, uploadStateInfo);
    }

    /* renamed from: a */
    private void m280a(ImageView imageView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            C5845d.m24605a(imageView, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
            return;
        }
        if (uploadState == 1) {
            C5845d.m24605a(imageView, Integer.valueOf(C2113R.mipmap.ic_scan_loading));
        } else if (uploadState == 2) {
            C5845d.m24612b(imageView, Integer.valueOf(C2113R.mipmap.ic_scan_ok));
        } else {
            if (uploadState != 3) {
                return;
            }
            C5845d.m24612b(imageView, Integer.valueOf(C2113R.mipmap.ic_scan_fail));
        }
    }
}
