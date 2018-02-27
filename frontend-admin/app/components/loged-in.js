import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        this.get('modelCopy').getLoginStatus().then((response) => {
            let status = response.status;
            if (status !== 'connected') {
                this.get('router').transitionTo('login');
            } else {
                let OAuth = response.authResponse;
                console.log(OAuth);
                this.get('modelCopy').api('/me', { access_token: OAuth.accessToken });
            }
            // console.log(this.get('fb').api('/me'));
        });
    },

    actions: {
        logOut() {
            this.get('fb').logout().then(() => {
                this.get('router').transitionTo('login');
                console.log('user Loged out');
            });
        }
    },

    didInsertElement() {
        return this.get('fb').xfbml_parse();
    }
});
