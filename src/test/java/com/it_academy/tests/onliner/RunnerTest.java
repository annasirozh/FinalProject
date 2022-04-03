package com.it_academy.tests.onliner;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectClasses({CatalogMenuNavigationTest.class,
        ComputerAndNetworkMenuNavigationTest.class,
        AccessoriesMenuNavigationTest.class})
@SuiteDisplayName("A demo Test Suite")
public class RunnerTest {
}
