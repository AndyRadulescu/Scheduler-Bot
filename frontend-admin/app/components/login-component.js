import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        // this.get('fb').getLoginStatus().then((response) => {
            // console.log(response);
            // if (response.status === 'connected') {
            //     console.log('Logged in.');
            //     this.get('router').transitionTo('main');
            // }
            // else {
            //     console.log('Not logged In');
            // }
        // });
    },

    actions: {
        onLoginWithFacebook() {
            this.get('fb').login('email public_profile').then((response) => {
                window.localStorage.fbToken = response.authResponse.accessToken;
                // console.log(response.authResponse.accessToken);
                this.get('router').transitionTo('main');
                console.log('it worked!')
            });
        }
    },

    didInsertElement() {
        return this.get('fb').xfbml_parse();
    }
});
