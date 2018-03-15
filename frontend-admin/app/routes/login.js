import Route from '@ember/routing/route';
import { inject } from '@ember/service'

export default Route.extend({
    utils: inject(),

    /**
     * Verifies if the session is active, if it is, the user is automatically sent to the main page.
     * To see the login page again, logging out is mandatory.
     */
    beforeModel() {
        if (this.get('utils').get('token') || this.get('utils').get('fbToken')) {
            this.transitionTo('main');
        }
        return this.get('fb').FBInit();
    }
})