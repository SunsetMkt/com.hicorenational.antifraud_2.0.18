package adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import bean.SmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class SmsSelectAdapter extends BaseQuickAdapter<SmsBean, BaseViewHolder> {

    /* renamed from: V */
    private List<SmsBean> f328V;

    /* renamed from: W */
    private List<SmsBean> f329W;

    /* renamed from: X */
    private InterfaceC0076b f330X;

    /* renamed from: adapter.SmsSelectAdapter$a */
    class ViewOnClickListenerC0075a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f331a;

        /* renamed from: b */
        final /* synthetic */ SmsBean f332b;

        ViewOnClickListenerC0075a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
            this.f331a = baseViewHolder;
            this.f332b = smsBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsSelectAdapter.this.f330X != null) {
                SmsSelectAdapter.this.f330X.mo287a(this.f331a.getAdapterPosition(), SmsSelectAdapter.this.f328V, this.f332b);
            }
        }
    }

    /* renamed from: adapter.SmsSelectAdapter$b */
    public interface InterfaceC0076b {
        /* renamed from: a */
        void mo287a(int i2, List<SmsBean> list, SmsBean smsBean);
    }

    public SmsSelectAdapter(int i2, List<SmsBean> list, List<SmsBean> list2) {
        super(i2, list);
        this.f328V = list;
        this.f329W = list2;
    }

    public void setOnItemClickListener(InterfaceC0076b interfaceC0076b) {
        this.f330X = interfaceC0076b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
        baseViewHolder.m5211a(C2113R.id.tv_sms_phone, (CharSequence) smsBean.getSmsNum()).m5211a(C2113R.id.tv_sms_content, (CharSequence) smsBean.getSmsContent()).m5211a(C2113R.id.tv_sms_date, (CharSequence) smsBean.getStringDate());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((SmsSelectAdapter) baseViewHolder, i2);
        SmsBean smsBean = this.f328V.get(baseViewHolder.getAdapterPosition());
        SmsBean m285a = m285a(smsBean);
        if (smsBean.isSelect()) {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0075a(baseViewHolder, m285a));
    }

    /* renamed from: a */
    private SmsBean m285a(SmsBean smsBean) {
        List<SmsBean> list = this.f329W;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (SmsBean smsBean2 : this.f329W) {
            if (TextUtils.equals(smsBean.getSmsNum(), smsBean2.getSmsNum()) && TextUtils.equals(smsBean.getStringDate(), smsBean2.getStringDate())) {
                smsBean.setSelect(true);
                return smsBean2;
            }
        }
        return null;
    }
}
