/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import java.io.Serializable;

/**
 *
 * @author Hammad
 */
public class Location implements Serializable{
    int x;
    int y;
    Location() {
        x = 0;
        y = 0;
    }
    Location(int a, int b) {
        x = a;
        y = b;
    }
    public boolean equals(Location b) {
        return x == b.x && y == b.y;
    }
}
