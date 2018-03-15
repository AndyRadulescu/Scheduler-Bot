import Service from '@ember/service';
// import { bind } from '@ember/runloop';
import $ from 'jquery';

export default Service.extend({

    init() {
        this._super(...arguments);
        this.set('token', window.localStorage.token);
        this.set('fbToken', window.localStorage.fbToken);
        console.log(this.token);

        //listener
        let callback = this.unAuthorizedToken.bind(this);
        $(window).on('storage', callback);
    },

    /**
     * Checks the token, allows the session if the token is not malformed, it kills it otherwise.
     * @param {*} event 
     */
    unAuthorizedToken(event) {
        let storageEvent = event.originalEvent;
        let newValue = storageEvent.newValue;
        let oldValue = storageEvent.oldValue;

        if ((oldValue && newValue !== oldValue) || !newValue) {
            console.log('a intrat pe main');
            this.removeToken();
            this.get('router').transitionTo('login');
        } else if (!oldValue && newValue) {
            console.log('a intrat pe main');
            this.setToken(newValue);
            this.get('router').transitionTo('main');
        }
    },

    /**
     * Sets the JWT Token for the entire session.
     * @param {*} value 
     */
    setToken(value) {
        console.log('set token');
        this.set('token', value);
        window.localStorage.setItem('token', value);
    },

    /**
     * Sets the FB token for the entire session,
     * @param {*} value 
     */
    setFbToken(value) {
        this.set('fbToken', value);
        window.localStorage.setItem('fbToken', value);
    },

    /**
     * Removes the token from the localStorage, thus the session is ended.
     */
    removeToken() {
        this.set('token', null);
        window.localStorage.removeItem('token');
    },

     /**
     * Removes the FB token from the localStorage, thus the session is ended.
     */
    removeFbToken() {
        this.set('fbToken', null);
        window.localStorage.removeItem('fbToken');
    }
});
