/*
 * Liczba.h
 *
 *  Created on: 03-05-2013
 *      Author: Adam Szerszen
 */

#ifndef LICZBA_H_
#define LICZBA_H_

#include <iostream>
#include <vector>

using namespace std;

class Liczba {
private:
  int m_nWartosc;
	bool m_bCzyPierwsza;
	int m_nDzielnikPierwszy;
	vector<int> m_vVectorRozkladu;
	vector<int> m_vVectorPotegRozkladu;
public:
	Liczba();
	Liczba(int nWartosc, bool bCzyPierwsza, int nDzielnikPierwszy);
	~Liczba();
	void ustawWartosc(int nWartosc);
	int zwrocWartosc()const;
	void ustawCzyPierwsza(bool bCzyPierwsza);
	bool zwrocCzyPierwsza()const;
	void ustawDzielnikPierwszy(int nDzielnikPierwszy);
	int zwrocDzielnikPierwszy()const;
	void dodajDzielnikDoRozkladu(int nNowyDzielnik);
	void dodajPotegSkladnikaRozkladu(int nPotega);
	vector<int> zwrocVectorRozkladu();
	vector<int> zwrocVectorPotegiRozkladu();
};

#endif /* LICZBA_H_ */
