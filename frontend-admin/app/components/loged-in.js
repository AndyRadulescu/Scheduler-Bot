import Component from '@ember/component';
import { inject } from '@ember/service';

export default Component.extend({
    ajax: inject(),
    utils: inject('utils'),
    url: "http://localhost:8000/api/user",

    init() {
        this._super(...arguments);
        this.token = this.get('utils').get('token');
        this.fbToken = this.get('utils').get('fbToken');
        // console.log(`token ${this.token}`);
        // console.log(`fbToken ${this.fbToken}`);
        // this.get('modelCopy').setAccessToken(this.fbToken);

        this.get('modelCopy').getLoginStatus().then((response) => {
            this.status = response.status;
            // console.log(`status   ${this.status}`);
            //     if (status !== 'connected' && this.token ==='') {
            //         this.get('router').transitionTo('login');
            //     } else {
            //         let OAuth = response.authResponse;
            //         console.log(OAuth);
            //         this.get('modelCopy').api('/me').then((res) => {
            //             console.log(res);
            //         });
            // }
        });

        if (!this.token && !this.fbToken) {
            this.get('router').transitionTo('login');
        } else if (!this.fbToken) {
            this.verifyAuthentification();
        }
    },

    actions: {
        logOut() {
            if (status === 'connected') {
                this.get('fb').logout().then(() => {
                    this.tokenEmpty();
                    this.get('router').transitionTo('login');
                    console.log('user Loged out with fb');
                });
            } else {
                this.tokenEmpty();
                this.get('router').transitionTo('login');
                console.log('user Loged out');
            }
        }
    },

    verifyAuthentification() {
        this.get('ajax').myRequest(this.url + '/sync', {
            method: 'POST'
        }).catch(() => {
            this.tokenEmpty();
            this.get('router').transitionTo('login');
        });
    },

    tokenEmpty() {
        this.get('utils').removeToken();
        this.get('utils').removeFbToken();
    },

    didInsertElement() {
        return this.get('fb').xfbml_parse();
    }
});
