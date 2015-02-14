package code.challenge.system.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Chuck
 *
 */
public class ReflectionUtilsTest {

    @Test
    public void testInvokeMethodOnObjThatDoesNotContainMethod() {
        Class<?> stringClass = new String().getClass();

        Method clearListMethod = null;
        try {
            clearListMethod = new ArrayList<String>().getClass().getDeclaredMethod("clear");
        } catch (NoSuchMethodException ex) {
            // To test, we need a method to invoke.
            Assert.fail();
        }

        if (clearListMethod == null) {
            // To test, we need a method.
            Assert.fail();
        }

        Object results = ReflectionUtils.invokeMethod(clearListMethod, stringClass);
        // String does not contain "clear" method
        Assert.assertNull(results);
    }
}
