package util.permissionutil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p388ui.C6813c;

/* loaded from: classes2.dex */
public class PermissionFragment extends Fragment {

    /* renamed from: c */
    private static final int f25518c = 1;

    /* renamed from: a */
    Activity f25519a;

    /* renamed from: b */
    private InterfaceC7309b f25520b;

    /* renamed from: b */
    private void m26491b() {
        InterfaceC7309b interfaceC7309b = this.f25520b;
        if (interfaceC7309b != null) {
            interfaceC7309b.onGranted();
        }
    }

    /* renamed from: a */
    public void m26494a(InterfaceC7309b interfaceC7309b) {
        this.f25520b = interfaceC7309b;
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f25519a = getActivity();
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // android.app.Fragment
    @RequiresApi(api = 23)
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 1) {
            return;
        }
        try {
            if (iArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (iArr[i3] != 0) {
                        arrayList.add(strArr[i3]);
                    }
                }
                if (arrayList.isEmpty()) {
                    m26491b();
                    return;
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!shouldShowRequestPermissionRationale(it.next())) {
                        m26492b(arrayList);
                        return;
                    }
                }
                m26490a(arrayList);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public Activity m26493a() {
        Activity activity = this.f25519a;
        return activity == null ? C6813c.m25437i().m25453h() : activity;
    }

    /* renamed from: b */
    private void m26492b(List<String> list) {
        InterfaceC7309b interfaceC7309b = this.f25520b;
        if (interfaceC7309b != null) {
            interfaceC7309b.mo26509a(list);
        }
    }

    @TargetApi(23)
    /* renamed from: a */
    public void m26495a(@NonNull String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(m26493a(), str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                m26491b();
            } else {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            }
        } catch (Error | Exception unused) {
        }
    }

    /* renamed from: a */
    private void m26490a(List<String> list) {
        InterfaceC7309b interfaceC7309b = this.f25520b;
        if (interfaceC7309b != null) {
            interfaceC7309b.mo26510b(list);
        }
    }
}
