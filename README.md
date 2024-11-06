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

