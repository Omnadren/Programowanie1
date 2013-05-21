/*
 * Liczba.cpp
 *
 *  Created on: 03-05-2013
 *      Author: Adam Szerszen
 */
#include <vector>
#include "Liczba.h"

Liczba::Liczba() {
  m_nWartosc = 0;
	m_bCzyPierwsza = false;
	m_nDzielnikPierwszy = 0;
	vector<int> m_vVectorRozkladu;
	vector<int> m_vVectorPotegRozkladu;
	m_vVectorRozkladu.reserve(m_nWartosc);
	m_vVectorPotegRozkladu.reserve(m_nWartosc);
	for (int i = 0; i < m_nWartosc; i++) {
		m_vVectorPotegRozkladu.push_back(0);
	}
}
Liczba::Liczba(int nWartosc, bool bCzyPierwsza, int nDzielnikPierwszy) {
	m_nWartosc = nWartosc;
	m_bCzyPierwsza = bCzyPierwsza;
	m_nDzielnikPierwszy = nDzielnikPierwszy;
}
Liczba::~Liczba() { }
void Liczba::ustawWartosc(int nWartosc) {
	m_nWartosc = nWartosc;
}
int Liczba::zwrocWartosc()const {
	return m_nWartosc;
}
void Liczba::ustawCzyPierwsza(bool bCzyPierwsza) {
	m_bCzyPierwsza = bCzyPierwsza;
}
bool Liczba::zwrocCzyPierwsza()const {
	return m_bCzyPierwsza;
}
void Liczba::ustawDzielnikPierwszy(int nDzielnikPierwszy) {
	m_nDzielnikPierwszy = nDzielnikPierwszy;
}
int Liczba::zwrocDzielnikPierwszy()const {
	return m_nDzielnikPierwszy;
}
void Liczba::dodajDzielnikDoRozkladu(int nNowyDzielnik) {
	m_vVectorRozkladu.push_back(nNowyDzielnik);
}
void Liczba::dodajPotegSkladnikaRozkladu(int nPotega) {
	m_vVectorPotegRozkladu[nPotega]++;
}
vector<int> Liczba::zwrocVectorRozkladu() {
	return m_vVectorRozkladu;
}
vector<int> Liczba::zwrocVectorPotegiRozkladu()	{
	return m_vVectorPotegRozkladu;
}
