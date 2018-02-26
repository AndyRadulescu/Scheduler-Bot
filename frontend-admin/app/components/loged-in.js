import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        let status = this.get('model').status;
        console.log(status);
        if (status !== 'connected') {
            this.get('router').transitionTo('login');
        } else {
            console.log(this.get('model'));
        }
        // console.log(this.get('fb').api('/me'));
    },

    actions: {
        logOut() {
            this.get('fb').logout().then(() => {
                this.get('router').transitionTo('login');
                console.log('user Loged out');
            });
        }
    }
});
