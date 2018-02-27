import Route from '@ember/routing/route';
import { inject } from '@ember/service'

export default Route.extend({
    fb: inject(),

    beforeModel() {
        return this.get('fb').FBInit();
    }
})