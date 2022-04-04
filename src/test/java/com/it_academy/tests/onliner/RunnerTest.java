package com.it_academy.tests.onliner;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({CatalogMenuNavigationTest.class,
        ComputerAndNetworkMenuNavigationTest.class,
        AccessoriesMenuNavigationTest.class})
@SuiteDisplayName("A demo Test Suite")
public class RunnerTest {
}
