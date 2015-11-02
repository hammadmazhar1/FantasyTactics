/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hammad
 */
public class TurnOrder {
    ArrayList<BattleMem> order;
    int numE = 0;
    TurnOrder() {
        order = new ArrayList<BattleMem>();
        order.clear();
    }
    public void create(ArrayList<BattleMem> en, ArrayList<BattleMem> play) {
        ArrayList<BattleMem> ord = new ArrayList<BattleMem>();
        ord.addAll(en);
        ord.addAll(play);
        for (BattleMem i : ord) {
            insert(i);
        }
    }
    public void insert(BattleMem e) {
        order.add(e);
        heapifyUp(numE);
        numE++;
    }
    public void heapifyUp(int index) {
        if (index > 0) {
            int pInd = (index-1)/2;
            if (order.get(index).member.getSpd() > order.get(pInd).member.getSpd()) {
                Collections.swap(order,index,pInd);
                heapifyUp(pInd);
            }
        }
    }
}
