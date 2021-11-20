package main;

import base.Kalkulator;

public class Main {
	public static void main(String[] args) {
		Kalkulator kal = new Kalkulator();
		kal.saberi(5.4, 30);
		kal.oduzmi(5, 2.1);
		kal.pomnozi(4, 0);
		kal.podeli(34, 7);
		System.out.println(kal.izracunaj(6, 2, (a,b) -> a-b));
		System.out.println(kal.izracunaj(953, 64, (a,b) -> a-b*6, "Moja operacija"));
		System.out.println(kal.izracunaj(60, 45, (a,b) -> a-b+b-b));
		kal.ispisiIstoriju();
	}
}
