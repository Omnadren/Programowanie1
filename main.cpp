#include <iostream>
#include <conio.h>
#include "Liczba.h"

int main()
{
  Liczba liczba1(25);
	liczba1.ustawDoDziesiatej();
	liczba1.ustawZapisLiczby();
	for (int i = 2; i <=16; i++) {
		cout << "Podstawa: " << i << " zapis: " << liczba1.zwrocZapisLiczby(i) << endl;
	}
	system("pause");
	return 0;
}
