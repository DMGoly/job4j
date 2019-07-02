package ru.job4j.calculate;

public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }
    /**
     * Конвертируем Rub to Euro.
     * @param value Euro.
     * @return RUB.
     */
    public int EuroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / 65;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     **/
    public int DollarToRuble(int value) {
        return value * 65;
    }
}