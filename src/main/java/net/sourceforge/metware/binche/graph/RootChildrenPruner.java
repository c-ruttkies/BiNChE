/**
 * RootChildrenPruner.java
 *
 * 2012.10.25
 *
 * This file is part of the CheMet library
 *
 * The CheMet library is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * CheMet is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with CheMet. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.metware.binche.graph;

import java.util.Collection;
import org.apache.log4j.Logger;

/**
 * @name RootChildrenPruner
 * @date 2012.10.25
 *
 * @version $Rev$ : Last Changed $Date$
 * @author pmoreno
 * @author $Author$ (this version)
 * @brief ...class description...
 *
 * Removes the defined level of children from the root class of the ontology.
 *
 */
public class RootChildrenPruner implements ChEBIGraphPruner {

    private static final Logger LOGGER = Logger.getLogger(RootChildrenPruner.class);
    private int level;
    private boolean reExecution;
    private int executionCount = 0;

    public RootChildrenPruner(int level, boolean allowReExecution) {
        this.level = level;
        this.reExecution = allowReExecution;
    }

    public void prune(ChebiGraph graph) {
        if (reExecution || executionCount == 0) {
            Collection<ChebiVertex> roots = graph.getRoots();
            for (ChebiVertex root : roots) {
                deleteChildren(root, graph, level);
            }
        }
        executionCount++;
    }

    private void deleteChildren(ChebiVertex vertex, ChebiGraph graph, int nextLevel) {
        if (nextLevel > 0) {
            nextLevel--;
            for (ChebiVertex child : graph.getChildren(vertex)) {
                deleteChildren(child, graph, nextLevel);
            }
            graph.removeVertex(vertex);
        }
    }
}
