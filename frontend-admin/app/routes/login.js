import Route from '@ember/routing/route';
import { inject } from '@ember/service'

export default Route.extend({
    utils: inject(),

    beforeModel() {
        if (this.get('utils').get('token') || this.get('utils').get('fbToken')) {
            this.transitionTo('main');
        }
        return this.get('fb').FBInit();
    }
})