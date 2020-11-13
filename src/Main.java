public class Main {

    public static void main(String[] args) {
	int[]lijst= randomnumbers(1000000);                 //een lijst aanmaken van 1 miljoen random nummers
	long starttijd = System.nanoTime();            // bepaalt de start tijd
	Sort(lijst, 0, lijst.length - 1);      // voert het sorteeralgoritme uit
	long eindtijd =System.nanoTime();               // bepaalt eindtijd
	long runtijd =eindtijd-starttijd;               // bepaald runtime in nanoseconds
        System.out.println("runtime quick sort in nanoseconds:" +runtijd);
    }

    /**
     * Deze functie genereerd een lijst met randomnummer tussen 1 en een miljard
     * @param num dit is het aantal numers dat wordt gegenereerd
     * @return lijstrandomnummer, een lijst met num aantal nummers tussen 1 en een miljard
     */
    static int[] randomnumbers(int num){
        int[] lijstrandomnummers =new int[num];
        // invoer van de min en max van de grote van de nummers
        int min=1;
        int max=1000000000;

        for (int i=0; i<num;i++){
            // generates a number from min(inclusief) to max(exclusief)
            lijstrandomnummers[i]= (int) (Math.random() * (max - min + 1) + min);
        }
        return lijstrandomnummers;
    }

    /**
     * Deze functie sorteert een lijst met integers met het quicksort algoritme
     * @param Lijst lijst met randomised integers
     * @param left 0
     * @param right lengte lijst -1
     */
    private static void Sort(int[] Lijst, int left, int right)
    {
        int L = left;   //dit is 0 in de eerste ronde
        int R = right;   //dit is de lengte van de lijst -1 in de eerste ronde
        int midleElement = Lijst[(left + right) / 2];  // dit is het midelste getal

        do
        { // dit wordt uitgevoert uitgevoert zolang l kleiner is dan r
            // deze begint met lopen aan het begin van de lijst en loopt na het midden toe
            while(Lijst[L] < midleElement) //
            {
                //schuift een plek op na rechts als het eerste getal kleiner is dan het middelste element
                L++;
            }
            // en deze begint met lopen aan het eind van de lijst en loopt na het midden toe
            while(midleElement < Lijst[R])
            {
                //schuift een plek op na rechts als het laatste getal groter is dan het middelste element
                R--;
            }
            // zolang l kleiner is dan r zijn ze nog niet in het midden aangekomen en zijn ze nog niet klaar
            // Het cijfer op positie l dat nu is meegegeven is groter dan het midenste getal en
            // het cijfer op positie r dat nu is meegeven is kleiner dan het middelste getal
            // in een geordende lijst zouden alle cijfer aan de rechterkant van het middelste getal groter zijn dan het
            // het middelste getal en de cijfers aan de linkerkant kleiner dan het middelste getal
            if(L <= R)
            // daarom worden hier het rechter en linker element omgedraait. Zodat uiteindelijk alle cijfers aan de
                // linkerkant groter zijn dan het middeslte getal en alle cijfers aan de rechter kant kleiner.
            { int leftelement = Lijst[L];
                Lijst[L] = Lijst[R];
                Lijst[R] = leftelement ;
                // en beide stappen een stapje verder door de lijst
                L++;
                R--;
            }
        } while(L < R);


        if(left < R) // als r groter is dan de linker waarde die is meegegeven toen de functie werd geroepen)
            // zijn nog niet genoeg punten als middelpunt gebruikt om de lijst geordend te hebben
            // worden deze waarden gebruikt om de functie in recursie op te roepen
        {
            Sort(Lijst, left, R);
        }
        // als de l waarde groter is dan de rechter waarde die is meegeven toen de functie werd aangeroepen
        // zijn nog niet genoeg punten als middelpunt gebruikt om de lijst geordend te hebben
        // en worden deze waarden gebruikt om deze functie in recursie op te roepen
        if(L < right)
        {
            Sort(Lijst, L, right);
        }
    }}
