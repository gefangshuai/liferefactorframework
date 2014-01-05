package net.wincn.test;

import net.wincn.utils.Utils;

import org.junit.Assert;
import org.junit.Test;

public class TestCommon {
	@Test
	public void test1() {
		String hello = Utils.sayHello();
		Assert.assertEquals("Hello World", hello);
	}
}
