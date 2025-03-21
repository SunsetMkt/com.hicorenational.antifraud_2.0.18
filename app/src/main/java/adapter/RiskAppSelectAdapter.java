package adapter;

import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p388ui.Hicore;

/* loaded from: classes.dex */
public class RiskAppSelectAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {

    /* renamed from: V */
    private List<AppInfoBean> f312V;

    /* renamed from: W */
    private InterfaceC0071b f313W;

    /* renamed from: adapter.RiskAppSelectAdapter$a */
    class ViewOnClickListenerC0070a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f314a;

        ViewOnClickListenerC0070a(BaseViewHolder baseViewHolder) {
            this.f314a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RiskAppSelectAdapter.this.f313W != null) {
                RiskAppSelectAdapter.this.f313W.onItemClickListener(this.f314a.getAdapterPosition(), RiskAppSelectAdapter.this.f312V);
            }
        }
    }

    /* renamed from: adapter.RiskAppSelectAdapter$b */
    public interface InterfaceC0071b {
        void onItemClickListener(int i2, List<AppInfoBean> list);
    }

    public RiskAppSelectAdapter(int i2, List<AppInfoBean> list) {
        super(i2, list);
        this.f312V = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<AppInfoBean> list) {
        this.f312V = list;
        this.f5546A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(InterfaceC0071b interfaceC0071b) {
        this.f313W = interfaceC0071b;
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
        baseViewHolder.m5194a(C2113R.id.iv_checkbox);
        Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
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
        baseViewHolder.m5211a(C2113R.id.tv_app_name, (CharSequence) appInfoBean.getName()).m5211a(C2113R.id.tv_app_version, (CharSequence) ("(版本:" + appInfoBean.getVersionCode() + " )")).m5202a(C2113R.id.app_icon, appInfoBean.getAppIcon());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((RiskAppSelectAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox);
        try {
            AppInfoBean appInfoBean = this.f312V.get(baseViewHolder.getAdapterPosition());
            if (appInfoBean.getFileSize() > 209715200) {
                imageView.setImageResource(C2113R.mipmap.checkbox_unchecked_circle);
                imageView.setBackgroundColor(this.f5580x.getResources().getColor(C2113R.color.colorGray));
            } else if (appInfoBean.isSelect()) {
                imageView.setImageResource(C2113R.mipmap.checkbox_checked_circle);
            } else {
                imageView.setImageResource(C2113R.mipmap.checkbox_unchecked_circle);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0070a(baseViewHolder));
    }
}
