package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonUtil {
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    /* renamed from: a */
    private static String m7780a(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    m7786a(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    m7786a(field, isAccessible);
                    m7787a(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    private static Object m7789b(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object m7779a = m7779a(field.getName(), jSONObject);
        if (m7779a != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) m7779a, (IMessageEntity) field.getType().newInstance());
                }
                if (!(m7779a instanceof JSONObject) || !((JSONObject) m7779a).has(VAL_TYPE)) {
                    return m7779a;
                }
                int i2 = ((JSONObject) m7779a).getInt(VAL_TYPE);
                if (i2 != 1 && i2 != 0) {
                    if (i2 == 2) {
                        return m7788a((JSONObject) m7779a);
                    }
                    if (i2 == 3) {
                        return m7790b(field.getGenericType(), (JSONObject) m7779a);
                    }
                    HMSLog.m7715e("JsonUtil", "cannot support type : " + i2);
                }
                return m7781a(field.getGenericType(), (JSONObject) m7779a);
            } catch (InstantiationException unused) {
                HMSLog.m7715e("JsonUtil", "InstantiationException  ");
            }
        }
        return null;
    }

    @Deprecated
    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.m7715e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return m7780a(iMessageEntity);
        } catch (IllegalAccessException e2) {
            HMSLog.m7715e("JsonUtil", "catch IllegalAccessException " + e2.getMessage());
            return "";
        } catch (JSONException e3) {
            HMSLog.m7715e("JsonUtil", "catch JSONException " + e3.getMessage());
            return "";
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.m7715e("JsonUtil", "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    @Deprecated
    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) {
        Class<? super Object> superclass;
        if (iMessageEntity == null) {
            return null;
        }
        try {
            Class<?> cls = iMessageEntity.getClass();
            JSONObject jSONObject = new JSONObject(str);
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields == null) {
                    superclass = cls.getSuperclass();
                } else {
                    for (Field field : declaredFields) {
                        if (field.isAnnotationPresent(Packed.class)) {
                            try {
                                m7782a(iMessageEntity, field, jSONObject);
                            } catch (IllegalAccessException unused) {
                                HMSLog.m7715e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                            }
                        }
                    }
                    superclass = cls.getSuperclass();
                }
                cls = superclass;
            }
        } catch (JSONException e2) {
            HMSLog.m7715e("JsonUtil", "catch JSONException when parse jsonString" + e2.getMessage());
        }
        return iMessageEntity;
    }

    /* renamed from: a */
    private static void m7786a(final Field field, final boolean z) {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.utils.JsonUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                field.setAccessible(z);
                return null;
            }
        });
    }

    /* renamed from: b */
    private static Map m7790b(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2 += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i2), jsonToEntity(jSONArray.getString(i2 + 1), (IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i2), jSONArray.get(i2 + 1));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static boolean m7787a(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        }
        if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        }
        if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        }
        if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        }
        if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        }
        if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        }
        if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        }
        if (obj instanceof byte[]) {
            m7785a(str, (byte[]) obj, jSONObject);
            return true;
        }
        if (obj instanceof List) {
            m7783a(str, (List<?>) obj, jSONObject);
            return true;
        }
        if (obj instanceof Map) {
            m7784a(str, (Map) obj, jSONObject);
            return true;
        }
        if (obj instanceof IMessageEntity) {
            try {
                jSONObject.put(str, m7780a((IMessageEntity) obj));
                return true;
            } catch (IllegalAccessException e2) {
                HMSLog.m7715e("JsonUtil", "IllegalAccessException , " + e2);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m7784a(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.put(m7780a((IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.put(m7780a((IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 3);
        jSONObject2.put("_map_", jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m7785a(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 2);
        try {
            jSONObject2.put("_byte_", Base64.encode(bArr));
        } catch (IllegalArgumentException e2) {
            HMSLog.m7715e("JsonUtil", "writeByte failed : " + e2.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m7783a(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 1);
        jSONObject2.put("_list_size_", list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            m7787a("_list_item_" + i2, list.get(i2), jSONObject2);
            if (list.get(i2) instanceof IMessageEntity) {
                jSONObject2.put(VAL_TYPE, 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m7782a(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object m7789b = m7789b(iMessageEntity, field, jSONObject);
        if (m7789b != null) {
            boolean isAccessible = field.isAccessible();
            m7786a(field, true);
            field.set(iMessageEntity, m7789b);
            m7786a(field, isAccessible);
        }
    }

    /* renamed from: a */
    private static Object m7779a(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
            return jSONObject.getJSONObject("body").get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static List<Object> m7781a(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i2 = jSONObject.getInt("_list_size_");
        int i3 = jSONObject.getInt(VAL_TYPE);
        ArrayList arrayList = new ArrayList(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = jSONObject.get("_list_item_" + i4);
            if (i3 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i3 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static byte[] m7788a(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString("_byte_"));
        } catch (IllegalArgumentException e2) {
            HMSLog.m7715e("JsonUtil", "readByte failed : " + e2.getMessage());
            return null;
        }
    }
}
