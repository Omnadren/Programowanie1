/*
 * Sito.h
 *
 *  Created on: 03-05-2013
 *      Author: Adam Szerszen
 */

#ifndef SITO_H_
#define SITO_H_

#include <iostream>
#include <vector>
#include "Liczba.h"

using namespace std;

class Sito {
private:
  vector<Liczba*>s_vSito;
public:
	Sito();
	Sito(int nNajwiekszaLiczba);
	~Sito();
	vector<Liczba*> zwrocVector();
	void rozlozNaCzynniki (int nLiczbaRozkladana);
};

#endif /* SITO_H_ */
