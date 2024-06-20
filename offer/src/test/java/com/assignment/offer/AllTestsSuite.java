package com.assignment.offer;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * A test suite that aggregates all unit test classes for the offer application.
 *
 * This suite allows running all unit tests together, ensuring comprehensive
 * testing of the application components.
 */
@Suite
@SelectPackages("com.assignment.offer")
@IncludeClassNamePatterns(".*Test")
public class AllTestsSuite {
}
