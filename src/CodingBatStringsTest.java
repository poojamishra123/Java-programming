import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodingBatStringsTest {

	@Test
	public void testHelloName() {
		CodingBatStrings tester = new CodingBatStrings();

		assertEquals("Hello Bob!", tester.helloName("Bob"));
		assertEquals("Hello Alice!", tester.helloName("Alice"));
		assertEquals("Hello C2!", tester.helloName("C2"));

	}

	@Test
	public void testMakeAbba() {
		CodingBatStrings tester = new CodingBatStrings();

		assertEquals("hiC2C2hi", tester.makeAbba("hi", "C2"));
		assertEquals("FatbabybabyFat", tester.makeAbba("Fat", "baby"));
		assertEquals("", tester.makeAbba("", ""));

	}

	@Test
	public void testMakeTags() {
		CodingBatStrings tester = new CodingBatStrings();

		assertEquals("<i>Yay</i>", tester.makeTags("i", "Yay"));
		assertEquals("<body>Hello</body>", tester.makeTags("body", "Hello"));
		assertEquals("<h>Kujri</h>", tester.makeTags("h", "Kujri"));
		assertEquals("<>Baby</>", tester.makeTags("", "Baby"));

	}

	@Test
	public void testMakeOutWord() {
		CodingBatStrings tester = new CodingBatStrings();

		assertEquals("[[sishu]]", tester.makeOutWord("[[]]", "sishu"));
		assertEquals("bbaabb", tester.makeOutWord("bbbb", "aa"));
		assertEquals("{{}}", tester.makeOutWord("{{}}", ""));
		assertEquals("houho", tester.makeOutWord("hoho", "u"));

	}

	@Test
	public void testExtraEnd() {
		CodingBatStrings tester = new CodingBatStrings();

		assertEquals("ononon", tester.extraEnd("moon"));
		assertEquals("TvTvTv", tester.extraEnd("Tv"));

	}

}
