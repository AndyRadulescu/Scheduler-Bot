import Service from '@ember/service';
// import { bind } from '@ember/runloop';

export default Service.extend({

    init() {
        this._super(...arguments);
        this.set('token', window.localStorage.token);
        this.set('fbToken', window.localStorage.fbToken);

        //listener
        // console.log($(localStorage))
        // jQuery(localStorage).on('change', this.unAuthorizedToken);
        // console.log($(localStorage))
    },

    unAuthorizedToken() {
        console.log('a intrat');
        this.removeToken();
        this.get('router').transitionTo('login');
    },

    setToken(value) {
        this.set('token', value);
        window.localStorage.token = value;
    },

    setFbToken(value) {
        this.set('fbToken', value);
        window.localStorage.fbToken = value;
    },

    removeToken() {
        this.set('token', null);
        window.localStorage.removeItem('token');
    },

    removeFbToken() {
        this.set('fbToken', null);
        window.localStorage.removeItem('fbToken');
    }
});
