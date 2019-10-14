class Main {
	public static void main(String[] args) {

		String message = "101101010";
		int[][] matrix = { { 238, 12, 230 }, { 190, 23, 45 }, { 120, 128, 80 } };
		lsbs(matrix, message);

	}

	public static void lsbs(int[][] matrix, String message) {
		int position = 0;

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {

				// elemento binario
				String bin = Integer.toBinaryString(matrix[i][j]);
				String newBin = "";
				// reescrevendo binario
				for (int k = 1; k < 9 - bin.length(); k++) {
					newBin = newBin + "0";
				}
				newBin = newBin + bin;
				// substituindo oitavo digito da mensagem se existir
				if (position < message.length()) {
					newBin = newBin.substring(0, 7) + message.substring(position, position + 1);
				}
				// avanca posicao na mensagem
				position++;
				// novo digito como inteiro
				int substitution = Integer.parseInt(newBin, 2);
				// executa aritmetica modular se novo digito for maior que 255
				if (substitution > 255) {
					substitution = substitution % 256;
				}
				// substitui
				matrix[i][j] = substitution;

				// exibir elementos
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}