package net.timeboxing.resource.test;

import net.timeboxing.resource.ClasspathResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Intentionally in a package different from ClasspathResource to ensure
 * we get the package of this class and not the package of classpath resource.
 */
class ClasspathResourceTest {

    @Test
    void canGetByPackageResourceFolder() {
        String value = ClasspathResource.get("test.txt");
        Assertions.assertEquals("lorem ipsum", value);
    }
}
