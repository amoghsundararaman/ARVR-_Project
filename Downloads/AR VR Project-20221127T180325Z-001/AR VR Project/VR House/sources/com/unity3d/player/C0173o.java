package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.unity3d.player.o */
final class C0173o {

    /* renamed from: a */
    private HashMap f240a = new HashMap();

    /* renamed from: b */
    private Class f241b = null;

    /* renamed from: c */
    private Object f242c = null;

    /* renamed from: com.unity3d.player.o$a */
    class C0174a {

        /* renamed from: a */
        public Class[] f243a;

        /* renamed from: b */
        public Method f244b = null;

        public C0174a(Class[] clsArr) {
            this.f243a = clsArr;
        }
    }

    public C0173o(Class cls, Object obj) {
        this.f241b = cls;
        this.f242c = obj;
    }

    /* renamed from: a */
    private void m166a(String str, C0174a aVar) {
        try {
            aVar.f244b = this.f241b.getMethod(str, aVar.f243a);
        } catch (Exception e) {
            C0160g.Log(6, "Exception while trying to get method " + str + ". " + e.getLocalizedMessage());
            aVar.f244b = null;
        }
    }

    /* renamed from: a */
    public final Object mo1696a(String str, Object... objArr) {
        Object obj;
        if (!this.f240a.containsKey(str)) {
            C0160g.Log(6, "No definition for method " + str + " can be found");
            return null;
        }
        C0174a aVar = (C0174a) this.f240a.get(str);
        if (aVar.f244b == null) {
            m166a(str, aVar);
        }
        if (aVar.f244b == null) {
            C0160g.Log(6, "Unable to create method: " + str);
            return null;
        }
        try {
            obj = objArr.length == 0 ? aVar.f244b.invoke(this.f242c, new Object[0]) : aVar.f244b.invoke(this.f242c, objArr);
        } catch (Exception e) {
            C0160g.Log(6, "Error trying to call delegated method " + str + ". " + e.getLocalizedMessage());
            obj = null;
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo1697a(String str, Class[] clsArr) {
        this.f240a.put(str, new C0174a(clsArr));
    }
}
