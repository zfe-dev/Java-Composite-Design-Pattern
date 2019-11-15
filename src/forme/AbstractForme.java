package forme;

import ui.FormeInteractor;

public abstract class AbstractForme implements Forme {

    private FormeInteractor interactor = FormeInteractor.getInstance();

    @Override
    public FormeInteractor getInteractor() {
        return interactor;
    }

}
