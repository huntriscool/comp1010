package practicePackage._04_recursion.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import practicePackage._04_recursion.attempts.*;

public class Stage5Test {
	public static int randInt(int max, int min) {
		return ((int) (Math.random()*(max - min))) + min;
	}

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "addrecursive", marks = 1)
	public void testAddRecursive()  {
		//equal
		assertEquals("5592",Stage5.addRecursive("2796","2796"));
		assertEquals("9284",Stage5.addRecursive("4642","4642"));
		assertEquals("14680",Stage5.addRecursive("7340","7340"));
		assertEquals("10186",Stage5.addRecursive("5093","5093"));
		assertEquals("4108",Stage5.addRecursive("2054","2054"));
		//low close
		assertEquals("290",Stage5.addRecursive("263","27"));
		assertEquals("1349",Stage5.addRecursive("379","970"));
		assertEquals("693",Stage5.addRecursive("92","601"));
		assertEquals("838",Stage5.addRecursive("834","4"));
		assertEquals("1027",Stage5.addRecursive("209","818"));
		//high close
		assertEquals("130094",Stage5.addRecursive("00000000000082598","000047496"));
		assertEquals("130094",Stage5.addRecursive("82598","47496"));
		assertEquals("125478",Stage5.addRecursive("64662","60816"));
		assertEquals("125645",Stage5.addRecursive("41635","84010"));
		assertEquals("45049",Stage5.addRecursive("5939","39110"));
		assertEquals("36226",Stage5.addRecursive("-4204","40430"));
		//wildly different
		assertEquals("55103",Stage5.addRecursive("24882","30221"));
		assertEquals("55398",Stage5.addRecursive("28473","26925"));
		assertEquals("168838",Stage5.addRecursive("70253","98585"));
		assertEquals("58353",Stage5.addRecursive("35670","22683"));
		assertEquals("49149",Stage5.addRecursive("17431","31718"));
		//negatives (hard)
		assertEquals("-141070",Stage5.addRecursive("-87036","-54034"));
		assertEquals("-70310",Stage5.addRecursive("-60955","-9355"));
		assertEquals("-34729",Stage5.addRecursive("-44594","9865"));
		assertEquals("-49312",Stage5.addRecursive("-21787","-27525"));
		assertEquals("-169774",Stage5.addRecursive("-73696","-96078"));

		assertEquals("3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage5.addRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage5.addRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage5.addRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage5.addRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));

		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage5.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage5.getRandomInteger(1,100));
				String expected = a.add(b).toString();
				String actual = Stage5.addRecursive(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n+\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "subtractrecursive", marks = 1)
	public void testSubtractRecursive()  {
		//equal
		assertEquals("0",Stage5.subtractRecursive("959","959"));
		assertEquals("0",Stage5.subtractRecursive("2378","2378"));
		assertEquals("0",Stage5.subtractRecursive("8648","8648"));
		assertEquals("0",Stage5.subtractRecursive("5714","5714"));
		assertEquals("0",Stage5.subtractRecursive("6282","6282"));
		//low close
		assertEquals("812",Stage5.subtractRecursive("882","70"));
		assertEquals("486",Stage5.subtractRecursive("655","169"));
		assertEquals("-567",Stage5.subtractRecursive("343","910"));
		assertEquals("-633",Stage5.subtractRecursive("174","807"));
		assertEquals("757",Stage5.subtractRecursive("923","166"));
		//high close
		assertEquals("-18890",Stage5.subtractRecursive("00000000045821","000064711"));
		assertEquals("-64711",Stage5.subtractRecursive("000000000","00000000000000000064711"));
		
		assertEquals("-18890",Stage5.subtractRecursive("45821","64711"));
		assertEquals("-55680",Stage5.subtractRecursive("19881","75561"));
		assertEquals("46485",Stage5.subtractRecursive("49504","3019"));
		assertEquals("12982",Stage5.subtractRecursive("36785","23803"));
		assertEquals("42951",Stage5.subtractRecursive("33323","-9628"));
		//wildly different
		assertEquals("-53091",Stage5.subtractRecursive("40120","93211"));
		assertEquals("38731",Stage5.subtractRecursive("67007","28276"));
		assertEquals("-1912",Stage5.subtractRecursive("65639","67551"));
		assertEquals("27032",Stage5.subtractRecursive("60399","33367"));
		assertEquals("20123",Stage5.subtractRecursive("90968","70845"));
		//negatives (hard)
		assertEquals("38414",Stage5.subtractRecursive("-33686","-72100"));
		assertEquals("-49404",Stage5.subtractRecursive("-40611","8793"));
		assertEquals("45327",Stage5.subtractRecursive("-19992","-65319"));
		assertEquals("89015",Stage5.subtractRecursive("2435","-86580"));
		assertEquals("188",Stage5.subtractRecursive("-25627","-25815"));

		assertEquals("3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage5.subtractRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage5.subtractRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage5.subtractRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage5.subtractRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));

		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage5.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage5.getRandomInteger(1,100));
				String expected = a.subtract(b).toString();
				String actual = Stage5.subtractRecursive(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n-\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "multiplyrecursive", marks = 1)
	public void testMultiplyRecursive()  {
		//equal
		assertEquals("2030625",Stage5.multiplyRecursive("1425","1425"));
		assertEquals("38266596",Stage5.multiplyRecursive("6186","6186"));
		assertEquals("3748096",Stage5.multiplyRecursive("1936","1936"));
		assertEquals("4977361",Stage5.multiplyRecursive("2231","2231"));
		assertEquals("9369721",Stage5.multiplyRecursive("3061","3061"));
		//low close
		assertEquals("513810",Stage5.multiplyRecursive("519","990"));
		assertEquals("755505",Stage5.multiplyRecursive("927","815"));
		assertEquals("15147",Stage5.multiplyRecursive("99","153"));
		assertEquals("21384",Stage5.multiplyRecursive("44","486"));
		assertEquals("541140",Stage5.multiplyRecursive("933","580"));
		//high close
		assertEquals("179805052",Stage5.multiplyRecursive("32597","5516"));
		assertEquals("-575902146",Stage5.multiplyRecursive("-00000000000000000000006717","0000000085738"));
		assertEquals("-575902146",Stage5.multiplyRecursive("-6717","85738"));
		assertEquals("2086736180",Stage5.multiplyRecursive("41165","50692"));
		assertEquals("5448387522",Stage5.multiplyRecursive("56649","96178"));
		assertEquals("-50689842",Stage5.multiplyRecursive("23709","-2138"));
		//wildly different
		assertEquals("3079953791",Stage5.multiplyRecursive("95393","32287"));
		assertEquals("8105815575",Stage5.multiplyRecursive("85735","94545"));
		assertEquals("25430544",Stage5.multiplyRecursive("85914","296"));
		assertEquals("2128763377",Stage5.multiplyRecursive("35087","60671"));
		assertEquals("666492384",Stage5.multiplyRecursive("18444","36136"));
		//negatives (hard)
		assertEquals("2200952668",Stage5.multiplyRecursive("-36812","-59789"));
		assertEquals("243967088",Stage5.multiplyRecursive("-7984","-30557"));
		assertEquals("1326082434",Stage5.multiplyRecursive("-54858","-24173"));
		assertEquals("2897653824",Stage5.multiplyRecursive("-56544","-51246"));
		assertEquals("686308819",Stage5.multiplyRecursive("-49997","-13727"));

		assertEquals("31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage5.multiplyRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage5.multiplyRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage5.multiplyRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage5.multiplyRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		
		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage5.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage5.getRandomInteger(1,100));
				String expected = a.multiply(b).toString();
				String actual = Stage5.multiplyRecursive(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n*\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "remainderrecursive", marks = 1)
	public void testRemainderRecursive()  {
		//equal
		assertEquals("0",Stage5.remainderRecursive("3199","3199"));
		assertEquals("0",Stage5.remainderRecursive("5109","5109"));
		assertEquals("0",Stage5.remainderRecursive("3699","3699"));
		assertEquals("0",Stage5.remainderRecursive("5084","5084"));
		assertEquals("0",Stage5.remainderRecursive("8050","8050"));
		//low close
		assertEquals("53",Stage5.remainderRecursive("7400","93"));
		assertEquals("0",Stage5.remainderRecursive("1400","5"));
		assertEquals("5",Stage5.remainderRecursive("4500","31"));
		assertEquals("30",Stage5.remainderRecursive("8200","38"));
		assertEquals("64",Stage5.remainderRecursive("4600","72"));
		//high close
		assertEquals("-76",Stage5.remainderRecursive("-125900","31456"));
		assertEquals("3654",Stage5.remainderRecursive("5678400","79926"));
		assertEquals("34359",Stage5.remainderRecursive("4044900","36131"));
		assertEquals("22224",Stage5.remainderRecursive("5933600","57392"));
		assertEquals("24596",Stage5.remainderRecursive("6965700","24968"));
		//wildly different
		assertEquals("15452",Stage5.remainderRecursive("7737500","34784"));
		assertEquals("39933",Stage5.remainderRecursive("7682100","87841"));
		assertEquals("89872",Stage5.remainderRecursive("4085600","90812"));
		assertEquals("4028",Stage5.remainderRecursive("902300","12476"));
		assertEquals("62760",Stage5.remainderRecursive("8053200","66587"));
		//negatives (hard)
		assertEquals("-85478",Stage5.remainderRecursive("-384200","-99574"));
		assertEquals("-18925",Stage5.remainderRecursive("-9691400","-22975"));
		assertEquals("-1960",Stage5.remainderRecursive("-3221800","-2795"));
		assertEquals("50810",Stage5.remainderRecursive("435500","-64115"));
		assertEquals("-2059",Stage5.remainderRecursive("-7513900","-49097"));

		assertEquals("2964967479885262852878534846244981087097214113210047490819913196915",Stage5.remainderRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-2964967479885262852878534846244981087097214113210047490819913196915",Stage5.remainderRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("2964967479885262852878534846244981087097214113210047490819913196915",Stage5.remainderRecursive("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-2964967479885262852878534846244981087097214113210047490819913196915",Stage5.remainderRecursive("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		
		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage5.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage5.getRandomInteger(1,100));
				if(!b.equals(new BigInteger("0"))) {
					String expected = a.remainder(b).toString();
					String actual = Stage5.remainderRecursive(a.toString(), b.toString());
					assertEquals(expected, actual, a+"\n%\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);
				}
			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}


    @AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if (currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score += graded.marks();
            score = Math.min(score, 100);
			result += graded.description() + " passed. Marks awarded: " + graded.marks() + "\n";
		}
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		if (result.length() != 0) {
			result = result.substring(0, result.length() - 1); // remove the last "\n"
		}
		System.out.println(result);
		System.out.println("\nmethods passed: " + score);
	}
}
