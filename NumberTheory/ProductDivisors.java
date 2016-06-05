class ProductDivisors {
	private static long mod = 1000000007L;
	
    public static void main(String args[] ) throws Exception {
        int N = 2;
        long[] array = {2, 3};
		
		// each long calculate the multiplicty
		double result = 1;
		for(int i = 0; i < array.length; i++) {
			double a = result % mod;
			double b = array[i] % mod;
			result = ( a * b ) % mod;
		}
		
		int count = 0;
		for(long j = 1; j * j <= result; j++) {
			if(result % j == 0) {
				if(j * j == result) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		
		System.out.println(count);
    }
}