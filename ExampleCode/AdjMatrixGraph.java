/*
 * An example of an Adjacency Matrix Graph.
 * Written By: Josue
 */
import java.util.LinkedList;
import java.util.Queue;
public class AdjMatrixGraph
{
	// attributes

	public static final int DEF_VERT_COUNT = 10;

	private double[][] adjMatrix;
	private LinkedList<Integer> markedList;
	private Queue<Integer> vQ;

	// constructors

	public AdjMatrixGraph()
	{
		init(DEF_VERT_COUNT);
	}

	public AdjMatrixGraph(int size)
	{
		init(size);
	}

	/**
	 * Initializes the multi-dimensional array by using the given size, and
	 * filling the array with values of 0. If the given size is less than or
	 * equal to 0, then a default size is used. Also initializes the Linked List
	 * and the Queue.
	 * 
	 * @param size
	 *            the size of the multi-dimensional array
	 */
	private void init(int size)
	{
		if (size <= 0)
		{
			init(DEF_VERT_COUNT);
			return;
		}
		adjMatrix = new double[size][size];

		// fill array
		for (int i = 0; i < adjMatrix.length; i++)
			for (int j = 0; j < adjMatrix[i].length; j++)
				adjMatrix[i][j] = 0;

		markedList = new LinkedList<Integer>();
		vQ = new LinkedList<Integer>();
	}

	/**
	 * Changes a value in given indices to a given value in the
	 * multi-dimensional array.
	 * 
	 * @param fromVertex
	 *            the row index
	 * @param toVertex
	 *            the column index
	 * @param weight
	 *            the new value
	 */
	public void addEdge(int fromVertex, int toVertex,
			double weight)
	{
		// check if indices are correct
		if (!isValid(fromVertex) || !isValid(toVertex))
			return;

		adjMatrix[fromVertex][toVertex] = weight;
	}

	/**
	 * Checks if the given value, which represents an index in the
	 * multi-dimensional array is within the array's bounds.
	 * 
	 * @param index
	 *            the index to check
	 * @return true if the given value is within the array's bounds, false
	 *         otherwise
	 */
	private boolean isValid(int index)
	{
		return index >= 0 && index < adjMatrix.length;
	}

	/**
	 * Iterates the multi-dimensional array and prints all elements.
	 */
	public void printAdjMatrix()
	{
		for (int i = 0; i < adjMatrix.length; i++)
		{
			for (int j = 0; j < adjMatrix[i].length; j++)
				System.out.print(adjMatrix[i][j] + " ");
			System.out.println();
		}
	}

	/**
	 * Prints the vertices of the graph using Depth-First Search (DFS) starting
	 * from vertex 0. This method clears the marked list and initiates the DFS
	 * traversal.
	 */
	public void printDFS()
	{
		// clear the list
		markedList.clear();
		// initiate traversal starting from vertex 0
		printDFS(0);
	}

	/**
	 * Recursive helper method for Depth-First Search (DFS) traversal. Prints
	 * the vertex at the specified index and recursively explores its adjacent
	 * vertices.
	 *
	 * @param index
	 *            the index of the vertex to explore
	 */
	private void printDFS(int index)
	{
		// print the current vertex
		System.out.println(index);
		// mark the current vertex as visited
		markedList.add(index);

		// explore adjacent vertices
		for (int i = 0; i < adjMatrix.length; i++)
			if (adjMatrix[index][i] != 0.0
					&& !markedList.contains(i))
				// recursively explore the unvisited adjacent vertex
				printDFS(i);
	}

	/**
	 * Prints the vertices of the graph using Breadth-First Search (BFS)
	 * starting from vertex 0. This method clears the marked list and the queue
	 * of vertices, and initiates the BFS traversal.
	 */
	public void printBFS()
	{
		// clear the lists
		markedList.clear();
		vQ.clear();

		// mark and print the starting vertex (vertex 0)
		markedList.add(0);
		vQ.add(0);
		System.out.println(0);

		while (!vQ.isEmpty())
		{
			// retrieve and remove the front vertex from the queue
			int currI = vQ.remove();
			// mark the current vertex as visited
			markedList.add(currI);

			// explore adjacent vertices
			for (int i = 0; i < adjMatrix.length; i++)
				if (!markedList.contains(i)
						&& !vQ.contains(i)
						&& adjMatrix[currI][i] != 0.0)
				{
					// print and enqueue unvisited adjacent vertices
					System.out.println(i);
					vQ.add(i);
				}
		}
	}
}
