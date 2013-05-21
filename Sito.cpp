/*
 * Sito.cpp
 *
 *  Created on: 03-05-2013
 *      Author: Adam Szerszen
 */
#include <vector>
#include "Sito.h"
#include "Liczba.h"

Sito::Sito() {
  vector<Liczba>s_vSito;
}
Sito::Sito(int nNajwiekszaLiczba) {
	//cout << "w sicie..."<<endl; //do tej pory idzie
	vector<Liczba*>s_vSito;
	int k = 0;
	s_vSito.reserve(nNajwiekszaLiczba + 1);
	for (int i = 0; i < (nNajwiekszaLiczba + 1);i++) {
		s_vSito.push_back(new Liczba);
		s_vSito[i]->ustawWartosc(i);
	}
	for (int i = 2; i*i <= nNajwiekszaLiczba;i++) {

		//cout << "daje wartości bool" << endl;
		if (s_vSito[i]->zwrocCzyPierwsza()) continue;
		for (int j = 2 * i; j <= nNajwiekszaLiczba; j += i) {
			s_vSito[j]->ustawCzyPierwsza(true);
			//cout << "ustawia true" << endl;
		}
	}
	for (int i = 2; i <= nNajwiekszaLiczba; i++) {
		//cout << "ustawia dzielniki pierwsze w tablicy" << endl;
		if(s_vSito[i]->zwrocCzyPierwsza()) s_vSito[k++]->ustawDzielnikPierwszy(i);
	}
	//cout << "Na koniec sita, wychodzi z niego..."<<endl; //tego już nie wykonuje...
}
Sito::~Sito() {
	for(int i = 0; i < (int)s_vSito.size(); i++) {
		s_vSito[i]->~Liczba();
	}
}
vector<Liczba*> Sito::zwrocVector() {
	return s_vSito;
}
void Sito::rozlozNaCzynniki(int nLiczbaRozkladana) {
	int robocza, i = 2;
	robocza = s_vSito[nLiczbaRozkladana]->zwrocWartosc();
	cout << "zwraca wartosci"<<endl;
	while (robocza > 1) {
		if(robocza % s_vSito[i]->zwrocDzielnikPierwszy() == 0) {
			s_vSito[nLiczbaRozkladana]->dodajDzielnikDoRozkladu(s_vSito[i]->zwrocWartosc());
			s_vSito[nLiczbaRozkladana]->dodajPotegSkladnikaRozkladu(s_vSito[i]->zwrocWartosc());
			robocza/=s_vSito[i]->zwrocDzielnikPierwszy();
		} else i++;
	}
}
