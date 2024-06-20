package com.assignment.offer;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.assignment.offer")
@IncludeClassNamePatterns(".*Test")
public class AllTestsSuite {
}
