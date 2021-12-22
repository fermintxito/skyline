package main;

public class SkylineMain {

	private static final String SHOW_TRACE = "-t";
	private static final String SHOW_HELP = "-h";

	@SuppressWarnings("unused")
	private static boolean showTrace = false;

	public static void main(String[] args) {
		System.out.println("Launch Skyline\r\n");
		boolean isInput = true;

		String inputFile = null;
		String outputFile = "output.txt";

		if (args.length > 4) {
			System.out.println("Too much args, see [skyline -h] for help\r\n");
			return;
		}

		for (String a : args) {
			switch (a) {
			case SHOW_TRACE:
				showTrace = true;
				continue;
			case SHOW_HELP:
				System.out.println(showHelp());
				continue;
			}

			if (isInput) {
				inputFile = a;
				isInput = false;
			} else {
				outputFile = a;
			}
		}

		System.out.println(showFileNames(inputFile, outputFile));
		System.out.println("Close Skyline\r\n");
	}

	private static String showHelp() {
		StringBuilder sb = new StringBuilder();

		sb.append("SINTAXIS: skyline [-t][-h] [fichero entrada] [fichero salida]\r\n");
		sb.append("-t Traza cada llamada recursiva y sus parámetros\r\n");
		sb.append("-h Muestra esta ayuda\r\n");
		sb.append("[fichero entrada] Conjunto de edificios de la ciudad\r\n");
		sb.append("[fichero salida] Secuencia que representan el skyline de la ciudad\r\n");

		return sb.toString();
	}

	private static String showFileNames(String inputFile, String outputFile) {
		StringBuilder sb = new StringBuilder();

		sb.append("fichero entrada: " + inputFile + "\r\n");
		sb.append("fichero salida: " + outputFile + "\r\n");

		return sb.toString();
	}

}
