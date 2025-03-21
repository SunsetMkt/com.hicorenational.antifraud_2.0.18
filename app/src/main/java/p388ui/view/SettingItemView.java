package p388ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class SettingItemView extends LinearLayout {

    /* renamed from: a */
    private ViewGroup f24664a;

    /* renamed from: b */
    private TextView f24665b;

    /* renamed from: c */
    private TextView f24666c;

    /* renamed from: ui.view.SettingItemView$a */
    class ViewOnClickListenerC7195a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f24667a;

        ViewOnClickListenerC7195a(View.OnClickListener onClickListener) {
            this.f24667a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f24667a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public SettingItemView(Context context) {
        super(context);
        m25842a(null);
    }

    /* renamed from: a */
    private void m25842a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(C2113R.layout.layout_settings_item, (ViewGroup) this, true);
        this.f24664a = (ViewGroup) findViewById(C2113R.id.container_settings);
        this.f24665b = (TextView) findViewById(C2113R.id.tv_settings_title);
        this.f24666c = (TextView) findViewById(C2113R.id.tv_settings_value);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2113R.styleable.SettingItemView);
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
            this.f24665b.setText(string);
            this.f24666c.setText(string2);
        }
    }

    public void setItemEnable(boolean z) {
        this.f24664a.setEnabled(z);
    }

    public void setSettingItemClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f24664a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new ViewOnClickListenerC7195a(onClickListener));
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f24665b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setValue(String str) {
        TextView textView = this.f24666c;
        if (textView != null) {
            textView.setText(str);
            this.f24666c.setTextColor(ContextCompat.getColor(getContext(), C2113R.color.colorGray));
        }
    }

    public void setWarning(String str) {
        TextView textView = this.f24666c;
        if (textView != null) {
            textView.setText(str);
            this.f24666c.setTextColor(ContextCompat.getColor(getContext(), C2113R.color.colorAccent));
        }
    }

    public SettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25842a(attributeSet);
    }

    public SettingItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m25842a(attributeSet);
    }
}
