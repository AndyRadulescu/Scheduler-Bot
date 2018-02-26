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
            this.get('fb').login('email public_profile').then((response) => {
                //    console.log(this.get('fb'));
                this.get('router').transitionTo('main');
                console.log('it worked!')
            });
        }
    }
});
