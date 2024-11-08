# 1. Scenariusz: Weryfikacja poprawności wyświetlania danych na podstronie wiadomości w trojmiasto.pl

## Cel testu
Sprawdzenie, czy elementy na stronie głównej oraz podstronie wiadomości portalu [trojmiasto.pl](https://www.trojmiasto.pl/) działają poprawnie oraz są widoczne dla użytkownika.

## Kroki Testowe

### 1. Otwórz Przeglądarkę i Przejdź do Strony Głównej
- **Akcja**: Otwórz stronę główną serwisu [https://www.trojmiasto.pl/](https://www.trojmiasto.pl/).

### 2. Sprawdzenie Tytułu Strony
- **Asercja 1**: Zweryfikuj, czy tytuł strony wynosi "Trojmiasto.pl - wiadomości i informacje z Trójmiasta."
- **Oczekiwany wynik**: Tytuł strony jest poprawny, co wskazuje na poprawne załadowanie strony głównej.

### 3. Kliknij w Link „Wiadomości” na Stronie Głównej
- **Akcja**: Znajdź link „Wiadomości” i kliknij w niego.
- **Asercja 2**: Zweryfikuj, czy po kliknięciu użytkownik zostaje przeniesiony do URL: [https://www.trojmiasto.pl/wiadomosci/](https://www.trojmiasto.pl/wiadomosci/).
- **Oczekiwany wynik**: Przejście na stronę wiadomości zostało wykonane poprawnie.

### 4. Zaakceptowanie Polityki Cookies
- **Akcja**: Czekaj na wyświetlenie przycisku „Akceptuj” w oknie zgody na pliki cookies.
- **Asercja 3**: Sprawdź, czy przycisk „Akceptuj” jest widoczny, a następnie kliknij w niego, aby zaakceptować pliki cookies.
- **Oczekiwany wynik**: Polityka cookies zostaje zaakceptowana.

### 5. Kliknięcie w Pierwszy Artykuł w Sekcji Wiadomości
- **Akcja**: Znajdź i kliknij pierwszy artykuł dostępny w sekcji wiadomości.
- **Asercja 4**: Po załadowaniu artykułu sprawdź, czy nagłówek artykułu jest widoczny.
- **Oczekiwany wynik**: Nagłówek artykułu jest poprawnie wyświetlony.

### 6. Weryfikacja Widoczności Autora Artykułu
- **Asercja 5**: Sprawdź, czy informacja o autorze artykułu jest widoczna na stronie.
- **Oczekiwany wynik**: Widoczny jest autor artykułu.

### 7. Sprawdzenie Przycisku „Opinie” przy Artykule
- **Asercja 6**: Sprawdź, czy przycisk „Opinie” przy artykule jest widoczny.
- **Oczekiwany wynik**: Przycisk „Opinie” jest wyświetlany, umożliwiając użytkownikowi dostęp do sekcji komentarzy.

### 8. Weryfikacja Przycisku „Dodaj Opinię”
- **Akcja**: Znajdź przycisk „Dodaj opinię”.
- **Asercja 7**: Sprawdź, czy przycisk „Dodaj opinię” ma tekst równy „Dodaj opinię”.
- **Oczekiwany wynik**: Przycisk jest poprawnie wyświetlany i gotowy do interakcji z użytkownikiem.

### 9. Sprawdzenie Stanu Widoczności Formularza Opinii
- **Akcja**: Znajdź formularz opinii.
- **Asercja 8**: Sprawdź, czy formularz opinii ma wartość CSS `display` ustawioną na `none`, co oznacza, że początkowo jest ukryty.
- **Oczekiwany wynik**: Formularz opinii jest domyślnie ukryty (`display: none`), co zapewnia poprawność interfejsu użytkownika.

### 10. Zakończenie Testu
- **Akcja**: Zamknij przeglądarkę i zakończ sesję WebDriver.

## Podsumowanie Wyników

- **Test Pozytywny**: Wszystkie asercje są spełnione, a elementy na stronie głównej oraz w artykule są widoczne i działają poprawnie.
- **Test Negatywny**: Każde niepowodzenie asercji wskazuje na błąd – albo strona nie załadowała się poprawnie, albo elementy nie są widoczne lub mają niewłaściwe wartości, co wymaga dalszej analizy.


# 2. Scenariusz: Weryfikacja poprawności dodania i usunięcia produktu z koszyka supersklep.pl

## Cel testu
Sprawdzenie, czy elementy na stronie głównej oraz w procesie zakupu w sklepie internetowym [supersklep.pl](https://supersklep.pl/) działają poprawnie.

## Kroki Testowe

### 1. Otwórz Przeglądarkę i Przejdź do Strony Głównej
- **Akcja**: Otwórz stronę główną serwisu [https://supersklep.pl/](https://supersklep.pl/).

### 2. Sprawdzenie Tytułu Strony
- **Asercja 1**: Zweryfikuj, czy tytuł strony wynosi "Sklep skateboardowy, snowboardowy, ze sneakersami i ubraniami streetwear | SUPERSKLEP".
- **Oczekiwany wynik**: Tytuł strony jest poprawny, co wskazuje na poprawne załadowanie strony głównej.

### 3. Akceptacja Polityki Cookies
- **Akcja**: Znajdź przycisk "Akceptuj" w oknie zgody na pliki cookies i kliknij w niego.
- **Asercja 2**: Sprawdź, czy przycisk „Akceptuj” jest widoczny i kliknięty.
- **Oczekiwany wynik**: Polityka cookies zostaje zaakceptowana.

### 4. Wybór Języka
- **Akcja**: Kliknij w sekcję wyboru języka (dropdown).
- **Asercja 3**: Sprawdź, czy opcja „Polski” (PL) jest widoczna i kliknij ją.
- **Oczekiwany wynik**: Opcja języka „Polski” zostaje wybrana.

### 5. Weryfikacja Zmiany Języka
- **Akcja**: Sprawdź, czy po wybraniu języka, na stronie pojawi się tekst "Polski/PLN".
- **Asercja 4**: Zweryfikuj, czy tekst "Polski/PLN" jest widoczny po zmianie języka.
- **Oczekiwany wynik**: Tekst "Polski/PLN" jest poprawnie wyświetlony.

### 6. Akceptacja Wybory Języka
- **Akcja**: Kliknij przycisk „Akceptuj” po wyborze języka.
- **Oczekiwany wynik**: Wybór języka jest zaakceptowany i proces przechodzi dalej.

### 7. Przejście do Sekcji „Snowboard Shop”
- **Akcja**: Kliknij w link do sekcji „Snowboard shop” w menu.
- **Oczekiwany wynik**: Zostajesz przeniesiony do strony [https://supersklep.pl/snowboard](https://supersklep.pl/snowboard).

### 8. Wybór Kategorii „Rękawice snowboardowe”
- **Akcja**: Kliknij kategorię „Rękawice snowboardowe”.
- **Oczekiwany wynik**: Strona „Rękawice snowboardowe” jest poprawnie załadowana.

### 9. Przejście do Strony Produktu
- **Akcja**: Kliknij w produkt z kategorii.
- **Oczekiwany wynik**: Produkt jest poprawnie załadowany.

### 10. Dodanie Produktu do Koszyka
- **Akcja**: Kliknij przycisk „Dodaj do koszyka”.
- **Asercja 5**: Sprawdź, czy przycisk „Dodaj do koszyka” jest widoczny i kliknij go.
- **Oczekiwany wynik**: Produkt zostaje dodany do koszyka.

### 11. Przejście do Koszyka
- **Akcja**: Kliknij przycisk „Przejdź do koszyka”.
- **Asercja 6**: Sprawdź, czy ikona koszyka jest widoczna.
- **Oczekiwany wynik**: Koszyk jest poprawnie wyświetlany, a użytkownik może przejść do dalszej interakcji.

### 12. Weryfikacja Ilości Produktów w Koszyku
- **Akcja**: Sprawdź ilość produktów w koszyku.
- **Asercja 7**: Sprawdź, czy w koszyku znajduje się 1 produkt.
- **Oczekiwany wynik**: Koszyk zawiera 1 produkt.

### 13. Usunięcie Produktu z Koszyka
- **Akcja**: Kliknij przycisk „Usuń” przy produkcie w koszyku.
- **Asercja 8**: Sprawdź, czy przycisk „Usuń” jest widoczny i kliknij go.
- **Oczekiwany wynik**: Produkt zostaje usunięty z koszyka.

### 14. Weryfikacja Ilości Produktów po Usunięciu
- **Akcja**: Sprawdź ilość produktów w koszyku po usunięciu.
- **Asercja 9**: Sprawdź, czy ilość produktów w koszyku wynosi 0.
- **Oczekiwany wynik**: Koszyk jest pusty.

### 15. Zakończenie Testu
- **Akcja**: Zamknij przeglądarkę i zakończ sesję WebDriver.

## Podsumowanie Wyników

- **Test Pozytywny**: Wszystkie asercje są spełnione, a kluczowe elementy na stronie oraz proces zakupu działają poprawnie.
- **Test Negatywny**: Każde niepowodzenie asercji wskazuje na błąd – albo strona nie załadowała się poprawnie, albo elementy nie są widoczne lub mają niewłaściwe wartości, co wymaga dalszej analizy.

# 3. Scenariusz Testowy: Weryfikacja sekcji na stronie głównej oraz strony logowania na Stronie OLX.pl

## Cel testu  
Sprawdzenie, czy główne funkcje interfejsu użytkownika na stronie [olx.pl](https://www.olx.pl/) działają poprawnie, a wszystkie elementy są widoczne i interaktywne.

## Kroki Testowe

### 1. Otwórz Przeglądarkę i Przejdź do Strony Głównej
- **Akcja**: Otwórz stronę główną serwisu [https://www.olx.pl/](https://www.olx.pl/).
  
### 2. Sprawdzenie Tytułu Strony
- **Asercja 1**: Zweryfikuj, czy tytuł strony wynosi "Ogłoszenia - Sprzedam, kupię na OLX.pl".
- **Oczekiwany wynik**: Tytuł strony jest poprawny, co wskazuje na załadowanie strony głównej.

### 3. Weryfikacja Widoczności Banera Cookies
- **Akcja**: Sprawdź, czy baner zgody na pliki cookies jest widoczny.
- **Asercja 2**: Sprawdź, czy baner cookies jest wyświetlany.
- **Oczekiwany wynik**: Baner cookies jest widoczny, a użytkownik może go zaakceptować.

### 4. Akceptacja Polityki Cookies
- **Akcja**: Kliknij przycisk „Zaakceptuj” w banerze zgody na cookies.
- **Asercja 3**: Sprawdź, czy baner z polityką cookies znika po kliknięciu przycisku "Zaakceptuj".
- **Oczekiwany wynik**: Po kliknięciu przycisku „Zaakceptuj”, baner zostaje zamknięty i nie jest już widoczny.

### 5. Weryfikacja Widoczności Sekcji Kategorii
- **Akcja**: Sprawdź, czy sekcja kategorii ogłoszeń jest widoczna.
- **Asercja 4**: Sprawdź, czy sekcja kategorii jest widoczna na stronie głównej.
- **Oczekiwany wynik**: Sekcja kategorii jest poprawnie wyświetlana, co umożliwia użytkownikowi przeglądanie różnych kategorii ogłoszeń.

### 6. Weryfikacja Widoczności Sekcji Wyszukiwania
- **Akcja**: Sprawdź, czy sekcja wyszukiwania jest dostępna i widoczna.
- **Asercja 5**: Sprawdź, czy sekcja wyszukiwania (pasek wyszukiwania) jest widoczna.
- **Oczekiwany wynik**: Sekcja wyszukiwania jest poprawnie wyświetlana, umożliwiając użytkownikowi wyszukiwanie ogłoszeń.

### 7. Weryfikacja Widoczności Sekcji Promowanych Ogłoszeń
- **Akcja**: Sprawdź, czy sekcja promowanych ogłoszeń jest widoczna.
- **Asercja 6**: Sprawdź, czy sekcja promowanych ogłoszeń jest widoczna na stronie.
- **Oczekiwany wynik**: Sekcja promowanych ogłoszeń jest widoczna, co świadczy o dostępności tych ogłoszeń na stronie głównej.

### 8. Kliknięcie w Sekcję „Twoje Konto”
- **Akcja**: Kliknij w przycisk „Twoje Konto” w prawym górnym rogu strony.
- **Oczekiwany wynik**: Użytkownik zostaje przeniesiony na stronę logowania lub rejestracji.

### 9. Weryfikacja Widoczności Sekcji Logowania
- **Akcja**: Sprawdź, czy sekcja logowania jest widoczna po kliknięciu w „Twoje Konto”.
- **Asercja 7**: Sprawdź, czy sekcja logowania jest wyświetlana.
- **Oczekiwany wynik**: Sekcja logowania (formularz logowania) jest poprawnie wyświetlana.

### 10. Weryfikacja Liczby Przycisków Logowania
- **Akcja**: Sprawdź, ile przycisków logowania (np. „Zaloguj się”, „Zarejestruj się”, „Przez Facebook”) znajduje się na stronie.
- **Asercja 8**: Sprawdź, czy na stronie znajdują się 3 przyciski logowania.
- **Oczekiwany wynik**: Na stronie znajduje się dokładnie 3 przyciski logowania, co sugeruje, że użytkownik może wybrać preferowaną metodę logowania.

### 11. Zakończenie Testu
- **Akcja**: Zamknij przeglądarkę i zakończ sesję WebDriver.
- **Oczekiwany wynik**: Test kończy się poprawnie, przeglądarka jest zamknięta, a sesja WebDriver zostaje zakończona.

## Podsumowanie Wyników

- **Test Pozytywny**: Wszystkie asercje są spełnione, a elementy na stronie głównej i na stronie logowania działają poprawnie.
- **Test Negatywny**: Każde niepowodzenie asercji wskazuje na problem z ładowaniem elementów na stronie lub ich interaktywnością, co wymaga dalszej analizy.


# 4. Scenariusz: Weryfikacja wyszukiwania mieszkań na stronie otodom.pl

## Cel testu
Sprawdzenie, czy funkcjonalności wyszukiwania mieszkań na stronie [Otodom](https://www.otodom.pl/) działają poprawnie, w tym akceptacja polityki cookies, wyświetlanie wyników wyszukiwania oraz poprawność wyników.

## Kroki Testowe

### 1. Otwórz Przeglądarkę i Przejdź do Strony Głównej
- **Akcja**: Otwórz stronę główną serwisu [https://www.otodom.pl/](https://www.otodom.pl/).

### 2. Sprawdzenie Tytułu Strony
- **Asercja 1**: Zweryfikuj, czy tytuł strony wynosi "Otodom: Nieruchomości, Mieszkania, Domy, Działki".
- **Oczekiwany wynik**: Tytuł strony jest poprawny, co wskazuje na poprawne załadowanie strony głównej.

### 3. Zaakceptowanie Polityki Cookies
- **Akcja**: Czekaj na wyświetlenie przycisku „Akceptuj” w oknie zgody na pliki cookies.
- **Asercja 2**: Sprawdź, czy przycisk „Akceptuj” jest widoczny, a następnie kliknij w niego, aby zaakceptować pliki cookies.
- **Oczekiwany wynik**: Polityka cookies zostaje zaakceptowana, a okno zgody znika.

### 4. Weryfikacja Widoczności Sekcji Wyszukiwania
- **Akcja**: Znajdź sekcję wyszukiwania mieszkań na stronie.
- **Asercja 3**: Sprawdź, czy sekcja wyszukiwania jest widoczna.
- **Oczekiwany wynik**: Sekcja wyszukiwania jest widoczna i gotowa do interakcji.

### 5. Otwarcie Rozwijanej Listy Typów Nieruchomości
- **Akcja**: Kliknij na rozwijane menu, które umożliwia wybór typu nieruchomości.
- **Asercja 4**: Sprawdź, czy lista rozwijana jest widoczna.
- **Oczekiwany wynik**: Menu rozwija się poprawnie, a użytkownik może wybrać typ nieruchomości.

### 6. Wybór Opcji „Mieszkania” z Listy
- **Akcja**: Wybierz opcję „Mieszkania” z rozwijanej listy typów nieruchomości.
- **Asercja 5**: Sprawdź, czy po wybraniu opcji „Mieszkania” element zawiera tekst "Mieszkania".
- **Oczekiwany wynik**: Opcja „Mieszkania” zostaje wybrana, a tekst przycisku jest zgodny z oczekiwanym.

### 7. Kliknięcie Przycisku „Szukaj”
- **Akcja**: Kliknij przycisk „Szukaj”, aby rozpocząć wyszukiwanie mieszkań.
- **Asercja 6**: Sprawdź, czy po kliknięciu przycisku, strona przekierowuje do wyników wyszukiwania.
- **Oczekiwany wynik**: Po kliknięciu przycisku użytkownik zostaje przekierowany do wyników wyszukiwania dla mieszkań.

### 8. Weryfikacja Nagłówka na Stronie Wyników
- **Akcja**: Sprawdź nagłówek na stronie wyników wyszukiwania.
- **Asercja 7**: Sprawdź, czy nagłówek zawiera tekst „Mieszkania na sprzedaż: Cała Polska”.
- **Oczekiwany wynik**: Nagłówek strony wyników wyszukiwania jest poprawny i zawiera oczekiwany tekst.

### 9. Sprawdzenie Liczby Wyników Wyszukiwania
- **Akcja**: Sprawdź, ile wyników wyszukiwania jest wyświetlanych na stronie.
- **Asercja 8**: Sprawdź, czy liczba wyników wynosi 37.
- **Oczekiwany wynik**: Wyniki wyszukiwania zawierają 37 pozycji.

### 10. Zakończenie Testu
- **Akcja**: Zamknij przeglądarkę i zakończ sesję WebDriver.

## Podsumowanie Wyników

- **Test Pozytywny**: Wszystkie asercje zostały spełnione, a elementy na stronie Otodom są widoczne i działają zgodnie z oczekiwaniami. Wyszukiwanie mieszkań na stronie działa poprawnie.
- **Test Negatywny**: Każde niepowodzenie asercji wskazuje na problem z załadowaniem strony, wyświetlaniem elementów lub niewłaściwymi wartościami, co wymaga dalszej analizy.

---

### Opis użytego podejścia:
Test został zaprojektowany z wykorzystaniem narzędzi Selenium WebDriver do automatyzacji interakcji z przeglądarką i weryfikacji działania strony Otodom. W szczególności sprawdzono poprawność widoczności elementów, interakcji użytkownika (kliknięcia, wybory z list rozwijanych) oraz weryfikację poprawności wyników wyszukiwania.
