package lan.training.advanced.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reflection helper
 * @author nik-lazer  12.01.2015   18:01
 */
public class ReflectionHelper {
	private static Logger log = Logger.getLogger(ReflectionHelper.class.getName());

	public static Object createInstance(String className) {
		try {
			return Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE, "Class not found for instance creating", e);
		} catch (InstantiationException e) {
			log.log(Level.SEVERE, "Instance creation error", e);
		} catch (IllegalAccessException e) {
			log.log(Level.SEVERE, "Illegal access error", e);
		}
		return null;
	}

	public static void setFieldValue(Object object, String fieldName, String value) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			Class<?> type = field.getType();
			field.setAccessible(true);
			if (type == int.class || type == Integer.class) {
				field.set(object, new Integer(value));
			}
			if (type == String.class) {
				field.set(object, value);
			}
			field.setAccessible(false);
		} catch (NoSuchFieldException e) {
			log.log(Level.SEVERE, "Field " + fieldName + " is not exists in object " + object.getClass().getName(), e);
		} catch (IllegalAccessException e) {
			log.log(Level.SEVERE, "Illegal access error", e);
		}
	}

	public static Object getFieldValue(Object object, String fieldName) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			Class<?> type = field.getType();
			field.setAccessible(true);
			Object val  = field.get(object);
			field.setAccessible(false);
			return val;
		} catch (NoSuchFieldException e) {
			log.log(Level.SEVERE, "Field " + fieldName + " is not exists in object " + object.getClass().getName(), e);
		} catch (IllegalAccessException e) {
			log.log(Level.SEVERE, "Illegal access error", e);
		}
		return null;
	}

	public static Object methodInvoke(String methodName, Object instance) {
		try {
			Method method = instance.getClass().getMethod(methodName);
			method.setAccessible(true);
			Object result = method.invoke(instance);
			method.setAccessible(false);
			return result;
		} catch (NoSuchMethodException e) {
			log.log(Level.SEVERE, "Method " + methodName + "is not exist in class " + instance.getClass(), e);
		} catch (InvocationTargetException e) {
			log.log(Level.SEVERE, "Invocation target method error", e);
		} catch (IllegalAccessException e) {
			log.log(Level.SEVERE, "Illeegal method access error", e);
		}
		return null;
	}
}
