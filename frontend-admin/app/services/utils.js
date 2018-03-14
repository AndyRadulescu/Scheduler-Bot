import Service from '@ember/service';
// import { bind } from '@ember/runloop';
import $ from 'jquery';

export default Service.extend({

    init() {
        this._super(...arguments);
        this.set('token', window.localStorage.token);
        this.set('fbToken', window.localStorage.fbToken);

        //listener
        // console.log($(localStorage))
        var callback = this.unAuthorizedToken.bind(this);
        $(window).on('storage', callback);
        // console.log($(localStorage))
    },

    unAuthorizedToken(event) {
        var storageEvent = event.originalEvent;
        console.log(storageEvent);
        let newValue = storageEvent.newValue;
        let oldValue = storageEvent.oldValue;

        if (oldValue !==null && newValue !== oldValue) {
            // this.notifyPropertyChange(key);
            console.log('a intrat');
            this.removeToken();
            this.get('router').transitionTo('login');
        }
    },

    setToken(value) {
        console.log('set token');
        this.set('token', value);
        window.localStorage.setItem('token', value);
    },

    setFbToken(value) {
        this.set('fbToken', value);
        window.localStorage.setItem('fbToken', value);
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
