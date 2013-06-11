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



private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
				 Bitmap^ bgObszarRysowania = gcnew Bitmap(100, 100);
				 Graphics^ gGrafika = this->CreateGraphics();
				 gGrafika->DrawImage(bgObszarRysowania, 20, 20);
				 Pen^ pPioro = gcnew Pen(System::Drawing::Color::Black, 2);
				 for(int i = 30; i < 80; i++) {
					 bgObszarRysowania->SetPixel(i, 30, System::Drawing::Color::Black);
					 bgObszarRysowania->SetPixel(i, 80, System::Drawing::Color::Black);
					 bgObszarRysowania->SetPixel(30, i, System::Drawing::Color::Black);
					 bgObszarRysowania->SetPixel(80, i, System::Drawing::Color::Black);
				 }
				 gGrafika->DrawImage(bgObszarRysowania, 20, 20);
				 Color^ cKolor = System::Drawing::Color::Black;
				 Color^ cKolorFill = System::Drawing::Color::Red;
				 wypelnijSeed(40,40,cKolor, cKolorFill, bgObszarRysowania);
			 }
