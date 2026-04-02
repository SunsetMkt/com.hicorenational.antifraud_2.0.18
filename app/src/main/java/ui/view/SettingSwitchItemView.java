package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettingSwitchItemView extends LinearLayout {
    private ViewGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f14628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Switch f14629c;

    class a implements View.OnClickListener {
        final /* synthetic */ View.OnClickListener a;

        a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public SettingSwitchItemView(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_settings_radio_item, (ViewGroup) this, true);
        this.a = (ViewGroup) findViewById(R.id.container_settings);
        this.f14628b = (TextView) findViewById(R.id.tv_settings_title);
        this.f14629c = (Switch) findViewById(R.id.swicth_settings);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SettingSwitchItemView);
            String string = typedArrayObtainStyledAttributes.getString(1);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            this.f14628b.setText(string);
            this.f14629c.setChecked(z);
        }
    }

    public void setItemEnable(boolean z) {
        this.a.setEnabled(z);
    }

    public void setOnSwitchCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r0 = this.f14629c;
        if (r0 != null) {
            r0.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setSettingItemClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new a(onClickListener));
        }
    }

    public void setSwichChecked(boolean z) {
        Switch r0 = this.f14629c;
        if (r0 != null) {
            r0.setChecked(z);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f14628b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public SettingSwitchItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SettingSwitchItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
