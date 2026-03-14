package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		if (esVacio(mat)) {
			return false;
		}
		if (!esPositivo(num)) {
			return false;
		}
		boolean esFilaMultiploN = false;
		for (int fila = 0; fila < tamanio(mat); fila++) {
			esFilaMultiploN = esFilaMultiploN || sonTodosMultiplos(mat[fila], num);
		}
		return esFilaMultiploN;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		throw new RuntimeException("Metodo no implementado aun!!!");
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		throw new RuntimeException("Metodo no implementado aun!!!");
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		throw new RuntimeException("Metodo no implementado aun!!!");
	}

  private boolean esVacio(int[][] mat) {
		return mat == null || mat.length == 0 || mat[0].length == 0;
	}

	private boolean esPositivo(int numero) {
		return numero > 0;
	}

	private int tamanio(int[][] mat) {
		if (esVacio(mat)) {
			return 0;
		}
		return mat.length;
	}

	private boolean sonTodosMultiplos(int[] fila, int num) {
		boolean esMultiplo = true;
		for (int i = 0; i < tamanio(fila); i++) {
			esMultiplo = esMultiplo && esMultiplo(fila[i], num);
		}
		return esMultiplo;
	}

	private boolean esMultiplo(int num1, int num2) {
		return num1 % num2 == 0;
	}

	private int tamanio(int[] arr) {
		if (esVacio(arr)) {
			return 0;
		}
		return arr.length;
	}

	private boolean esVacio(int[] arr) {
		return arr == null || arr.length == 0;
	}
}
