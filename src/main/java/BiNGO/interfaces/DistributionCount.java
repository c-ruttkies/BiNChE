/*
 * DistributionCount.java
 *
 * Created on 30 november 2007, 10:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package BiNGO.interfaces;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author stmae
 */
public interface DistributionCount extends CalculateTestTask {
        

    /*--------------------------------------------------------------
      METHODS.
    --------------------------------------------------------------*/

    /**
     * method for compiling GO classifications for given node
     */


    public Set getNodeClassifications(String node);    

    /**
     * method for making the hashmap for small n.
     */
    public void countSmallN() ;


    /**
     * method for making the hashmap for the small x.
     */
    public void countSmallX() ;


    /**
     * method that counts for small n and small x.
     */
    public Map count(Set nodes) ;

    /**
     * counts big N. unclassified nodes are not counted ; no correction for function_unknown nodes (yet)(requires user input)
     */
    public void countBigN() ;

    /**
     * counts big X. unclassified nodes are not counted ; no correction for function_unknown nodes (yet)(requires user input)
     */
    public void countBigX() ;
    
    public void calculate();

    public Map<String,Double> getWeights();

    public Map<Integer,Double> getMapWeights();
    
}
