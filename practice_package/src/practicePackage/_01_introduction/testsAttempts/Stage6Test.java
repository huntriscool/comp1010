package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage6;

public class Stage6Test {

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

	@Test @Graded(description = "add", marks = 1)
	public void testAdd()  {
		//equal
		assertEquals("5592",Stage6.add("00000000000000000000002796","00002796"));
		assertEquals("5592",Stage6.add("2796","2796"));
		assertEquals("9284",Stage6.add("4642","4642"));
		assertEquals("14680",Stage6.add("7340","7340"));
		assertEquals("10186",Stage6.add("5093","5093"));
		assertEquals("4108",Stage6.add("2054","2054"));
		//low close
		assertEquals("290",Stage6.add("263","27"));
		assertEquals("1349",Stage6.add("379","970"));
		assertEquals("693",Stage6.add("92","601"));
		assertEquals("838",Stage6.add("834","4"));
		assertEquals("1027",Stage6.add("209","818"));
		//high close
		assertEquals("130094",Stage6.add("82598","47496"));
		assertEquals("125478",Stage6.add("64662","60816"));
		assertEquals("125645",Stage6.add("41635","84010"));
		assertEquals("45049",Stage6.add("5939","39110"));
		assertEquals("36226",Stage6.add("-4204","40430"));
		//wildly different
		assertEquals("55103",Stage6.add("24882","30221"));
		assertEquals("55398",Stage6.add("28473","26925"));
		assertEquals("168838",Stage6.add("70253","98585"));
		assertEquals("58353",Stage6.add("35670","22683"));
		assertEquals("49149",Stage6.add("17431","31718"));
		//negatives (hard)
		assertEquals("-141070",Stage6.add("-87036","-54034"));
		assertEquals("-70310",Stage6.add("-60955","-9355"));
		assertEquals("-34729",Stage6.add("-44594","9865"));
		assertEquals("-49312",Stage6.add("-21787","-27525"));
		assertEquals("-169774",Stage6.add("-73696","-96078"));

		assertEquals("3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage6.add("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage6.add("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage6.add("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage6.add("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));

		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage6.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage6.getRandomInteger(1,100));
				String expected = a.add(b).toString();
				String actual = Stage6.add(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n+\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "subtract", marks = 1)
	public void testSubtract()  {
		//equal
		assertEquals("0",Stage6.subtract("959","959"));
		assertEquals("0",Stage6.subtract("2378","2378"));
		assertEquals("0",Stage6.subtract("8648","8648"));
		assertEquals("0",Stage6.subtract("5714","5714"));
		assertEquals("0",Stage6.subtract("6282","6282"));
		//low close
		assertEquals("812",Stage6.subtract("00000000000000882","000070"));
		assertEquals("812",Stage6.subtract("882","70"));
		assertEquals("486",Stage6.subtract("655","169"));
		assertEquals("-567",Stage6.subtract("343","910"));
		assertEquals("-633",Stage6.subtract("174","807"));
		assertEquals("757",Stage6.subtract("923","166"));
		//high close
		assertEquals("-18890",Stage6.subtract("45821","64711"));
		assertEquals("-55680",Stage6.subtract("19881","75561"));
		assertEquals("46485",Stage6.subtract("49504","3019"));
		assertEquals("12982",Stage6.subtract("36785","23803"));
		assertEquals("42951",Stage6.subtract("33323","-9628"));
		//wildly different
		assertEquals("-53091",Stage6.subtract("40120","93211"));
		assertEquals("38731",Stage6.subtract("67007","28276"));
		assertEquals("-1912",Stage6.subtract("65639","67551"));
		assertEquals("27032",Stage6.subtract("60399","33367"));
		assertEquals("20123",Stage6.subtract("90968","70845"));
		//negatives (hard)
		assertEquals("38414",Stage6.subtract("-33686","-72100"));
		assertEquals("-49404",Stage6.subtract("-40611","8793"));
		assertEquals("45327",Stage6.subtract("-19992","-65319"));
		assertEquals("89015",Stage6.subtract("2435","-86580"));
		assertEquals("188",Stage6.subtract("-25627","-25815"));

		assertEquals("3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage6.subtract("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage6.subtract("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("3765428673067053708746837688950610862116285623924234310569774088437558761694124345632139623530",Stage6.subtract("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-3765428673067053708746837672143466088658970450487500099143642626804132586473397323880029888640",Stage6.subtract("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));

		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage6.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage6.getRandomInteger(1,100));
				String expected = a.subtract(b).toString();
				String actual = Stage6.subtract(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n-\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "multiply", marks = 1)
	public void testMultiply()  {
		//equal
		assertEquals("2030625",Stage6.multiply("1425","1425"));
		assertEquals("38266596",Stage6.multiply("6186","6186"));
		assertEquals("3748096",Stage6.multiply("1936","1936"));
		assertEquals("4977361",Stage6.multiply("2231","2231"));
		assertEquals("9369721",Stage6.multiply("3061","3061"));
		//low close
		assertEquals("513810",Stage6.multiply("000000000000519","0000990"));
		assertEquals("513810",Stage6.multiply("519","990"));
		assertEquals("755505",Stage6.multiply("927","815"));
		assertEquals("15147",Stage6.multiply("99","153"));
		assertEquals("21384",Stage6.multiply("44","486"));
		assertEquals("541140",Stage6.multiply("933","580"));
		//high close
		assertEquals("179805052",Stage6.multiply("32597","5516"));
		assertEquals("-575902146",Stage6.multiply("-6717","85738"));
		assertEquals("2086736180",Stage6.multiply("41165","50692"));
		assertEquals("5448387522",Stage6.multiply("56649","96178"));
		assertEquals("-50689842",Stage6.multiply("23709","-2138"));
		//wildly different
		assertEquals("3079953791",Stage6.multiply("95393","32287"));
		assertEquals("8105815575",Stage6.multiply("85735","94545"));
		assertEquals("25430544",Stage6.multiply("85914","296"));
		assertEquals("2128763377",Stage6.multiply("35087","60671"));
		assertEquals("666492384",Stage6.multiply("18444","36136"));
		//negatives (hard)
		assertEquals("2200952668",Stage6.multiply("-36812","-59789"));
		assertEquals("243967088",Stage6.multiply("-7984","-30557"));
		assertEquals("1326082434",Stage6.multiply("-54858","-24173"));
		assertEquals("2897653824",Stage6.multiply("-56544","-51246"));
		assertEquals("686308819",Stage6.multiply("-49997","-13727"));

		assertEquals("31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage6.multiply("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage6.multiply("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage6.multiply("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("31643052421182622643080994466257368727518999666441125198843789906834274253207361756659921683730490018463087827516524655644595249906327039895858838249229832152825",Stage6.multiply("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		
		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage6.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage6.getRandomInteger(1,100));
				String expected = a.multiply(b).toString();
				String actual = Stage6.multiply(a.toString(), b.toString());
				assertEquals(expected, actual, a+"\n*\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "divide", marks = 1)
	public void testDivide()  {
		//equal
		assertEquals("280",Stage6.divide("1400","5"));
		assertEquals("1",Stage6.divide("5039","5039"));
		assertEquals("1",Stage6.divide("5169","5169"));
		assertEquals("1",Stage6.divide("3108","3108"));
		assertEquals("1",Stage6.divide("9765","9765"));
		assertEquals("1",Stage6.divide("3128","3128"));
		//low close
		assertEquals("5001",Stage6.divide("175035","35"));
		assertEquals("138",Stage6.divide("9700","70"));
		assertEquals("147",Stage6.divide("8400","57"));
		assertEquals("19",Stage6.divide("1900","100"));
		assertEquals("208",Stage6.divide("4800","23"));
		assertEquals("103",Stage6.divide("6200","60"));
		//high close
		assertEquals("6",Stage6.divide("000000000000000531100","00088228"));
		assertEquals("6",Stage6.divide("531100","88228"));
		assertEquals("-1063",Stage6.divide("7647600","-7193"));
		assertEquals("129",Stage6.divide("9104600","70178"));
		assertEquals("426",Stage6.divide("7993300","18734"));
		assertEquals("30",Stage6.divide("2379300","76826"));
		//wildly different
		assertEquals("31",Stage6.divide("1270700","40238"));
		assertEquals("2045",Stage6.divide("7196800","3519"));
		assertEquals("302",Stage6.divide("9710000","32053"));
		assertEquals("284",Stage6.divide("5998100","21083"));
		assertEquals("34",Stage6.divide("1295300","37217"));
		//negatives (hard)
		assertEquals("100",Stage6.divide("-6270500","-62384"));
		assertEquals("467",Stage6.divide("-9610800","-20559"));
		assertEquals("82",Stage6.divide("-4107400","-49830"));
		assertEquals("110",Stage6.divide("-8717600","-78673"));
		assertEquals("459",Stage6.divide("-4857600","-10583"));

		assertEquals("448074759136198703302898106",Stage6.divide("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-448074759136198703302898106",Stage6.divide("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-448074759136198703302898106",Stage6.divide("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("448074759136198703302898106",Stage6.divide("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		
		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage6.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage6.getRandomInteger(1,100));
				if(!b.equals(new BigInteger("0"))) {
					String expected = a.divide(b).toString();
					String actual = Stage6.divide(a.toString(), b.toString());
					assertEquals(expected, actual, a+"\n/\n"+b+"\nexpected to be\n"+expected+"\nbut was\n"+actual);

				}
			}
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "remainder", marks = 1)
	public void testRemainder()  {
		//equal
		assertEquals("0",Stage6.remainder("3199","3199"));
		assertEquals("0",Stage6.remainder("5109","5109"));
		assertEquals("0",Stage6.remainder("3699","3699"));
		assertEquals("0",Stage6.remainder("5084","5084"));
		assertEquals("0",Stage6.remainder("8050","8050"));
		//low close
		assertEquals("53",Stage6.remainder("0000000000007400","000093"));
		assertEquals("53",Stage6.remainder("7400","93"));
		assertEquals("0",Stage6.remainder("1400","5"));
		assertEquals("5",Stage6.remainder("4500","31"));
		assertEquals("30",Stage6.remainder("8200","38"));
		assertEquals("64",Stage6.remainder("4600","72"));
		//high close
		assertEquals("-76",Stage6.remainder("-125900","31456"));
		assertEquals("3654",Stage6.remainder("5678400","79926"));
		assertEquals("34359",Stage6.remainder("4044900","36131"));
		assertEquals("22224",Stage6.remainder("5933600","57392"));
		assertEquals("24596",Stage6.remainder("6965700","24968"));
		//wildly different
		assertEquals("15452",Stage6.remainder("7737500","34784"));
		assertEquals("39933",Stage6.remainder("7682100","87841"));
		assertEquals("89872",Stage6.remainder("4085600","90812"));
		assertEquals("4028",Stage6.remainder("902300","12476"));
		assertEquals("62760",Stage6.remainder("8053200","66587"));
		//negatives (hard)
		assertEquals("-85478",Stage6.remainder("-384200","-99574"));
		assertEquals("-18925",Stage6.remainder("-9691400","-22975"));
		assertEquals("-1960",Stage6.remainder("-3221800","-2795"));
		assertEquals("50810",Stage6.remainder("435500","-64115"));
		assertEquals("-2059",Stage6.remainder("-7513900","-49097"));

		assertEquals("2964967479885262852878534846244981087097214113210047490819913196915",Stage6.remainder("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-2964967479885262852878534846244981087097214113210047490819913196915",Stage6.remainder("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("2964967479885262852878534846244981087097214113210047490819913196915",Stage6.remainder("3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		assertEquals("-2964967479885262852878534846244981087097214113210047490819913196915",Stage6.remainder("-3765428673067053708746837680547038475387628037205867204856708357620845674083760834756084756085","-8403572386728657586718367105713065730816713087610363510876054867445"));
		
		for(int i=0; i < 100; i++) {
			BigInteger a = new BigInteger(Stage6.getRandomInteger(1,100));
			for(int k=0; k < 100; k++) {
				BigInteger b = new BigInteger(Stage6.getRandomInteger(1,100));
				if(!b.equals(new BigInteger("0"))) {
					String expected = a.remainder(b).toString();
					String actual = Stage6.remainder(a.toString(), b.toString());
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
