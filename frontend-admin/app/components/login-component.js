import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        this.get('fb').getLoginStatus().then((response) => {
            console.log(response);
            if (response.status === 'connected') {
                console.log('Logged in.');
                this.get('router').transitionTo('main');
            }
            else {
                console.log('Not logged In');
            }
        });
    },

    actions: {
        onClick() {
            // publish_actions
            this.get('fb').login('email public_profile', { default_audience: 'everyone' }).then((response) => {
                let fbToken = response.authResponse.accessToken;
                console.log(this.get('fb').setAccessToken(fbToken));
                this.get('fb').api('/me', { access_token: fbToken }).then(function (response) {
                    console.log(response);
                });
                // console.log(response.authResponse.accessToken);
                // console.log(this.get('fb').api("/me",'get'));
                // this.get('router').transitionTo('main');
                console.log('it worked!')
            });
        }
    },

    didInsertElement() {
        return this.get('fb').xfbml_parse();
    }
});
