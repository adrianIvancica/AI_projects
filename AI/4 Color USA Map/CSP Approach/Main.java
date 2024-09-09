
public class Main {
	
	static void initCompleteUSMap(Map map) {
		map.states.add("Maine"); // 0
		map.borders.add(new Border(0,1));
		map.states.add("New Hampshire"); // 1
		map.borders.add(new Border(1,2));
		map.borders.add(new Border(1,3));
		map.states.add("Vermont"); // 2
		map.borders.add(new Border(2,3));
		map.borders.add(new Border(2,6));
		map.states.add("Massachusetts"); // 3
		map.borders.add(new Border(3,5));
		map.borders.add(new Border(3,4));
		map.borders.add(new Border(3,6));
		map.states.add("Connecticut"); // 4
		map.borders.add(new Border(4,5));
		map.borders.add(new Border(4,6));
		map.states.add("Rhode Island"); // 5
		map.states.add("New York"); // 6
		map.borders.add(new Border(6,7));
		map.borders.add(new Border(6,8));
		map.states.add("Pennsylvania"); // 7
		map.borders.add(new Border(7,8));
		map.borders.add(new Border(7,9));
		map.borders.add(new Border(7,10));
		map.borders.add(new Border(7,13));
		map.borders.add(new Border(7,14));
		map.states.add("New Jersey"); // 8
		map.borders.add(new Border(8,10));
		map.states.add("Maryland"); // 9
		map.borders.add(new Border(9,10));
		map.borders.add(new Border(9,11));
		map.borders.add(new Border(9,12));
		map.borders.add(new Border(9,13));
		map.states.add("Delaware"); // 10
		map.states.add("Washington DC"); // 11
		map.borders.add(new Border(11,12));
		map.states.add("Virginia"); // 12
		map.borders.add(new Border(12,13));
		map.borders.add(new Border(12,17));
		map.borders.add(new Border(12,18));
		map.borders.add(new Border(12,19));
		map.states.add("West Virginia"); // 13
		map.borders.add(new Border(13,14));
		map.borders.add(new Border(13,17));
		map.states.add("Ohio"); // 14
		map.borders.add(new Border(14,15));
		map.borders.add(new Border(14,16));
		map.borders.add(new Border(14,17));
		map.states.add("Michigan"); // 15
		map.borders.add(new Border(15,16));
		map.borders.add(new Border(15,29));
		map.states.add("Indiana"); // 16
		map.borders.add(new Border(16,17));
		map.borders.add(new Border(16,28));
		map.states.add("Kentucky"); // 17
		map.borders.add(new Border(17,18));
		map.borders.add(new Border(17,27));
		map.borders.add(new Border(17,28));
		map.states.add("Tennessee"); // 18
		map.borders.add(new Border(18,19));
		map.borders.add(new Border(18,21));
		map.borders.add(new Border(18,23));
		map.borders.add(new Border(18,24));
		map.borders.add(new Border(18,26));
		map.borders.add(new Border(18,27));
		map.states.add("North Carolina"); // 19
		map.borders.add(new Border(19,20));
		map.borders.add(new Border(19,21));
		map.states.add("South Carolina"); // 20
		map.borders.add(new Border(20,21));
		map.states.add("Georgia"); // 21
		map.borders.add(new Border(21,22));
		map.borders.add(new Border(21,23));
		map.states.add("Florida"); // 22
		map.borders.add(new Border(22,23));
		map.states.add("Alabama"); // 23
		map.borders.add(new Border(23,24));
		map.states.add("Mississippi"); // 24
		map.borders.add(new Border(24,25));
		map.borders.add(new Border(24,26));
		map.states.add("Louisiana"); // 25
		map.borders.add(new Border(25,26));
		map.borders.add(new Border(25,37));
		map.states.add("Arkansas"); // 26
		map.borders.add(new Border(26,27));
		map.borders.add(new Border(26,36));
		map.borders.add(new Border(26,37));
		map.states.add("Missouri"); // 27
		map.borders.add(new Border(27,28));
		map.borders.add(new Border(27,30));
		map.borders.add(new Border(27,34));
		map.borders.add(new Border(27,35));
		map.borders.add(new Border(27,36));
		map.states.add("Illinois"); // 28
		map.borders.add(new Border(28,29));
		map.borders.add(new Border(28,30));
		map.states.add("Wisconsin"); // 29
		map.borders.add(new Border(29,30));
		map.borders.add(new Border(29,31));
		map.states.add("Iowa"); // 30
		map.borders.add(new Border(30,31));
		map.borders.add(new Border(30,33));
		map.borders.add(new Border(30,34));
		map.states.add("Minnesota"); // 31
		map.borders.add(new Border(31,32));
		map.borders.add(new Border(31,33));
		map.states.add("North Dakota"); // 32
		map.borders.add(new Border(32,33));
		map.borders.add(new Border(32,41));
		map.states.add("South Dakota"); // 33
		map.borders.add(new Border(33,34));
		map.borders.add(new Border(33,40));
		map.borders.add(new Border(33,41));
		map.states.add("Nebraska"); // 34
		map.borders.add(new Border(34,35));
		map.borders.add(new Border(34,39));
		map.borders.add(new Border(34,40));
		map.states.add("Kansas"); // 35
		map.borders.add(new Border(35,36));
		map.borders.add(new Border(35,39));
		map.states.add("Oklahoma"); // 36
		map.borders.add(new Border(36,37));
		map.borders.add(new Border(36,38));
		map.borders.add(new Border(36,39));
		map.states.add("Texas"); // 37
		map.borders.add(new Border(37,38));
		map.states.add("New Mexico"); // 38
		map.borders.add(new Border(38,39));
		map.borders.add(new Border(38,43));
		map.borders.add(new Border(38,44));
		map.states.add("Colorado"); // 39
		map.borders.add(new Border(39,40));
		map.borders.add(new Border(39,43));
		map.borders.add(new Border(39,44));
		map.states.add("Wyoming"); // 40
		map.borders.add(new Border(40,41));
		map.borders.add(new Border(40,42));
		map.borders.add(new Border(40,43));
		map.states.add("Montana"); // 41
		map.borders.add(new Border(41,42));
		map.states.add("Idaho"); // 42
		map.borders.add(new Border(42,43));
		map.borders.add(new Border(42,45));
		map.borders.add(new Border(42,46));
		map.borders.add(new Border(42,47));
		map.states.add("Utah"); // 43
		map.borders.add(new Border(43,44));
		map.borders.add(new Border(43,45));
		map.states.add("Arizona"); // 44
		map.borders.add(new Border(44,45));
		map.borders.add(new Border(44,48));
		map.states.add("Nevada"); // 45
		map.borders.add(new Border(45,46));
		map.borders.add(new Border(45,48));
		map.states.add("Oregon"); // 46
		map.borders.add(new Border(46,47));
		map.borders.add(new Border(46,48));
		map.states.add("Washington"); // 47
		map.borders.add(new Border(47,49));
		map.states.add("California"); // 48
		map.borders.add(new Border(48,50));
		map.states.add("Alaska"); // 49
  		map.states.add("Hawaii"); // 50
	}
	
	/**
	 * Initializes the map of the states in the South West of the USA
	 * @param map The map to be initialized
	 */
	static void initMap(Map map) {
		map.states.add("North Carolina");
		map.states.add("South Carolina");
		map.states.add("Virginia");
		map.states.add("Tennessee");
		map.states.add("Kentucky");
		map.states.add("West Virginia");
		map.states.add("Georgia");
		map.states.add("Alabama");
		map.states.add("Mississippi");
		map.states.add("Florida");

		map.borders.add(new Border(0, 1));
		map.borders.add(new Border(0, 2));
		map.borders.add(new Border(0, 3));
		map.borders.add(new Border(0, 6));
		map.borders.add(new Border(1, 6));
		map.borders.add(new Border(2, 3));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 5));
		map.borders.add(new Border(3, 4));
		map.borders.add(new Border(3, 6));
		map.borders.add(new Border(3, 7));
		map.borders.add(new Border(3, 8));
		map.borders.add(new Border(4, 5));
		map.borders.add(new Border(6, 7));
		map.borders.add(new Border(6, 9));
		map.borders.add(new Border(7, 8));
		map.borders.add(new Border(7, 9));
	}
	
	/**
	 * Initialized some sudoku.
	 * @param sudoku The sudoku to be initialized.
	 */
	static void initSudoku(Sudoku sudoku) {
		sudoku.givenValues.put("A3", 6);
		sudoku.givenValues.put("A4", 9);
		sudoku.givenValues.put("A5", 8);
		sudoku.givenValues.put("B1", 9);
		sudoku.givenValues.put("B7", 2);
		sudoku.givenValues.put("B8", 5);
		sudoku.givenValues.put("B9", 1);
		sudoku.givenValues.put("C3", 4);
		sudoku.givenValues.put("C6", 1);
		sudoku.givenValues.put("D5", 2);
		sudoku.givenValues.put("D6", 4);
		sudoku.givenValues.put("E1", 7);
		sudoku.givenValues.put("E2", 2);
		sudoku.givenValues.put("E5", 5);
		sudoku.givenValues.put("E8", 6);
		sudoku.givenValues.put("E9", 3);
		sudoku.givenValues.put("F4", 1);
		sudoku.givenValues.put("F5", 7);
		sudoku.givenValues.put("G4", 3);
		sudoku.givenValues.put("G7", 5);
		sudoku.givenValues.put("H1", 8);
		sudoku.givenValues.put("H2", 6);
		sudoku.givenValues.put("H3", 7);
		sudoku.givenValues.put("H9", 9);
		sudoku.givenValues.put("I5", 9);
		sudoku.givenValues.put("I6", 7);
		sudoku.givenValues.put("I7", 1);
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Map map = new Map();
		//initCompleteUSMap(map);
		initMap(map);

		Sudoku sudoku = new Sudoku();
		initSudoku(sudoku);
		
		CSP<Integer> csp = map.createCSP();
		//CSP<Integer> csp = sudoku.createCSP();
		
		
		// set Tennessee to a specific value
		//csp.domains.get("Tennessee").clear();
		//csp.domains.get("Tennessee").add(1);
		
		
		//AC3.ac3(csp);
		
		CSPSolver solver = new BacktrackingCSPSolver();
		//CSPSolver solver = new ForwardCheckingCSPSolver();
		//CSPSolver solver = new MinConflicts();

		long startTime = System.currentTimeMillis();
		CSPResult<Integer> result = solver.solve(csp);
		long runtime = System.currentTimeMillis() - startTime;

		if(result == null) {
			System.out.println("Found no solution!");
		} else {
			System.out.println(result.toString());
			System.out.println("runtime: " + runtime + "ms");
		}
		

		/* 
		 * evaluate the different algorithms
		 */
		/* 
		long totalTime = 0;
		int totalNoSolutions = 0;
		long percentSolution;
		long numIterations = 1000000;
		for (int i = 0; i < numIterations; i++){
			Map map = new Map();
			//initCompleteUSMap(map);
			initMap(map);

			//Sudoku sudoku = new Sudoku();
			//initSudoku(sudoku);
			
			CSP<Integer> csp = map.createCSP();
			//CSP<Integer> csp = sudoku.createCSP();
			
			
			// set Tennessee to a specific value
			csp.domains.get("Tennessee").clear();
			csp.domains.get("Tennessee").add(1);
			
			
			//AC3.ac3(csp);
			
			CSPSolver solver = new BacktrackingCSPSolver();
			//CSPSolver solver = new ForwardCheckingCSPSolver();
			//CSPSolver solver = new MinConflicts();

			long startTime = System.nanoTime();
			CSPResult<Integer> result = solver.solve(csp);
			long runtime = System.nanoTime() - startTime;
			totalTime += runtime;
			if(result == null) {
				//System.out.println("Found no solution!");
				totalNoSolutions++;
			} else {
				//System.out.println(result.toString());
				//System.out.println("runtime: " + runtime + "ms");
			}
		}
		long averageTime = totalTime / numIterations;
		percentSolution = ((numIterations - totalNoSolutions) / numIterations) * 100;
		System.out.println("Average Time: " + averageTime + "ns, Solutions Found: " + percentSolution + "%");
		*/
	}
}
