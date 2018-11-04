package game.ui.view;

import game.model.IModelObservable;

/**
 * Observer interface
 */
public interface IPanelObserver {

    // Observer suffix due to Java has builtin notify method, so to have unified unique name.

    /**
     * Update method for Observer
     * @param iModelObservable
     */
    public void updateObserver(IModelObservable iModelObservable);
}
