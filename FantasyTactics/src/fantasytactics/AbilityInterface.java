/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hammad
 */
public interface AbilityInterface extends Serializable{
       public void doAction(BattleMem user, ArrayList<BattleMem> vics);
    
}
