package adapter;

import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.Hicore;

/* JADX INFO: loaded from: classes.dex */
public class AppDeleteAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {
    List<UploadStateInfo> V;

    public AppDeleteAdapter(int i2, List<AppInfoBean> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        if (i2 < this.V.size()) {
            a(textView, this.V.get(i2));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            baseViewHolder.a(R.id.app_icon, appIcon);
        }
        String fileSize = Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
        baseViewHolder.a(R.id.tv_app_name, (CharSequence) appInfoBean.getName()).a(R.id.tv_app_version, (CharSequence) ("\u7248\u672c:" + appInfoBean.getVersionCode() + "  |  " + fileSize)).a(R.id.iv_clear);
    }

    private void a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("\u7b49\u5f85\u4e0a\u4f20");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("\u4e0a\u4f20\u4e2d");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("\u4e0a\u4f20\u5b8c\u6210");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("\u4e0a\u4f20\u5931\u8d25");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        }
    }
}
