void wypelnijSeed(int nX, int nY, Color^ cKolorKrawedzi, Color^ cKolorWypelnienia, Bitmap^ bMapaBitowa) {
  		if(nX >= bMapaBitowa->Width || nX  < 0 || nY >= bMapaBitowa->Height || nY < 0)
				return;
			Color^ cKolor = bMapaBitowa->GetPixel(nX, nY);
			if((cKolorWypelnienia != cKolorKrawedzi) && (cKolor != cKolorWypelnienia)) {
				bMapaBitowa->SetPixel(nX, nY, System::Drawing::Color::Red);
					wypelnijSeed(nX, (nY - 1), cKolorKrawedzi, cKolorWypelnienia, bMapaBitowa);
					wypelnijSeed(nX, (nY + 1), cKolorKrawedzi, cKolorWypelnienia, bMapaBitowa);
					wypelnijSeed((nX - 1), nY, cKolorKrawedzi, cKolorWypelnienia, bMapaBitowa);
					wypelnijSeed((nX + 1), nY, cKolorKrawedzi, cKolorWypelnienia, bMapaBitowa);
			} else return;
		}
