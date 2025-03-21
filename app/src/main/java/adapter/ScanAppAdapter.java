package adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bean.AppInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import p357j.C5845d;

/* loaded from: classes.dex */
public class ScanAppAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {
    public ScanAppAdapter(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        try {
            baseViewHolder.m5211a(C2113R.id.tv_app_name, (CharSequence) appInfoBean.getName());
            ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.app_icon);
            Drawable appIcon = appInfoBean.getAppIcon();
            if (appIcon != null) {
                imageView.setBackground(appIcon);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) baseViewHolder.m5224c(C2113R.id.scan_state);
            int virusLevel = appInfoBean.getVirusLevel();
            if (virusLevel == 0) {
                C5845d.m24612b(imageView2, Integer.valueOf(C2113R.mipmap.ic_scan_ok));
                return;
            }
            if (virusLevel != 2 && virusLevel != 1) {
                C5845d.m24605a(imageView2, Integer.valueOf(C2113R.mipmap.ic_scan_loading));
                return;
            }
            C5845d.m24612b(imageView2, Integer.valueOf(C2113R.mipmap.ic_scan_risk));
        } catch (Exception unused) {
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((ScanAppAdapter) baseViewHolder, i2);
    }
}
