/**
 *  
 */
package code.challenge.system.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Where the "magic" happens. <br>
 * <br>
 * IMPORTANT: ONLY PASS IN ARGUMENTS TO THIS UTILITY FROM THE CLASS THEY ARE
 * DEFINED IN! <br>
 * Otherwise, an object's private methods could be exposed. <br>
 * Unless, of course, you have a mage that can control objects against thier
 * will!
 * 
 * @author Chuck
 *
 */
public class ReflectionUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtils.class.getSimpleName());

    private static final String ERR_MSG_METHOD_INVOCATION_FAILURE = "Unable to invoke method!";

    // This is a utility. All methods are static, so no need to instantiate.
    private ReflectionUtils() {
    }

    /**
     * Recurses through the given class's hierarchy searching for the given
     * method.
     * 
     * @see java.lang.Class.getDeclaredMethod(String name, Class<?>...
     *      parameterTypes) for more details.
     * @param clazz
     *            The class containing the method.
     * @param methodName
     *            The name of the method to retrieve.
     * @return The method with the given methodName within the given clazz
     *         hierarchy. <code>null</code> if not found.
     */
    public static Method getMethod(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName);
            LOGGER.debug("Found method '{}' in {}.", methodName, clazz.getName());
        } catch (NoSuchMethodException e) {
            Class<?> superClazz = clazz.getSuperclass();
            if (superClazz != null) {
                return getMethod(superClazz, methodName);
            }
            LOGGER.debug("Could not find method '{}' in {}.", methodName, clazz.getName());
        }
        return method;
    }

    /**
     * Wrapper method for {@link java.lang.reflect.Method.invoke(Object obj,
     * Object... args)} to set the given method to 'accessible' and captures any
     * Exceptions as needed and logs the errors. (For use where an exception
     * should not crash an application).
     * 
     * @param method
     *            The Method to invoke.
     * @param obj
     *            The Object containing the method.
     * @param args
     *            Any arguments the method needs passed in. (Must be in order)
     * @return The return value of the invoked method. <code>null</code> if an
     *         Exception is encountered.
     */
    public static Object invokeMethod(Method method, Object obj, Object... args) {
        Object results = null;
        try {
            // stays true only for the current invocation.
            method.setAccessible(true);
            results = method.invoke(obj, args);
        } catch (IllegalArgumentException e) {
            LOGGER.error(ERR_MSG_METHOD_INVOCATION_FAILURE, e);
        } catch (IllegalAccessException e) {
            LOGGER.error(ERR_MSG_METHOD_INVOCATION_FAILURE, e);
        } catch (InvocationTargetException e) {
            LOGGER.error(ERR_MSG_METHOD_INVOCATION_FAILURE, e);
        }
        return results;
    }
}
