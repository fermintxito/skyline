package main;

import java.util.ArrayList;

import main.common.CommonApiDate;
import main.common.CommonApiFile;
import main.domain.Building;
import main.domain.Skyline;

public class DyV {

	public static void run(String inputFile, String outputFile, boolean showTrace) {
		Building[] buildings = CommonApiFile.readFile(inputFile);
		ArrayList<Skyline> skylines = obtenerSkyLines(buildings, 0, (buildings.length - 1), showTrace);

		boolean isFirst = true;
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Skyline s : skylines) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(",");
			}

			sb.append("(");
			sb.append(s.abscisa + "," + s.height);
			sb.append(")");

		}
		sb.append("}");

		CommonApiFile.createAndWriteFile(outputFile, sb.toString());
	}

	private static ArrayList<Skyline> obtenerSkyLines(Building[] edificios, int i, int j, boolean showTrace) {
		if (showTrace)
			trace("obtenerSkyLines i : " + i + ", j: " + j);

		int n = j - i + 1;
		if (n == 1) {
			ArrayList<Skyline> s = new ArrayList<Skyline>();
			s.add(new Skyline(edificios[i].getLeft(), edificios[i].getHeight()));
			s.add(new Skyline(edificios[i].getRight(), 0));

			return s;
		} else {
			int m = (i + j - 1) / 2;
			ArrayList<Skyline> sa = obtenerSkyLines(edificios, i, m, showTrace);
			ArrayList<Skyline> sb = obtenerSkyLines(edificios, m + 1, j, showTrace);
			return combinarSkyLines(sa, sb, showTrace);
		}

	}

	private static ArrayList<Skyline> combinarSkyLines(ArrayList<Skyline> sa, ArrayList<Skyline> sb,
			boolean showTrace) {
		if (showTrace)
			trace("combinarSkyLines sa : " + skylinesToString(sa) + ", sb: " + skylinesToString(sb));

		ArrayList<Skyline> s = new ArrayList<Skyline>();

		Skyline a, b;
		int ha = 0, hb = 0, uh = 0;
		int ia = 0, ib = 0, nx = 0, nh = 0;

		while ((ia < sa.size()) && (ib < sb.size())) {
			a = sa.get(ia);
			b = sb.get(ib);

			if (a.getAbscisa() == b.getAbscisa()) {
				nx = a.getAbscisa();
				nh = Math.max(a.getHeight(), b.getHeight());
				ha = a.getHeight();
				hb = b.getHeight();
				ia = ia + 1;
				ib = ib + 1;
			} else if ((a.getAbscisa() < b.getAbscisa())) {
				nx = a.getAbscisa();
				nh = Math.max(a.getHeight(), hb);
				ha = a.getHeight();
				ia = ia + 1;
			} else {
				nx = b.getAbscisa();
				nh = Math.max(b.getHeight(), ha);
				hb = b.getHeight();
				ib = ib + 1;
			}
			if (uh != nh) {
				s.add(new Skyline(nx, nh));
				uh = nh;
			}
		}
		while (ia < sa.size()) {
			s.add(sa.get(ia++));
		}
		while (ib < sb.size()) {
			s.add(sb.get(ib++));
		}

		return s;
	}

	private static void trace(String trace) {
		String date = CommonApiDate.dateNowToString();
		System.out.println(date + " || " + trace + "\r\n");
	}

	private static String skylinesToString(ArrayList<Skyline> skylines) {
		StringBuilder sb = new StringBuilder();

		skylines.forEach(s -> sb.append(s.toString()));

		return sb.toString();
	}
}