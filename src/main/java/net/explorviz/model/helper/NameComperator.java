package net.explorviz.model.helper;

import java.util.Comparator;

import net.explorviz.model.landscape.NodeGroup;

/**
 * Helper class for {@link NodeGroup}
 * 
 * @author Christian Zirkelbach (czi@informatik.uni-kiel.de)
 *
 */
public class NameComperator implements Comparator<String> {
	@Override
	public int compare(final String o1, final String o2) {
		if (endsInNumber(o1) && endsInNumber(o2)) {
			final double o1Number = getLastNumber(o1);
			final double o2Number = getLastNumber(o2);

			return (int) (o1Number - o2Number);
		} else {
			return o1.compareToIgnoreCase(o2);
		}
	}

	public double getLastNumber(final String arg) {
		int i = arg.length() - 1;
		double result = 0d;
		int index = 0;

		while (i >= 0 && isNumber(arg.charAt(i))) {
			final int currentNumber = Integer.parseInt(arg.substring(i, i + 1));
			result = currentNumber * Math.pow(10, index) + result;
			i = i - 1;
			index = index + 1;
		}

		return result;
	}

	public boolean endsInNumber(final String arg) {
		if (arg != null) {
			return isNumber(arg.charAt(arg.length() - 1));
		} else {
			return false;
		}
	}

	public boolean isNumber(final char c) {
		return Character.isDigit(c);
	}
}
