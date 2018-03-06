import Component from '@ember/component';
import { inject } from '@ember/service';

export default Component.extend({
    ajax: inject(),
    ajaxAuth: inject('ajax-auth'),
    url: "http://localhost:8000/api/user",

    init() {
        this._super(...arguments);

        // this.get('modelCopy').getLoginStatus().then((response) => {
        //     let status = response.status;
        //     if (status !== 'connected') {
        //         this.get('router').transitionTo('login');
        //     } else {
        //         let OAuth = response.authResponse;
        //         console.log(OAuth);
        //         this.get('modelCopy').api('/me').then((res) => {
        //             console.log(res);
        //         });
        //     }
        // });
        // console.log(window.localStorage);
        this.verifyAuthentification();
    },

    actions: {
        logOut() {
            this.get('fb').logout().then(() => {
                this.get('router').transitionTo('login');
                console.log('user Loged out');
            });
        }
    },

    verifyAuthentification() {
        console.log(window.localStorage.token);
        this.get('ajaxAuth').authRequest(this.url, { method: 'OPTIONS' });
    },

    didInsertElement() {
        return this.get('fb').xfbml_parse();
    }
});
