package yang.annotiontest;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	public static void processAnnotions(Object obj) {
		try {
			Class c1 = obj.getClass();
			for (Field f : c1.getDeclaredFields()) {
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				Object fObj = f.get(obj);
				if (a != null && fObj != null && fObj instanceof AbstractButton) {
					Class<? extends ActionListener> listenerClazz = a.listener();
					ActionListener a1 = listenerClazz.newInstance();
					AbstractButton ab = (AbstractButton) fObj;
					ab.addActionListener(a1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
