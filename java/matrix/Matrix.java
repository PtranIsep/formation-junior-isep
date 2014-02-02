package matrix;

public class Matrix<E extends Number> {

	private Number[][] elementData;

	public Matrix(int numberColumn, int numberLine) {
		if (numberColumn < 0)
			throw new IllegalArgumentException("Illegal Column Capacity: "
					+ numberColumn);
		else if (numberLine < 0)
			throw new IllegalArgumentException("Illegal Line Capacity: "
					+ numberLine);
		this.elementData = new Number[numberColumn][numberLine];
	}

	public Matrix(int numberColumnLine) {
		this(numberColumnLine, numberColumnLine);
	}

	public int getNumberOfColumn() {
		return this.elementData.length;
	}

	public int getNumberOfLine() {
		return this.elementData[0].length;
	}

	public E[] getColumn(int index) {
		return this.elementDataColumn(index);
	}

	@SuppressWarnings("unchecked")
	private E[] elementDataColumn(int index) {
		return (E[]) elementData[index];
	}

	public E[] getLine(int indexLine) {
		return this.elementDataLine(indexLine);
	}

	@SuppressWarnings("unchecked")
	private E[] elementDataLine(int indexLine) {
		return (E[]) this.createLine(indexLine);
	}

	private Number[] createLine(int indexLine) {
		Number[] line = new Number[elementData.length];
		for (int indexColumn = 0; indexColumn < elementData.length; indexColumn++)
			line[indexColumn] = elementData[indexColumn][indexLine];
		return line;
	}

	public E get(int indexColumn, int indexLine) {
		return elementData(indexColumn, indexLine);
	}

	@SuppressWarnings("unchecked")
	private E elementData(int indexColumn, int indexLine) {
		return (E) elementData[indexColumn][indexLine];
	}
}