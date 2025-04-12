package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    @Test
        @DisplayName("Sollte das Ergebnis nach dem Hinzufügen von zwei positiven mehrstelligen Zahlen angezeigt")
        void testMultiply() {
            Calculator calc = new Calculator();
            calc.pressDigitKey(2);
            calc.pressDigitKey(0);
            calc.pressBinaryOperationKey("x");
            calc.pressDigitKey(2);
            calc.pressDigitKey(0);
            calc.pressEqualsKey();
            String expected = "400";
            String actual = calc.readScreen();
            assertEquals(expected, actual);
        }
    @Test
    @DisplayName("should display the two functions of the Clear button and Clear Entry button ")
    void testSaveClear(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();//18
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressClearKey();//zwischengespeicherte Werte soll bleiben //18 x
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "90";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Fehler 1: Die Clear-Funktion löscht immer alle Einträge und setzt alles auf 0 zurück.
    // Bug fix Erstellen Sie einen Zähler für die Anzahl der Klicks auf die Löschtaste und stellen Sie sicher,
    // dass die Löschfunktion zwei Funktionen hat: eine zum Löschen der auf dem Bildschirm angezeigten Nummer und die zwischengespeicherte Werte zum Zurücksetzen auf 0
    @Test
    @DisplayName("should display the precedent result after Pressing an Operation key")
    void testBinaryOperationKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        String expected = "20";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Fehler:die zweite funktionalität von binaryoperationkey fehlt .. zwichen ergebniss wurde nicht gezeigt
}

