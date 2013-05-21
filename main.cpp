/*
 * main.cpp
 *
 *  Created on: 03-05-2013
 *      Author: ubuntu
 */

#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <string>
#include "Liczba.h"
#include "Sito.h"

using namespace std;

int String2Int(char *str);
string Int2String(int number);

int main(int argc, char **argv)
{
  vector<int> argumenty;//Vector argumentów
	vector<int> vVectorRoboczy;
	vector<int> vVectorPoteg;
	int max; //Największy argument
	argumenty.reserve(argc); //Zarezerwowanie miejsca na argumenty

	for(int i = 1; i < argc; ++i) {
		try {
			cout<<"puszam argumenty"<<endl; // to robi dobrze
			argumenty.push_back(String2Int(argv[i]));
        }
	    catch(const char *error) {
	    	cerr << error << " nie jest liczbą!\n";
	    }
	}

	max = *(max_element(argumenty.begin(), argumenty.end())); //Szukanie największego argumentu
	cout << "Przed sitem"<<endl;
	Sito cSito(max);

	cout << "Po zrobienu sita..."<<endl;
	for (int i = 0; i < argc; i++) {
		cout<<"zaraz rozłoże elementy na czynniki"<<endl;
		cSito.rozlozNaCzynniki(cSito.zwrocVector()[argumenty[i]]->zwrocWartosc());
		//cout << "Rozkładam elementy na czynniki..."<<endl;
	}
	for (int i = 0; i < argc; i++) {
		//cout << "Po kolei zaczynam wypisywał rozkłady..." <<endl;
		vVectorRoboczy = cSito.zwrocVector()[argumenty[i]]->zwrocVectorRozkladu();
		vVectorPoteg = cSito.zwrocVector()[argumenty[i]]->zwrocVectorPotegiRozkladu();
		string wynik = "";
		int gwiazdka = 0;
		wynik = argumenty[i] + " =";

		for (int h = 0; h < (int)vVectorPoteg.size();h++) {
			if(vVectorPoteg[h] != 0) {
				if(gwiazdka != 0) wynik + "* " + Int2String(h);
				else wynik = wynik + " " + Int2String(h);
				if(vVectorPoteg[h] != 1)wynik = wynik + " ^" + Int2String(vVectorPoteg[h]);
				gwiazdka++;
			}
		}
		cout << argumenty[i] << " =" << wynik <<endl;
	}
	cSito.~Sito();
	return 0;
}

int String2Int(char *str) {

    stringstream stream;
    stream << str;
    int i;

    if(stream >> i) {

	return i;
    }
    else {

	throw str;
        return 0;
    }
}
string Int2String(int number)
{
   stringstream ss;
   ss << number;
   return ss.str();
}
