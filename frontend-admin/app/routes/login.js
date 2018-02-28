import Route from '@ember/routing/route';
// import { inject } from '@ember/service'

export default Route.extend({
    // fb: inject(),

    beforeModel() {
        return this.get('fb').FBInit();
    },

    actions: {
        onClick() {
            // publish_actions
            this.get('fb').login('email public_profile').then((response) => {
                // let fbToken = response.authResponse.accessToken;
                console.log(response)
                // console.log(this.get('fb').setAccessToken(fbToken));
                this.get('fb').api('/me').then(function (res) {
                    console.log(res);
                });
                // console.log(response.authResponse.accessToken);
                // console.log(this.get('fb').api("/me",'get'));
                // this.get('router').transitionTo('main');
                console.log('it worked!')
            });
        }
    }
})