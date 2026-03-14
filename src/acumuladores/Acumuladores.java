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
		if (esVacio(mat1) || esVacio(mat2)) {
			return false;
		}
		if (tamanio(mat1) != tamanio(mat2)) {
			return false;
		}
		boolean hayInterseccionXFilas = true;
		for (int fila = 0; fila < tamanio(mat1); fila++) {
			hayInterseccionXFilas = hayInterseccionXFilas && hayInterseccion(mat1[fila], mat2[fila]);
		}
		return hayInterseccionXFilas;
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
		if (esVacio(mat)) {
			return false;
		}
		if (!esColumnaValida(mat, nColum)) {
			return false;
		}
		boolean filaSumaMasQueCol = false;
		int sumaCol = sumarElementosColumna(mat, nColum);
		for (int fila = 0; fila < tamanio(mat); fila++) {
			int sumaFila = sumarElementosFila(mat[fila]);
			filaSumaMasQueCol = filaSumaMasQueCol || (sumaFila > sumaCol);
		}
		return filaSumaMasQueCol;
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
		if (esVacio(mat1) || esVacio(mat2)) {
			return false;
		}
		if (tamanio(mat1[0]) != tamanio(mat2[0])) {
			return false;
		}
		boolean hayInterseccionXCol = true;
		for (int col = 0; col < tamanio(mat1[0]); col++) {
			hayInterseccionXCol = hayInterseccionXCol && hayInterseccion(mat1, mat2, col);
		}
		return hayInterseccionXCol;
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

  private boolean hayInterseccion(int[] fila1, int[] fila2) {
		boolean hayInterseccion = false;
		for(int i = 0; i < tamanio(fila1); i++) {
			hayInterseccion = hayInterseccion || estaElemento(fila2, fila1[i]);
		}
		return hayInterseccion;
	}

	private boolean estaElemento(int[] fila, int elem) {
		boolean esta = false;
		for (int i = 0; i < tamanio(fila); i++) {
			esta = esta || (elem == fila[i]);
		}
		return esta;
	}

  private boolean esColumnaValida(int[][] mat, int col) {
		return col >= 0 && col < tamanio(mat[0]);
	}
	
	private int sumarElementosColumna(int[][] mat, int col) {
		int suma = 0;
		for (int fila = 0; fila < tamanio(mat); fila++) {
			suma += mat[fila][col];
		}
		return suma;
	}
	
	private int sumarElementosFila(int[] fila) {
		int suma = 0;
		for (int i = 0; i < tamanio(fila); i++) {
			suma += fila[i];
		}
		return suma;
	}

  private boolean hayInterseccion(int[][] mat1, int[][] mat2, int col) {
		boolean hayInterseccion = false;
		for (int fila = 0; fila < tamanio(mat2); fila++) {
			hayInterseccion = hayInterseccion || estaElemento(mat1, col, mat2[fila][col]);
		}
		return hayInterseccion;
	}

	private boolean estaElemento(int[][] mat, int col, int elem) {
		boolean esta = false;
		for (int fila = 0; fila < tamanio(mat); fila++) {
			esta = esta || (mat[fila][col] == elem);
		}
		return esta;
	}
}
