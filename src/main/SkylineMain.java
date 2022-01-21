package main;

import java.util.ArrayList;

import main.common.CommonApiFile;
import main.common.CommonApiMenu;
import main.domain.Building;
import main.domain.Skyline;

public class SkylineMain {

	private static final String SHOW_TRACE = "-t";
	private static final String SHOW_HELP = "-h";

	@SuppressWarnings("unused")
	private static boolean showTrace = false;

	public static void main(String[] args) {
		System.out.println("Launch Skyline\r\n");
		boolean isInput = true;

		String inputFile = null;
		String outputFile = "pruebas/output.txt";

		if (args.length > 4) {
			System.out.println("Too much args, see [skyline -h] for help\r\n");
			return;
		} else if (args.length < 1) {
			System.out.println("Not enough arguments, see [skyline -h] for help\r\n");
			return;
		}

		for (String a : args) {
			switch (a) {
			case SHOW_TRACE:
				showTrace = true;
				continue;
			case SHOW_HELP:
				System.out.println(CommonApiMenu.showHelp());
				continue;
			}

			if (isInput) {
				inputFile = a;
				isInput = false;
			} else {
				outputFile = a;
			}
		}

		Building[] edificios = CommonApiFile.readFile(inputFile);
		DyV dyv = new DyV();
		ArrayList<Skyline> skylines = dyv.obtenerSkyLines(edificios, 0, (edificios.length - 1));

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
		System.out.println(CommonApiMenu.showFileNames(inputFile, outputFile));
		System.out.println("Close Skyline\r\n");
	}

}
