package adapter;

import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p388ui.Hicore;

/* loaded from: classes.dex */
public class AppDeleteAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {

    /* renamed from: V */
    List<UploadStateInfo> f168V;

    public AppDeleteAdapter(int i2, List<AppInfoBean> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f168V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((AppDeleteAdapter) baseViewHolder, i2);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state);
        if (i2 < this.f168V.size()) {
            m205a(textView, this.f168V.get(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            baseViewHolder.m5202a(C2113R.id.app_icon, appIcon);
        }
        String formatFileSize = Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
        baseViewHolder.m5211a(C2113R.id.tv_app_name, (CharSequence) appInfoBean.getName()).m5211a(C2113R.id.tv_app_version, (CharSequence) ("版本:" + appInfoBean.getVersionCode() + "  |  " + formatFileSize)).m5194a(C2113R.id.iv_clear);
    }

    /* renamed from: a */
    private void m205a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("等待上传");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("上传中");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("上传完成");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("上传失败");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        }
    }
}
