package com.huawei.hms.p182ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SafeIntent extends Intent {
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Exception unused) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b2) {
        try {
            return super.getByteExtra(str, b2);
        } catch (Exception unused) {
            return b2;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Exception unused) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c2) {
        try {
            return super.getCharExtra(str, c2);
        } catch (Exception unused) {
            return c2;
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Exception unused) {
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Exception unused) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d2) {
        try {
            return super.getDoubleExtra(str, d2);
        } catch (Exception unused) {
            return d2;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Exception unused) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f2) {
        try {
            return super.getFloatExtra(str, f2);
        } catch (Exception unused) {
            return f2;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Exception unused) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i2) {
        try {
            return super.getIntExtra(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Exception unused) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j2) {
        try {
            return super.getLongExtra(str, j2);
        } catch (Exception unused) {
            return j2;
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Exception unused) {
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Exception unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        try {
            return super.getShortExtra(str, s);
        } catch (Exception unused) {
            return s;
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Exception unused) {
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
