package hu.krivan.jklickety;

import java.util.List;

/**
 * Ezt az interfészt kell megvalósítania a vezérlőnek.
 *
 * @author Balint
 */
public interface Controller {
    /**
     * Értesítjük a controllert ha változott a pontszám
     *
     * @param points pontszám új értéke
     */
    void onPointsChanged(double points);

    /**
     * Értesítjük a controllert, ha vége a játéknak
     *
     * @param points
     */
    void onNoMoreMove(int points);

    /**
     * Controllertől lekérhetjük a pontszámokat a DB-ből a toplistához
     */
    List<Result> getDataFromDatabase();

    /**
     * Controller elmentheti a pontszámot a DB-be
     *
     * @param name felhasználó neve
     * @param points pontszáma
     */
    void savePoints(String name, int points);
}
