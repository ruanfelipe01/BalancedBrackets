package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	private DemoApplication DemoApplication;

	@Test
	public void emptyBalanced() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance(""), is(true));
	}

	@Test
	public void balanceIsOKInSequenceIsTue() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("(){}[]"), is(true));
	}

	@Test
	public void balanceIsOKMixedIsTue() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("[{()}](){}"), is(true));
	}

	@Test
	public void balanceIsNotOKMissingClosingIsFalse() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("[]{()"), is(false));
	}

	@Test
	public void balanceIsNotOKMissingClosingAndOpeningIsFalse() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("[{)]"), is(false));
	}

	@Test
	public void manyNestedBracketsOkIsTrue() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("([Hell{} T(h(e[r]e))]boom)"), is(true));
	}
	@Test
	public void numberOfClosingBracketsIsOKButInWrongOrderIsFalse() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("(a[b{c)d]e}"), is(false));
	}
	@Test
	public void onlyClosedBracesExistingIsFalse() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("}])"), is(false));
	}
	@Test
	public void balanceIsOKButWithMoreOpeningBracketsIsFalse() throws Exception {
		DemoApplication = new DemoApplication();
		assertThat(DemoApplication.checkBalance("({}"), is(false));
	}



}

