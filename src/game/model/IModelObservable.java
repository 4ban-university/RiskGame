package game.model;

import game.ui.view.IPanelObserver;

/**
 * Observable for game controller
 * @author Dmitry Kryukov, Ksenia Popova
 */
public interface IModelObservable {
    /**
     * Attach Observer
     * @param iPanelObserver
     */
    public void attachObserver(IPanelObserver iPanelObserver);

    /**
     * Detach Observer
     * @param iPanelObserver
     */
    public void detachObserver(IPanelObserver iPanelObserver);

    // Observer suffix due to Java has builtin notify method, so to have unified unique name.

    /**
     * Notify observers
     */
    public void notifyObservers();
}
