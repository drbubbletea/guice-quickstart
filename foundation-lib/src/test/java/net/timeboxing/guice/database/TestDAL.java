package net.timeboxing.guice.database;

public interface TestDAL {

    /**
     * Run a simple "SELECT 1" query to see if the datasource is working as expected.
     */
    int test();
}
