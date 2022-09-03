package net.timeboxing.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClasspathResourceTest {

    @Test
    public void canGetByPackageResourceFolder() {
        String value = ClasspathResource.get("test.txt");
        Assertions.assertEquals("lorem ipsum", value);
    }
}
