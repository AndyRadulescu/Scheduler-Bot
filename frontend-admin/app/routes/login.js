import Route from '@ember/routing/route';
// import { inject } from '@ember/service'

export default Route.extend({
    // fb: inject(),

    beforeModel() {
        console.log(window.localStorage.token);
        if (window.localStorage.token != '' || window.localStorage.fbToken) {
            this.transitionTo('main');
        }
        return this.get('fb').FBInit();
    }
})