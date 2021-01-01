package com.company;
public class Wielomian {
    private int[] a;
    public Wielomian(int[] tab){
        a = new int[tab.length];
        System.arraycopy(tab, 0, a,0,tab.length);
    }

    public Wielomian DodajWielomian(Wielomian input) {
        if (a.length == 0) {
            Wielomian output = new Wielomian(new int[input.a.length]);
            System.arraycopy(input.a,0 ,output.a,0, input.a.length);
            return output;
        }
        if (input.a.length == 0) {
            Wielomian output = new Wielomian(new int[a.length]);
            System.arraycopy(a,0, output.a,0 ,a.length);
            return output;
        }

        if(a.length==input.a.length){
            Wielomian output = new Wielomian(new int[a.length]);
            for (int i = 0; i<a.length;i++)
                output.a[i] = a[i] + input.a[i];
            return output;
        }
        int shortLength, longLength;

        if (a.length > input.a.length) {
            longLength = a.length;
            shortLength = input.a.length;
        }
        else {
            longLength = input.a.length;
            shortLength = a.length;
        }

        Wielomian output = new Wielomian(new int[longLength]);
        int i = 0;
        for (; i < shortLength; i++)
            output.a[i] = a[i] + input.a[i];
        for (; i < longLength; i++) {
            if (a.length > input.a.length)
                output.a[i] = a[i];
            else if (a.length < input.a.length)
                output.a[i] = input.a[i];
        }
        return output;
    }
    public Wielomian Pomnoz(int input) {
        for(int i = 0; i < a.length; i++)
            a[i] *= input;
        return this;
    }
    public String ToString() {
        if (a.length == 0)
            return "0 * x^0";
        String output = "";
        for (int i = 0; i < a.length; i++) {
            if (output == "" && a[i] != 0)
                output += String.format("%d * x^%d",a[i],i);
            else if (a[i] != 0)
                output += String.format(" + %d * x^%d",a[i],i);
        }
        return output;
    }

    public static void Test() {
        // Czy puste tablice sa prawidlowo obslugowane? (ini i wyp)
        Wielomian w1 = new Wielomian(new int[0]);
        System.out.println("ini w1: " + w1.ToString());

        // Czy niepuste tablice sa prawidlowo obslugowane? (ini i wyp)
        int[] wsp1 = new int[] { 1, 2, 3, 4, 5 };
        Wielomian w2 = new Wielomian(wsp1);
        System.out.println("ini w2: " + w2.ToString());

        // Czy dziala mnozenie? Czy dziala wypisywanie ujemnych wspolczynnikow?
        w2.Pomnoz(-2);
        System.out.println("mnz: w2 = " + w2.ToString());

        // Czy dziala dodawanie wielomianow roznej dlugosci?
        Wielomian w3 = w2.DodajWielomian(w1);
        System.out.println("dod: w3 = w2 + w1 = " + w3.ToString());

        // Czy konstruktor kopiuje tablice?
        for (int i = 0; i < wsp1.length; i++)
            wsp1[i] = -wsp1[i];
        System.out.println("tst: w2 = " + w2.ToString());

        // Czy dodawanie wielomianu samego do siebie nie powoduje bledow?
        System.out.println("dod: w2 + w2 = " + w2.DodajWielomian(w2).ToString());

        // Czy dodawanie nie zmienia wielomianu?
        System.out.println("tst: w2 = " + w2.ToString());
    }
}

