package hanoi;
/*
 * Note: This hanoi solving includes simple Java recursion
 */
import java.util.ArrayList;
import java.util.List;

public class Hanoi {
	int n;
	private List<Character> a;
	private List<Character> b;
	private List<Character> c;
	public Hanoi(int n) {
		this.n = n;
		a = new ArrayList<>();
		b = new ArrayList<>();
		c = new ArrayList<>();
		for (char c = (char)('1' + n - 1); c >= '1'; c--) {
			a.add(c);
		}
	}
	
	public void solve(int m, List<Character> source, List<Character> target, List<Character> spare) {
		if (m == 0) {
			return;
		}
		solve(m - 1, source, spare, target);
		target.add(source.remove(0));
		System.out.println("--------");
		System.out.println(this);
		solve(m - 1, spare, target, source);
	}
	
	public void solve() {
		solve(n, a, c, b);
	}
	
	public String toString() {
		return a.toString() + '\n' + b.toString() + '\n' +c.toString(); 
	}
	
	public static void main(String[] args) {
		int n = 4;
		Hanoi h = new Hanoi(n);
		h.solve();
		h.toString();
	}
}
