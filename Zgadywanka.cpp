#include <iostream>
#include <cstdlib>
#include <ctime>
#include <conio.h>

using namespace std;

int main()
{
  char cWyjscie;
	int nLicznik = 0, nZgadywana = -666; //licznik, ktory zapamietuje liczbe prob zgadniecia
	srand (time(NULL)); //czyszczenie rand() żeby za każdym uruchomieniem losowało nową liczbę
	int nLiczbaLosowana = rand() % 100; // zmienna nLiczbaLosowana otrzymuje wartosc losowa 0 - 100
	while(nZgadywana != nLiczbaLosowana) { //dopóki nie zgadniemy lub nie przerwiemy, pętla się nie skończy
		cout << "Zgadnij liczbe, lub wpisz 123 aby sie poddac..."<<endl;
		cin >> nZgadywana;
		if(nZgadywana == 123) {
			cout << "Poddales sie!" << endl;
			cout << "Liczba byla rowna: " << nLiczbaLosowana <<endl;
			cout << "Czy chcesz wyjsc z programu? t/n" <<endl;
			cin >> cWyjscie;
			if (cWyjscie == 't') {
				system("pause");
				return 0;
			}
		}
		nLicznik++; //zapamiętywanie każdej próby
	}
	cout << "Udalo Ci sie odgadnac liczbe! " <<endl;
	cout << "Liczba wylosowana: " << nLiczbaLosowana << " Twoja liczba: " << nZgadywana <<endl;
	cout << "Odgadles liczbe po: " << nLicznik << " probach!" <<endl;
	system("pause");
	return 0;
}
