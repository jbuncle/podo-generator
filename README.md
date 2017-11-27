# Java Plain Old Data Object (PODO) Generator

[![Build Status](https://travis-ci.org/jbuncle/podo-generator.svg?branch=master)](https://travis-ci.org/jbuncle/podo-generator)
[![codecov.io](https://codecov.io/github/jbuncle/podo-generator/coverage.svg?branch=master)](https://codecov.io/github/jbuncle/podo-generator?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9c2a9c7bfc2740478541860a2a678226)](https://www.codacy.com/app/jbuncle/podo-generator?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jbuncle/podo-generator&amp;utm_campaign=Badge_Grade)

Java library for creating "Plain Old Data Object" class files from mixed typed
Map instances or Objects.

For instance, for generating data objects from a schema-less JSON service.

## Installation

This library isn't currently available in standard repositories, however it can
be used via https://jitpack.io/. 

The Maven setup is:

```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
        ...
	<dependency>
	    <groupId>com.github.jbuncle</groupId>
	    <artifactId>podo-generator</artifactId>
	    <version>master</version>
	</dependency>
```