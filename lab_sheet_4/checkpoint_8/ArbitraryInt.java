import java.util.ArrayList;
import java.lang.Math;

class ArbitraryInt{
	public static void main(String[] args) {
		ArrayList<Integer> intsL = new ArrayList<Integer>();
		ArrayList<Integer> intsL2 = new ArrayList<Integer>();

		intsL2.add(1); intsL2.add(6); intsL2.add(3);
		intsL.add(4); intsL.add(5); intsL.add(6);
		// intsL.add(7);
//		intsL2.add(0);

		Ints ints = new Ints(intsL, false);
		Ints ints2 = new Ints(intsL2, false);

		System.out.println("----------------------------------------------");
		System.out.println("The first unbound int is: " + ints.getStr());
		System.out.println("The second unbound int is: " + ints2.getStr());
		System.out.println("----------------------------------------------");

		System.out.println("The fact that " + ints.getStr() + " and " + ints2.getStr() + " are equal is " + compare(ints, ints2) + "!");
		System.out.println("----------------------------------------------");

		Ints intsAdd = add(ints, ints2);
		System.out.println(ints.getStr() + " + " + ints2.getStr() + " = " + intsAdd.getStrRev());
		System.out.println("----------------------------------------------");

		Ints intsSubtract = subtract(ints, ints2);
		System.out.println(ints.getStr() + " - " + ints2.getStr() + " = " + intsSubtract.getStr());
		System.out.println("----------------------------------------------");

		Ints intsMultiply = multiply(ints, ints2);
		System.out.println(ints.getStr() + " × " + ints2.getStr() + " = " + intsMultiply.getStr());
		System.out.println("----------------------------------------------");

		Ints[] intsDivide = divide(ints, ints2);
		System.out.println(ints.getStr() + " / " + ints2.getStr() + " = quotient:" + intsDivide[0].getStr() + ", remainder:" + intsDivide[1].getStr());
		System.out.println("----------------------------------------------");

		// TODO
		// calculate negative values
	}

	// comparing method
	public static boolean compare(Ints a, Ints b) {
		if ( !a.getStr().equals(b.getStr()) ) {
			return false;
		}
		return true;
	}

	// checks if a > b
	public static boolean isBiggerThan(Ints a, Ints b) {
		if ( a.getLen() > b.getLen() ) {
			return true;
		}

		if (a.getLen() == b.getLen()) {
			for (int i = 0; i < a.getLen(); i++) {
				if (a.getVal(i) > b.getVal(i)) {
					return true;
				}
				if (a.getVal(i) < b.getVal(i)) {
					return false;
				}
			}
		}

		return false;
	}

	// reverses arraylist
	public static ArrayList<Integer> listRev(ArrayList<Integer> a) {
		ArrayList<Integer> r = new ArrayList<Integer>();

		for (int i = a.size() - 1; i >= 0; i--) {
			r.add(a.get(i));
		}

		return r;
	}

	// adding method
	public static Ints add(Ints a, Ints b) {
		ArrayList<Integer> total = new ArrayList<Integer>();

		boolean aN = a.getNeg();
		boolean bN = b.getNeg();

		if (!aN && bN || aN && !bN) {
			a.setNeg(false);
			b.setNeg(false);
			Ints sub = subtract(a, b);
			a.setNeg(aN);
			b.setNeg(bN);
			return sub;
		}

		int length = Math.max(a.getLen(), b.getLen());
		int co = 0;

		for (int i = 0; i < length; i++) {
			int addA = (a.hasNext(i) ? a.getVal( a.getLen() - i - 1 ) : 0);
			int addB = (b.hasNext(i) ? b.getVal( b.getLen() - i - 1 ) : 0);

			int sum = addA + addB + co;
//			System.out.println("a:" + addA + " b:" + addB + " c:" + co + " s:" + sum);

			if (sum > 9) {
				sum = sum % 10;
				co = 1;
			} else {
				co = 0;
			}

			total.add(sum);
		}

		if (co > 0) {
			total.add(co);
		}

		total = listRev(total);

		Ints totalInts = new Ints(total, false);
		return totalInts;
	}

	// mutiplying method
	public static Ints multiply(Ints a, Ints b) {
		ArrayList<Integer> sumL = new ArrayList<Integer>();
		ArrayList<Integer> nullL = new ArrayList<Integer>();
		nullL.add(0);
		Ints total = new Ints(nullL, false);

		int co = 0;
		int sum;

		boolean negative = false;
		boolean aN = a.getNeg();
		boolean bN = b.getNeg();

		if ( (aN && !bN) || (!aN && bN) ) {
			negative = true;
		}

		for (int i = (a.getLen() - 1); i >= 0; i--) {
			co = 0;
			sumL.clear();

			// adds power of 10
			for (int k = (a.getLen() - 1); k > i; k--) {
				sumL.add(0);
			}

			for (int j = (b.getLen() - 1); j >= 0; j--) {
				sum = a.getVal(i) * b.getVal(j) + co;

				if (sum > 9) {
					co = sum / 10;
					sum = sum % 10;
				} else {
					co = 0;
				}

				sumL.add(sum);
			}

			if (co > 0) {
				sumL.add(co);
			}

			ArrayList<Integer> sumR = listRev(sumL);

			Ints sumI = new Ints (sumR, false);
			total = add(total, sumI);
		}

		total = new Ints(total.getInts(), negative);

		return total;
	}

	// subtraction method
	public static Ints subtract(Ints a, Ints b) {
		ArrayList<Integer> total = new ArrayList<Integer>();

		Ints totalInts = new Ints(total, false);

		int sum = 0;
		int co = 0;

		int length = Math.max(a.getLen(), b.getLen());

		boolean isNeg = false;

		boolean aN = a.getNeg();
		boolean bN = b.getNeg();

		if (!aN && bN || aN && !bN) {
			a.setNeg(false);
			b.setNeg(false);
			totalInts = add(a, b);
			total = totalInts.getInts();
			a.setNeg(aN);
			b.setNeg(bN);
		} else {
			for (int i = 0; i < length; i++) {
				if (isBiggerThan(a, b)) {
					if ( a.hasNext(i) && b.hasNext(i) ) {
						sum = a.getVal(i) - b.getVal(i) - co;
					}
				} else if (!isBiggerThan(a, b)){
					if ( a.hasNext(i) && b.hasNext(i) ) {
						sum = b.getVal(i) - a.getVal(i) - co;
					}
					isNeg = true;
				} else if ( a.hasNext(i) && !b.hasNext(i)) {
					sum = a.getVal(i) - co;
				} else if ( !a.hasNext(i) && b.hasNext(i)) {
					sum = b.getVal(i) - co;
				} else {
					sum = co;
				}

				if (sum >= 0) {
					co = 0;
				} else {
					co = 1;
					sum += 10;
				}
				total.add(sum);
			}
		}

		boolean negative = false;

		if (a.getNeg() && b.getNeg()) {
			negative = true;
		} else if (a.getNeg() && !b.getNeg()) {
			negative = true;
		}

		totalInts = new Ints(total, negative);
		return totalInts;
	}

	// division method
	public static Ints[] divide(Ints dividend, Ints divisor) {
		Ints[] divded = new Ints[2];

		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<Integer> quotient = new ArrayList<Integer>();
		ArrayList<Integer> remainder = new ArrayList<Integer>();

		Ints quo = new Ints(empty, false);
		Ints rem = new Ints(empty, false);

		int calcInt = 0;
		int divisorInt = 0;

		boolean negative = false;

		if ( (dividend.getNeg() && !divisor.getNeg()) || (!dividend.getNeg() && divisor.getNeg()) ) {
			negative = true;
		}

		for (int i = 0; i < divisor.getLen(); i++) {
			divisorInt = divisorInt * 10 + divisor.getVal(i);
		}

		for (int j = 0; j < dividend.getLen(); j++) {
			calcInt = (calcInt * 10) + dividend.getVal(j);
		}

		int q = calcInt / divisorInt;
		int r = calcInt % divisorInt;

		while (q > 0) {
			int digitQ = q % 10;
			q = q / 10;
			quotient.add(digitQ);
		}

		while (r > 0) {
			int digitR = r % 10;
			r = r / 10;
			remainder.add(digitR);
		}
		remainder = listRev(remainder);

		if (quotient.size() == 0) {
			quotient.add(0);
		}

		quo = new Ints(quotient, negative);
		rem = new Ints(remainder, false);

		divded[0] = quo;
		divded[1] = rem;
		return divded;
	}
}

class Ints {
	private ArrayList<Integer> ints;
	private boolean neg;

	// sets int
	public Ints(ArrayList<Integer> ints, boolean neg) {
		this.ints = ints;
		this.neg = neg;
	}

	// get Ints obj
	public ArrayList<Integer> getInts() {
		return ints;
	}

	// gets Ints obj in reverse
	public Ints getRev() {
		Ints r = new Ints(getRevInts(), getNeg());
		return r;
	}

	public ArrayList<Integer> getRevInts() {
		ArrayList<Integer> intsR = new ArrayList<Integer>();

		for (int i = (this.ints.size() - 1); i >= 0; i--) {
			intsR.add(this.ints.get(i));
		}

		return intsR;
	}

	// gets Ints obj value at index
	public int getVal(int i) {
		return this.ints.get(i);
	}

	// adds val to Ints obj
	public void addVal(int val) {
		this.ints.add(val);
	}

	// checks to see if there is a value at index of i
	public boolean hasNext(int i) {
		return !(i >= getLen());
	}

	// get Ints obj as str
	public String getStr() {
		String s = (neg ? "-" : "");
		s += getStrInts();

		return s;
	}

	// gets Ints obj in reverse as str
	public String getStrRev() {
		Ints t = getRev();
		ArrayList<Integer> intsR = t.getInts();
		String s = (neg ? "-" : "");

		for (int i = 0; i < intsR.size(); i++) {
			s += intsR.get(i);
		}

		return s;
	}

	public String getStrInts() {
		String s = "";
		for (int i = 0; i < this.ints.size(); i++) {
			s += this.ints.get(i);
		}

		return s;
	}

	// get length of Ints obj
	public int getLen() {
		String s = getStrInts();
		return s.length();
	}

	// gets negative value
	public boolean getNeg() {
		return this.neg;
	}

	// sets negative value
	public void setNeg(boolean val) {
		this.neg = val;
	}

	// emptys Ints obj
	public void clear() {
		this.ints.clear();
	}
}