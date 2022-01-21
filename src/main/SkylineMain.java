package main;

import main.common.CommonApiDate;
import main.common.CommonApiMenu;

public class SkylineMain {

	private static final String DEFAULT_OUTPUT = "pruebas/output/defaultOutput.txt";

	private static final String SHOW_TRACE = "-t";
	private static final String SHOW_HELP = "-h";

	private static boolean showTrace = false;

	public static void main(String[] args) {
		System.out.println(CommonApiDate.dateNowToString() + " || Launch Skyline\r\n");
		boolean isInput = true;

		String inputFile = null;
		String outputFile = DEFAULT_OUTPUT;

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

		DyV.run(inputFile, outputFile, showTrace);
		System.out.println(CommonApiDate.dateNowToString() + " || Close Skyline\r\n");
	}

}
