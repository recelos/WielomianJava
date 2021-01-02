package com.company;


public class Wielomian {

    private int[] a;

    private Wielomian(int[] tab) {
        a = new int[tab.length];
        System.arraycopy(tab,0,a,0,tab.length);
    }
    private Wielomian DodajWielomian(Wielomian input) {
        Wielomian output = new Wielomian(new int[0]);
        if (input.a.length == 0 && this.a.length == 0){
            return output;
        }
        if (this.a.length == 0 || input.a.length == 0) {
            if (this.a.length == 0) {
                output.a = new int[input.a.length];
                System.arraycopy(input.a, 0, output.a, 0, input.a.length);
            } else {
                output.a = new int[this.a.length];
                System.arraycopy(this.a, 0, output.a, 0, a.length);
            }
            return output;
        }
        if (this.a.length == input.a.length) {
            output.a = new int[a.length];
            for (int i = 0; i < output.a.length; i++)
                output.a[i] = this.a[i] + input.a[i];
            return output;
        }

        int shortLength, longLength;

        if (this.a.length > input.a.length) {
            longLength = this.a.length;
            shortLength = input.a.length;
        } else {
            longLength = input.a.length;
            shortLength = this.a.length;
        }
        output.a = new int[longLength];
        int i = 0;
        for (; i < shortLength; i++)
            output.a[i] = this.a[i] + input.a[i];
        for (; i < longLength; i++) {
            if (this.a.length > input.a.length)
                output.a[i] = this.a[i];
            else
                output.a[i] = input.a[i];
        }
        return output;
    }

    private void Pomnoz(int input) {
        for(int i = 0; i < a.length; i++)
            a[i] *= input;
    }

    @Override
    public String toString() {
        if (a.length == 0)
            return "0 * x^0";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (output.toString().equals("") && a[i] != 0)
                output.append(String.format("%d * x^%d", a[i], i));
            else if (a[i] != 0)
                output.append(String.format(" + %d * x^%d", a[i], i));
        }
        return output.toString();
    }
    public static void Test() {
        // Czy puste tablice sa prawidlowo obslugowane? (ini i wyp)
        Wielomian w1 = new Wielomian(new int[0]);
        System.out.println("ini w1: " + w1);

        // Czy niepuste tablice sa prawidlowo obslugowane? (ini i wyp)
        int[] wsp1 = new int[] { 1, 2, 3, 4, 5 };
        Wielomian w2 = new Wielomian(wsp1);
        System.out.println("ini w2: " + w2);

        // Czy dziala mnozenie? Czy dziala wypisywanie ujemnych wspolczynnikow?
        w2.Pomnoz(-2);
        System.out.println("mnz: w2 = " + w2);

        // Czy dziala dodawanie wielomianow roznej dlugosci?
        Wielomian w3 = w2.DodajWielomian(w1);
        System.out.println("dod: w3 = w2 + w1 = " + w3);

        // Czy konstruktor kopiuje tablice?
        for (int i = 0; i < wsp1.length; i++)
            wsp1[i] = -wsp1[i];
        System.out.println("tst: w2 = " + w2);

        // Czy dodawanie wielomianu samego do siebie nie powoduje bledow?
        System.out.println("dod: w2 + w2 = " + w2.DodajWielomian(w2));

        // Czy dodawanie nie zmienia wielomianu?
        System.out.println("tst: w2 = " + w2);
    }
}

