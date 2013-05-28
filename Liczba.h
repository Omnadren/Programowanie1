#pragma once
#include <string>
#include <vector>
#include <cmath>
#include <sstream>

using namespace std;

class Liczba {
private:
  int m_nLiczbaDziesietna;
	int m_nPodstawaRobocza;
	string m_sZapisRoboczy;
	vector<string> m_vsVektorZapisu;	
public:
	Liczba(void);
	Liczba(int nLiczbaDziesietna);
	Liczba(string sZapisRoboczy, int nPodstawaRobocza);
	void ustawDoDziesiatej(void);
	void ustawZapisLiczby(void);
	string zwrocZapisLiczby(int nPodstawa);
	~Liczba(void);
};
