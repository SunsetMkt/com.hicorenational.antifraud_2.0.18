package adapter;

import android.text.TextUtils;
import android.view.View;
import bean.TellNumHtyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import util.C7283h1;

/* loaded from: classes.dex */
public class HistoryPhoneTagAdapter extends BaseQuickAdapter<TellNumHtyBean, BaseViewHolder> {

    /* renamed from: V */
    private List<TellNumHtyBean> f215V;

    /* renamed from: adapter.HistoryPhoneTagAdapter$a */
    class ViewOnClickListenerC0063a implements View.OnClickListener {
        ViewOnClickListenerC0063a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public HistoryPhoneTagAdapter(int i2, List<TellNumHtyBean> list) {
        super(i2, list);
        this.f215V = list;
    }

    /* renamed from: a */
    public void m241a(List<TellNumHtyBean> list) {
        this.f215V.clear();
        this.f215V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, TellNumHtyBean tellNumHtyBean) {
        String caseCategoryText = tellNumHtyBean.getCaseCategoryText();
        String number = tellNumHtyBean.getNumber();
        String m26369a = C7283h1.m26369a(number);
        String submitTime = tellNumHtyBean.getSubmitTime();
        if (TextUtils.isEmpty(caseCategoryText)) {
            caseCategoryText = "其他诈骗";
        }
        if (TextUtils.isEmpty(m26369a)) {
            m26369a = "未知";
        }
        baseViewHolder.m5211a(C2113R.id.tv_phone, (CharSequence) number);
        baseViewHolder.m5211a(C2113R.id.casecategory, (CharSequence) caseCategoryText);
        baseViewHolder.m5211a(C2113R.id.phone_type, (CharSequence) m26369a);
        baseViewHolder.m5211a(C2113R.id.report_time, (CharSequence) submitTime);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((HistoryPhoneTagAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0063a());
    }
}
