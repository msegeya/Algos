/**
	Question: Minimize Cash Flow among a given set of friends who have borrowed money from each other.

	Reference:  http://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/
				http://stackoverflow.com/questions/877728/what-algorithm-to-use-to-determine-minimum-number-of-actions-required-to-get-the

	Logic: 
		- Denote each person from P0 to Pn-1
		- Compute net amount of each person. The net amount for person 'i' can be calculated as,
			(TOTAL_CREDITS - TOTAL_DEBITS) of that person.
		- Now find two persons that are having maxCredit and the one having max. debit 
				Denote them as maximum creditor and maximum debitor. Denote them shortly as Pc and Pd.
		- If amount[max_credit_index] = 0 and amount[max-debt_index] = 0 then return.
		- Else,
			- Find minimum of Pc and Pd and call it as "x". Debit this "x" amount from Pd and credit this to Pc.
			- If "x" is equal to max_credit then remove Pc and do the above steps for remaining (n-1) persons.
			- If "x" is equal to max_debtit then remove Pd and do the above steps for remaining (n-1) persons.
*/

class MinCashFlow {

	// Amount present at each person => (credits - debts)
	public int[] amount;
	// total persons
	public int P;

	public int[][] graph;

	public static void main(String[] args) {
		MinCashFlow mcfObj = new MinCashFlow();
		mcfObj.initialize();

		mcfObj.solveMinCashFlow();
	}

	public void initialize() {
		P = 3;
		amount = new int[P];
		graph = new int[P][P];

		graph[0][0] = 0; graph[0][1] = 1000; graph[0][2] = 2000;
		graph[1][0] = 0;  graph[1][1] = 0; graph[1][2] = 5000; 
		graph[2][0] = 0;  graph[2][1] = 0; graph[2][2] = 0; 
	}

	public void solveMinCashFlow() {
		// step-1: Compute total amount of each person.
		calAmount();

		// step-2: Get the max. creditor and max. debtor.
		findSolution(amount);
		
		/*System.out.println("Printing amount for each person: ");
		for(int i = 0; i < amount.length; i++) {
			System.out.println("Person - " + i + " = " + amount[i]);
		}*/
	}

	// calculate amount
	public void calAmount() {
		for(int i = 0; i < P; i++) {
			for(int j = 0; j < P; j++) {
				amount[i] += (graph[j][i] - graph[i][j]);
			}
			System.out.println("Amount (Credit - Debt) of P" + i + " is: " + amount[i]);
		}
	}

	public void findSolution(int[] amount) {
		
		// get max creditor index and max debtor index.
		int max_creditor_id = getMaxCreditor(amount);
		int max_debtor_id = getMaxDebtor(amount);

		if(amount[max_creditor_id] == 0 && amount[max_debtor_id] == 0) {
			return;
		}

		// get the minimum of them.
		int min = getMinOfTwo(amount[max_creditor_id], -amount[max_debtor_id]);
		System.out.println("Minimum of max credit and max debt is: " + min);

		amount[max_creditor_id] = amount[max_creditor_id] - min;
		amount[max_debtor_id] = amount[max_debtor_id] + min;

		System.out.println("P-" + max_debtor_id + " pays amount " + min + " to P-" + max_creditor_id);

		findSolution(amount);
	}

	public int getMaxCreditor(int[] amount) {
		int maxC_Id = 0;
		int maxC_amt = 0;
		for(int i = 0; i < amount.length; i++) {
			if(maxC_amt < amount[i]) {
				maxC_Id = i;
				maxC_amt = amount[i];
			}
		}

		return maxC_Id;
	}

	public int getMaxDebtor(int[] amount) {
		int maxD_Id = 0;
		int maxD_amt = 0;
		for(int i = 0; i < amount.length; i++) {
			if(maxD_amt > amount[i]) {
				maxD_Id = i;
				maxD_amt = amount[i];
			}
		}

		return maxD_Id;
	}

	public int getMinOfTwo(int a, int b) {
		if(a < b) {
			return a;
		}

		return b;
	}
}
