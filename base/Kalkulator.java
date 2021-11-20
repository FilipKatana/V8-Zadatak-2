package base;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Kalkulator {
	
	private ArrayList<Akcija> istorija = new ArrayList<Akcija>();
	
	private class Akcija {
		private String ime;
		private double operand1;
		private double operand2;
		private double rezultat;
		
		public Akcija(String ime, double o1, double o2, double r) {
			this.ime = ime;
			this.operand1 = o1;
			this.operand2 = o2;
			this.rezultat = r;
		}
		
		@Override
		public String toString() {
			return this.ime + " [" + this.operand1 + ", " + this.operand2 + "->" + this.rezultat + "]";
		}
		
		public double getRezultat() {
			return this.rezultat;
		}
	}
	
	public double saberi(double o1, double o2) {
		return this.izracunaj(o1, o2, (a, b) -> a + b, "Sabiranje");
	}
	
	public double oduzmi(double o1, double o2) {
		return this.izracunaj(o1, o2, (a, b) -> a - b, "Oduzimanje");
	}
	
	public double pomnozi(double o1, double o2) {
		return this.izracunaj(o1, o2, (a, b) -> a*b, "Množenje");
	}
	
	public double podeli(double o1, double o2) {
		return this.izracunaj(o1, o2, (a, b) -> a/b, "Deljenje");
	}
	
	
	public double izracunaj(double operand1, double operand2, BiFunction<Double, Double, Double> func, String ime) {
		Akcija a = new Akcija(ime, operand1, operand2, func.apply(operand1, operand2));
		istorija.add(a);
		return a.getRezultat();
	}
	
	public double izracunaj(double o1, double o2, BiFunction<Double, Double, Double> func) {
		return this.izracunaj(o1, o2, func, "Default");
	}
	
	public void ispisiIstoriju() {
		for (Akcija a : this.istorija) {
			System.out.println(a);
		}
	}
}
